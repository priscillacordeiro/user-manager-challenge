<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User Management</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/main.css">
	</head>
	<body>
		<div class="center">
			<img src="/img/logo.png" class="logo">
			<p class="user-greeting">Hi, ${name}!</p>
		</div>	
		<table>
			<thead>
				<tr>
					<th></th>
					<th>Id</th>
					<th>Name</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach 	var="user" items="${listUser}" varStatus="count">
					<tr onclick="location.href = 'view?id=${user.id}'" 
						class="${(count.index % 2 == 0) ? 'list-item-white' : 'list-item-lilac'} cursor-pointer">	
						
						<td><img src="/img/icon_user.png" class="user-icon"></td>
						<td>${user.id}</td> 
						<td>${user.name}</td> 
						<td>${user.email}</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="center footer">
			<a class="link-button link-button-margin" href="new">New user</a>
			<a class="link-button logout" href="/logout">Logout</a>
		</div>	
	</body>
</html>