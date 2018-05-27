package com.bc.service;

import com.bc.dao.IUser;
import com.bc.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserInfoService") //在spring配置里面声明是个bean，就是getbean("")得到那样
public class UserInfoService {
    @Autowired
    private IUser iuser;
    /**
     * 校验用户登录
     * @param loginName 登录名
     * @param passWord 登录密码
     * @return
     */
    public User checkUser(String loginName, String passWord) {

        return iuser.checkUser(loginName, passWord);
    }


}
