package blog.post.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import blog.dao.CommentDao;
import blog.dao.PostDao;
import blog.model.Comment;
import blog.model.Result;
import blog.model.User;
import core.web.argumentresolver.LoginUser;
import jersey.repackaged.com.google.common.collect.Maps;

@Controller
@RestController
@RequestMapping("/api/post")
public class ApiPostController {
	
	private static final Logger log = LoggerFactory.getLogger(ApiPostController.class);
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private PostDao postDao;
	
	@RequestMapping(value = "/{postId}/newComment", method = RequestMethod.POST)
	public Map<String, Object> addAnswer(@LoginUser User loginUser, @PathVariable long postId, String contents) throws Exception {

		Map<String, Object> values = Maps.newHashMap();
    	Comment comment = new Comment(loginUser.getUserId(), contents, postId);
    	Comment savedComment = commentDao.insert(comment);
    	postDao.updateCountOfAnswer(savedComment.getPostId());
		values.put("comment", savedComment);
		values.put("result", Result.ok());
		System.out.println(values);
		return values;
	}

}
