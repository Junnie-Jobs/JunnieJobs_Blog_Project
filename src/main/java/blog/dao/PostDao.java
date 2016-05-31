package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

import blog.model.Post;


@Repository
public class PostDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
    public Post insert(Post post) {
    	
        String sql = "INSERT INTO posts (writer, title, contents, createdDate) VALUES (?, ?, ?, ?)";
        PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				pstmt.setString(1, post.getWriter());
				pstmt.setString(2, post.getTitle());
				pstmt.setString(3, post.getContents());
				pstmt.setTimestamp(4, new Timestamp(post.getTimeFromCreateDate()));
				return pstmt;
			}
		};
		        
		/*mysql에서는 auto_increment 칼럼과 같이 데이터를 삽입할 때 자동으로 생성되는 
		 * 키 칼럼 값을 구하고 싶은 경우에는 PreparedStatementCreator와 Key Holder를 함께
		 * 사용하는 update() 메서드를 호출해주면 된다.
		 * */
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
        return findById(keyHolder.getKey().longValue());
        /*편리한 update() 메서드는 데이터베이스가 생성한 기본 키의 획득을 지원한다. 
         * 이 지원은 JDBC 3.0 표준의 일부분이다. 자세한 내용은 명세서의 13.6장을 참고해라. 
         * 이 메서드는 첫 인자로 PreparedStatementCreator를 받은데 이것이 필수 insert문을 지정하는 방법이다. 
         * 다른 인자는 update가 성공정으로 반환하는 생성된 키를 담고 있는 KeyHolder이다. 
         * 적합한 PreparedStatement (메서드 시그니처가 왜 이렇게 되어 있는지를 설명한다.)를 생성하는 하나의 표준화된 방법은 존재하지 않는다. 
         * */
    }
	
	public List<Post> findAll() {
		String sql = "SELECT postId, writer, title, createdDate, countOfAnswer FROM posts "
				+ "order by postId desc";
		
		RowMapper<Post> rm = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int index) throws SQLException {
				return new Post(rs.getLong("postId"),
						rs.getString("writer"), 
						rs.getString("title"), 
						null,
						rs.getTimestamp("createdDate"),
						rs.getInt("countOfAnswer"));
			}
//			private long postId;
//			private String writer;
//			private String title;
//			private String contents;
//			private Date createdDate;
//			private int countOfComment;
		};
		
		return jdbcTemplate.query(sql, rm);
	}

	public Post findById(long postId) {
		String sql = "SELECT postId, writer, title, contents, createdDate, countOfAnswer FROM posts "
				+ "WHERE postId = ?";
		
		RowMapper<Post> rm = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int index) throws SQLException {
				return new Post(rs.getLong("postId"),
						rs.getString("writer"), 
						rs.getString("title"),
						rs.getString("contents"),
						rs.getTimestamp("createdDate"),
						rs.getInt("countOfAnswer"));
			}
		};
		
		return jdbcTemplate.queryForObject(sql, rm, postId);
	}

	public void update(Post post) {
		String sql = "UPDATE postS set title = ?, contents = ? WHERE postId = ?";
        jdbcTemplate.update(sql, 
        		post.getTitle(),
                post.getContents(),
                post.getpostId());
	}

	public void delete(long postId) {
		String sql = "DELETE FROM postS WHERE postId = ?";
		jdbcTemplate.update(sql, postId);
	}

	public void updateCountOfAnswer(long postId) {
		String sql = "UPDATE postS set countOfAnswer = countOfAnswer + 1 WHERE postId = ?";
		jdbcTemplate.update(sql, postId);
	}
	
	// 게시판 조회수 증가 수정 처리

//		public void updateHit(BoardModel boardModel) {
//			try {
//				// 데이터베이스 객체 생성
//				Class.forName(this.JDBC_DRIVER);
//				this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
//				// 조회수 증가 쿼리 실행
//				this.pstmt = this.conn.prepareStatement("UPDATE BOARD SET HIT = HIT + 1 WHERE NUM = ?");
//				this.pstmt.setInt(1, boardModel.getNum());
//				this.pstmt.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				// 사용한 객체 종료
//				close(null, this.pstmt, this.conn);
//			}
//		}

}
