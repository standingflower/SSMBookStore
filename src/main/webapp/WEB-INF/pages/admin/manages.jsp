<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍crud</title>
<style type="text/css">
	*{
		margin:0px;
		padding:0px;
	}

	.top{
		text-align: center;
		padding: 20px;
		background-color:#b3e5fc;
	}
	.top .u{
		float:right;
		margin-right: 15px;
		margin-top:45px;
	}

	.left{
		width: 14%;
		height: 360px;
		float: left;
	}
	.right{
		width: 85%;
		height: 360px;
		float: right;
	}
	
	.inner{
		width: 80%;
		margin-top: 30px;
		margin-left:50px;
		padding: 20px;
		
	}
	
	.left button{
		width: 100%;
		height:40px;
		background-color:#b3e5fc;
		
	}
	
	
	.pic{
		float: right;
		margin-right: 80px;
	}
	
	.tab{
		float: left;
		margin-left: 90px;
	
	}
	
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
		width:40%;
		margin:0px auto;
		border: 2px solid black;
	}
	
	.log{
		padding:30px;
		border:3px solid white;
		background-color:#00b0ff;
		box-shadow: 0px 0px 20px white;
		border-radius:20px;
	}
	
	.input{
		width:80%;
		height:35px;
		margin-top:25px;
		background-color:#b3e5fc;
		margin-left: 30px;
	}
	 
	
	
	.button{
		clear:both;
		width:80%;
		margin-left: 30px;
		background-color:pink;
		font-size:25px;
		color:white;
		line-height:25px;
	}
	
	td{
		padding:3px;
	}
	
	
	
	
