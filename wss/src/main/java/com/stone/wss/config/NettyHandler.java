package com.stone.wss.config;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName: NettyHandler
 * @Desc: //TextWebSocketFrame是netty用于处理websocket发来的文本对象
 * @Auther: shitao
 * @Date: 2022/01/20 16:11
 * @Version: 1.0
 * @Modified By:
 */
public class NettyHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //所有正在连接的channel都会存在这里面，所以也可以间接代表在线的客户端
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //在线人数
    public static int online;

    /**
     * @Desc: 接收到客户都发送的消息
     * @Author: shitao
     * @Date: 2022/1/20 0020 16:12
     * @Param channelHandlerContext
     * @Param textWebSocketFrame
     * @Return: <p></p>
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        SendAllMessages(channelHandlerContext, textWebSocketFrame);//send_message是我的自定义类型，前后端分离往往需要统一数据格式，可以先把对象转成json字符串再发送给客户端
        channelHandlerContext.channel().close();
    }

    //客户端建立连接
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        online=channelGroup.size();
        System.out.println(ctx.channel().remoteAddress()+"上线了!");
    }
    //关闭连接
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.remove(ctx.channel());
        online=channelGroup.size();
        System.out.println(ctx.channel().remoteAddress()+"断开连接");
    }

    //出现异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    //给某个人发送消息
    private void SendMessage(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame(msg.text()));
    }

    //给每个人发送消息,除发消息人外
    private void SendAllMessages(ChannelHandlerContext ctx,TextWebSocketFrame msg) {
        for(Channel channel:channelGroup){
            if(!channel.id().asLongText().equals(ctx.channel().id().asLongText())){
                channel.writeAndFlush(new TextWebSocketFrame(msg.text()));
            }
        }
    }
}
