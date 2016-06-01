package blog.model;

import java.util.Date;

public class Post {
	
	private long postId;
	private String writer;
	private String title;
	private String contents;
	private Date createdDate;
	private String mainCoverPath;
	private int countOfComment;
	
//	//** 조회수 */
//	private int hit = 0;
//	//** 수정 일시 */
//	private String modDate;
	
//	public int getHit() {
//		return hit;
//	}
//
//	public void setHit(int hit) {
//		this.hit = hit;
//	}
//
//	public String getModDate() {
//		return modDate;
//	}
//
//	public void setModDate(String modDate) {
//		this.modDate = modDate;
//	}
//		

	public Post() {
	}

	public Post(String writer, String title, String contents, String mainCoverPath) {
		this(0, writer, title, contents, new Date(), mainCoverPath, 0);
	}

	public Post(long postId, String writer, String title, String contents, Date createdDate, String mainCoverPath,
			int countOfComment) {
		this.postId = postId;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.mainCoverPath = mainCoverPath;
		this.countOfComment = countOfComment;
	}

	public String getMainCoverPath() {
		return mainCoverPath;
	}

	public void setMainCoverPath(String mainCoverPath) {
		this.mainCoverPath = mainCoverPath;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

//	public void update(Question newQuestion) {
//		this.title = newQuestion.title;
//		this.contents = newQuestion.contents;
//	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", writer=" + writer + ", title=" + title + ", contents="
				+ contents + ", createdDate=" + createdDate + ", countOfComment=" + countOfComment + "]";
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
		return new Post(user.getUserId(), title, contents, mainCoverPath);
	}

	public void update(Post newPost) {
		this.title = newPost.title;
		this.contents = newPost.contents;	
	}


}
