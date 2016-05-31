package blog.model;

import java.util.Date;

public class Comment {
	private long commentId;
	
	private String writer;
	
	private String contents;
	
	private Date createdDate;

	private long postId;
	
	public Comment(String writer, String contents, long postId) {
		this(0, writer, contents, new Date(), postId);
	}
	
	public Comment(long commentId, String writer, String contents, Date createdDate, long postId) {
		this.commentId = commentId;
		this.writer = writer;
		this.contents = contents;
		this.createdDate = createdDate;
		this.postId = postId;
	}
	
	public long getcommentId() {
		return commentId;
	}
	
	public String getWriter() {
		return writer;
	}

	public String getContents() {
		return contents;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public long getTimeFromCreateDate() {
		return this.createdDate.getTime();
	}
	
	public long getPostId() {
		return postId;
	}
	
	public boolean isSameUser(User user) {
		if (user == null) {
			return false;
		}
		return user.isSameUser(this.writer);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (commentId ^ (commentId >>> 32));
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
		Comment other = (Comment) obj;
		if (commentId != other.commentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", writer=" + writer
				+ ", contents=" + contents + ", createdDate=" + createdDate
				+ ", postId=" + postId + "]";
	}
}