</style>
<script type="text/javascript" src="/file/js/jquery-1.3.1.js" ></script>
<script type="text/javascript">
	function viewImage(file){
    var preview = document.getElementById('preview');
    if(file.files && file.files[0]){
        //火狐下
        preview.style.display = "block";
        preview.style.width = "200px";
        preview.style.height = "250px";
        preview.src = window.URL.createObjectURL(file.files[0]);
    }else{
        //ie下，使用滤镜
        file.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("localImag"); 
        //必须设置初始大小 
        localImagId.style.width = "250px"; 
        localImagId.style.height = "200px"; 
        try{ 
        localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
        locem("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
        }catch(e){ 
        alert("您上传的图片格式不正确，请重新选择!"); 
        return false; 
        } 
        preview.style.display = 'none'; 
        document.selection.empty(); 
        } 
        return true; 
	}
		
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
			
			//切换效果
			$(".bu1").click(function(){
				$(".bu1").css("background-color","#00b0ff");
				$(".bu2").css("background-color","#b3e5fc");
				$(".bu3").css("background-color","#b3e5fc");
				$(".bu4").css("background-color","#b3e5fc");
				$(".bu5").css("background-color","#b3e5fc");
				$(".bu6").css("background-color","#b3e5fc");
				$(".inner").eq(0).show();
				$(".inner").eq(1).hide();
				$(".inner").eq(2).hide();
				$(".inner").eq(3).hide();
				$(".inner").eq(4).hide();
				$(".inner").eq(5).hide();
				$(".inner").eq(6).hide();
			});
			$(".bu2").click(function(){
				$(".bu1").css("background-color","#b3e5fc");
				$(".bu2").css("background-color","#00b0ff");
				$(".bu3").css("background-color","#b3e5fc");
				$(".bu4").css("background-color","#b3e5fc");
				$(".bu5").css("background-color","#b3e5fc");
				$(".bu6").css("background-color","#b3e5fc");
				$(".inner").eq(0).hide();
				$(".inner").eq(1).show();
				$(".inner").eq(2).hide();
				$(".inner").eq(3).hide();
				$(".inner").eq(4).hide();
				$(".inner").eq(5).hide();
				$(".inner").eq(6).hide();
			});
			$(".bu3").click(function(){
				$(".bu1").css("background-color","#b3e5fc");
				$(".bu2").css("background-color","#b3e5fc");
				$(".bu3").css("background-color","#00b0ff");
				$(".bu4").css("background-color","#b3e5fc");
				$(".bu5").css("background-color","#b3e5fc");
				$(".bu6").css("background-color","#b3e5fc");
				$(".inner").eq(0).hide();
				$(".inner").eq(1).hide();
				$(".inner").eq(2).show();
				$(".inner").eq(3).hide();
				$(".inner").eq(4).hide();
				$(".inner").eq(5).hide();
				$(".inner").eq(6).hide();
			});
			$(".bu4").click(function(){
				$(".bu1").css("background-color","#b3e5fc");
				$(".bu2").css("background-color","#b3e5fc");
				$(".bu3").css("background-color","#b3e5fc");
				$(".bu4").css("background-color","#00b0ff");
				$(".bu5").css("background-color","#b3e5fc");
				$(".bu6").css("background-color","#b3e5fc");
				$(".inner").eq(0).hide();
				$(".inner").eq(1).hide();
				$(".inner").eq(2).hide();
				$(".inner").eq(3).show();
				$(".inner").eq(4).hide();
				$(".inner").eq(5).hide();
				$(".inner").eq(6).hide();
			});
			$(".bu5").click(function(){
				$(".bu1").css("background-color","#b3e5fc");
				$(".bu2").css("background-color","#b3e5fc");
				$(".bu3").css("background-color","#b3e5fc");
				$(".bu4").css("background-color","#b3e5fc");
				$(".bu5").css("background-color","#00b0ff");
				$(".bu6").css("background-color","#b3e5fc");
				$(".inner").eq(0).hide();
				$(".inner").eq(1).hide();
				$(".inner").eq(2).hide();
				$(".inner").eq(3).hide();
				$(".inner").eq(4).show();
				$(".inner").eq(5).hide();
				$(".inner").eq(6).hide();
			});

			
			//crud
			$("#bt1,#bt2,#bt3,#bt4").click(function(){
				
				if($(this).attr("name")=="Ubook"){
					var pic=$.trim($("#preview").attr("src"));
					$("#preview").prev().attr("value",pic);
				}
				var method="crud_"+$(this).attr("name");
				$("#formId").attr("action",method);
			});
			//获取所有图书信息
			$(".bu6,.prepage,.nextpage").click(function(){
				$(".bu1").css("background-color","#b3e5fc");
				$(".bu2").css("background-color","#b3e5fc");
				$(".bu3").css("background-color","#b3e5fc");
				$(".bu4").css("background-color","#b3e5fc");
				$(".bu5").css("background-color","#b3e5fc");
				$(".bu6").css("background-color","#00b0ff");
				$(".inner").eq(0).hide();
				$(".inner").eq(1).hide();
				$(".inner").eq(2).hide();
				$(".inner").eq(3).hide();
				$(".inner").eq(4).hide();
				$(".inner").eq(5).hide();
				$(".inner").eq(6).show();
				var pageNo=this.href;
				if(pageNo){
					//值获取页数
					pageNo=pageNo.substr(22,pageNo.length-22 );
					//alert(pageNo);
				}else{
					pageNo=1
				}
				$.ajax({
					type:"post",
					url:"book_findbookByAjax?pageNoStr="+pageNo,
					data:null,
					dataType:"json",
					success:function(rs){
						$("#span3").html(rs.pageNum);//当前页数
						$("#span4").html(rs.pages);//总页数
						$(".prepage").attr("href",rs.prePage);//上一页
						
						$(".nextpage").attr("href",rs.nextPage);//下一页
						for(var i=1;i<rs.list.length+1;i++){
							var book=rs.list[i-1];
							$("#trs_"+i).show();
							$("#trs_"+i+" #th_1").html(book.bookId);
							$("#trs_"+i+" #th_2").html(
								'<a href=book_findBookByPrimaryKey?bookId='+
								book.bookId+'>'+book.bookName+'</a>'
								);	
							$("#trs_"+i+" #th_3").html(book.bookAuthor);
							$("#trs_"+i+" #th_4").html(book.bookPublih);
							$("#trs_"+i+" #th_5").html(book.bookIsbn);
							$("#trs_"+i+" #th_6").html(book.bookPrice);
							$("#trs_"+i+" #th_7").html(book.bookStroe);
							$("#trs_"+i+" #th_8").html(book.bookLend);
							$("#trs_"+i+" #th_9").html(book.bookStyle);
							$("#trs_"+i+" #th_10").html(book.bookLendtimes);
						}
					}
				});
				return false;
			});
			
			//学生管理
			$("#but2,#prepage,#nextpage").click(function(){
				for(var i=1;i<6;i++){
					$("#tr_"+i).hide();
				}
				var name=$("#userName").val();
				var pageNo=this.href;
				if(pageNo){
					//值获取页数
					pageNo=pageNo.substr(22,pageNo.length-22 );
				}else{
					pageNo=1
				}
				var url="bookuser_selectRecordByUserIdByAjax";
				var args={'userId':name,'pageNoStr':pageNo};
				$.post(url,args,function(rs){
					$(".bu1").css("background-color","#b3e5fc");
					$(".bu2").css("background-color","#b3e5fc");
					$(".bu3").css("background-color","#00b0ff");
					$(".bu4").css("background-color","#b3e5fc");
					$(".bu5").css("background-color","#b3e5fc");		
					$(".inner").eq(0).hide();
					$(".inner").eq(1).hide();
					$(".inner").eq(2).hide();
					$(".inner").eq(3).hide();
					$(".inner").eq(4).hide();
					$(".inner").eq(5).show();
					if(rs.resjson==-1){
						alert("未找到指定用户！");
					}else{
						$("#span1").html(rs.pageNum);
						$("#span2").html(rs.pages);
						//上一页
						$("#prepage").attr("href",rs.prePage);
						//下一页
						$("#nextpage").attr("href",rs.nextPage);
						//用户信息
						$("#Uname").html(rs.userName);
						$("#Uid").html(rs.userId);
						if(rs.iflend==0){
							$("#Ustate").html("可借");
						}else{
							$("#Ustate_a").html("解挂");
						}
						//用户角色
						var userRole=${sessionScope.user.userRole}
						for(var i=1;i<rs.buList.length+1;i++){
							var record=rs.buList[i-1];
							$("#tr_"+i).show();
							$("#tr_"+i+" #th_1").html(
								'<a href=book_findBookByPrimaryKey?bookId='+
								record.book.bookId+'>'+record.book.bookName+'</a>'
								);
							var lendtime=record.lendtime;
							lendtime=(new Date(lendtime).getYear()+1900)+"-"+(new Date(lendtime).getMonth()+1)+
							"-"+(new Date(lendtime).getDate());
							$("#tr_"+i+" #th_2").html(lendtime);
							var returntime=record.returntime;
							if(returntime){
								returntime=(new Date(returntime).getYear()+1900)+"-"+(new Date(returntime).getMonth()+1)+
								"-"+(new Date(returntime).getDate());
							}
							$("#tr_"+i+" #th_3").html(returntime);
							//归还书籍
							if(record.ifreturn==0){
								$("#tr_"+i+" #th_4").html("是");
								$("#tr_"+i+" #th_6").children().html("续借");
								$("#tr_"+i+" #th_6").children().removeAttr("href");
							}
							if(record.ifreturn==1){
								$("#tr_"+i+" #th_4").html("否");
								$("#tr_"+i+" #th_6").children().html("续借");
								$("#tr_"+i+" #th_6").children().attr("href",'bookuser_renew?'+
										'userId='+record.user.userId+
										'&bookId='+record.book.bookId);
							}
							$("#tr_"+i+" #th_5").html(record.renewtimes);
						}
					}
				},"json");
				return false;
			});	
			
			//续借but1
			$("#but1").click(function(){
				var bookId=$(this).prev().prev().prev().val();
				var userId=$(this).prev().prev().prev().prev().prev().val();
				$.ajax({
					type:"post",
					url:"bookuser_renew?userId="+userId+"&bookId="+bookId,
					data:null,
					dataType:"json",
					success:function(rs){
						var res=rs;
						if(res==-2){
							alert("未找指定用户");
						}
						if(res==-1){
							alert("续借失败！");							
						}
						if(res==1){
							alert("续借成功！");
						}
						if(res==2){
							//状态为挂失
							alert("当前用户不能续借！");
						}
					}
				});
				return false;
			});
			//续借2
			$(".xj").click(function(){
				var fun=$(this);
				var url=$.trim($(this).attr("href"))
				$.ajax({
					type:"post",
					url:$.trim($(this).attr("href")),
					data:null,
					dataType:"json",
					success:function(data){
						if(data==0){
							alert("续借失败！");
						}
						if(data==1){
							var time=Number(fun.parent().prev().html())+1;
							//alert(fun.parent().prev().html());
							fun.parent().prev().html(time);
							alert("续借成功");
						}
						if(data==2){
							alert("当前用户不能续借！");
						}
					}
				});
				return false;
			});
			
			
			//解挂
			$("#Ustate_a").click(function(){
				var userId=$(this).parent().prev().prev().html();
				alert(userId);
				$.ajax({
					type:"post",
					url:"user_unlose?userId="+userId,
					data:null,
					dataType:"json",
					success:function(rs){
						//alert(rs.res);
						if(rs==1){
							alert("解挂成功！");
							$("#Ustate").html("可借");
						}
						if(rs==0){
							alert("解挂失败！");
						}
					}
					
				});
				return false;
			});
			
			
			
			
			//借阅
			$("#but3").click(function(){
				var bookId=$(this).prev().prev().prev().val();
				var userId=$(this).prev().prev().prev().prev().prev().val();
				$.ajax({
					type:"post",
					url:"bookuser_lendBook?userId="+userId+"&bookId="+bookId,
					data:null,
					dataType:"json",
					success:function(rs){
						var res=rs;
						if(res==1){
							alert("借阅成功！");							
						}
						if(res==-2){
							alert("借阅失败！");
						}
						if(res==0){
							alert("图书以借光！");
						}
						if(res==-1){
							alert("此用户不可借！");
						}
						if(resjson==2){
							alert("未扎到指定用户！");
						}
					}
				});
				return false;
			});
			
			//归还but4
			$("#but4").click(function(){
				var bookId=$(this).prev().prev().prev().val();
				var userId=$(this).prev().prev().prev().prev().prev().val();
				$.ajax({
					type:"post",
					url:"bookuser_returnBook?userId="+userId+"&bookId="+bookId,
					data:null,
					dataType:"json",
					success:function(rs){
						var res=rs;
						if(res==0){
							alert("归还成功！");							
						}
						if(res==-1){
							alert("归还失败！");
						}
						if(res==1){
							alert("为找到指定用户");
						}
					}
				});
				return false;
			});
		})
