<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

	<!-- jQuery中：使用load方法实现Ajax  load()方法是jQuery中简单常用的方法 -->

	$(function(){
		$("a").click(function(){
			//使用load处理Ajax
			var url = this.href;
			//参数格式：在jQuery中参数必须是Json格式
			var args = {"time":new Date()};
			$("#content").load(url,args);
			//取消默认行为
			return false;
		});
	});
	
</script>
</head>
<body>

	<a href="helloAjax.txt">HelloAjax</a>
	<div id="content"></div>

</body>
</html>