package com.stone.study.studynetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @ClassName: FixedLengthFrameDecoderTest
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2020/01/13 14:22
 * @Version: 1.0
 * @Modified By:
 */
public class FixedLengthFrameDecoderTest {

    public static void testFramesDecoded() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        assert (channel.writeInbound(input.retain()));

        assert (channel.finish());


        // read messages
        ByteBuf read = (ByteBuf) channel.readInbound();
        System.out.println(buf.readSlice(3) == read);
        read.release();
        read = (ByteBuf) channel.readInbound();
        System.out.println(buf.readSlice(3) == read);
        read.release();
        read = (ByteBuf) channel.readInbound();
        System.out.println(buf.readSlice(3) == read);
        read.release();
        System.out.println(channel.readInbound() == null);
        buf.release();
    }

    public static void main(String[] args) {
        testFramesDecoded();
    }
}
