<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User Management</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/user-manager-challenge/css/main.css">
	</head>
	<body>
		<div class="center">
			<img src="/user-manager-challenge/img/logo.png" class="logo">
		</div>
		<div class="center">
	  		<c:if test="${user == null}">
			<form action="create" method="post">
		 	</c:if>
	  		<c:if test="${user != null}">
			<form action="update" method="post">
				<input type="hidden" name="id" value="${user.id}"/>
		  	</c:if>
			<div class="form-line">
				<p class="form-label">Name:</p>
				<input class="form-input" type="text" name="name" value="${user.name}"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">E-mail:</p>
				<input class="form-input" type="email" name="email" value="${user.email}"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">Password:</p>
				<input class="form-input" type="password" name="password" value="${user.password}"/>
			</div>
			<p>
				<input class="save-button" type="submit" value="SAVE"/>
			</p>
		</form>
			<c:if test="${user != null}">
			<a href="/user-manager-challenge/phones/new?userId=${user.id}">Add phone</a>
			<c:forEach var="phone" items="${user.phones}">
			<p>
				${phone.ddd} - ${phone.number} - ${phone.type} 
				<a href="/user-manager-challenge/phones/edit?userId=${phone.user.id}&id=${phone.id}">edit</a> 
				<a href="/user-manager-challenge/phones/delete?userId=${phone.user.id}&id=${phone.id}">delete</a> 
			</p>
			</c:forEach>
		  	</c:if>
	  	</div>
		<div class="center footer">
			<a class="link-button" href="list">Back</a>
		</div>	
	</body>
</html>