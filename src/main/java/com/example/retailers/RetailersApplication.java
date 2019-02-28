package com.example.retailers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.retailers.bean")
public class RetailersApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailersApplication.class, args);
    }

}
