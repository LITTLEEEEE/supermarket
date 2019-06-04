package cn.edu.supermarket.service.Impl;

import cn.edu.supermarket.dao.UserDao;
import org.junit.Test;

public class userServiceImplTest {
    UserDao userDao ;
    @Test
    public void test(){
        java.sql.Date ctime = new java.sql.Date(System.currentTimeMillis());
        System.out.println(ctime);
        System.out.print(System.currentTimeMillis());
    }

}