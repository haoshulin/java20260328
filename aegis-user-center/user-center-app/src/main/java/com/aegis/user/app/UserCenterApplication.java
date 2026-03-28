package com.aegis.user.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户中心启动类
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aegis.user.api")
@MapperScan("com.aegis.user.dao")
@ComponentScan(basePackages = {"com.aegis.user"})
@SpringBootApplication
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}