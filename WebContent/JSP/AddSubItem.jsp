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

	<form action="subItemInput.action" method="get" ng-app="myApp"
		ng-controller="myCtrl" name="myForm" class="form-horizontal"
		novalidate>
		<div class="divx"></div>
		<div id="divposition">
			<center>
				<h1 class="page-header">
					<span class="glyphicon glyphicon-user"></span>添加模版
				</h1>
			</center>
			<br>
			<div class="col-md-12">
				<input type="text" class="form-control" name="subItemName"
					placeholder="SubItem名字" required="required">
			</div>
			<br>
			<div>
				<textarea name="subItemDescription" placeholder="subItem描述"
					required="required"></textarea>
			</div>
			<br>
			<center>
				<input type="submit" id="button1" class="btn btn-primary" value="添加">
				<input type="reset" id="button2" class="btn btn-primary" value="重置">
			</center>

		</div>
	</form>

</body>
</html>

