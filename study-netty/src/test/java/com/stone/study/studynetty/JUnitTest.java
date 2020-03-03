package com.stone.study.studynetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @ClassName： JUnitTest
 * @Description： TODO
 * @Author： Stone
 * @Date： 2020/3/2 下午2:37
 * @Version： 1.0
 **/
public class JUnitTest {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes("ABC".getBytes());
        EmbeddedChannel channel = new EmbeddedChannel(new TestMessageDecoder());
        channel.writeInbound(buf);
        channel.finish();

    }

}

class TestMessageDecoder extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("byte:" + byteBuf.toString(CharsetUtil.UTF_8));
    }
}
