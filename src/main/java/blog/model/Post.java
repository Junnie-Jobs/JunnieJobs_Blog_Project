package blog.model;

import java.sql.Timestamp;
import java.util.Date;

public class Post {
	
	private long postId;
	private String writer;
	private String title;
	private Date createdDate;
	private int countOfComment;
	private String first_page_image_url;
	private String second_page_image_url;
	private String second_page_short_text;
	private String second_page_long_text;
	private String third_page_thumb1_image_url;
	private String third_page_thumb2_image_url;
	private String third_page_thumb3_image_url;
	private String third_page_thumb4_image_url;
	private String third_page_thumb5_image_url;
	private String third_page_thumb6_image_url;
	
	public Post() {
	}


	public Post(
			String writer, 
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
			String third_page_thumb6_image_url 
			) {
		this(0, writer, title, new Date(), 0, 
				first_page_image_url, 
				second_page_image_url,
				second_page_short_text,
				second_page_long_text,
				third_page_thumb1_image_url,
				third_page_thumb2_image_url,
				third_page_thumb3_image_url,
				third_page_thumb4_image_url,
				third_page_thumb5_image_url,
				third_page_thumb6_image_url
				);
	}

	public Post(long postId, 
			String writer, 
			String title, 
			Date createdDate,			
			int countOfComment, 
			String first_page_image_url, 
			String second_page_image_url,
			String second_page_short_text,
			String second_page_long_text,
			String third_page_thumb1_image_url, 
			String third_page_thumb2_image_url, 
			String third_page_thumb3_image_url, 
			String third_page_thumb4_image_url, 
			String third_page_thumb5_image_url, 
			String third_page_thumb6_image_url 
			) {
		this.postId = postId;
		this.writer = writer;
		this.title = title;
		this.createdDate = createdDate;
		this.countOfComment = countOfComment;
		this.first_page_image_url = first_page_image_url;
		this.second_page_image_url = second_page_image_url;
		this.second_page_short_text = second_page_short_text;
		this.second_page_long_text = second_page_long_text;
		this.third_page_thumb1_image_url = third_page_thumb1_image_url;
		this.third_page_thumb2_image_url = third_page_thumb2_image_url;
		this.third_page_thumb3_image_url = third_page_thumb3_image_url;
		this.third_page_thumb4_image_url = third_page_thumb4_image_url;
		this.third_page_thumb5_image_url = third_page_thumb5_image_url;
		this.third_page_thumb6_image_url = third_page_thumb6_image_url;
	}



	public Post(
			long postId, 
			String writer, 
			String title, 
			Timestamp createdDate, 
			int countOfComment, 
			String first_page_image_url) {
		
		this.postId = postId;
		this.writer = writer;
		this.title = title;
		this.createdDate = createdDate;
		this.countOfComment = countOfComment;
		this.first_page_image_url = first_page_image_url;
		
	}


	public long getpostId() {
		return postId;
	}

	public void setpostId(long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public long getTimeFromCreateDate() {
		return this.createdDate.getTime();
	}

	public int getCountOfComment() {
		return countOfComment;
	}
	
	
	public boolean isSameUser(User user) {
		return user.isSameUser(this.writer);
	}


	public String getFirst_page_image_url() {
		return first_page_image_url;
	}

	public void setFirst_page_image_url(String first_page_image_url) {
		this.first_page_image_url = first_page_image_url;
	}

	public String getSecond_page_image_url() {
		return second_page_image_url;
	}

	public void setSecond_page_image_url(String second_page_image_url) {
		this.second_page_image_url = second_page_image_url;
	}
	public String getSecond_page_short_text() {
		return second_page_short_text;
	}

	public void setSecond_page_short_text(String second_page_short_text) {
		this.second_page_short_text = second_page_short_text;
	}

	public String getSecond_page_long_text() {
		return second_page_long_text;
	}

	public void setSecond_page_long_text(String second_page_long_text) {
		this.second_page_long_text = second_page_long_text;
	}

	public String getThird_page_thumb1_image_url() {
		return third_page_thumb1_image_url;
	}

	public void setThird_page_thumb1_image_url(String third_page_thumb1_image_url) {
		this.third_page_thumb1_image_url = third_page_thumb1_image_url;
	}

	public String getThird_page_thumb2_image_url() {
		return third_page_thumb2_image_url;
	}

	public void setThird_page_thumb2_image_url(String third_page_thumb2_image_url) {
		this.third_page_thumb2_image_url = third_page_thumb2_image_url;
	}

	public String getThird_page_thumb3_image_url() {
		return third_page_thumb3_image_url;
	}

	public void setThird_page_thumb3_image_url(String third_page_thumb3_image_url) {
		this.third_page_thumb3_image_url = third_page_thumb3_image_url;
	}

	public String getThird_page_thumb4_image_url() {
		return third_page_thumb4_image_url;
	}

	public void setThird_page_thumb4_image_url(String third_page_thumb4_image_url) {
		this.third_page_thumb4_image_url = third_page_thumb4_image_url;
	}

	public String getThird_page_thumb5_image_url() {
		return third_page_thumb5_image_url;
	}

	public void setThird_page_thumb5_image_url(String third_page_thumb5_image_url) {
		this.third_page_thumb5_image_url = third_page_thumb5_image_url;
	}

	public String getThird_page_thumb6_image_url() {
		return third_page_thumb6_image_url;
	}

	public void setThird_page_thumb6_image_url(String third_page_thumb6_image_url) {
		this.third_page_thumb6_image_url = third_page_thumb6_image_url;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", writer=" + writer + ", title=" + title + ", second_page_long_text="
				+ second_page_long_text + ", createdDate=" + createdDate + ", countOfComment=" + countOfComment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (postId ^ (postId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (postId != other.postId)
			return false;
		return true;
	}

	public Post newPost(User user) {
		return new Post(user.getUserId(), title, 
				first_page_image_url, 
				second_page_image_url,
				second_page_short_text,
				second_page_long_text,
				third_page_thumb1_image_url,
				third_page_thumb2_image_url,
				third_page_thumb3_image_url,
				third_page_thumb4_image_url,
				third_page_thumb5_image_url,
				third_page_thumb6_image_url
				);
	}

	public void update(Post newPost) {
		this.title = newPost.title;
		this.second_page_long_text = newPost.second_page_long_text;	
	}

	
	
	//TODO 아래는 추가예정!	
//		//** 조회수 */
//		private int hit = 0;
//		//** 수정 일시 */
//		private String modDate;
		
//		public int getHit() {
//			return hit;
//		}
	//
//		public void setHit(int hit) {
//			this.hit = hit;
//		}
	//
//		public String getModDate() {
//			return modDate;
//		}
	//
//		public void setModDate(String modDate) {
//			this.modDate = modDate;
//		}
	//	

}
