package cn.edu.supermarket.service;

import cn.edu.supermarket.entity.User;


public interface UserService {

    //用户登陆校验
    public User logincheck(String username, String userpass);


}
