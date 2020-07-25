package jdbctemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/25 9:34   戴宗明       1.0         None
 */


public class JDBCTemplateDemo2 {
    // Junit单元测试
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 修改account 一号数据
     */
    @Test
    public void test1() {
        String sql = "update account set balance = 1000 where id = ?";
        int count = template.update(sql, 1);
        System.out.println(count);
    }


    /**
     * 查询id位1得记录，将其封装为Map集合
     */
    @Test
    public void test4() {
        String sql = "select * from account where id = ? or id = ?;";
        Map<String, Object> map = template.queryForMap(sql, 1, 2);
        System.out.println(map);
    }

    /**
     * 查询id位1,2得记录，将其封装为Map集合
     */
    @Test
    public void test5() {
        String sql = "select * from account where id = ? or id = ?;";
        List<Map<String, Object>> maps = template.queryForList(sql, 1, 2);
        System.out.println(maps);
    }


}
