<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	.show h1{
		color:#210CBF;
		text-align:center;
		line-height:380px;
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
					<h1>注册成功！</h1>
			</div>
		</div>
	</div>
</body>
</html>