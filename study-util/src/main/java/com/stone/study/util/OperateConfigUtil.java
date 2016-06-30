package com.stone.study.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 配置文件操作
 * 
 * @author Administrator
 * 
 */
public class OperateConfigUtil {

	private static Properties prop = new Properties();

	private static final String PROP_FILE_NAME = "appconfig.properties";

	private static void initProperties() {
		try {
			InputStream is = OperateConfigUtil.class.getClassLoader()
					.getResourceAsStream(PROP_FILE_NAME);
			prop.load(is);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * 描述: 获取参数值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 * @author 俞世贵 date 2014-7-23
	 *         -------------------------------------------------- 修改人 修改日期 修改描述
	 *         俞世贵 2014-7-23 创建
	 *         --------------------------------------------------
	 * @Version Ver1.0
	 */
	public static String getParamByKey(String key, String defaultValue) {
		if (prop.isEmpty()) {
			initProperties();
		}
		String value = prop.getProperty(key);
		if (null == value) {
			setParam(key, defaultValue);
			return defaultValue;
		}
		return value;
	}

	/**
	 * 
	 * 描述: 保存参数
	 * 
	 * @param key
	 * @param value
	 * @author 俞世贵 date 2014-7-23
	 *         -------------------------------------------------- 修改人 修改日期 修改描述
	 *         俞世贵 2014-7-23 创建
	 *         --------------------------------------------------
	 * @Version Ver1.0
	 */
	public static void setParam(String key, String value) {
		if (prop.isEmpty()) {
			initProperties();
		}
		prop.setProperty(key, value);
		try {
			URL fileUrl = OperateConfigUtil.class.getClassLoader().getResource(
					PROP_FILE_NAME);
			FileOutputStream fos = new FileOutputStream(new File(
					fileUrl.toURI()));
			prop.store(fos, "save params!!!");
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("save error!!!：" + ex.getMessage());
		}
	}
}
