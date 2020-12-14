package com.tz.dao;

import com.tz.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生信息以及对应老师信息
    public List<Student> getStudent();
}
