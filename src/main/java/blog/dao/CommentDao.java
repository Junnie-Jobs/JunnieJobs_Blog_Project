package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import blog.model.Comment;

@Repository
public class CommentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    public Comment insert(Comment comment) {
        String sql = "INSERT INTO comments (writer, writerImage, contents, createdDate, postId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, comment.getWriter());
				pstmt.setString(2,  comment.getWriterImage());
				pstmt.setString(3, comment.getContents());
				pstmt.setTimestamp(4, new Timestamp(comment.getTimeFromCreateDate()));
				pstmt.setLong(5, comment.getPostId());
				return pstmt;
			}
		};
        //test
		 // 사용하는 update() 메서드를 호출해주면 된다.
		KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        return findById(keyHolder.getKey().longValue());
    }

    public Comment findById(long commentId) {
        String sql = "SELECT commentId, writer, writerImage, contents, createdDate, postId FROM comments WHERE commentId = ?";

        RowMapper<Comment> rm = new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int index) throws SQLException {
                return new Comment(rs.getLong("commentId"), 
                		rs.getString("writer"), 
                		rs.getString("writerImage"),
                		rs.getString("contents"),
                        rs.getTimestamp("createdDate"), 
                        rs.getLong("postId"));
            }
        };

        return jdbcTemplate.queryForObject(sql, rm, commentId);
    }

    public List<Comment> findAllByPostId(long postId) {
        String sql = "SELECT commentId, writer, writerImage, contents, createdDate FROM comments WHERE postId = ? "
                + "order by commentId desc";

        RowMapper<Comment> rm = new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int index) throws SQLException {
                return new Comment(rs.getLong("commentId"), 
                		rs.getString("writer"), 
                		rs.getString("writerImage"),
                		rs.getString("contents"),
                        rs.getTimestamp("createdDate"), 
                        postId);
            }
        };

        return jdbcTemplate.query(sql, rm, postId);
    }

	public void delete(Long commentId) {
        String sql = "DELETE FROM comments WHERE commentId = ?";
        jdbcTemplate.update(sql, commentId);
	}


}
