package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/24 16:47   戴宗明       1.0         None
 */


public class DruidPractice1 {
    public static void main(String[] args) throws Exception {
        // 1 导入jar包
        // 2 定义配置文件
        // 3 加载配置文件
        Properties pro = new Properties();
        InputStream resourceAsStream = DruidPractice1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(resourceAsStream);
        // 3 获取连接对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        // 5 获取链接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
