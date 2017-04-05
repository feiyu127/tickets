<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <script type="text/javascript" src="/js/jquery-3.2.0.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>
  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Site<span>Random</span></div>
		</div>
		<br>
		<div class="login">
			<form id="loginForm" method="post" action="/login/login">
				<input type="text" placeholder="username" name="loginName" /><br>
				<input type="password" placeholder="password" name="password" /><br>
				<input type="button" value="Login" onclick="checkUser()">
				<c:if test="${not empty loginErrorMsg}">
					<br>
					<span style="bgcolor:red">${loginErrorMsg}</span>
				</c:if>
				<%=request.getAttribute("loginErrorMsg") %>
			</form>
		</div>
		
		<script type="text/javascript">
		function checkUser(){
			$('#loginForm').submit();
		}
		</script>	
</body>
</html>
