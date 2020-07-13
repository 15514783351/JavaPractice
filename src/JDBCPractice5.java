import java.sql.*;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/13 14:52   戴宗明       1.0         None
 */


public class JDBCPractice5 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // 1. 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 创建connection链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/selecttest?serverTimezone=GMT", "root", "dzm940929347");
            // 3. 编写sql语句
            String sql = "select * from account;";
            // 4. Statement
            statement = connection.createStatement();
            // 5 执行sql
            resultSet = statement.executeQuery(sql);
            // 6. 处理结果
            // 6.1 让游标享下移动一行
            boolean next = false;
            while ((next = resultSet.next()) != false) {
                // 6.2 获取数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int balance = resultSet.getInt(3);
                System.out.println(id + "---" + name + "---" + balance);
            }

//            if (count > 0) System.out.println("删除成功");
//            else System.out.println("为执行成功");
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
