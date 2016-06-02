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
			
		commentDao.delete(postId);
	}


}
