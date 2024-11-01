package com.motaz.preload;


import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedisDocumentRepositories
public class DataPreloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataPreloadApplication.class, args);
    }
}
