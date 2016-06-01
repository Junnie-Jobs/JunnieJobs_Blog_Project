package blog.controller.post;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

public class StaticUtil {
	
	static final String PATH_PREFIX = "/uploads";
	static final String LOCAL_PATH_PREFIX = System.getProperty("user.home");
//	static final String LOCAL_PATH_PREFIX = "/resources";



	public static String getUploadPath() {
		return PATH_PREFIX + File.separator + getDatePrefix();
	}
	
	private static String getDatePrefix() {
		LocalDate date = LocalDate.now();
		return date.getYear() + File.separator + date.getMonthValue();
	}
	
	public static void createDirectory(String path) {
		File destDir = new File(LOCAL_PATH_PREFIX + File.separator + path);
		if (!destDir.exists() && !destDir.mkdirs()) {
			throw new IllegalStateException("Couldn't create dir: " + destDir);
		}
	}
	
	public static File saveFile(MultipartFile multipartFile, String path) throws IOException {
		File file = new File(LOCAL_PATH_PREFIX + File.separator + path + File.separator + getFilename(multipartFile));
		multipartFile.transferTo(file);
		return file;
	}
	public static String getFilename(MultipartFile file) throws IOException {
		String name = getMD5Hash(file.getBytes());
		String ext = getExtension(file.getContentType());
		return name + "." + ext;
	}
	
	private static String getMD5Hash(byte[] bs) {
		String MD5 = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bs);
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			MD5 = null;
		}
		return MD5;
	}

	private static String getExtension(String mimeType) {
		String extension = "";
		if (mimeType.equals(MimeTypeUtils.IMAGE_JPEG_VALUE)) {
			extension = "jpg";
		} else if (mimeType.equals(MimeTypeUtils.IMAGE_PNG_VALUE)) {
			extension = "png";
		}
		return extension;
	}
}
