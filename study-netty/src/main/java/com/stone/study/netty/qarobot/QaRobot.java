package com.stone.study.netty.qarobot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName： QaRobot
 * @Description： TODO
 * @Author： Stone
 * @Date： 2020/3/6 下午6:51
 * @Version： 1.0
 **/
public class QaRobot {
    private static Map<String, String> kbs = new HashMap<>();

    static {
        kbs.put("你好", "您好！");
        kbs.put("您好", "需要什么帮助？");
    }

    public static String match(String q) {
        String a = kbs.get(q);
        if (null == a) {
            a = "你说什么？不太明白。";
        }
        return a;
    }
}
