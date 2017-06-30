<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    <meta charset=UTF-8>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link href="css/drag.css" rel="stylesheet" type="text/css">
	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="js/drag.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<form action="LoginAction" method="post">
		<div id="login-div">
	  		<table id="login-table">
	  			<tr></tr>
		  		<tr>
		  			<td class="td-name">用户名：</td>
		  			<td><input type="text" width="30px" name="username" id="username" value="admin"/></td>
		  		</tr>
		  		<tr>
		  			<td class="td-name">密&nbsp;&nbsp;&nbsp;码：</td>
		  			<td><input type="password" width="30px" name="password" id="password" value="admin"/></td>
		  		</tr>
		  		<tr>
		  			<td colspan="2">
		  				<input type="radio" name="identity" value="student" />学生
		  				<input type="radio" name="identity" value="teacher" />教师
		  				<input type="radio" name="identity" value="manager" checked/>管理员
		  			</td>
		  		</tr>
		  		<tr>
		  			<td class="td-name" colspan="2"><div id="drag"/></div></td>
		  		</tr>
		  		<tr>
		  			<td colspan="2">
		  				<input type="submit" value="登录" id="submit-button" disabled="true" onclick="return checkNull()" />
		  				<input type="reset"  value="重置" id="reset" />
		  			</td>
		  		</tr>
	  		</table>
	  	</div>
	</form>
	<script type="text/javascript">
		$('#drag').drag();
	</script>
	<script>
		function checkNull(){
            if($('#username').val()!="" && $('#password').val()!=""){
                return true;
            }else{
                $('#login-table').prepend("<tr><td colspan='2'><font style='font-size:15px;color:red;'>用户名及密码不能为空</font></td></tr>");
                return false;
            }
        }
	</script>
  </body>
</html>
