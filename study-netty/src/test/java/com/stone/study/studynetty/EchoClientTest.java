package com.stone.study.studynetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @ClassName： EchoClientTest
 * @Description： TODO
 * @Author： Stone
 * @Date： 2020/2/21 下午2:43
 * @Version： 1.0
 **/
public class EchoClientTest {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress("127.0.0.1", 8040)).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ClientHandler());
                }
            });
            ChannelFuture future = b.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }
}

class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Say Hello！！", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println(buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
