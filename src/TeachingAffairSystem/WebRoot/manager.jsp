<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>管理员</title>
	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/manager.js"></script>
	<!--<script type="text/javascript" src="js/manager-js.jsp"></script>-->
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
	<script type="text/javascript" src="jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.min.css">
	<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.theme.min.css">
	<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.structure.min.css">

</head>
<body>
	<div id="div-header">
		<div id="div-header-left">
			<a href="#">首页</a>>>当前页面
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
				<tr><th>管理员功能</th></tr>
				<tr><td><a id="teacherInformation">教师信息</a></td></tr>
				<tr><td><a id="studentInformation">学生信息</a></td></tr>
				<tr><td><a id="courseInformation">课程信息</a></td></tr>
				<tr><td><a id="semesterInformation">学期信息</a></td></tr>
				<tr><td><a id="managerInformation">管理员信息</a></td></tr>
			</table>
		</div>
		<div id="div-main-right">
			<input type="text" id="input-semester-start-1" class="input-semester-date" readonly >
			<label>到</label>
			<input type="text" id="input-semester-end-1" class="input-semester-date" readonly >
			<script>
				function getDate(element) {
				    var date;
				    try {
				    	date = $.datepicker.parseDate( dateFormat, element.value );
				    } catch( error ) {
				    	date = null;
				    }
				    return date;
			    }
				$(function(){
					$(".input-semester-date").datepicker({
						"dateFormat":"yy-mm-dd",
						'changeMonth': true,
						'changeYear': true,
						'monthNamesShort': ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一','十二'],
						'onClose': function(selectDate,currentDate) {
							
						}
					});
					$("#input-semester-start-1").on("change",function(){
						$("#input-semester-end-1").datepicker("option","minDate",$(this).val());
					});
					$("#input-semester-end-1").on("change",function(){
						$("#input-semester-start-1").datepicker("option","maxDate",$(this).val());
					});

				});
			</script>
			<script>
				// getTeacherInformation();
			</script>
		</div>
	</div>
	<div id="div-footer">
		<center>Designed By ZZCoder</center>
	</div>
	<script type="text/javascript">

	</script>
</body>
</html>