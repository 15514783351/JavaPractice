/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/13 10:34   戴宗明       1.0         None
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * update一条数据
 */
public class JDBCPractice3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        // 1. 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库操作对象Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/selecttest?serverTimezone=GMT", "root", "dzm940929347");
            // 3. 编写mysql语句
            String sql = "update account set balance = 1500 where id = 3;";
            // 4. 获取执行sql的Statement语句
            statement = connection.createStatement();
            // 5. 执行mysql，返回执行结果
            int count = statement.executeUpdate(sql);
            // 6. 处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }
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
