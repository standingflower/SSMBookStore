<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
body{
		background-color:#b3e5fc;
		
	}
	.center{
		width:420px;
		height:250px;
		margin:0px auto;
		border:3px solid white;
		background-color:#00b0ff;
		box-shadow: 0px 0px 20px white;
		border-radius:20px;
		padding:50px;
		
	}
	.Tit{
		margin:0px auto;
		margin-top:80px;
		margin-bottom:40px;
		text-align:center;
		color:white;
		font-family:华文楷体;
		font-size:45px;

	}
	.IN{
		height:70%;
		width:80%;
		margin:0px auto;
	}
	
	.input{
		width:100%;
		height:35px;
		margin-top:25px;
		background-color:#b3e5fc;
		padding-left:10px;
	}
	 
	
	
	.put{
		clear:both;
		width:100%;
		background-color:pink;
		font-size:25px;
		color:white;
		line-height:25px;
	}
	
	
</style>

<script type="text/javascript" src="/file/js/jquery-1.3.1.js" ></script>
<script type="text/javascript">
	
	$(function(){
		
		var res="${res}";
		if(res.length!=0){
			alert(res);
		}
			
		//输入框效果
		$(".input").mousedown(function() {
			$(this).css("box-shadow", "0px 0px 30px #18ffff");
			$(this).css("border", "3px solid #18ffff");
		});
		
	})
</script>
</head>
<body>

	<div class="Tit">欢迎你的登录</div>
	<div class="center">
		<div class="IN">
			<div class="login">
				<form:form action="user_login" method="post" modelAttribute="user">
					<form:input path="userId" cssClass="input" placeholder="请输入ID号"/><br>
					<form:password path="password" cssClass="input" placeholder="输入密码"/><br>
					角色：<form:radiobutton path="userRole" value="0"/>管理员
					    <form:radiobutton path="userRole" value="1"/>学生<br><br>
					<input type="submit" value="登录" class="put">
				</form:form>
			</div>
		</div>
	</div>
	
</body>
</html>


