package com.xzy.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class Connect {

	public String ConnectWeb(String url, String format) {
		String html = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();// 创建httpClient对象
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(1000 * 60).setConnectTimeout(1000 * 60)
				.build();
		HttpGet httpget = new HttpGet(url);// 以get方式请求该URL
		httpget.setConfig(requestConfig);
		try {
			HttpResponse responce = httpClient.execute(httpget);// 得到responce对象
			int resStatu = responce.getStatusLine().getStatusCode();// 返回码
			if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
				// 获得相应实体
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = EntityUtils.toString(entity, format);// 获得html源代码
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
			}
		}
		return html;
	}

	public String post(String corpName, String province, String regCode) {
		HttpClient client = new DefaultHttpClient();
		HttpParams params = client.getParams();
		HttpConnectionParams.setConnectionTimeout(params, 300000);
		HttpConnectionParams.setSoTimeout(params, 300000);
//		String url = "http://10.141.250.75:8080/gstest/servlet/Dosearch";
		String url = "http://182.92.221.159:8080/gstest/servlet/Dosearch";
		HttpPost httppost = new HttpPost(url);
		List<NameValuePair> postform = new ArrayList<NameValuePair>();
		postform.add(new BasicNameValuePair("corpName", corpName));
		postform.add(new BasicNameValuePair("province", province));
		postform.add(new BasicNameValuePair("regCode", regCode));

		try {
			httppost.setEntity(new UrlEncodedFormEntity(postform, "UTF-8"));
			// 发送请求
			HttpResponse httpresponse = client.execute(httppost);
			HttpEntity entity = httpresponse.getEntity();
			String body = EntityUtils.toString(entity, "UTF-8");
			return body;
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}

	}

}
