package com.tz.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

//实体类
@Alias("User")

@Data
public class User {
    private   int id;
    private  String name;
    private  String password;


}
