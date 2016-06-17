package main.httputil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
			out.println("hello world!22222222222222");
			out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
			String name = request.getParameter("name");
			
			PrintWriter pw = response.getWriter();
			pw.println(name + "你好!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}