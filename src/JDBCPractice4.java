/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/13 10:55   戴宗明       1.0         None
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除表中的记录
 */
public class JDBCPractice4 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        // 1. 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 创建connection链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/selecttest?serverTimezone=GMT", "root", "dzm940929347");
            // 3. 编写sql语句
            String sql = "delete from account where id = 3;";
            // 4. Statement
            statement = connection.createStatement();
            // 执行sql
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) System.out.println("删除成功");
            else System.out.println("为执行成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
