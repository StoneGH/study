package com.stone.wss.config;

import com.stone.wss.component.ListenerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;

import java.time.Duration;

/**
 * @ClassName: RedisStreamConfig
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2021/10/08 16:00
 * @Version: 1.0
 * @Modified By:
 */
@Configuration
public class RedisStreamConfig {
    @Autowired
    private ListenerMessage streamListener;

    @Bean
    public Subscription subscription1(RedisConnectionFactory factory) {
        StreamMessageListenerContainer.StreamMessageListenerContainerOptions options = StreamMessageListenerContainer
                .StreamMessageListenerContainerOptions
                .builder()
                .pollTimeout(Duration.ofSeconds(1))
                .build();
        StreamMessageListenerContainer listenerContainer = StreamMessageListenerContainer.create(factory, options);
        Subscription subscription = listenerContainer.receiveAutoAck(Consumer.from("mygroup", "huhailong"),
                StreamOffset.create("mystream", ReadOffset.lastConsumed()), streamListener);
        listenerContainer.start();
        return subscription;
    }

    @Bean
    public Subscription subscription2(RedisConnectionFactory factory) {
        StreamMessageListenerContainer.StreamMessageListenerContainerOptions options = StreamMessageListenerContainer
                .StreamMessageListenerContainerOptions
                .builder()
                .pollTimeout(Duration.ofSeconds(1))
                .build();
        StreamMessageListenerContainer listenerContainer = StreamMessageListenerContainer.create(factory, options);
        Subscription subscription = listenerContainer.receiveAutoAck(Consumer.from("mygroup", "huhailong"),
                StreamOffset.create("mystream2", ReadOffset.lastConsumed()), streamListener);
        listenerContainer.start();
        return subscription;
    }
    //XADD mystream * message springboot
    //XGROUP CREATE mystream mygroup 0
}
