package main.httputil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Map<String, Object> defaultHead = new HashMap<String, Object>();
		defaultHead.put("merId", "188000000001");// 商户编号
		defaultHead.put("channelId", "200");// 渠道编号
		defaultHead.put("token", "");// 令牌
		defaultHead.put("serviceNo", "D407");// 请求业务编码
		defaultHead.put("version", "100");// 请求版本号
		defaultHead.put("signType", "");// 签名方式
		defaultHead.put("sign", "");// 签名
		defaultHead.put("tradeNo", "2016061616092220160616160922");// 请求交易流水号
		defaultHead.put("tradeDateTime", "20160616160922");// 请求交易日期时间
		defaultHead.put("callBack", "");// 异步回调地址
		Map<String, Object> reqBody = new HashMap<String, Object>();
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("reqHead", defaultHead);
		req.put("reqBody", reqBody);
		ObjectMapper mapper = new ObjectMapper();
		String reqStr = mapper.writeValueAsString(req);
		System.out.println("请求报文：" + reqStr);
		String s = post("http://172.20.1.30:8080/bsgservice/despatchServlet", reqStr);
		System.out.println("响应报文：" + s);
	}

	public static String post(String url, String reqStr) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		String html = null;
		try {
			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
			httpPost.setEntity(new StringEntity(reqStr));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			html = EntityUtils.toString(entity, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
		return html;
	}
}
