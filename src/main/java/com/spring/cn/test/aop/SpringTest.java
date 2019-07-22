package com.spring.cn.test.aop;

import com.spring.cn.test.aop.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP：切面编程
 */
public class SpringTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.add();
    }

}
