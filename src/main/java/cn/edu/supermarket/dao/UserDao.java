package cn.edu.supermarket.dao;

import cn.edu.supermarket.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where username = #{username} and userpass=#{userpass}")
    User logincheck(@Param("username") String username, @Param("userpass") String userpass);

    /**
     * 顾客的注册
     */
    @Insert("insert into user values(null,#{username},#{userpass},0)")
    int addUser(User user);

    /**
     * 用户注册姓名校验
     */
    @Select("select count(*) from user where username=#{name}")
    int nameCheck(@Param("name") String name) ;

    /**
     * 根据id查询用户信息
     */
    @Select("select * from user where userid=#{uid}")
    User geUserInfo(@Param("uid") Integer userid);

    /**
     * 修改密码
     */
    @Update("update user SET userpass=#{pwd} where username = #{username}")
    int updatepwd(@Param("pwd") String pwd, @Param("username") String username);
}
