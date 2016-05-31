package blog.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blog.controller.UserSessionUtils;
import blog.dao.UserDao;
import blog.model.User;
import core.utils.SessionUtils;
import core.web.argumentresolver.LoginUser;


@Controller
@RequestMapping("/users")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;
	
	
//	//블로그 처음 접속시 User model을 만들고 페이지를 다시 보내준다. 
//	@RequestMapping(value = "", method = RequestMethod.GET)
//    public String form(Model model) throws Exception {
//    	model.addAttribute("user", new User());
//    	return "/";
//    }
//	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String getUserInfo(Model model, HttpServletRequest request, @RequestParam String userId, @RequestParam String name, HttpSession session) {
		
//	    if (loginUser.isGuestUser()) {
//	        return "redirect:/";
//	    }
	    
	    User user = userDao.findByUserId(userId);
		session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
		
		if(user != null){
			
			System.out.println("유저가 이미 존재하여 바로 홈으로 넘어갑니다");			
			model.addAttribute("user", user);
			request.getSession().setAttribute("user", user);
			return "redirect:/";
		}	
		
			user = new User();		
			user.setUserId(userId);
			user.setName(name);	
			userDao.insert(user);;
			
			log.debug("새로운 유저가 추가되었습니다.");
			log.debug("User : {}", user);		
			userDao.insert(user);;
			model.addAttribute("user", user);
			request.getSession().setAttribute("user", user);
			return "redirect:/";

		
    }
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpSession session) {
//		user.UserLogout(SessionUtils.getUserValue(session, "user"));
//		session.removeAttribute("user");
//		return "redirect:/";	 
//	}
	
	
	
//	@RequestMapping("/post")
//	public String goChannel(Model model, HttpSession session) {
//		
//		return "/post";
//	}
	

	//유저가 로그인하고나면 페이지 이동
//	@RequestMapping(value = "", method = RequestMethod.GET)
//    public String index(@LoginUser User loginUser, Model model) throws Exception {
//		if (loginUser.isGuestUser()) {
//			return "redirect:/";
//		}
//		
//        model.addAttribute("users", userDao.findAll());
//        return "/user/list";
//    }
    
//    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
//    public String profile(@PathVariable String userId, Model model) throws Exception {
//    	model.addAttribute("user", userDao.findByUserId(userId));
//        return "/user/profile";
//    }
//    
//    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    public String form(Model model) throws Exception {
//    	model.addAttribute("user", new User());
//    	return "/user/form";
//    }
//    
//    @RequestMapping(value = "", method = RequestMethod.POST)
//	public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) throws Exception {
//        if (bindingResult.hasErrors()) {
//        	
//            return "/user/form";
//}   	
//    	log.debug("User : {}", user);
////        userDao.insert(user);
//		return "redirect:/";
//	}
//    
//    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
//	public String updateForm(@LoginUser User loginUser, @PathVariable String userId, Model model) throws Exception {
//    	User user = userDao.findByUserId(userId);
//    	if (!loginUser.isSameUser(user)) {
//        	throw new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다.");
//        }
//    	model.addAttribute("user", user);
//    	return "/user/updateForm";
//	}
//    
//    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
//	public String update(@LoginUser User loginUser, @PathVariable String userId, User newUser) throws Exception {
//    	User user = userDao.findByUserId(userId);
//    	if (!loginUser.isSameUser(user)) {
//        	throw new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다.");
//        }
//        
//        log.debug("Update User : {}", newUser);
//        user.update(newUser);
//        userDao.update(user);
//        return "redirect:/";
//	}
//    
//    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
//    public String loginForm() throws Exception {
//    	return "/user/login";
//    }
//    
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(String userId, String password, HttpSession session, Model model) throws Exception {
//        User user = userDao.findByUserId(userId);
//        if (user == null) {
//            model.addAttribute("loginFailed", true);
//            return "/user/login";
//        }
//        
//        if (user.matchPassword(password)) {
//            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
//            return "redirect:/";
//        } else {
//        	model.addAttribute("loginFailed", true);
//            return "/user/login";
//        }
//    }
//    
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpSession session) throws Exception {
//        session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
//        return "redirect:/";
//    }
}
