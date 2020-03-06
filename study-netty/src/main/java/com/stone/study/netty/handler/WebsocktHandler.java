package com.stone.study.netty.handler;

import com.alibaba.fastjson.JSON;
import com.stone.study.netty.qarobot.QaRobot;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName： WebsocktHandler
 * @Description： TODO
 * @Author： Stone
 * @Date： 2020/3/3 下午6:20
 * @Version： 1.0
 **/
public class WebsocktHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");
        ChannelHandlerPool.channels.add(ctx.channel());
        ctx.writeAndFlush(new TextWebSocketFrame("您好！客服【小萌】为您服务！"));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
        ChannelHandlerPool.channels.remove(ctx.channel());
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //首次连接是FullHttpRequest，处理参数 by zhengkai.blog.csdn.net
        if (null != msg && msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String uri = request.uri();

            Map<String, String> paramMap = getUrlParams(uri);
            System.out.println("接收到的参数是：" + JSON.toJSONString(paramMap));
            String uid = paramMap.get("uid");
            String cid = ctx.channel().id().asShortText();
            System.out.println("uid:" + uid + ",cid=" + cid);
            //如果url包含参数，需要处理
            if (uri.contains("?")) {
                String newUri = uri.substring(0, uri.indexOf("?"));
                System.out.println(newUri);
                request.setUri(newUri);
            }

        } else if (msg instanceof TextWebSocketFrame) {
            //正常的TEXT消息类型
            TextWebSocketFrame frame = (TextWebSocketFrame) msg;
            System.out.println("客户端收到服务器数据：" + frame.text());
            String a = QaRobot.match(frame.text().split(":")[1]);
            ctx.writeAndFlush(new TextWebSocketFrame(a));
        }
        super.channelRead(ctx, msg);
    }

    private void sendAllMessage(String message) {
        //收到信息后，群发给所有channel
        ChannelHandlerPool.channels.writeAndFlush(new TextWebSocketFrame(message));
    }

    private static Map getUrlParams(String url) {
        Map<String, String> map = new HashMap<>();
        url = url.replace("?", ";");
        if (!url.contains(";")) {
            return map;
        }
        if (url.split(";").length > 0) {
            String[] arr = url.split(";")[1].split("&");
            for (String s : arr) {
                String key = s.split("=")[0];
                String value = s.split("=")[1];
                map.put(key, value);
            }
            return map;

        } else {
            return map;
        }
    }
}
