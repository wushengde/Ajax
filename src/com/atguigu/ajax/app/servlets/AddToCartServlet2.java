package com.atguigu.ajax.app.servlets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.ajax.app.beans.Car;
import com.atguigu.ajax.app.beans.ShoppingCart;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/html/addToCart2")
public class AddToCartServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		/*此段代码复习了：ServletContext 代表整个web应用，能在整个web应用中共享数据。
		 * 	ServletConfig config = this.getServletConfig();
			ServletContext context = config.getServletContext();
			context.setAttribute("apple", "red apple");
			System.out.println(context.getAttribute("apple"));
			
			servletContext还可以用来读取配置文件
		*/
		
		/*
		 * 	此段代码用来测试servletContext读取配置文件的作用：适用于：servlet环境下，
		 * 	如果需要在一个普通的java中读取资源文件使用此方法：类加载器加载文件的方式读取资源。
		 * 	Properties prop = new Properties();
			prop.load(new FileReader(this.getServletContext().getRealPath("config.properties")));
			System.out.println(prop.getProperty("username"));
		*/
		
		//类加载器来读取资源文件：
		//Properties prop = new Properties();
		//prop.load(new FileReader(AddToCartServlet.class.getClassLoader()
		//.getResource("config.properties").getPath()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		//1.获取请求参数id，price
		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		//2.获取购物车对象
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
		
		if(sc==null){
			sc=new ShoppingCart();
			session.setAttribute("sc", sc);
		}
		//3.把点击的选项加入到购物车中
		sc.addToCart(bookName, price);*/
		
		
		//4.准备相应的JSON对象: {"bookName":"","totalBookNumber":1,"totalMoney":1}
		//一下使用jackson工具直接将对象转换成一个JSON字符串，以下的ObjectMapper不属于正规类，由于jar包问题暂时使用该类。
		
/*		StringBuilder result = new StringBuilder();
		result.append("{")
			  .append("\"bookName\":\""+bookName+"\"")
			  .append(",")
			  .append("\"totalBookNumber\":"+sc.getTotalBookNumber())
			  .append(",")
			  .append("\"totalMoney\":"+sc.getTotalMoney())
			  .append("}");
*/
		ObjectMapper mapper = new ObjectMapper();
		Car car1=new Car("奥迪1", "2012", "red", "aaaa");
		Car car2=new Car("奥迪2", "2012", "red", "aaaa");
		Car car3=new Car("奥迪3", "2012", "red", "aaaa");
		Car car4=new Car("奥迪4", "2012", "red", "aaaa");
		Car car5=new Car("奥迪4", "2012", "red", "aaaa");
		Car car6=new Car("奥迪4", "2012", "red", "aaaa");
		Car car7=new Car("奥迪4", "2012", "red", "aaaa");
		Car car8=new Car("奥迪4", "2012", "red", "aaaa");
		Car car9=new Car("奥迪4", "2012", "red", "aaaa");
		Car car10=new Car("奥迪4", "2012", "red", "aaaa");
		Car car11=new Car("奥迪4", "2012", "red", "aaaa");
		Car car12=new Car("奥迪4", "2012", "red", "aaaa");
		Car car13=new Car("奥迪4", "2012", "red", "aaaa");
		Car car14=new Car("奥迪4", "2012", "red", "aaaa");
		Car car15=new Car("奥迪4", "2012", "red", "aaaa");
		List<Car> list =new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		list.add(car9);
		list.add(car10);
		list.add(car11);
		list.add(car12);
		list.add(car13);
		list.add(car14);
		list.add(car15);
//		String result ="[{'brand': 'Volkswagen', 'year': 2012, 'color': 'White', 'vin': 'dsad231ff'},{'brand': 'Audi', 'year': 2011, 'color': 'Black', 'vin': 'gwregre345'},{'brand': 'Renault', 'year': 2005, 'color': 'Gray', 'vin': 'h354htr'},{'brand': 'BMW', 'year': 2003, 'color': 'Blue', 'vin': 'j6w54qgh'},{'brand': 'Mercedes', 'year': 1995, 'color': 'White', 'vin': 'hrtwy34'},{'brand': 'Volvo', 'year': 2005, 'color': 'Black', 'vin': 'jejtyj'},{'brand': 'Honda', 'year': 2012, 'color': 'Yellow', 'vin': 'g43gr'},{'brand': 'Jaguar', 'year': 2013, 'color': 'White', 'vin': 'greg34'},{'brand': 'Ford', 'year': 2000, 'color': 'Black', 'vin': 'h54hw5'},{'brand': 'Fiat', 'year': 2013, 'color': 'Red', 'vin': '245t2s'}]";
		String aString = mapper.writeValueAsString(list);
		//5.响应的JSON对象
		response.setContentType("text/javascript;charset=utf-8");
//		response.setContentType("text/html;");
		response.getWriter().print(aString);
	}

}
