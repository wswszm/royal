package com.game.royal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.game.royal.mapper")
public class RoyalApliication {
    public static void main(String[] args) {
        SpringApplication.run(RoyalApliication.class, args);
    }
}
