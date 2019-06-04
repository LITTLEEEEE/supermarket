package cn.edu.supermarket.service;

import cn.edu.supermarket.entity.User;


public interface UserService {

    //用户登陆校验
    public User logincheck(String username, String userpass);

    //顾客注册
    int register(User user);

    /**
     * 用户名是否可用
     */
    boolean isNameExists(String name) ;

    /**
     * 根据id查询用户信息
     */
    User geUserInfo(Integer userid);

    /**
     * 修改密码
     */
    int updatepwd(String pwd, String username);
}
