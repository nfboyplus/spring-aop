package com.spring.cn.test.transcation.service.impl;

import com.spring.cn.test.transcation.dao.UserDao;
import com.spring.cn.test.transcation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
        userDao.add(1, "刘松", 28);
        System.out.println("---- 向数据库添加数据 ----");
        // 没有加入事务处理之前：抛出异常，不继续执行，但是上面的数据插入到数据库，没有回滚；
        int i = 10/0;
        userDao.add(2, "刘刘",18);
    }

    @Override
    public void insert() {
        userDao.insert(1, "刘松", 28);
        System.out.println("---- 向数据库添加数据 ----");
        // 加入事务：抛出异常，不继续执行，上面的数据未插入到数据库，数据回滚；
        int i = 10/0;
        userDao.insert(2, "刘刘",18);
    }

    /**
     * 如果要 try catch，一定要在catch手动回滚，因为避免数据库更新产生死锁；
     */
    @Override
    public void update(){
        try {
            userDao.update(1,"松子",16);
        }catch (Exception e){
            //获取当前事务，进行手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    /**
     * 注意：开启事务的时候，不要 try catch，将异常抛给外层AOP处理；
     */

}
