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

    @Override
    public int register(User user) {
        if(null == user) {
            return 0;
        }
        return userDao.addUser(user) > 0 ? 1 : 0;
    }

    @Override
    public boolean isNameExists(String name) {
        int count = userDao.nameCheck(name) ;
        return count > 0 ? true : false ;
    }

    @Override
    public User geUserInfo(Integer userid) {
        return userDao.geUserInfo(userid);
    }

    @Override
    public int updatepwd(String pwd, Integer userid) {
        return userDao.updatepwd(pwd, userid);
    }
}
