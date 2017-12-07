<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0;padding:0;list-style:none}
	.wrap{
		width:1270px;
		height:665px;
		border:1px solid red;
		margin:0 auto;
	}
	.header{
		height:182px;
		border:1px solid red;
	}
	.header img{
		width:1270px;
		height:182px;
		float:left;
	}
	.content .left{
		width:179px;
		height:333px;
		border:1px solid red;
		background:url(images/bg_left.png) 0 0 repeat-y;
		background-size:279px 26px;
		padding:150px 0 0 100px;
		float:left
	}
	.left a{
		font-size:16px;
		font-weight:bolder;
		line-height:40px;
		text-decoration:none;
	}
	.left a:nth-child(1){
		letter-spacing:2em;
	}
	.show{
		width:680px;
		float:left;
		padding-top:50px;
		margin-left:100px;
	}
	.show table{
		border-collapse:collapse;
		cellpadding:5px;
		
	}
	.show td{
		border:1px solid #000;
		width:110px;
		text-align:center;
	}
	.left a:link{
		text-decoration:none;
		color:#210CBF;
	}
	.left a:visited{
		color:#210CBF;
	}
	.left a:hover{
		color:red;
	}
	.left a:active{
		color:#210CBF;
	}
	.show a:link{
		text-decoration:none;
	}
	.show a:visited{
		color:#210CBF;
	}
	center{
		margin-top:30px;
	}
</style>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<img src="images/banner.png">
		</div>
		<div class="content">
			<div class="left">
				<a href="index.vm">首页</a><br/>
				<a href="addLibrary.jsp">入库登记</a><br/>
				<a href="bookListAction">库存列表</a><br/>
				<a href="showBookActionByPage">分页查询</a>
			</div>
			<div class="show">
			<c:set var="pn" value="2,5,10"></c:set>
			<select name="pageNum" onchange="pagechange(this.value)">
				<c:forEach var="p" items="${pn }">
					<option value="${p }"
						<c:if test="${pageNum==p }">selected="selected"</c:if>	
					>${p }</option>
				</c:forEach>
			</select>
				<table>
					<tr>
					<td>序号</td>
					<td>书名</td>
					<td>作者</td>
					<td>价格</td>
					<td>数量</td>
					<td>操作</td>
					</tr>
					<c:forEach var="l" items="${list}">
						<tr>
							<td>${l.bid}</td>
							<td>${l.name}</td>
							<td>${l.author}</td>
							<td>${l.price}</td>
							<td>${l.count}</td>
							<td>
							<a href="showBookAction?bid=${l.bid}">详情</a>&nbsp&nbsp
							<a id="delete" onclick="return del()" href="deleteBookAction?bid=${l.bid}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<center>
					<c:if test="${currentNum==1}">
						<a>首页</a>
						<a>上一页</a>
					</c:if>	
					<c:if test="${currentNum!=1}">
						<a href="showBookActionByPage?currentNum=1&pageNum=${pageNum}">首页</a>
						<a href="showBookActionByPage?currentNum=${currentNum-1}&pageNum=${pageNum}">上一页</a>
					</c:if>
					<c:if test="${currentNum==totalPage }">						
						<a>下一页</a>
						<a>尾页</a>
					</c:if>
					<c:if test="${currentNum!=totalPage}">						
						<a href="showBookActionByPage?currentNum=${currentNum+1}&pageNum=${pageNum}">下一页</a>
						<a href="showBookActionByPage?currentNum=${page.totalPage}&pageNum=${pageNum}">尾页</a>
					</c:if>
				</center>
			</div>
		</div>
	</div>
</body>
<script>
	function pagechange(value){
		location.href="showBookActionByPage?pageNum="+value;
	}
</script>
</html>

