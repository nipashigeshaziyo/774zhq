<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.service.Service"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.library.domain.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0;padding:0;list-style:none}
	.box{
		width:903px;
		height:662px;
		border:3px solid red;
		margin:0 auto;
	}
	.banner{
		width:903px;
		height:128px;
	}
	.left_content{
		width:220px;
		height:434px;
		border-right:2px solid #000;
		background:url(images/bg_left.png) 0 0 repeat-y;
		padding-top:100px;
		float:left;
	}
	.left_content a{
		margin-left:50px;
		line-height:50px;
		color:#210CBF;
	}
	.left_content a:link{
		text-decoration:none;
	}
	.left_content a:visited{
		color:#210CBF
	}
	.left_content a:hover{
		 color:red
	}
	.left_content a:active{
		color:#000;
	}
	.show{
		width:680px;
		float:left;
		padding-top:50px;
	}
	.show table{
		border-collapse:collapse;
		cellpadding:5px;
	}
	.show td{
		border:1px solid #000;
		width:110px;
		height:20px;
		text-align:center;
	}
</style>
</head>
<body>
	<div class="box">
		<div class="banner">
			<img alt="banner" src="images/banner.png">
		</div>
		<div class="content">
			<div class="left_content">
				<h3><a href="index.jsp">首页</a></h3>
				<h3><a href="BookRegister.jsp">库存登记</a></h3>
				<h3><a href="BookList.jsp">库存列表</a></h3>
			</div>
			<div class="show">
				<table>
					<tr>
					<td>序号</td>
					<td>书名</td>
					<td>作者</td>
					<td>价格</td>
					<td>数量</td>
					<td>操作</td>
					</tr>
					<%!Boolean flag = false; %>
					<% 
						List<Book> list = Service.getQuery();
						
						if(list!=null){
						    for(Book i : list){
					%>
					<tr>
						<td><%=i.getBid() %></td>
						<td><%=i.getName() %></td>
						<td><%=i.getAuthor()%></td>
						<td><%=i.getPrice()%></td>
						<td><%=i.getCount()%></td>
						<td>
						
						<a href="showBook.jsp?id=<%=i.getBid() %>">详情</a>&nbsp&nbsp
						<a id="delete" onclick="fn" href="deleteBook?id=<%=i.getBid() %>">删除</a>
						</td>
					</tr>
					<%
						    }
						}
					%>
				</table>
			</div>
		</div>
	</div>
		
		
</body>
</html>