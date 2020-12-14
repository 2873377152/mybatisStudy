package com.tz.dao;

import com.tz.pojo.User;
import com.tz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class UserMapperTest {
  static Logger logger = Logger.getLogger(String.valueOf(UserMapperTest.class));

  @Test
    public void test(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//      List<User> users = mapper.getUsers();
//      for(User user :users){
//          System.out.println(user);
//      }

    User user = mapper.getUserById(1);
    System.out.println(user);

    sqlSession.close();
  }
  @Test
  public  void addUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    int res = mapper.addUser(new User(11,"迪迦","1121"));
    sqlSession.commit();
    sqlSession.close();


  }
  @Test
  public  void updateUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    int res = mapper.update(new User(3,"露娜","4959"));
    sqlSession.commit();
    sqlSession.close();


  }  @Test
  public  void deleteUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    int res = mapper.deleteUser(6);
    sqlSession.commit();
    sqlSession.close();


  }



//    @Test
//
//    public void getUserlist() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserById(1);
//
//        System.out.println(user);
//
//        sqlSession.commit();
//        sqlSession.close();
//
//
//    }
//
//    @Test
//    public  void getUserLimit(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        HashMap<String,Integer> map=new HashMap<String,Integer>();
//        map.put("startIndex",1);
//        map.put("pageSize",4);
//        List<User> userlist = mapper.getUserLimit(map);
//        for (User user:userlist){
//            System.out.println(user);
//        }
//
//
//        sqlSession.commit();
//        sqlSession.close();
//    }


//
//
//
//
//@Test
////
//    public  void testLog4j(){
//
//        logger.info("info：进入到了info模式");
//
//
//}

}
