package com.wangyunqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.wangyunqi.**")
@MapperScan("com.wangyunqi.mapper")
public class GraduationApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduationApplication.class, args);
    }
}
