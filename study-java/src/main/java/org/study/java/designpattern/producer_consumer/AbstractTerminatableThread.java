package org.study.java.designpattern.producer_consumer;

import java.io.File;

/**
 * 消费者
 * Created by shitao on 2018/3/22.
 */
public abstract class AbstractTerminatableThread extends Thread {
    protected abstract void doRun() throws Exception;

    public abstract void terminate();
}
