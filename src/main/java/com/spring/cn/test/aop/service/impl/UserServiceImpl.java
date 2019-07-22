package com.spring.cn.test.aop.service.impl;

import com.spring.cn.test.aop.dao.UserDao;
import com.spring.cn.test.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created on 2019/7/22 9:34
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        //如果在此处 try catch ，异常通知仍然会执行；
        //若不用 try catch，则AOP会把异常抛出；
//        int i = 10/0;
        System.out.println("---- 向数据库添加数据 ----");
    }
}
