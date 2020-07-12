/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/12 9:37   戴宗明       1.0         None
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 快速入门：
 * 步骤：
 *      1. 导入驱动jar包
 *      2. 注册驱动
 *      3. 获取数据库操作对象Connection
 *      4. 定义sql
 *      5. 获取执行sql语句的对象Statement
 *      6. 执行sql，接受返回结果
 *      7. 处理结果
 *      8. 释放资源
 *
 */
public class JDBCPractice {
    public static void main(String[] args) throws Exception {
        // 1. 导入驱动jar包
        // 2. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 3. 获取数据库操作对象Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/selecttest?serverTimezone=GMT", "root", "dzm940929347");
        // 4. 定义sql
        String sql = "update score set degree = 93 where sno = 103 and cno = '3-105'";
        // 5. 获取执行sql语句的对象Statement
        Statement statement = connection.createStatement();
        // 6. 执行sql，接受返回结果
        int count = statement.executeUpdate(sql);
        // 7. 处理结果
        System.out.println(count);
        // 8. 释放资源
        statement.close();
        connection.close();

    }
}
