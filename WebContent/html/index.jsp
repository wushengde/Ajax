<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("a").click(function(){
			//此处url中可以使用选择器，对需要的部分进行选择，一下只取了返回数据中的h2中的a。
			var url = this.href + " h2 a";
			var args = {"time":new Date()};
			//任何一个html节点都可以使用load方法来加载Ajax，结果将直接插入到html节点中。
			$("#details").load(url,args);
			return false;
		});
		
	});
	
</script>
</head>
<body>
	<h1>WebSite</h1>
	<ul>
		<li><a href="baidu.html">百度一下</a></li>
		<li><a href="google.html">谷歌</a></li>
	</ul>
	<div id="details"></div>
</body>
</html>