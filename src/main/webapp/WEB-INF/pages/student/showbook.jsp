<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书首页</title>
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
					<a href="login">登录</a>
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
		<div class="sele">
			a： <a href="book_selectByBookTypes?type=book_style&&value=文学">文学</a>
			&nbsp;&nbsp;b： <a
				href="book_selectByBookTypes?type=book_style&&value=军事">军事</a>
			&nbsp;&nbsp;c： <a
				href="book_selectByBookTypes?type=book_style&&value=科技">科技</a> <br>d：
			<a href="book_selectByBookTypes?type=book_style&&value=医学">医学</a>
			&nbsp;&nbsp;e： <a
				href="book_selectByBookTypes?type=book_style&&value=法律">法律</a>
		</div>
		<div>
			<table width="800px" align="center" style="list-style: none">
				<tr style="background-color: pink; list-style: none;">
					<td width="2%" style="padding-top: 20px"></td>
					<td width="6%">书名</td>
					<td width="10%">作者</td>
					<td width="10%">出版社</td>
					<td width="14%">ISBN</td>
					<td width="10%">借阅次数</td>
				</tr>
				
				<c:choose>
					<%--fn:length(${pageInfo.list })  --%>
					<c:when test="${fn:length(pageInfo.list ) > 0}">
						<c:forEach items="${pageInfo.list }" var="book" varStatus="vs">
							<tr>
								<th>${vs.count }</th>
								<td><a href="book_findBookByPrimaryKey?bookId=
									${book.bookId }
								">
									${book.bookName }
								</a></td>
								<td>${book.bookAuthor }</td>
								<td>${book.bookPublih }</td>
								<td>${book.bookIsbn }</td>
								<th>${book.bookLendtimes }</th>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="6">结果为空！</th>
						</tr>
					</c:otherwise>
				</c:choose>
				<c:if test=""></c:if>
			</table>
		</div>

		</div>
		<div class="foot">
			<a href="<c:out value="${requestScope.javax.servlet.forward.request_uri }" />
				?pageNo=${pageInfo.prePage }
				<c:if test="${!empty type}">
					&type=${type}&value=${value }
				</c:if>
			">
			上一页
			</a>

			<span style="color: red"> ${pageInfo.pageNum }
			</span> /
			${pageInfo.pages }
			<a href="<c:out value="${requestScope.javax.servlet.forward.request_uri }" />
				?pageNo=${pageInfo.nextPage }
				<c:if test="${!empty type}">
					&type=${type}&value=${value }
				</c:if>
			">			
			下一页</a>
		</div>
		
		
		<div style="margin-top:150px;text-align:center;">
			图书管理系统©版本1.0
		</div>
	
</body>
</html>