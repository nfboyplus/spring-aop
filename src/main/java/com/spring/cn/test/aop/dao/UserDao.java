package com.spring.cn.test.aop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * created on 2019/7/22 9:25
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name, Integer age) {
        String sql = "INSERT INTO test_user (`name`, age) VALUES(?,?);";
        int updateResult = jdbcTemplate.update(sql, name, age);
        System.out.println("updateResult:" + updateResult);
    }

}
