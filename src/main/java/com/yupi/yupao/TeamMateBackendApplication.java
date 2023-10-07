package com.yupi.yupao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//(exclude = {RedisAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.yupi.yupao.mapper")
@EnableScheduling
public class TeamMateBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamMateBackendApplication.class, args);
    }

}
