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
		//�����������
		req.setCharacterEncoding("utf-8");
		String name = 
			req.getParameter("userName");
		//��֤�û����Ƿ���ڣ��������ݿ���
		//ֻ��һ�����ݣ����û���Ϊadmin
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		if(name.equals("admin")) {
			//�û����Ѵ���
			w.println(1);
		} else {
			//�û����Ϸ�
			w.println(0);
		}
		w.close();
		
	}
	
}





