import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/20 22:09   戴宗明       1.0         None
 */


public class JDBCPractice8 {

    public boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn.setAutoCommit(false);
            // 1 获取链接
            conn = JDBCUtils.getConnection();
            // 2 定义sql
            String sql1 = "update account set balance = balance - ? where id = ?;";
            String sql2 = "update account set balance = balance + ? where id = ?;";
            // 3 获取sql
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            // 4 设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            // 书屋回滚
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt1, conn);
            JDBCUtils.close(null, pstmt2, null);
        }

        return false;
    }

    public static void main(String[] args) {
        JDBCPractice8 jdbcPractice8 = new JDBCPractice8();
        jdbcPractice8.login("a", "a");
    }
}
