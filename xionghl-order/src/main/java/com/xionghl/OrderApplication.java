package com.xionghl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:xionghl
 * @Date:2022/10/7 14:44
 */
@SpringBootApplication
@EnableFeignClients("com.xionghl")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
