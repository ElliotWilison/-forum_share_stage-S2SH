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
		

			<span style="float: right;padding-right:50px;"> <a class="right" id="register"
				href="LoginPage.jsp" role="button" class="btn">登录/注册</a></span>

		</div>

		<div class="boxy">
			<div id="leader" ng-app="myApp" ng-controller="myCtrl">
				<br />
				<div id="userImg">
					<img src="../images/userImg.png">
				</div>
				<br>
				<div id="userInfo">
					<s:iterator value="#session.User" var="user">
						<p>
							博主:
							<s:property value="#user.username"></s:property>
						</p>
						<p>
							博主年龄:
							<s:property value="#user.age"></s:property>
						</p>
						<p>
							积分数:
							<s:property value="#user.integral"></s:property>
						</p>
					</s:iterator>
				</div>
				<p>
					他的主题<span  ng-model="edit" ng-click="show()">
					<button class="btn btn-primary btn-sm">Edit</button>
					</span> 
							<span ng-show="edit=='back'"> 
							<a href="AddItem.jsp">添加</a>
					</span>
				</p>
				<hr style="border: 1px solid gray;" />
				<s:iterator value="#session.Items" var="item">
				<div class="part1">
				<div class="part2">
					<a href="subItemInput.action?itemID=${item.itemID}">
					<s:property value="#item.itemName"></s:property>
					</a>
					</div>
					<span ng-show="edit=='back'">
					
					<a href="itemInput.action?itemID=${item.itemID}">删除</a>
			
					</span>
					</div>
					<br>
					
				</s:iterator>
			</div>


			<div id="depart"></div>

			<div id="content">
				推荐文章 <br>
				<s:iterator value="#session.AllTopics" var="topics">
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



	<script>
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope) {
			$scope.show = function() {
				if ($scope.edit == null || $scope.edit == 'edit')
					$scope.edit = 'back';
				else
					$scope.edit = 'edit';

			};
		});
		
	</script>

</body>
</html>