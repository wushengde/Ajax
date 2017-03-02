<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- 
	实现以下三处的Ajax 实现的步骤：
	1.获取当前页面的所有的：a节点，并为每一个a节点添加onclick响应函数，同时取消其默认行为(return false)。
	2.准备发送Ajax请求：url(a 节点的href属性值）;args(时间戳）
	3.响应为一个：JSON 对象，包括：bookName,totalBookNumber,totalMoney.
	4.把对应的属性添加到对应的为位置

 -->
 <script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
 	
 	$(function() {
 		
 		var isHasCart="${sessionScope.sc == null}";
 		
 		if(isHasCart=="true"){
 			$("#cartstatus").hide();
 		}else{
 			$("#cartstatus").show();
 			
 			$("#bookName").text("${sessionScope.sc.bookName}");
			$("#totalBookNumber").text("${sessionScope.sc.totalBookNumber}");
			$("#totalMoney").text("${sessionScope.sc.totalMoney}");
 		}
 		
		$("a").click(function(){
			
			$("#cartstatus").show();
			
			var url = this.href;
			var args = {"time":new Date()};
			
			$.getJSON(url,args,function(data){
				$("#bookName").text(data.bookName);
				$("#totalBookNumber").text(data.totalBookNumber);
				$("#totalMoney").text(data.totalMoney);
			});
			
			//取消其默认行为，防止跳转。
			return false;
		});
	})

 </script>
</head>
<body>
	
	<div id="cartstatus">
	您已将 &nbsp; <span id="bookName"></span> &nbsp;
	加入到购物车，购物车中的书有&nbsp; <span id="totalBookNumber"></span> &nbsp;
	本 。总价格：&nbsp; <span id="totalMoney"></span> &nbsp;元。
	</div>
	
	<br><br>
	
	Java&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=Java&price=100">加入购物车</a>
	<br><br>
	
	Oracle&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=Oracle&price=200">加入购物车</a>
	<br><br>
	
	Struts2&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=Struts2&price=100">加入购物车</a>
	<br><br>
	
			
</body>
</html>