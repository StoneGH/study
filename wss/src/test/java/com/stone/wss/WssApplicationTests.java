package com.stone.wss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class WssApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void createStream() {
        Map map = new HashMap();
        map.put("*", "1111");
        RecordId recordId = redisTemplate.opsForStream().add("test-stream", map);
        redisTemplate.opsForStream().delete("test-stream", recordId.getValue());
    }
}
