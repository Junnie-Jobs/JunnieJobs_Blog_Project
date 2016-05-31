package blog.home.controller;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private UserDao userDao; 
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home(Model model, HttpSession session) throws Exception {
		System.out.println("첫번째로 거치는 곳");
		ModelAndView mav = new ModelAndView("index");
		model.addAttribute("user", new User());

		return mav;
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(Model model, HttpSession session) throws Exception {
		
		return "post";
	}
	
	@RequestMapping(value = "/loginPages", method = RequestMethod.GET)
	public String loginPages() throws Exception {
		return "loginPages";
	}
	
//	@RequestMapping(value = "/write", method = RequestMethod.GET)
//	public String write() throws Exception {
//		return "write";
//	}
	
	@RequestMapping(value = "/postBook", method = RequestMethod.GET)
	public String postBook() throws Exception {
		return "/post/postBook";
	}
}
