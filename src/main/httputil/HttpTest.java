package main.httputil;

public class HttpTest {
	public static void main(String[] args) {
		String s = HttpUtil.get("https://github.com/");
		System.out.println("响应报文：" + s);
	}
}
