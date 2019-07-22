package com.spring.cn.test.transcation;

import com.spring.cn.test.transcation.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务：开启事务的时候，不要 try catch，将异常抛给外层AOP处理；
 */
public class TransactionTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-transaction.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        // 未加事务方法
//        userService.add();
        // 加入事务方法
        userService.insert();
    }

    /**
     * 事务特性：原子性、一致性、持久性、隔离性
     */
}
