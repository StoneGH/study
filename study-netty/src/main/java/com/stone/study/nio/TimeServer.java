package com.stone.study.nio;

/**
 * @ClassName: TimeServer
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2019/12/30 09:07
 * @Version: 1.0
 * @Modified By:
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8123;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
