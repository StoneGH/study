package org.study.java.designpattern.producer_consumer;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 基于阻塞队列的通道实现
 * Created by shitao on 2018/3/22.
 */
public class BlockingQueueChannel<P> implements Channel {

    private final BlockingQueueChannel<P> queue;

    public BlockingQueueChannel(ArrayBlockingQueue<P> queue) {
        this.queue = null;
    }

    @Override
    public P take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void put(Object product) throws InterruptedException {
        queue.put(product);
    }
}
