package com.stone.study.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;

/**
 * HTTP请求
 * 
 * @author Stone
 * 
 */
public class HttpRequestUtil {
	private String codedFormat = "UTF-8";

	public HttpRequestUtil() {
	}

	public HttpRequestUtil(String codedFormat) {
		this.codedFormat = codedFormat;
	}

	/**
	 * get请求
	 * 
	 * @param url
	 * @return
	 */
	public String getRequestUrl(String url) {
		CloseableHttpClient httpclient = null;
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		try {
			httpclient = createHttpsClient();
			URLEncoder.encode(url, codedFormat);
			HttpGet get = new HttpGet(url);
			HttpResponse response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, codedFormat));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("异常：" + ex.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("异常：" + ex.getMessage());
			}
		}
		return sb.toString();

	}

	/**
	 * POST JSON数据请求
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public String postJsonRequestUrl(String url, JSONObject json) {
		CloseableHttpClient httpclient = null;
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		try {
			httpclient = createHttpsClient();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type", "text/html;charset=" + codedFormat);
			post.setEntity(new StringEntity(json.toJSONString(), codedFormat));
			HttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, codedFormat));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception ex) {
			System.out.println("异常：" + ex.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("异常：" + ex.getMessage());
			}
		}
		return sb.toString();
	}

	/**
	 * POST XML数据请求
	 * 
	 * @param url
	 * @param xmlStr
	 * @return
	 */
	public String postXmlRequestUrl(String url, String xmlStr) {
		CloseableHttpClient httpclient = null;
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		try {
			httpclient = createHttpsClient();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type", "text/xml;charset=" + codedFormat);
			post.setEntity(new StringEntity(xmlStr, codedFormat));
			HttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, codedFormat));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception ex) {
			System.out.println("异常：" + ex.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("异常：" + ex.getMessage());
			}
		}
		return sb.toString();
	}

	/**
	 * POST STR数据请求
	 * 
	 * @param url
	 * @param str
	 * @return
	 */
	public String postStrRequestUrl(String url, String str) {
		CloseableHttpClient httpclient = null;
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		try {
			httpclient = createHttpsClient();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type", "text/html;charset=" + codedFormat);
			post.setEntity(new StringEntity(str, codedFormat));
			HttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, codedFormat));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception ex) {
			System.out.println("异常：" + ex.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("异常：" + ex.getMessage());
			}
		}
		return sb.toString();
	}

	/**
	 * 描述: 由此方法创建的CloseableHttpClient可以请求https
	 * HttpClients.createHttpsClient()创建的无法使用https，具体不知道怎么回事。
	 * 
	 * @return
	 */
	public CloseableHttpClient createHttpsClient() {
		X509TrustManager x509mgr = new X509TrustManager() {
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] arg0, String arg1)
					throws CertificateException {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] arg0, String arg1)
					throws CertificateException {
			}

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try {
			sslContext.init(null, new TrustManager[] { x509mgr }, null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
}
