package blog.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() throws Exception {
		return "index";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post() throws Exception {
		return "post";
	}
	
	@RequestMapping(value = "/loginPages", method = RequestMethod.GET)
	public String loginPages() throws Exception {
		return "loginPages";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() throws Exception {
		return "write";
	}
}
