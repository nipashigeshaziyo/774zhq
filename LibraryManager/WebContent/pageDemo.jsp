<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.service.Service"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.library.domain.Book" %>
<%@ page import="com.library.domain.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		position:relative;
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
	.show a:link{
		text-decoration:none;
		color:#210CBF;
	}
	.show a:hover{
		color:red;
	}
	.show a:visited{
		color:#210CBF;
	}
	.show a:active{
		color:#210CBF;
	}
	center{
		position:absolute;
		left:240px;
		bottom:-100px;
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
				<h3><a href="<%=request.getContextPath()%>/Pagechange">库存列表</a></h3>
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
					
					<% 
						Page p = (Page)request.getAttribute("page");
						List<Book> list = p.getList();
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
						<a id="delete" onclick="return del()" href="deleteBook?id=<%=i.getBid() %>">删除</a>
						</td>
					</tr>
					<%
						    }
						}
					%>
					<center>
						<c:if test="${page.currentPage==1}">
							<a>首页</a>
							<a>上一页</a>
						</c:if>	
						<c:if test="${page.currentPage!=1}">
							<a href="<%=request.getContextPath()%>/Pagechange?currentPage=1&PageNum=${page.pageNum}">首页</a>
							<a href="<%=request.getContextPath()%>/Pagechange?currentPage=${page.currentPage-1}&PageNum=${page.pageNum}">上一页</a>
						</c:if>
						<c:if test="${page.currentPage==page.totalPage }">						
							<a>下一页</a>
							<a>尾页</a>
						</c:if>
						<c:if test="${page.currentPage!=page.totalPage}">						
							<a href="<%=request.getContextPath()%>/Pagechange?currentPage=${page.currentPage+1}&PageNum=${page.pageNum}">下一页</a>
							<a href="<%=request.getContextPath()%>/Pagechange?currentPage=${page.totalPage}&PageNum=${page.pageNum}">尾页</a>
						</c:if>
					</center>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function del(){
		var i=window.confirm("您确定删除吗");
		return i;
	} 
	</script>
		
</body>
</html>