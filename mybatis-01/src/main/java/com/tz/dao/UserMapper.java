package com.tz.dao;

import com.tz.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);

    User getUserById2(Map<String,Object> map);

    //insert一个用户
    int addUser(User user);
    //insert 一个用户
    int addUser2(Map<String,Object> map);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
    //模糊查询
    List<User> getUserlike(String value);

}
