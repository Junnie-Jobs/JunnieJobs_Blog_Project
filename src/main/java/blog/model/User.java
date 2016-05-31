package blog.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import blog.dao.UserDao;


public class User {
	public static final GuestUser GUEST_USER = new GuestUser();
	
	private static final Logger log = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserDao userDao;
	private String userId;
	private String name;
	
	public User() {
	}

	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

//	public String getImageLink() {
//		return imageLink;
//	}
//
//	public void setImageLink(String imageLink) {
//		this.imageLink = imageLink;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isSameUser(User user) {
		return isSameUser(user.getUserId());
	}

	public boolean isSameUser(String newUserId) {
		if (userId == null) {
			return false;
		}
		return userId.equals(newUserId);
	}
	
	public boolean isGuestUser() {
		return false;
	}
	
	private static class GuestUser extends User {
		@Override
		public boolean isGuestUser() {
			return true;
		}
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name +"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	public boolean isEnrolled(String userId) {
		
		if(userDao.findByUserId(userId) != null){
			log.debug(userId+"는 이미 존재함");
			return true;
		}
		
		return false;
	}


}
