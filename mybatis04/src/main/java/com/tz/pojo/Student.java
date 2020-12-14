package com.tz.pojo;

import lombok.Data;

import javax.swing.*;
@Data
public class Student {
    private  int id;
    private String name;
    private Teacher teacher;
}
