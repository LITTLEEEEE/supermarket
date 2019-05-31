package cn.edu.supermarket.service.Impl;

import cn.edu.supermarket.dao.UserDao;
import org.junit.Test;

public class userServiceImplTest {
    UserDao userDao ;
    @Test
    public void test(){
    System.out.print(userDao.logincheck("pyh","123"));

    }

}