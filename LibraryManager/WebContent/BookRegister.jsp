<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
		padding-top:100px;
		padding-left:150px;
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
	textarea{
		font-size:14px;
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
					
					List<String> error= new ArrayList<String>();
					error = (List<String>)request.getAttribute("error");
					if(error==null){
					    
					}else{
						for(String i:error){%>
						    <h1><%response.getWriter().write(i);%></h1>
						<%}
					}
				%>
				<form class="block" action="<%=request.getContextPath()%>/Compare" method="post">
					书名：<input class="ip" type="text" name="name" /><br/>
					类别：<input type="checkbox" name="kind" value="科学" />科学
					<input type="checkbox" name="kind" value="教育" />教育
					<input type="checkbox" name="kind" value="文学" />文学
					<input type="checkbox" name="kind" value="生活" />生活
					<input type="checkbox" name="kind" value="其他" />其他<br/>
					作者：<input class="ip" type="text" name="author" /> <br/>
					折扣：<input type="radio" name="discount" value="1.0" checked="checked">全价
					<input type="radio" name="discount" value="0.9">九折
					<input type="radio" name="discount" value="0.8">八折
					<input type="radio" name="discount" value="0.7">七折
					<input type="radio" name="discount" value="0.6">六折<br/>
					价格：<input class="ip" type="text" name="price"><br/>
					数量：<input class="ip" type="text" name="count"><br/>
					简介：<textarea cols="30" rows="3" name="introduce"></textarea><br/>
					<input class="bottom" type="submit" value="提交">
					<input class="bottom" type="reset" value="重置">
				</form>
			</div>
		</div>
	</div>
</body>
</html>