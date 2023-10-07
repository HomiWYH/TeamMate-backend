package com.yupi.yupao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//(exclude = {RedisAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
public class YupaoBackendMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(YupaoBackendMasterApplication.class, args);
    }

}
