package com.atguigu.ajax.app.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateUserName
 */
@WebServlet("/validateUserName")
public class ValidateUserName extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> userNames = Arrays.asList("AAA","BBB","CCC");
		
		String userName=request.getParameter("userName");
		String result = null;
		if(userNames.contains(userName)){
			result="<font color='red'>该用户名已经存在！</font>";
		}else{
			result="<font color='green'>该用户名可用！</font>";
			
		}
		//此行代码解决：浏览器与服务器之间产生的乱码
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result);
		
	}

}
