package com.tz.dao;

import com.tz.pojo.User;
import com.tz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    //查询所有用户
    public void test() {
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }


        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    //根据id查询用户
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);


        sqlSession.close();
    }

    @Test
    //插入用户，注意必须要提交事务
    public  void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(10, "蔡徐坤", "283737"));
        if (res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    //更新用户
    public  void updateUser(){
       SqlSession sqlSession =MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res=mapper.updateUser(new User(10,"滴滴","123"));
        if (res>0){
            System.out.println("更新成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    //删除用户
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res=mapper.deleteUser(10);
        if (res>0){
            System.out.println("删除成功");
        }
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    /*
                     万能map
     */


    //添加用户
    public  void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       Map<String,Object> map=new HashMap<String,Object>();
       map.put("userid",4);
       map.put("username","zhang");
       map.put("password",123);
       mapper.addUser2(map);
       sqlSession.commit();
        sqlSession.close();
    }
    @Test
    //根据id查询用户
    public  void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userid",5);
        User user=mapper.getUserById2(map);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    //模糊查询
    public  void getUserlike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userlist = mapper.getUserlike("张");
        for (User user:userlist){
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();


    }



}
