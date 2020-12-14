package com.tz.dao;

import com.tz.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);
    //查询数据
    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogForeach(Map map);
    List<Blog> queryBlogChoose(Map map);
    //更新博客
    int updateBlog(Map map);
    //sql片段
    List<Blog> queryBlogIFSql(Map map);
}
