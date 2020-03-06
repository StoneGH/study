package com.stone.study.netty.handler;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName： ChannelHandlerPool
 * @Description： 通道组池，管理所有的websockt连接
 * @Author： Stone
 * @Date： 2020/3/3 下午6:26
 * @Version： 1.0
 **/
public class ChannelHandlerPool {
    public ChannelHandlerPool() {
    }

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
