package com.yupi.yupao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.yupao.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.List;

/**
 * Redis 测试
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void Add() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("yupiString", "dog");
        valueOperations.set("yupiInt", 1);
        valueOperations.set("yupiDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("yupi");
        valueOperations.set("yupiUser", user);
        // 查
        /*Object yupi = valueOperations.get("yupiString");
        Assertions.assertTrue("dog".equals((String) yupi));
        yupi = valueOperations.get("yupiInt");
        Assertions.assertTrue(1 == (Integer) yupi);
        yupi = valueOperations.get("yupiDouble");
        Assertions.assertTrue(2.0 == (Double) yupi);
        System.out.println(valueOperations.get("yupiUser"));
        valueOperations.set("yupiString", "dog");
        redisTemplate.delete("yupiString");*/
    }

    @Test
    void search() {
        ValueOperations ops = redisTemplate.opsForValue();
        String yupiString = (String) ops.get("yupiString");
        System.out.println(yupiString);
        int yupiInt = (int) ops.get("yupiInt");
        System.out.println(yupiInt);
        User user = (User) ops.get("yupiUser");
        System.out.println(user);
    }

    @Test
    void redisTest() {
        String redisKey = String.format("yupao:user:recommend:%s", 6);
        System.out.println(redisKey);
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Page<User> userPage = (Page<User>) valueOperations.get(redisKey);
        List<User> records = userPage.getRecords();
        for (User user : records) {
            System.out.println(user);
        }
    }
}
