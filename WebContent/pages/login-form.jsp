<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User Manager - Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${context}/css/main.css">
	</head>
	<body>
		<div class="center login-section">
			<img src="${context}/img/home_logo.png" class="home-logo">
			<form action="${context}/login" method="post">
				<div class="form-line">
					<input class="form-input-login user-login-icon" type="email" name="email" placeholder="E-mail" required/>
				</div>
				<br>
				<br>
				<div class="form-line">
					<input class="form-input-login password-login-icon" type="password" name="password" placeholder="Password" required/>
				</div>
				<br>
				<div class="center footer">
					<p><input class="login-button" type="submit" value="LOGIN"/></p>
				</div>
			</form>
			<p class="error">${error}</p>
		</div>
	</body>
</html>