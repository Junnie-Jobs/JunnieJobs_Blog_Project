package blog.model;

import java.util.Date;

public class Image {

	private long imageId;
	private String writer;
	private String originalName;
	private Date createdDate;
	private String filePath;

	public Image() {

	}

	public Image(String writer, String originalName, Date createdDate, String filePath) {
		this(0, writer, originalName, new Date(), filePath);
	}

	public Image(long imageId, String writer, String originalName, Date createdDate, String filePath) {

		this.imageId = imageId;
		this.writer = writer;
		this.originalName = originalName;
		this.createdDate = createdDate;
		this.filePath = filePath;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
