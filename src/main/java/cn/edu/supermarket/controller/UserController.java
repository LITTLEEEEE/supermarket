package cn.edu.supermarket.controller;

import cn.edu.supermarket.bean.Page;
import cn.edu.supermarket.entity.User;
import cn.edu.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Page logincheck(@RequestParam("username")String username,@RequestParam("userpass")String userpass){
        System.out.print("d");
        User user = userService.logincheck(username, userpass);
        Page page = new Page();
        if(user==null){
            Map data = new HashMap();
            page = new Page(0,"登陆失败",data);
        }else{
            int i = 1;
            Map data = new HashMap();
            data.put("role",user.getType());
            data.put("userid",user.getUserid());
            page = new Page(i,"登陆成功",data);
        }
        return page;
    }
    @RequestMapping("hello")
    @ResponseBody
    String hello(@RequestParam("id")int id){
        return("hello");
    }
}
