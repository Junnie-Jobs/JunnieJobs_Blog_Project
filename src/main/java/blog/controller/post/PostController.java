package blog.controller.post;

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
	public String postProcess(
			@LoginUser User loginUser, 
			String title,
			String first_page_image_url,
			String second_page_image_url,
			String second_page_short_text, 
			String second_page_long_text,
			String third_page_thumb1_image_url, 
			String third_page_thumb2_image_url, 
			String third_page_thumb3_image_url,
			String third_page_thumb4_image_url, 
			String third_page_thumb5_image_url, 
			String third_page_thumb6_image_url)
	
			throws Exception {

		log.debug("loginUser : " + loginUser);

		Post post = new Post(
				loginUser.getName(), 
				title, 
				first_page_image_url, 
				second_page_image_url,
				second_page_short_text, 
				second_page_long_text, 
				third_page_thumb1_image_url, 
				third_page_thumb2_image_url,
				third_page_thumb3_image_url, 
				third_page_thumb4_image_url, 
				third_page_thumb5_image_url,
				third_page_thumb6_image_url);

		postDao.insert(post); //modelAndView를 이용해 전달해줘야 하낟.
		return "post/postBook";
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

	// @RequestMapping(value = "/postBook/{postId}", method = RequestMethod.GET)
	// public String showPost(@PathVariable long postId, Model model) throws
	// Exception {
	// model.addAttribute("post", postService.findById(postId));
	// model.addAttribute("comment", postService.findAllByPostId(postId));
	// return "/post/show";
	//
	// }

	// @RequestMapping(value = "/fileUploadTest", method = RequestMethod.GET)
	// public String fileUploadTest(Model model) throws Exception {
	//
	// model.addAttribute("image", new Image());
	// return "post/fileUploadTest";
	// }

	// @RequestMapping(value = "/postTest", method = RequestMethod.POST)
	// public void postTest(@LoginUser User loginUser, Image image) throws
	// Exception {
	//
	// System.out.println(image.getFileData());
	// System.out.println(image);
	//
	// }

}
