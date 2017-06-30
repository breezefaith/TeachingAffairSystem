<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学生</title>
	<link rel="stylesheet" href="css/student.css">
	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/student.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>
<body>
	<div id="div-header">
		<div id="div-header-left">
			首页>>当前页面
		</div>
		<div id="div-header-right">
			<script type="text/javascript">
				if('<s:property value="username"/>'==""||'<s:property value="username"/>'=="null"){
					alert("登陆过期");
					window.location.href="/TeachingAffairSystem/";
				}else{
					//alert('<s:property value="username"/>');
				}
			</script>
			<s:property value="username"/>(<s:property value="identity"/>)<a style="color:blue;" id="logout">（退出）</a>
			<script>
				$(function(){
					$("#logout").click(function(){
						window.location.href="login.jsp";
					});
				});
			</script>
		</div>
	</div>
	<div id="div-main">
		<div id="div-main-left">
			<table cellspacing="0" class="table-foundation-button">
				<tr><th>学生功能</th></tr>
				<tr><td><a id="score">成绩查询</a></td></tr>
				<tr><td><a id="selectCourse">选课</a></td></tr>
				<tr><td><a id="personInformation">个人信息</a></td></tr>
			</table>
		</div>
		<div id="div-main-right">
			
		</div>
	</div>
	<div id="div-footer">
		<center>Designed By ZZCoder</center>
	</div>
</body>
</html>