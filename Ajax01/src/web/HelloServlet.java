package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//模拟网络延迟
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//接收请求参数
		req.setCharacterEncoding("utf-8");
		String name = 
			req.getParameter("userName");
		System.out.println(name);
		//作出响应
		res.setContentType(
			"text/html;charset=utf-8;");
		PrintWriter w = res.getWriter();
		w.println(name + "，你好！");
		w.close();
	}
	
}




