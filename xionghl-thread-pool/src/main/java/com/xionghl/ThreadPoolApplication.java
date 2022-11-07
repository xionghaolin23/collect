package com.xionghl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:xionghl
 * @Date:2022/10/8 22:44
 */
@SpringBootApplication
@MapperScan("com.xionghl.mapper")
public class ThreadPoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThreadPoolApplication.class,args);
    }
}
