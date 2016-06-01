package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.Statement;

import blog.model.Image;
import blog.model.Post;

public class ImageDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
//    public Image insert(Post post) {
//    	
//        String sql = "INSERT INTO img_table (writer, title, contents, createdDate) VALUES (?, ?, ?, ?)";
//        PreparedStatementCreator psc = new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				
//				pstmt.setString(1, post.getWriter());
//				pstmt.setString(2, post.getTitle());
//				pstmt.setString(3, post.getContents());
//				pstmt.setTimestamp(4, new Timestamp(post.getTimeFromCreateDate()));
//				return pstmt;
//			}
//		};
//		        
//		/*mysql에서는 auto_increment 칼럼과 같이 데이터를 삽입할 때 자동으로 생성되는 
//		 * 키 칼럼 값을 구하고 싶은 경우에는 PreparedStatementCreator와 Key Holder를 함께
//		 * 사용하는 update() 메서드를 호출해주면 된다.
//		 * */
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(psc, keyHolder);
//        return findById(keyHolder.getKey().longValue());
//        /*편리한 update() 메서드는 데이터베이스가 생성한 기본 키의 획득을 지원한다. 
//         * 이 지원은 JDBC 3.0 표준의 일부분이다. 자세한 내용은 명세서의 13.6장을 참고해라. 
//         * 이 메서드는 첫 인자로 PreparedStatementCreator를 받은데 이것이 필수 insert문을 지정하는 방법이다. 
//         * 다른 인자는 update가 성공정으로 반환하는 생성된 키를 담고 있는 KeyHolder이다. 
//         * 적합한 PreparedStatement (메서드 시그니처가 왜 이렇게 되어 있는지를 설명한다.)를 생성하는 하나의 표준화된 방법은 존재하지 않는다. 
//         * */
//    }
    
//    public Image findById(long imageId) {
//		String sql = "SELECT postId, writer, title, contents, createdDate, countOfAnswer FROM posts "
//				+ "WHERE postId = ?";
//		
//		RowMapper<Post> rm = new RowMapper<Post>() {
//			@Override
//			public Post mapRow(ResultSet rs, int index) throws SQLException {
//				return new Post(rs.getLong("postId"),
//						rs.getString("writer"), 
//						rs.getString("title"),
//						rs.getString("contents"),
//						rs.getTimestamp("createdDate"),
//						rs.getInt("countOfAnswer"));
//			}
//		};
//		
//		return jdbcTemplate.queryForObject(sql, rm, postId);
//	}

}
