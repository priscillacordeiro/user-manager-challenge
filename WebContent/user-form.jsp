<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User Management</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
				<input class="form-input" type="text" name="name" value="${user.name}" required maxlength="100"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">E-mail:</p>
				<input class="form-input" type="email" name="email" value="${user.email}" required maxlength="100"/>
			</div>
			<br>
			<div class="form-line">
				<p class="form-label">Password:</p>
				<input class="form-input" type="password" name="password" value="${user.password}" required minlength="4" maxlength="50"/>
			</div>
			<p>
				<input class="save-button" type="submit" value="SAVE"/>
			</p>
			</form>
			<p class="error">${error}</p>
	  	</div>
		<div class="center footer">
			<c:if test="${user == null}">
				<a class="link-button" href="list">Back</a> 
			</c:if>
			<c:if test="${user != null}">
				<a class="link-button link-button-margin" href="view?id=${user.id}">Back</a> 	
			    <a class="link-delete" id="myBtn" href="javascript: void(0)">Delete user</a>
			</c:if>
		</div>	
		<div id="myModal" class="modal">
			<div class="modal-content center">
				<p>Do you really want to delete this <strong>user</strong>?</p>
				<br>
			    <a class="modal-button yes-label" href="delete?id=${user.id}">Yes</a>
			    <a class="modal-button close no-label" href="javascript: void(0)">No</a>
			</div>
		</div>
		<script type="text/javascript" src="/user-manager-challenge/js/main.js"></script>
	</body>
</html>