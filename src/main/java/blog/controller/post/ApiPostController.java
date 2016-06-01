package blog.controller.post;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import blog.dao.CommentDao;
import blog.dao.PostDao;
import blog.model.Comment;
import blog.model.FileMetadata;
import blog.model.Post;
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
	public Map<String, Object> addAnswer(@LoginUser User loginUser, @PathVariable long postId, String contents)
			throws Exception {

		Map<String, Object> values = Maps.newHashMap();
		Comment comment = new Comment(loginUser.getUserId(), contents, postId);
		Comment savedComment = commentDao.insert(comment);
		postDao.updateCountOfAnswer(savedComment.getPostId());
		values.put("comment", savedComment);
		values.put("result", Result.ok());
		System.out.println(values);
		return values;
	}

	@RequestMapping(value = "/fileUpload") // ajax에서 호출하는 부분
	public Object upload(@RequestParam("files[]") List<MultipartFile> files, HttpSession session) throws IOException {

		System.out.println("fileUpload 처리 api");

		List<FileMetadata> fileMetadatas = new ArrayList<>();
		final String path = session.getServletContext().getRealPath("/images/upload/");
		log.info("path:{}", path);

		System.out.println(files);
		for (MultipartFile file : files) {

			File newFile = new File(path + "/" + file.getOriginalFilename());
			
			try {
				FileUtils.writeByteArrayToFile(newFile, file.getBytes());
				FileMetadata fileMetadata = new FileMetadata();
				fileMetadata.setName(file.getOriginalFilename());
				fileMetadata.setUrl(file.getOriginalFilename());
				System.out.println(fileMetadata.getUrl());
				fileMetadatas.add(fileMetadata);

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		Map<String, Object> response = new HashMap<>();
		response.put("files", fileMetadatas);
		return response;

	}

	@RequestMapping(value = "/fileUploadForOne") // ajax에서 호출하는 부분
	public Map<String, Object> uploadForOne(MultipartFile file, Post post, HttpSession session)
			throws IOException {

		List<FileMetadata> fileMetadatas = new ArrayList<>();
		System.out.println(post);
		System.out.println(post.getFirst_page_image_url());
		final String path = session.getServletContext().getRealPath("/images/upload/");
		log.info("path:{}", path);

		File newFile = new File(path + "/" + file.getOriginalFilename());
		System.out.println("Test1");
		try {
			System.out.println("Test2");
			FileUtils.writeByteArrayToFile(newFile, file.getBytes());
			System.out.println("Test3");
			FileMetadata fileMetadata = new FileMetadata();
			System.out.println("Test4");
			fileMetadata.setName(file.getOriginalFilename());
			System.out.println("Test5");
			fileMetadata.setUrl(path + file.getOriginalFilename());
			System.out.println("Test6");
			fileMetadatas.add(fileMetadata);

		} catch (IOException e) {
			e.printStackTrace();

		}

		Map<String, Object> response = new HashMap<>();
		response.put("files", fileMetadatas);
		return response;

	}

}