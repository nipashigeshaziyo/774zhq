<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.library.service.Service" %>
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
		width:530px;
		float:left;
	}
	.text{
		margin:0 auto;
		width:364px;
		padding-top:100px;
	}
	.text h2{
		text-align:center;
		letter-spacing:20px;
	}
	.text p{
		text-indent:2em;
	}
	.show{
		padding-left:150px;
		padding-top:80px;
		
	}
	.show h1{
		font-size:16px;
	}
	.show a{
		font-size:16px;
		font-weight:bolder;
	}
	.show a:link{
		text-decoration:none;
	}
	.show a:hover{
		color:red;
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
				<%
					int id =0;
					try{
					    id=Integer.parseInt(request.getParameter("id"));
					    session.setAttribute("bid", id);
					}catch(NumberFormatException e){
					    e.printStackTrace();
					}
					Book book = Service.getQuery(id);
					session.setAttribute("book", book);
				%>
				<h1>书名：<%=book.getName() %></h1><br/>
				<h1>种类：<%=book.getKind() %></h1><br/>
				<h1>作者：<%=book.getAuthor() %></h1><br/>
				<h1>折扣：<%=book.getDiscount() %></h1><br/>
				<h1>价格：<%=book.getPrice() %></h1><br/>
				<h1>数量：<%=book.getCount() %></h1><br/>
				<h1>简介：<%=book.getIntroduce() %></h1><br/>
				<a href="update.jsp">修改</a>
				<a href="BookList.jsp">返回</a>
			</div>
		</div>
	</div>
</body>
</html>





