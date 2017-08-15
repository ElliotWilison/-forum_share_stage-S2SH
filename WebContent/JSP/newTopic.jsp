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
<link href="../css/topic.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h2>新建标题</h2>
<hr>

<div class="content">
<form action="topicInput.action" method="get">
选择文章标题：
<select name="subItemID">
<s:iterator value="#session.SItems" var="sItem">
<option value="${sItem.subItemID}"><s:property value="#sItem.subItemName"></s:property></option>
</s:iterator>

</select>
<p></p>
<input type="text" class="form-control" name="topic" placeholder="文章标题"/>
<br>
<input type="text" class="form-control" name="content" placeholder="文章内容"/>

<button type="submit" class="btn btn-success">提交</button>
</form>
</div>
</div>

</body>
</html>