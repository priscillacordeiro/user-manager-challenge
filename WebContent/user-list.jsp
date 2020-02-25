<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Management</title>
	</head>
	<body>
		<p>User list</p>
		<a href="new">add user</a>
		<c:forEach 	var="user" items="${listUser}">
			<p>${user.name}</p> <a href="edit?id=${user.id}">edit</a> <a href="delete?id=${user.id}">delete</a>
		</c:forEach>
	</body>
</html>