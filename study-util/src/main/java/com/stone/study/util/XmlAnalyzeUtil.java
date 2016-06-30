package com.stone.study.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSONObject;

/**
 * XML解析
 * 
 * @author Stone
 * 
 */
public class XmlAnalyzeUtil {
	public static Map<String, String> xmlAnalyze(String xml,
			List<String> elements)
			throws ParserConfigurationException, SAXException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xml));
		Document doc = db.parse(is);

		NodeList nodes = doc.getElementsByTagName(elements.get(0));
		// iterate the employees
		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);
			NodeList childs = element.getChildNodes();
			for (int j = 0; j < childs.getLength(); j++) {
				Element line = (Element) childs.item(j);
				System.out.println(line.getNodeName() + ":"
						+ line.getTextContent());
				map.put(line.getNodeName(), line.getTextContent());
			}
		}
		return map;
	}

	public static void main(String[] args) {
		StringBuffer xml = new StringBuffer();
		xml.append("<ResBizArgs>");
		xml.append("<invokeFlag>1</invokeFlag>");
		xml.append("<orderInfo>");
		xml.append("<prod_offer_order_id>1231111111111</prod_offer_order_id>");
		xml.append("<create_date>2015-04-01</create_date>");
		xml.append("<is_pay_online>0</is_pay_online>");
		xml.append("<prod_offer_name>123</prod_offer_name>");
		xml.append("<product_color>red</product_color>");
		xml.append("<counts>2</counts>");
		xml.append("<discuss_charge>456</discuss_charge>");
		xml.append("<staff_name>678</staff_name>");
		xml.append("<package_name>11</package_name>");
		xml.append("<package_key>22</package_key>");
		xml.append("<pakcage_desc>33</pakcage_desc>");
		xml.append("<order_name>44</order_name>");
		xml.append("<contact_tel>55</contact_tel>");
		xml.append("<mail_addr>66</mail_addr>");
		xml.append("<card_id>77</card_id>");
		xml.append("<process_node_id>88</process_node_id>");
		xml.append("<channel_name>99</channel_name>");
		xml.append("<choose_number>120</choose_number>");
		xml.append("</orderInfo>");
		xml.append("</ResBizArgs>");
		try {
			List<String> elements = new ArrayList<String>();
			elements.add("orderInfo");
			Map<String, String> map = xmlAnalyze(xml.toString(), elements);
			JSONObject json = new JSONObject();
			json.put("map", map);
			System.out.println(json.toJSONString());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
