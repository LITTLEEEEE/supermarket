package cn.edu.supermarket.service.Impl;

import cn.edu.supermarket.dao.UserDao;
import cn.edu.supermarket.entity.User;
import cn.edu.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User logincheck(String username, String userpass) {
        return(userDao.logincheck(username, userpass));
    }
}
