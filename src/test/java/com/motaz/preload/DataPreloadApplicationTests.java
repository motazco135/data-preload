package com.motaz.preload;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DataPreloadApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedisTemplateWithString() {
        redisTemplate.opsForValue().set("testKey", "testValue");
        String result = redisTemplate.opsForValue().get("testKey");
        System.out.println("Result: " + result); // Should print "testValue"
    }

}
