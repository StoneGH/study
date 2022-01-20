package com.stone.wss.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName: NettyServer
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2022/01/20 16:04
 * @Version: 1.0
 * @Modified By:
 */
public class NettyServer {
    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        //创建主线程组，接收请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //创建从线程组，处理主线程组分配下来的io操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建netty服务器
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)//设置主从线程组
                    .channel(NioServerSocketChannel.class)//设置通道
                    .childHandler(new NettyServerInitializer());//子处理器，用于处理workerGroup中的操作
            //启动server
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //监听关闭channel
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();//关闭主线程
            workerGroup.shutdownGracefully();//关闭从线程
        }
    }
}
