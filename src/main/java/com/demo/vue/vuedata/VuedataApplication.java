package com.demo.vue.vuedata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.vue.vuedata.dao")

public class VuedataApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuedataApplication.class, args);
    }

}
