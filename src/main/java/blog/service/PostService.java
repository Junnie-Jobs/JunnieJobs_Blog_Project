package blog.service;

import java.util.List;

import javax.inject.Inject;



import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import blog.dao.PostDao;
import blog.dao.CommentDao;
import blog.model.Comment;
import blog.model.Post;
import blog.model.User;

@Service
public class PostService {
	private PostDao postDao;
	private CommentDao commentDao;

	@Inject
	public PostService(PostDao postDao, CommentDao commentDao) {
		this.postDao = postDao;
		this.commentDao = commentDao;
	}

	public Post findById(long postId) {
		return postDao.findById(postId);
	}

	public List<Comment> findAllByPostId(long postId) {
		return commentDao.findAllByPostId(postId);
	}

	public void deletePost(long postId, User user) throws CannotOperateException {
		Post post = postDao.findById(postId);
		if (post == null) {
			throw new EmptyResultDataAccessException("존재하지 않는 post입니다.", 1);
		}

		List<Comment> comments = commentDao.findAllByPostId(postId);
		if (comments.isEmpty()) {
			commentDao.delete(postId);
			return;
		}

		boolean canDelete = true;
		for (Comment comment : comments) {
			String writer = post.getWriter();
			if (!writer.equals(comment.getWriter())) {
				canDelete = false;
				break;
			}
		}

		if (!canDelete) {
			throw new CannotOperateException("다른 사용자가 추가한 댓글이 존재해 삭제할 수 없습니다.");
		}

		commentDao.delete(postId);
	}


}
