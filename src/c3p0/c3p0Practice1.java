package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/24 16:07   戴宗明       1.0         None
 */


public class c3p0Practice1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 1 创建数据库连接池对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 10; i++) {
            // 2 获取连接对象
            Connection conn = ds.getConnection();

            // 3 打印

            System.out.println(i + "" + conn);
        }


    }
}
