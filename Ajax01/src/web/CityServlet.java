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
 *	根据传入的省份ID，查询出对应的城市。
 *	假设页面上有3个省，分别是：
 *	  1-浙江省；2-江苏省；3-山东省；
 */
public class CityServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取请求参数
		req.setCharacterEncoding("utf-8");
		String id = 
			req.getParameter("provinceId");
		//根据id查询对应的城市，由于此处重点
		//不在于数据库的访问，因此模拟实现。
		List<City> list = 
			new ArrayList<City>();
		if(id.equals("1")) {
			//浙江
			list.add(new City("hz","杭州"));
			list.add(new City("nb","宁波"));
			list.add(new City("jx","嘉兴"));
		} else if(id.equals("2")) {
			//江苏
			list.add(new City("nj","南京"));
			list.add(new City("wx","无锡"));
			list.add(new City("sz","苏州"));
		} else if(id.equals("3")) {
			//山东
			list.add(new City("jn","济南"));
			list.add(new City("qd","青岛"));
			list.add(new City("yt","烟台"));
		}
		//作出响应，输出城市相关的信息
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		//济南,青岛,烟台
		String str = "";
		for(City c : list) {
			str += "," + c.getName();
		}
		str = str.replaceFirst(",", "");
		w.println(str);
		w.close();
	}
	
}




