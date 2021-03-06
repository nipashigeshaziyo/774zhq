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
	a:link{
		color:#0D51AC;
	}
	a:visited{
		color:#0D51AC
	}
	a:hover{
		color:red;
	}
	a:active{
		color:#0D51AC;
	}
	.show{
		width:530px;
		float:left;
		padding-top:60px;
		padding-left:300px;
		font-size:20px;
	}
	.show h1{
		font-size:16px;
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
				<h1>书名：${book.name}</h1><br/>
				<h1>种类：${book.kind}</h1><br/>
				<h1>作者：${book.author}</h1><br/>
				<h1>折扣：${book.discount}</h1><br/>
				<h1>价格：${book.price}</h1><br/>
				<h1>数量：${book.count}</h1><br/>
				<h1>简介：${book.introduce}</h1><br/>
				<a href="updateBookAction_1?bid=${book.bid }&name=${book.name }&kind=${book.kind}&author=${book.author }&discount=${book.discount}&price=${book.price}&count=${book.count}&introduce=${book.introduce}">修改</a>
				<a href="BookList.jsp">返回</a>
			</div>
		</div>
	</div>
</body>
</html>

