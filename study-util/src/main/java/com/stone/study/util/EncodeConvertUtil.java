package com.stone.study.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Class Name: EncodeConvertUtil
 * </p>
 * <p>
 * Description: 编码转换工具
 * </p>
 * <p>
 * Sample: 该类的典型使用方法和用例
 * </p>
 * <p>
 * Author: 石涛
 * </p>
 * <p>
 * Date: 2014-12-1
 * </p>
 * <p>
 * Modified History: 修改记录，格式(Name) (Version) (Date) (Reason & Contents)
 * </p>
 */
public class EncodeConvertUtil {

	/**
	 * @description: 汉字转换为UNICODE码
	 * @param s
	 * @return
	 * @author 石涛
	 * @date 2014-12-1
	 * @-- ------------------------------------------------
	 * @xx 修改人修改日期 修改描述
	 * @xx 石涛 2014-12-1 创建
	 * @-- ------------------------------------------------
	 * @Version Ver1.0
	 */
	public static String chineseCharacterConvertToUnicode(final String str) {
		String resultStr = "";
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			resultStr += "\\u" + Integer.toHexString(ch);
		}
		return resultStr;
	}

	/**
	 * @description: UNICODE码转换为汉字
	 * @param str
	 * @return
	 * @author 石涛
	 * @date 2014-12-1
	 * @-- ------------------------------------------------
	 * @xx 修改人修改日期 修改描述
	 * @xx 石涛 2014-12-1 创建
	 * @-- ------------------------------------------------
	 * @Version Ver1.0
	 */
	public static String unicodeConvertToChineseCharacter(String str) {
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while (matcher.find()) {
			ch = (char) Integer.parseInt(matcher.group(2), 16);
			str = str.replace(matcher.group(1), ch + "");
		}
		return str;
	}


	public static void main(String[] args) {
		System.out
				.println(unicodeConvertToChineseCharacter("\u6c89\u9999\u6551\u6bcd\u5176\u5b9e\u6839\u672c\u4e0d\u7528\u5b66\u6cd5\u672f\u7684\uff0c\u6b63\u6708\u91cc\u5243\u4e2a\u5934\u5c31\u628a\u4e8c\u90ce\u795e\u6536\u62fe\u4e86\uff01"));
	}
}
