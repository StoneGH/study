package com.stone.study.netty.server;

import com.stone.study.netty.handler.WebsocktHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import jdk.nashorn.internal.runtime.logging.Logger;

/**
 * @ClassName： NettyServer
 * @Description： TODO
 * 参考：https://blog.csdn.net/moshowgame/article/details/91552993
 * @Author： Stone
 * @Date： 2020/3/3 下午5:54
 * @Version： 1.0
 **/
@Logger
public class NettyServer {
    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.option(ChannelOption.SO_BACKLOG, 1024);
            server.group(parentGroup, childGroup).channel(NioServerSocketChannel.class).localAddress(this.port).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    System.out.println("接收到新链接");
                    //websockt协议基于http协议，使用http编解码器
                    socketChannel.pipeline().addLast(new HttpServerCodec());
                    //以块的方式来写的处理器
                    socketChannel.pipeline().addLast(new ChunkedWriteHandler());
                    socketChannel.pipeline().addLast(new HttpObjectAggregator(8192));
                    socketChannel.pipeline().addLast(new WebsocktHandler());
                    socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", null, true, 65536 * 10));

                }
            });
            ChannelFuture future = server.bind().sync();
            System.out.println("启动正在监听：" + future.channel().localAddress());
            future.channel().closeFuture().sync();
        } finally {
            //释放线程资源
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();

        }


    }
}
