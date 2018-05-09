package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//接收请求参数
		req.setCharacterEncoding("utf-8");
		String name = 
			req.getParameter("userName");
		//验证用户名是否存在，假设数据库中
		//只有一条数据，其用户名为admin
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		if(name.equals("admin")) {
			//用户名已存在
			w.println(1);
		} else {
			//用户名合法
			w.println(0);
		}
		w.close();
		
	}
	
}





