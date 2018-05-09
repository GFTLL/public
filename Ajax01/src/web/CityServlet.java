package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.City;

/**
 *	���ݴ����ʡ��ID����ѯ����Ӧ�ĳ��С�
 *	����ҳ������3��ʡ���ֱ��ǣ�
 *	  1-�㽭ʡ��2-����ʡ��3-ɽ��ʡ��
 */
public class CityServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ȡ�������
		req.setCharacterEncoding("utf-8");
		String id = 
			req.getParameter("provinceId");
		//����id��ѯ��Ӧ�ĳ��У����ڴ˴��ص�
		//���������ݿ�ķ��ʣ����ģ��ʵ�֡�
		List<City> list = 
			new ArrayList<City>();
		if(id.equals("1")) {
			//�㽭
			list.add(new City("hz","����"));
			list.add(new City("nb","����"));
			list.add(new City("jx","����"));
		} else if(id.equals("2")) {
			//����
			list.add(new City("nj","�Ͼ�"));
			list.add(new City("wx","����"));
			list.add(new City("sz","����"));
		} else if(id.equals("3")) {
			//ɽ��
			list.add(new City("jn","����"));
			list.add(new City("qd","�ൺ"));
			list.add(new City("yt","��̨"));
		}
		//������Ӧ�����������ص���Ϣ
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		//����,�ൺ,��̨
		String str = "";
		for(City c : list) {
			str += "," + c.getName();
		}
		str = str.replaceFirst(",", "");
		w.println(str);
		w.close();
	}
	
}




