package io.github.neoqf.dao;

import io.github.neoqf.domain.User;
import io.github.neoqf.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user表的类
 */
public class UserDao {

    // 声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆方法
     * @param loginUser 只有用户名和密码
     * @return 包含用户全部数据，若未查询到返回null
     */
    public User login(User loginUser) {
        try {
            // 1.编写SQL
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();    // 记录日志
            return null;
        }
    }
}
