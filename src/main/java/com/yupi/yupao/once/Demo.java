package com.yupi.yupao.once;

import com.yupi.yupao.mapper.UserMapper;
import com.yupi.yupao.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@Component
public class Demo {

    @Resource
    private UserMapper userMapper;

    /**
     * 定时任务
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000, fixedRate = 3000)
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("goodgoodgood");
        stopWatch.start();
        /*final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假鱼皮");
            user.setUserAccount("homi001");
            user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
            user.setGender(0);
            user.setUserPassword("123456789");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111111");
            userMapper.insert(user);
        }*/
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String newAdd = String.valueOf(String.format("%0" + 3 + "d", i+1));
            System.out.println(newAdd);
        }
    }
}
