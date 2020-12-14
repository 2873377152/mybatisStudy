import com.tz.dao.StudentMapper;
import com.tz.dao.TeacherMapper;
import com.tz.pojo.Student;
import com.tz.pojo.Teacher;
import com.tz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> student = mapper.getStudent();
      for(Student student1:student){
          System.out.println(student1);
      }
        sqlSession.commit();
        sqlSession.close();

    }


}
