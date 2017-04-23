<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- 
	实现Ajax验证用户名是否已存在的步骤：
	1.导入jQuery库
	2.获取：name="username"节点：username;
	3.为：username 添加 change 响应函数
	3.1 获取：username 的 value 属性值，去除前后空格，且不为空，准备发送Ajax请求
	3.2 发送Ajax请求 检验username是否可用
	3.3 在服务器端直接返回 ：html片段 即可。
	3.4 在客户端浏览器把其直接添加到 #message 的html中
 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".username").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			
			if(val !=""){
				var url  = "${pageContext.request.contextPath}/validateUserName";
				var args = {"userName":val,"time":new Date()};
				
				$.post(url,args,function(data){
					$("#message").html(data);
				});
			}
		});
	})
	
</script>

</head>
<body>
	<form action="" method="post">
		
		UserName:<input type="text" class="username"/>
		<br>
		<div id="message"></div>
		<br>
		<input type="submit" value="submit"/>		
	</form>
</body>
</html>