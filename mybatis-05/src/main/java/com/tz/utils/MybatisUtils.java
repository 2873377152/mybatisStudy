package com.tz.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//SqlSessionFactory 中获取 SqlSession
public class MybatisUtils {

    private  static  SqlSessionFactory sqlSessionFactory;
    static {

        try {
            //获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream  inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //有了SqlSessionFactory对象，就可以获取Sqlsession实例
    //Sqlsession对象包含了面向数据库执行SQL命令的所有方法
    public  static SqlSession getSqlSession(){
     return sqlSessionFactory.openSession();
    }


}
