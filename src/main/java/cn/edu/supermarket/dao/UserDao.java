package cn.edu.supermarket.dao;

import cn.edu.supermarket.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where username = #{username} and userpass=#{userpass}")
    User logincheck(@Param("username")String username, @Param("userpass")String userpass);
}
