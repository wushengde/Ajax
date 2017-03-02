package com.atguigu.ajax.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.ajax.app.beans.ShoppingCart;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取请求参数id，price
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
		sc.addToCart(bookName, price);
		
		
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
		String result = mapper.writeValueAsString(sc);
		System.out.println(result);
		
		//5.响应的JSON对象
		response.setContentType("text/javascript");
		response.getWriter().print(result);
	}

}
