package com.yupi.yupao.service;

import com.yupi.yupao.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    private ExecutorService executorService =
            new ThreadPoolExecutor(40, 1000, 10000,
                    TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    @Test
    void searchUsersByTags() {
        List<String> tagNameList = Arrays.asList("java", "C++");
        List<User> userList = userService.searchUsersByTags(tagNameList);
        System.out.println(userList);
//        Assert.assertNotNull(userList);
    }

    /**
     * 批量插入数据
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("张老七");
            String newAcc = String.valueOf(String.format("%0" + 6 + "d", i + 1));
            user.setUserAccount("zhanglaoqi" + newAcc);
            user.setAvatarUrl("https://img2.baidu.com/it/u=1133753674,2890846820&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=585");
            int gender = (int) Math.round(Math.random());
            user.setGender(gender);
            user.setUserPassword("0a6eeafe9b745a2786347853d28efc12");
            user.setPhone("789");
            user.setEmail("789@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            String planetcode = (int) (Math.random() * 100000000) + "";
            user.setPlanetCode(planetcode);
            userList.add(user);
        }
        //40秒
//        userService.saveBatch(userList, 10000);
        //43秒
        //userService.saveBatch(userList, 1000);
        //33秒
        userService.saveBatch(userList, 50000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 分十组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("一蓑烟雨任平生");
                user.setUserAccount("sushi");
                user.setAvatarUrl("https://img2.baidu.com/it/u=1133753674,2890846820&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=585");
                user.setGender(0);
                user.setUserPassword("0a6eeafe9b745a2786347853d28efc12");
                user.setPhone("123");
                user.setEmail("123@qq.com");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("11111111");
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            // 异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName: " + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        // 20 秒 10 万条
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}