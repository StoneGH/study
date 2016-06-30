package com.stone.study.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 配置操作
 * 
 * @author Stone
 * 
 */
public class PropsFileOperateUtil {
	/** 属性文件的路径 */
	public static String propsFilePath = "weixin.properties";

	/** 属性文件 */
	private static Properties props = new Properties();

	/**
	 * 初始化配置文件
	 */
	private static void initProperties() {
		try {
			// 加载配置文件
			props.load(PropsFileOperateUtil.class.getClassLoader()
					.getResourceAsStream(propsFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key, String value) {
		if (props.isEmpty()) {
			initProperties();
		}
		String val = props.getProperty(key);
		if (null == val) {
			setValue(key, value);
			return value;
		}
		return val;
	}

	/**
	 * 设置值
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(String key, String value) {
		if (props.isEmpty()) {
			initProperties();
		}
		props.setProperty(key, value);
		try {
			URL fileUrl = PropsFileOperateUtil.class.getClassLoader()
					.getResource(propsFilePath);
			FileOutputStream fos = new FileOutputStream(new File(
					fileUrl.toURI()));
			props.store(fos, "save params!!!");
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("save error!!!：" + ex.getMessage());
		}
	}
}
