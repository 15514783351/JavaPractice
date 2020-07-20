/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/19 21:05   戴宗明       1.0         None
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 练习：
 *     需求：
 *     1. 通过键盘录入用户名和密码
 *     2. 判断用户是否登陆成功
 *        select * from user where username = "" and password = "";
 *        有数据代表成功
 *
 */
public class JDBCPractice7 {
    /**
     * 登陆方法 使用PrepareStatement实现
     */

    public boolean login(String username, String password) {

        if (username == null || password == null) return false;
        // 获取数据库连接
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            // 2 定义sql
            String sql = "select * from user where name = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pstmt, conn);
        }
        return false;
    }
    public static void main(String[] args) {
        // 1. 键盘录入 接受用户名密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        JDBCPractice7 jdbcPractice6 = new JDBCPractice7();
        boolean flag = jdbcPractice6.login(username, password);
        if (flag) System.out.println("登陆成功");
        else System.out.println("登陆失败");
    }
}
