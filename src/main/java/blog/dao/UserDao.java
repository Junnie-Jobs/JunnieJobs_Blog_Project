package blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import blog.model.User;

@Repository
public class UserDao {
	
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    public void insert(User user) {
        String sql = "INSERT INTO user VALUES (?, ?, ?)";
        log.info("유저 정보 " + user.getUserId() + user.getName() + user.getImage());
        jdbcTemplate.update(sql, 
        		user.getUserId(),
                user.getName(),
                user.getImage());
    }

    public User findByUserId(String userId) {
    	try{
    		
    		 String sql = "SELECT id, name, image FROM user WHERE id=?";
    	     return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
    	}catch(EmptyResultDataAccessException e){
    		return null;
    	}
       
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT id, name, image FROM user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    
    private static class UserRowMapper implements RowMapper<User> {
    	@Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            return new User(
            		rs.getString("id"), 
                    rs.getString("name"),
                    rs.getString("image")
                    );
        }
    }

}
