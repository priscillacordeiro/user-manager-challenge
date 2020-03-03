<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User Manager - Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/user-manager-challenge/css/main.css">
	</head>
	<body>
		<div class="center login-section">
			<img src="/user-manager-challenge/img/home_logo.png" class="home-logo">
			<form action="/user-manager-challenge/login" method="post">
				<div class="form-line">
					<input class="form-input-login user-login-icon" type="email" name="email" placeholder="E-mail"/>
				</div>
				<br>
				<br>
				<div class="form-line">
					<input class="form-input-login password-login-icon" type="password" name="password" placeholder="Password"/>
				</div>
				<br>
				<div class="center footer">
					<p><input class="login-button" type="submit" value="LOGIN"/></p>
				</div>
			</form>
		</div>
	</body>
</html>