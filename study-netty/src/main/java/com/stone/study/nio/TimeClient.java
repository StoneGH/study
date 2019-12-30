package com.stone.study.nio;

import com.stone.study.nio.AsyncTimeClientHandler;

/**
 * @ClassName: TimeClient
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2019/12/30 11:43
 * @Version: 1.0
 * @Modified By:
 */
public class TimeClient {
    public static void main(String[] args) throws InterruptedException {
        int port = 8123;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
        Thread.sleep(20000);
    }
}
