package com.demo.multi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.multi.dao")
public class MultiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiWebApplication.class, args);
    }

}
