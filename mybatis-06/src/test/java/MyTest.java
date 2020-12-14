import com.tz.dao.BlogMapper;
import com.tz.pojo.Blog;
import com.tz.utils.IDutils;
import com.tz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
  @Test
  public  void addInitBlog(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      Blog blog = new Blog();
      blog.setId(IDutils.getId());
      blog.setTitle("adada");
      blog.setAuthor("王一博");
      blog.setCreateTime(new Date());
      blog.setViews(122);
      mapper.addBlog(blog);


      blog.setId(IDutils.getId());
      blog.setTitle("jisfjisoj");
      mapper.addBlog(blog);

      blog.setId(IDutils.getId());
      blog.setTitle("java");
      mapper.addBlog(blog);

      blog.setId(IDutils.getId());
      blog.setTitle("spring");
      mapper.addBlog(blog);


      sqlSession.commit();
      sqlSession.close();


  }

  @Test
    public  void queryBlogIF(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      HashMap map=new HashMap();
      List<Blog> blogs = mapper.queryBlogIF(map);
      for (Blog blog:blogs){
          System.out.println(blog );
      }

      sqlSession.commit();
      sqlSession.close();
  }
    @Test
    public  void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("author","王一博");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog:blogs){
            System.out.println(blog );
        }

        sqlSession.commit();
        sqlSession.close();
    }
 @Test
    public  void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("author","吴亦凡");
        map.put("title","99999");
        map.put("id","1");
        mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void queryBlogIFSql(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("author","吴亦凡");
        map.put("title","99999");
        map.put("id","1");
            List<Blog> blogs = mapper.queryBlogIFSql(map);
        for(Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for(Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }



}
