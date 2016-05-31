package blog.post.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import blog.dao.PostDao;
import blog.model.Post;
import blog.model.User;
import blog.service.PostService;
import core.web.argumentresolver.LoginUser;

@Controller
@RequestMapping("/write")
public class PostController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PostController.class);
	@Autowired
	private PostDao postDao;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(@LoginUser User loginUser, Model model) throws Exception {
		if (loginUser.isGuestUser()) {
			log.debug("Gueset User로 찍혀서 post로 이동");
			return "redirect:/post";
		}
		model.addAttribute("post", new Post());
		return "post/writeForm";
	}
	
	@RequestMapping(value = "/postProcess", method = RequestMethod.POST)
	public String postProcess(@LoginUser User loginUser, Post post) throws Exception {
		if (loginUser.isGuestUser()) {
			System.out.println("Gueset User로 찍혀서 post로 이동");
			return "redirect:/post";
		}

		log.debug("loginUser를 찍으면 " + loginUser);
		postDao.insert(post.newPost(loginUser));
		return "post";
	}
	
	@RequestMapping(value = "/postBook", method = RequestMethod.GET)
	public ModelAndView postBook() throws Exception {
		ModelAndView mav = new ModelAndView("/post/postBook");
		mav.addObject("posts", postDao.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/postBook/{postId}", method = RequestMethod.GET)
	public String showPost(@PathVariable long postId, Model model) throws Exception {
		model.addAttribute("post", postService.findById(postId));
		model.addAttribute("comment", postService.findAllByPostId(postId));
		return "/post/show";

	}

	
//	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
//	public String create(@LoginUser User loginUser, Post board) throws Exception {
//		if (loginUser.isGuestUser()) {
//			return "redirect:/post";
//		}
//		boardDao.insert(board.newQuestion(loginUser));
//		return "redirect:/story";
//	}
//	
//	@RequestMapping(value = "/{postId}/edit", method = RequestMethod.GET)
//	public String editForm(@LoginUser User loginUser, @PathVariable long questionId, Model model) throws Exception {
//		Post post = Post.findById(questionId);
//		if (!question.isSameUser(loginUser)) {
//			throw new IllegalStateException("다른 사용자가 쓴 글을 수정할 수 없습니다.");
//		}
//		model.addAttribute("question", question);
//		return "/qna/update";
//	}


}
