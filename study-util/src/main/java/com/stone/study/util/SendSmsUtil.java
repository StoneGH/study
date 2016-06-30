package com.stone.study.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendSmsUtil {

	private static final String addr = "http://api.sms.cn/mt/";
	private static final String userId = "52493";

	/*
	 * 如uid是：52493，登录密码是：ys7802ui1 pwd=md5(ys7802ui152493),即
	 * pwd=d514404bc6204cab75b281b536abfae1
	 * 
	 * 线生成地址：http://www.sms.cn/password
	 */

	private static final String pwd = "d514404bc6204cab75b281b536abfae1";

	private static final String encode = "utf8";

	public static String sendSms(String msgContent, String mobile) throws Exception {
		// 组建请求
		String straddr = addr + "?uid=" + userId + "&pwd=" + pwd + "&mobile="
				+ mobile + "&encode=" + encode + "&content=" + URLEncoder.encode(msgContent, "UTF-8");
		StringBuffer sb = new StringBuffer(straddr);
		
		//发送请求
		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"GBK"));
		
		//返回结果
		String inputline = in.readLine();
		return inputline;
	}

}