</script>

</head>
<body>
	<div class="top">
		<span style="font-size: 40px">管理员界面</span>
		<span class="u">欢迎<span style="color:red">${sessionScope.user.userName }</span>的登录</span>	
	</div>
	<div class="left">
		<button class="bu1" style="background-color: #00b0ff;">图书管理</button>
		<button class="bu2">续借操作</button>
		<button class="bu3">学生管理</button>
		<button class="bu4">借阅操作</button>
		<button class="bu5">归还图书</button>
		<button class="bu6">图书信息</button>
		
		
	</div>
	<div class="right">
		<!-- CRUD -->
		<div class="inner" style="height: 360px;border:3px solid white;border-radius:20px;
								background-color:#00b0ff;box-shadow: 0px 0px 20px white;
								">
			<form:form action="" method="post" enctype="multipart/form-data" id="formId" modelAttribute="book">
				<table class="tab">
					<tr>
						<td>书籍编号：</td>
						<td>
							<form:input path="bookId"/>
						</td>
					</tr>
					<tr>
						<td>书名：</td>
						<td>
							<form:input path="bookName"/>
						</td>
					</tr>
					<tr>
						<td>作者：</td>
						<td>
							<form:input path="bookAuthor"/>
						</td>
					</tr>
					<tr>
						<td>出版社：</td>
						<td>
							<form:select path="bookPublih" items="${bookPublihList }"></form:select>
						</td>
					</tr>
					<tr>
						<td>ISBN：</td>
						<td>
							<form:input path="bookIsbn"/>
						</td>
					</tr>
					<tr>
						<td>摘要：</td>
						<td>
							<form:textarea path="bookBrief"/>
						</td>
					</tr>
					<tr>
						<td>价格：</td>
						<td>
							<form:input path="bookPrice"/>
						</td>
					</tr>
					<tr>
						<td>库存：</td>
						<td>
							<form:input path="bookStore"/>
						</td>
					</tr>
					<tr>
						<td>类型：</td>
						<td>
							<form:select path="bookStyle" items="${bookStyleList }"></form:select>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
							<input type="submit" id="bt1" value="删除书籍" name="Dbook">
						</td>
						<td>
							<input type="submit" id="bt2" value="查询书籍" name="Rbook">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" id="bt3" value="添加书籍" name="Cbook">
						</td>
						<td>
							<input type="submit" id="bt4" value="修改书籍" name="Ubook">
						</td>
					</tr>
				</table>
				
				
				
				<div class="pic">
					<br>封面:<input type="file" name="picture" onchange="viewImage(this)" id="pic">
					<input type="hidden" name="bookPicture" value="">
					<img id="preview" src="
						${book.bookPicture }
					" style="width: 200px;height: 250px;">
				</div>
			</form:form>
		</div>
		
		<!-- 续借操作 -->
		<div class="inner" style="display: none;">
			<div class="IN">
				<div class="log">
					<form action="" method="post">
						<input name="userId" class="input" placeholder="请输入借阅号"/><br>
						<input name="bookId" style="margin-bottom: 25px;" class="input" placeholder="请输入图书编号"/><br>
						<br>
						<input type="submit" value="续借" class="button" id="but1"/>
					</form>
				</div>
			</div>
		</div>
		
		<!-- 学生管理 -->
		<div class="inner" style="display: none;">
			<div class="IN">
				<div class="log">
					<form action="" method="post">
						<input id="userName" class="input" placeholder="请输入借阅号">
						<br>
						<input type="submit" value="查询" class="button" id="but2">
					</form>
				</div>
			</div>
		</div>
 		
 		<!-- 借阅操作 -->
		<div class="inner" style="display: none;">
			<div class="IN">
				<div class="log">
					<form action="">
						<input name="userId" class="input" placeholder="请输入借阅号"/><br>
						<input name="bookId" style="margin-bottom: 25px;" class="input" placeholder="请输入图书编号"/><br>
						<br>
						<input type="submit" value="借书" class="button" id="but3"/>
					</form>
				</div>
			</div>
		</div>
		
		<!-- 归还图书 -->
		<div class="inner" style="display: none;">
			<div class="IN">
				<div class="log">
					<form action="">
						<input name="userId" class="input" placeholder="请输入借阅号"/><br>
						<input name="bookId" style="margin-bottom: 25px;" class="input" placeholder="请输入图书编号"/><br>
						<br>
						<input type="submit" value="还书" class="button" id="but4"/>
					</form>
				</div>
			</div>
		</div>
			
		
		<!-- 用户信息 -->
		<div class="inner" style="display: none;">
			<div style="text-align: center;">用户信息</div>
			<div>
				用户名：<span id="Uname" style="color:red;"></span><br>
				借阅号：<span id="Uid" style="color:red;"></span><br>
				借阅状态：<span id="Ustate" style="color:red;"><a href="" id="Ustate_a"></a></span>
			</div>
			<div style="text-align: center;">借阅详情</div>
			<div>
				<table>
					<tr style="background-color: pink">
						<th width="5%">序号</th>
						<th width="10%">书名</th>
						<th width="10%">借书时间</th>
						<th width="10%">还书时间</th>
						<th width="5%">是否归还</th>
						<th width="5%">需借次数</th>
						<th width="5%">续借</th>
					</tr>
					<c:forEach begin="1" end="5" varStatus="st">
						<tr id="tr_${st.getIndex() }" style="display: none;">
							<th>${st.getIndex() }</th>
							<th id="th_1"></th>
							<th id="th_2"></th>
							<th id="th_3"></th>
							<th id="th_4"></th>
							<th id="th_5"></th>
							<th id="th_6"><a href="" class="xj"></a></th>
						</tr>
					</c:forEach>
				</table>
				<div style="margin: 0px auto;
					margin-top: 45px;
					text-align: center;">
					<a href="#" id="prepage">上一页</a>
					<span style="color: red" id="span1"></span>
					/
					<span id="span2"></span>
					<a href="#" id="nextpage">下一页</a>
				</div>
			</div>
		</div>
		
		<!-- 图书信息 -->
		<div class="inner" style="display: none;">
			<div style="text-align: center;">图书信息</div>
			<div>
				<table>
					<tr style="background-color: pink;">
						<th width="5%">序号</th>
						<th width="10%">编号</th>
						<th width="10%">书名</th>
						<th width="5%">作者</th>
						<th width="10%">出版社</th>
						<th width="10%">ISBN</th>
						<th width="5%">价格</th>
						<th width="5%">库存</th>
						<th width="5%">可借数</th>
						<th width="5%">类型</th>
						<th width="5%">借阅次数</th>
					</tr>
					<c:forEach begin="1" end="5" varStatus="st">
						<tr id="trs_${st.getIndex() }" style="display: none;">
							<th>${st.getIndex() }</th>
							<th id="th_1"></th>
							<th id="th_2"></th>
							<th id="th_3"></th>
							<th id="th_4"></th>
							<th id="th_5"></th>
							<th id="th_6"></th>
							<th id="th_7"></th>
							<th id="th_8"></th>
							<th id="th_9"></th>
							<th id="th_10"></th>
						</tr>
					</c:forEach>
				</table>
				<div style="margin: 0px auto;
					margin-top: 45px;
					text-align: center;">
					<a href="#" class="prepage">上一页</a>
					<span style="color: red" id="span3"></span>
					/
					<span id="span4"></span>
					<a href="#" class="nextpage">下一页</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="book_downLoadToExcele">一键下载</a>
				</div>
			</div>
		</div>
		</div>
		
	
	
	
	<div style="margin-top:750px;text-align:center;clear: both;">
		图书管理系统©版本1.0
	</div>
	
</body>
</html>