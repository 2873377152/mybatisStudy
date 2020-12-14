package com.tz.dao;

import com.tz.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select *from users")
    List<User> getUsers();
    @Select("select id,name,psw as password from users where id=#{id}")
    User getUserById(@Param("id") int id);
    @Insert("insert into users(id,name,psw) values(#{id},#{name},#{password})")
    int addUser(User user);
    @Update("update users set name=#{name},psw=#{password} where id=#{id}")
    int update(User user);

    @Delete("delete from users where id=#{uid}")
    int deleteUser(@Param("uid") int id);


}
