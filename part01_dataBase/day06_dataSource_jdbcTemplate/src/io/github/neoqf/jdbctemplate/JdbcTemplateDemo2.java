package io.github.neoqf.jdbctemplate;

import io.github.neoqf.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {

    // Junit单元测试

    // 1.获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1.修改1号数据的salary为10000
     */
    @Test
    public void test1() {
        // 2.定义SQL
        String sql = "update emp set salary = 10000 where id = 1001";
        // 3.执行SQL
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }
}
