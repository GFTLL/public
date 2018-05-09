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
		//ģ�������ӳ�
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�����������
		req.setCharacterEncoding("utf-8");
		String name = 
			req.getParameter("userName");
		System.out.println(name);
		//������Ӧ
		res.setContentType(
			"text/html;charset=utf-8;");
		PrintWriter w = res.getWriter();
		w.println(name + "����ã�");
		w.close();
	}
	
}




