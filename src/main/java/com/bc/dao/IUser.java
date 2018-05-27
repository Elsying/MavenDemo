package com.bc.dao;

import com.bc.view.User;
import org.apache.ibatis.annotations.Param;

public interface  IUser {
//当你不使用@Param注解来声明参数时，必须使用使用 #{}方式。如果使用 ${} 的方式，会报错。
    //当你使用了使用@Param注解来声明参数时，如果使用 #{} 或 ${} 的方式都可以。
    User checkUser(@Param("username") String loginName, @Param("password") String passWord);
}
