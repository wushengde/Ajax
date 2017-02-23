<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function(){
			
			var url = this.href;
			var args = {"time":new Date()};
			//url:
			//args:JSON格式
			//function:回调函数，当响应结束时，回调函数被触发，响应结果在data中。
			$.post(url,args,function(data){
				//$(data):将data转为jQuery对象使用。
				var name = $(data).find("name").text();
				var website = $(data).find("website").text();
				
				$("#details").empty().append("<h2><a href='"+website+"'>"+name+"</a></h2>")
									 .append("<a href='"+website+"'>"+website+"</a>");
				
			});
			
			
			return false;
		});
	})
	
</script>
</head>
<body>
	<h1>WebSite</h1>
	<ul>
		<li><a href="files/baidu.xml">百度一下</a></li>
		<li><a href="files/google.xml">谷歌</a></li>
	</ul>
	<div id="details"></div>
	
</body>
</html>