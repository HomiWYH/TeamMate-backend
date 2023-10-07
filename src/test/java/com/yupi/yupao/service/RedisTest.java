package com.yupi.yupao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.yupao.model.domain.User;
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
    void redisTest() {
        String redisKey = String.format("yupiyupao:user:recommend:%s", 6);
        System.out.println(redisKey);
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Page<User> userPage = (Page<User>) valueOperations.get(redisKey);
        List<User> records = userPage.getRecords();
        for (User user : records) {
            System.out.println(user);
        }
    }
}
