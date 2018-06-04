<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检索书籍</title>
<style type="text/css">
	body {
		margin: 0px;
		background-color:#b3e5fc;
	}
	
	.header {
		margin: 0px auto;
		margin-top: 25px;
		width: 840px;
		height: 110px;
		padding-left: 45px;
	}
	
	.main {
		margin: 0px auto;
		width: 840px;
	}
	
	.book_logo {
		float: left;
		font-family: 华文楷体;
		font-size: 45px;
		padding-left: 105px;
		padding-top: 25px;
		line-height: 100px;
		color: #2979ff;
	}
	
	.login {
		margin-top: 75px;
		margin-right: 35px;
		float: right;
		font-size: 20px;
	}
	
	.navi {
		clear: both;
		margin: 0px auto;
		width: 840px;
		border: 1px solid #b3e5fc;
	}
	
	.bod{
		clear: both;
		margin: 100px auto;
		padding-top:30px;
		width: 240px;
		text-align: center;
		background-color:#00b0ff;
		box-shadow: 0px 0px 20px white;
		border-radius:20px;
	}
	
	dt{
		float: left;
		width:33%;
		text-align:center;
		background-color:#4999ff; 
	}
	
	dt a{
		display: block;
		text-decoration: none;
		font-size: 20px;
		
	}
	dt a:hover{
		background-color:#b3e5fc;
	}
	
	
	.sele {
		clear: both;
		padding-left: 22px;
		margin-top: 40px;
		margin-bottom: 10px;
	}
	
	.foot {
		width: 55%;
		margin: 0px auto;
		margin-top: 45px;
		text-align: center;
		color: #757575;
	}

</style>
</head>
<body>
	<div class="header">
		<div style="float: left;">
			<img src="file/img/webimg/book_logo.png" width="150px" height="120px">
		</div>
		<div class="book_logo">图书管理系统</div>
		<div class="login">	
			<!-- 
				test不能使用EL表达式
			 -->
			<c:choose>
				<c:when test="${empty sessionScope.user}">
					<a href="login.jsp">登录</a>
				</c:when>
				<c:otherwise>
					欢迎<span style="color:red;">
						${sessionScope.user.userName }
					</span>的登录
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="main">
		<div class="navi">
			<dl>
				<dt><a href="book_findbook" style="display: block;">热门推荐</a></dt>
				<dt><a href="book_search" >文献查找</a></dt>
				<dt><a href="bookuser_selectRecordByUserId">我的图书</a></dt>
			</dl>
		</div>
		
		<div class="bod">
			<form action="book_selectBookBySearch" method="post">
				<input type="text" name="value"> <br>
				<input type="radio" name="type" value="book_name">书名&nbsp;
				<input type="radio" name="type" value="book_author">作者&nbsp;
				<input type="radio" name="type" value="book_publih">出版社&nbsp;
				<input type="submit" value="检索">
			</form>
		</div>
	</div>
	
	<div style="margin-top:150px;text-align:center;">
		图书管理系统©版本1.0
	</div>


</body>
</html>