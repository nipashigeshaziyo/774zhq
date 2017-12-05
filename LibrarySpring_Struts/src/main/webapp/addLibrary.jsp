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
	.block input{
		margin-top:20px;
		font-size:16px;
	}
	.block .ip{
		width:200px;
		height:25px;
	}
	.block .bottom{
		
		margin:10px 50px 0;
	}
	.block span{
		font-size:12px;
		color:red;
	}
	.block ul{
		display:inline;
	}
	.block li{
		display:inline;
	}
	textarea{
		font-size:14px;
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
				<a href="#">首页</a><br/>
				<a href="addLibrary.jsp">入库登记</a><br/>
				<a href="bookListAction">库存列表</a>
			</div>
			<div class="show">
				<form class="block" action="addAction" method="post">
					书名：<input class="ip" type="text" name="name" value="${param.name }"/>
						<font color="red">
							<s:fielderror>
								<s:param>name</s:param>
							</s:fielderror>
						</font>
					<br/>
					<c:set var="types" value="科学,教育,文学,生活,其他"></c:set>
					类别：
					<c:forEach var="arr" items="${types}">
						<input type="checkbox" name="kind" value="${arr }"
						<c:forEach var="k" items="${kinds }">
								<c:if test="${arr eq k}">checked="checked"</c:if>
						</c:forEach>
						/>${arr }
					</c:forEach>
						<span>
						<font color="red">
							<s:fielderror>
								<s:param>kind</s:param>
							</s:fielderror>
						</font>
						</span>
						<br/>
					作者：<input class="ip" type="text" name="author" value="${param.author }"/>
						<font color="red">
							<s:fielderror>
								<s:param>author</s:param>
							</s:fielderror>
						</font>
						<br/>
						<c:set var="prices" value="1,0.9,0.8,0.7,0.6"></c:set>
						折扣：
						<c:forEach items="${prices}" var="p">
							<input type="radio" name="discount" value="${p }"
								<c:if test="${param.discount eq p }">checked="checked"</c:if>
							/>${p}
						</c:forEach>

						<font color="red">
							<s:fielderror>
								<s:param>discount</s:param>
							</s:fielderror>
						</font>
						<br/>
						价格：<input class="ip" type="text" name="price" value="${param.price }">
						<font color="red">
							<s:fielderror>
								<s:param>price</s:param>
							</s:fielderror>
						</font>
						<br/>
						数量：<input class="ip" type="text" name="count" value="${param.count }">
						<font color="red">
							<s:fielderror>
								<s:param>count</s:param>
							</s:fielderror>
						</font>
						<br/>
						简介：<textarea cols="30" rows="3" name="introduce"">${param.introduce }</textarea>
						<font color="red">
							<s:fielderror>
								<s:param>introduce</s:param>
							</s:fielderror>
							</font>
						<br/>
						<input class="bottom" type="submit" value="提交">
						<input class="bottom" type="reset" value="重置">
					</form>
			</div>
		</div>
	</div>
</body>
</html>