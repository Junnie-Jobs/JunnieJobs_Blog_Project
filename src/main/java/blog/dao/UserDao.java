package blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import blog.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    public void insert(User user) {
        String sql = "INSERT INTO user VALUES (?, ?)";
        System.out.println("유저 정보 " + user.getUserId() + user.getName());
        jdbcTemplate.update(sql, 
        		user.getUserId(),
                user.getName());
    }

    public User findByUserId(String userId) {
    	try{
    		
    		 String sql = "SELECT id, name FROM user WHERE id=?";
    	     return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
    	}catch(EmptyResultDataAccessException e){
    		return null;
    	}
       
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT id, name FROM user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    
    private static class UserRowMapper implements RowMapper<User> {
    	@Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            return new User(
            		rs.getString("id"), 
                    rs.getString("name"));
        }
    }

}
