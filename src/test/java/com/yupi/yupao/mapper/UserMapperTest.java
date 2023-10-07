package com.yupi.yupao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.yupao.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getAll() {
        List<User> users = userMapper.selectList(null);
    }

    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("王老五");
            String newAcc = String.valueOf(String.format("%0" + 4 + "d", i + 1));
            user.setUserAccount("homi" + newAcc);
            user.setAvatarUrl("https://img2.baidu.com/it/u=1133753674,2890846820&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=585");
            int gender = (int) Math.round(Math.random());
            user.setGender(gender);
            user.setUserPassword("0a6eeafe9b745a2786347853d28efc12");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            String planetcode = (int) (Math.random() * 100000) + "";
            user.setPlanetCode(planetcode);
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }


}