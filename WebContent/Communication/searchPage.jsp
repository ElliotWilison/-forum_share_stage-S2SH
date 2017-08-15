<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp" ng-controller="myCtrl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<link href="../css/views.css" rel="stylesheet">
<script src="../jquery/J_query.js" >
	</script>
</head>
<body>

	<div id="container">


		<div id="head"></div>

		<div id="title">
			<span><font size="6">ISEEN</font></span>
			
			
			 <span><input
				type="text"  id="searchKey" size="30" placeholder="Search" /></span> <span><input
				type="button"  id="search" class="btn-primary" value="Search" /></span>
				
					<span><a href="#">我的订阅</a></span>
				<span><a href="subItemInput.action?write=1">写文章</a></span>
				
				 <span
				style="float: right;padding-right:50px;"> 
				
				<a class="right" id="login"
				href="LoginPage.jsp" role="button" class="btn">登录/注册</a>
				</span>
	
		</div>

		

			<div id="depart">
			<s:iterator value="#session.User" var="user">
			<input type="hidden" id="uname" value="${user.username }"/>
			</s:iterator>
			</div>

			<div id="content">
				推荐文章 <br>
				<s:iterator value="#session.STopics" var="topics">
					<a href="replyInput.action?topicID=${topics.topicID}">
						<div id="divtopic">
							话题名称:
							<s:property value="#topics.topic"></s:property>
							<br> 话题内容:
							<s:property value="#topics.content"></s:property>
							<br> 阅读数：
							<s:property value="#topics.hasread"></s:property>
							日期：
							<s:property value="#topics.date"></s:property>
						</div>
					</a>
					<br>
				</s:iterator>
			</div>

		</div>


		<div id="endline">
		
		<span>&copy;Copyright|</span>
		<span>14级计科三班刘啸|</span>
		<span>合作伙伴</span>
		</div>

	</div>


</body>
</html>