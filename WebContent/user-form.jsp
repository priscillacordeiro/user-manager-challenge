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
  		<c:if test="${user == null}">
			<form action="create" method="post">
	 	</c:if>
  		<c:if test="${user != null}">
			<form action="update" method="post">
			<input type="hidden" name="id" value="${user.id}"/>
	  	</c:if>
			<p>Name:</p> <input type="text" name="name" value="${user.name}"/>
			<p>E-mail:</p> <input type="text" name="email" value="${user.email}"/>
			<p>Password:</p> <input type="password" name="password" value="${user.password}"/>
			<input type="submit"/>
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
	</body>
</html>