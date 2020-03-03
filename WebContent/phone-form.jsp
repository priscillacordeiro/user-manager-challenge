<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User phone management</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/user-manager-challenge/css/main.css">
	</head>
	<body>
		<div class="center">
			<img src="/user-manager-challenge/img/logo.png" class="logo">
		</div>
		<div class="center">
			<c:if test="${phone == null}">
			<form action="create" method="post">
			</c:if>
			<c:if test="${phone != null}">
			<form action="update" method="post">
			<input type="hidden" name="id" value="${phone.id}"/>
			</c:if>
			<input type="hidden" name="userId" value="${userId}"/>
			<div class="form-line">
				<p class="form-label">DDD:</p>
				<input class="form-input" type="number" name="ddd" value="${phone.ddd}"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">Number:</p>
				<input class="form-input" type="number" name="number" value="${phone.number}"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">Type:</p>
				<input class="form-input" type="text" name="type" value="${phone.type}"/>
			</div>
			<br>
			<p>
				<input class="save-button" type="submit" value="SAVE"/>
			</p>
			</form>
		</div>
		<div class="center footer">
			<a class="link-button" href="list">Back</a>
		</div>
	</body>
</html>