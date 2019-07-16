package com.whiteget;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author fjc
 */
@SpringBootApplication
@MapperScan("com.whiteget.*.dao")
public class WhiteGetApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhiteGetApplication.class, args);
    }
}
