package blog.controller.home;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import blog.controller.UserSessionUtils;
import blog.dao.UserDao;
import blog.model.User;


@Controller
public class HomeController {
	
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDao userDao; 
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home(Model model, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView("index");
		model.addAttribute("user", new User());
		log.debug("Home 화면으로 이동");
		return mav;
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(Model model, HttpSession session) throws Exception {
		
		return "post";
	}
	
	
	@RequestMapping(value = "/post/fileUploadTest", method = RequestMethod.GET)
	public String fileUploadTest(Model model, HttpSession session) throws Exception {
		
		return "redirect:/fileUploadTest";
	}
	
	@RequestMapping(value = "/fileUploadTest", method = RequestMethod.GET)
	public String fileUploadTest2(Model model, HttpSession session) throws Exception {
		
		return "fileUploadTest";
	}
	
	@RequestMapping(value = "/loginPages", method = RequestMethod.GET)
	public String loginPages() throws Exception {
		return "loginPages";
	}
	
	
	@RequestMapping(value = "/postBook", method = RequestMethod.GET)
	public String postBook() throws Exception {
		return "/post/postBook";
	}
}
