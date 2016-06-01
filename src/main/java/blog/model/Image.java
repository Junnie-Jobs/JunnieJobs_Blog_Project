package blog.model;

import java.util.Date;

public class Image {

	String fileData;
	
	public Image() {
	}
	
	public Image(String fileData){
		this.fileData = fileData;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "Image [fileData=" + fileData + "]";
	}

	
}
