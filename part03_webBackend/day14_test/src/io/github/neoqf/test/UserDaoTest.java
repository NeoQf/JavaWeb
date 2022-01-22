package io.github.neoqf.test;

import io.github.neoqf.dao.UserDao;
import io.github.neoqf.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123111");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
