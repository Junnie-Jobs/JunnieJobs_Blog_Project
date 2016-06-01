package blog.controller.post;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import blog.dao.PostDao;
import blog.model.FileMetadata;
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
	
	  @RequestMapping(value = "/fileUpload") //ajax에서 호출하는 부분
	   public Object upload(@RequestParam("files[]") List<MultipartFile> files) { //Multipart로 받는다.
			System.out.println("fileUpload 처리");
			String img_url = "/images/upload/";
			String url = null;
			
			List<FileMetadata> fileMetadatas = new ArrayList<>();
		
			for (MultipartFile file : files) {
				String path = "/resources/images/upload/";					
//					File saved = StaticUtil.saveFile(file, path);
//					File thumbnail = thumbnailer.apply(saved);
				FileMetadata fileMetadata = new FileMetadata();
					fileMetadata.setName(file.getOriginalFilename());
					fileMetadata.setUrl(path + file.getOriginalFilename());
//					fileMetadata.setThumbnailUrl(path + File.separator + thumbnail.getName());
				fileMetadatas.add(fileMetadata);
			}
			
	        Map<String, Object> response = new HashMap<>();
			response.put("files", fileMetadatas);
			return response;
	   

}
	

	@RequestMapping(value = "/fileUploadTest", method = RequestMethod.GET)
	public String fileUploadPage(Model model) throws Exception {
		
		return "redirect:/post/fileUploadTest";
	}
	

	
	@RequestMapping(value = "/fileUploadTests", method = {RequestMethod.POST, RequestMethod.GET})
	public String fileUploadTests(@RequestParam(value="files") MultipartFile[] files, HttpSession session, Model model) throws Exception {
		System.out.println("fileUpload 처리중");
		String img_url = "/images/upload/";
		String url = null;
		
        final String path = session.getServletContext().getRealPath("/images/upload");
        // final String path = "c:\\upload";
        log.info("path:{}",path);
        System.out.println("fileUpload 처리중2");
        // 간단한 설명을 위해 controller layer에서 파일을 저장하였지만,
        // service layer로 path와 files값을(인수로) 넘겨서 작업을 하는것을 권장
        for(MultipartFile file : files){
        	System.out.println("fileUpload 처리중3");
            File newFile = new File(path+"/"+file.getOriginalFilename());
            System.out.println("파일의 이름 :" +file.getOriginalFilename());
            try {
                FileUtils.writeByteArrayToFile(newFile, file.getBytes());
                url = file.getOriginalFilename();
//                model.addAttribute(attributeValue)
//                modelAndView.addObject("message", img_url+file.getOriginalFilename());
//                modelAndView.addObject("imgLink", img_url+file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
//                modelAndView.addObject("message", "파일업로드 실패!");
            }        
        }
        System.out.println("fileUpload 처리중4");
        return url;

	}
	
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public Model fileUpload(@RequestParam(value="files") MultipartFile[] files, HttpSession session, Model model) throws Exception {
		System.out.println("fileUpload 처리");
		String img_url = "/images/upload/";

//		ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/post/addView");
       
        final String path = session.getServletContext().getRealPath("/images/upload");
        // final String path = "c:\\upload";
        log.info("path:{}",path);
       
        // 간단한 설명을 위해 controller layer에서 파일을 저장하였지만,
        // service layer로 path와 files값을(인수로) 넘겨서 작업을 하는것을 권장
        for(MultipartFile file : files){
            File newFile = new File(path+"/"+file.getOriginalFilename());
            try {
                FileUtils.writeByteArrayToFile(newFile, file.getBytes());
                model.addAttribute("message", img_url+file.getOriginalFilename());
                System.out.println("모델 값을 찍어보면 ?");
//                modelAndView.addObject("message", img_url+file.getOriginalFilename());
//                modelAndView.addObject("imgLink", img_url+file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "파일업로드 실패!");
//                modelAndView.addObject("message", "파일업로드 실패!");
            }        
        }
        return model;

	}
	
	//이건 테스트 버젼 여기서 나는 무엇을 하려 했는c
//	@RequestMapping(value = "/fileUploadPocess", method = RequestMethod.POST)
//	public Model fileUpload(@RequestParam(value="files") MultipartFile[] files, HttpSession session, Model model) throws Exception {
//		System.out.println("fileUpload 처리");
//		String img_url = "/images/upload/";
//        final String path = session.getServletContext().getRealPath("/images/upload");
//        // final String path = "c:\\upload";
//        log.info("path:{}",path);
//       
//        // 간단한 설명을 위해 controller layer에서 파일을 저장하였지만,
//        // service layer로 path와 files값을(인수로) 넘겨서 작업을 하는것을 권장
//        for(MultipartFile file : files){
//            File newFile = new File(path+"/"+file.getOriginalFilename());
//            try {
//                FileUtils.writeByteArrayToFile(newFile, file.getBytes());
//                modelAndView.addObject("message", img_url+file.getOriginalFilename());
////                modelAndView.addObject("imgLink", img_url+file.getOriginalFilename());
//            } catch (IOException e) {
//                e.printStackTrace();
//                modelAndView.addObject("message", "파일업로드 실패!");
//            }        
//        }
//        return model;
//
//	}
	
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
