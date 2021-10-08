package com.stone.wss.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ListenerMessage
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2021/10/08 15:59
 * @Version: 1.0
 * @Modified By:
 */
@Slf4j
@Component
public class ListenerMessage  implements StreamListener<String, MapRecord<String, String, String>> {
    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        log.info("接受到来自redis的消息");
        System.out.println("message id "+message.getId());
        System.out.println("stream "+message.getStream());
        System.out.println("body "+message.getValue());
    }
}
