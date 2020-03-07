<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User phone management</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/main.css">
	</head>
	<body>
		<div class="center">
			<img src="/img/logo.png" class="logo">
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
				<input class="form-input" type="number" name="ddd" value="${phone.ddd}" required max="999"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">Number:</p>
				<input class="form-input" type="text" name="number" value="${phone.number}" required maxLength="20"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">Type:</p>
				<input class="form-input" type="text" name="type" value="${phone.type}" maxlength="20"/>
			</div>
			<br>
			<p>
				<input class="save-button" type="submit" value="SAVE"/>
			</p>
			</form>
		</div>
		<div class="center footer">
			<a class="link-button" href="/users/view?id=${userId}">Back</a>
		</div>
	</body>
</html>