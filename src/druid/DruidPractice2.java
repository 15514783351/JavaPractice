package druid;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/24 18:35   戴宗明       1.0         None
 */

import com.alibaba.druid.util.JdbcUtils;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidPractice2 {
    public static void main(String[] args) {
        /**
         * 完成添加操作, 给account表添加一条记录
         */

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1 获取链接
            conn = JDBCUtils.getConnection();
            // 2 定义sql
            String sql = "insert into account values(null, ?, ?)";
//            String sql = "update account set balance = balance - ? where id = ?;";
            // 3 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 4 给？赋值
            pstmt.setString(1, "王五");
            pstmt.setInt(2, 2000);
            // 5 执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6 释放资源
            JDBCUtils.close(pstmt, conn);
        }
    }

}
