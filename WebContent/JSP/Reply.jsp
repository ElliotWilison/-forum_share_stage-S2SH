<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<body ng-app="myApp">

	<div id="container">

		<div id="head"></div>

		<div id="title">
			<span>
			<font size="6">ISEEN</font>
			</span> 
			
			 <span><input
				type="text"  id="searchKey" size="30" placeholder="Search" /></span> <span><input
				type="button"  id="search" class="btn-primary" value="Search" /></span>
			
				<span><a href="#">我的订阅</a></span>
				<span><a href="subItemInput.action?write=1">写文章</a></span>
			
			<span style="float: right;padding-right:50px;">
			 <a class="right" id="login" href="LoginPage.jsp" class="btn">登录/注册</a>
			</span>
			
			
			 
		</div>

		<div class="boxy">
			<div id="leader" ng-controller="myCtrl">
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
							<input type="hidden" id="uname" value="${user.username }"/>
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
					他的主题<span id="rightspan" ng-model="edit" ng-click="show()">
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
					
					<span ng-show="edit=='back'" >
<a href="itemInput.action?itemID=${item.itemID}">删除</a>
</span>
					</div>
					<br>
				</s:iterator>
			</div>

			<div id="depart"></div>

			<div id="content">

				<div id="replycontent" ng-controller="myCtrl1">

<div class="ed">
							<a><span>编辑</span></a>
							<span>|</span>
							<a href="topicInput.action?topicID=${topics.topicID}"><span>删除</span></a>
							</div>
					<br>
					<s:iterator value="#session.Topic" var="topic1">
						<div id="topiccontent">
							<center>
								<h1>
									<s:property value="#topic1.topic"></s:property>
								</h1>
							</center>
							<br>
							<p style="text-align: right;">
								日期：
								<s:property value="#topic1.date"></s:property>
							</p>
							<p style="text-indent: 2em;">
								<s:property value="#topic1.content"></s:property>
							</p>
							<br> <br> <br> <br> <br> <br>
							<center>
								阅读数：
								<s:property value="#topic1.hasread"></s:property>
							</center>
						</div>
						<br>

						<div id="replyarea">
							<span ng-model="reply" ng-show="reply!='show'"
								ng-click="showReply()">
								<h3 id="h3sign">点击我进行评论</h3>
							</span>
							<div ng-show="reply=='show'">
								<br>
								<form action="replyInput.action" method="post">
									<textarea name="content"></textarea>
									<input type="text" name="topicID" value="${topic1.topicID}"
										hidden="hidden" /> <input type="text" name="userID"
										value="${user.userID}" hidden="hidden" />  <input type="submit"
										id="sbtn" class="btn btn-primary btn-sm" ng-click="showTime()"
										value="发表" />
								</form>
							</div>
						</div>

					</s:iterator>
					<hr>

					<s:iterator value="#session.Replies" var="reply" status="stat">
					<div class="floors">
						<s:property value="#stat.getIndex()+1"></s:property>楼
						<span><s:property value="#reply.user.userName"/></span>
						</div>
						<p>
							<s:property value="#reply.content"></s:property>
						</p>
						<s:property value="#reply.date"></s:property>
						<hr style="border: 1px solid gray;">
					</s:iterator>

					<center>
						<s:if test="#session.Page.hasPrePage">
							<a href="replyInput.action?currentPage=1">首页</a>
							<a href="replyInput.action?currentPage=${Page.currentPage-1}">上一页</a>
						</s:if>
						<s:else>
	首页 上一页
	</s:else>
						<s:if test="#session.Page.hasNextPage">
							<a href="replyInput.action?currentPage=${Page.currentPage+1}">下一页</a>
							<a href="replyInput.action?currentPage=${Page.totalPage}">末页</a>
						</s:if>
						<s:else>
	下一页 末页
	</s:else>
					</center>
				</div>
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
		app.controller('myCtrl1', function($scope) {
		$scope.showReply = function() {
			$scope.reply ='show';
		};
		$scope.showTime=function(){
			var today=new Date();
			var year=today.getFullYear();
			var month=today.getMonth()+1;
			var day=today.getDate();
			var hours = today.getHours();
			var minutes = today.getMinutes();
			var seconds = today.getSeconds();
			
			
			var alltime=year+"-"+month+"-"+day;
			
			var now=document.getElementById("time");
			now.value=alltime;
		};
		});
	</script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		var uname=$("#uname").val();
		if(uname!=null){
			$("#login").text(uname);
			$("#login").attr('href','#');
			
			}
		
		
	});
	
	</script>
</body>
</html>