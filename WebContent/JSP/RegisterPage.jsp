<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

<link
	href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<link href="../css/views.css" rel="stylesheet">
</head>
<body id="exbody">
	<div class="divx"></div>
	<form action="userInput.action" method="post" ng-app="myApp"
		ng-controller="myCtrl" name="myForm" class="form-horizontal"
		novalidate>
		<div id="divposition">
			<center>
				<h1 class="page-header">
					<span class="glyphicon glyphicon-user"></span>用户注册
				</h1>
			</center>
			<br>

			<div class="col-md-12">
				<span ng-show="myForm.username.$dirty && myForm.username.$invalid">
					<span ng-show="myForm.username.$error.required">用户名是必需的</span>
				</span> <input type="text" class="form-control" name="username"
					ng-model="username" placeholder="用户名/email" required="required">
				<br>
			</div>

			<div class="col-md-12">
				<span ng-show="myForm.pwd.$error.minlength">密码长度至少为6位</span> <input
					type="password" class="form-control" ng-model="password"
					ng-minlength="6" " placeholder="密码" required="required" /><br>
			</div>

			<div class="col-md-12">
				<span ng-show="re_password!=null"> <span
					ng-show="re_password!=password">两次密码不一致</span>
				</span> <input type="password" name="re_pwd" class="form-control"
					ng-model="re_password" placeholder="重新输入密码" required="required" /><br>
			</div>

			<center>
				<input type="submit" id="button1" class="btn btn-primary"
					ng-disabled="myForm.username.$error.required||re_password!=password||re_password==null"
					value="注册"> <input type="reset" id="button2"
					class="btn btn-primary" ng-click="reset()" value="重置">
			</center>

		</div>
	</form>
	<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
   $scope.username = '';
});
</script>
</body>

</html>
