<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User phone management</title>
	</head>
	<body>
		<c:if test="${phone == null}">
		<form action="create" method="post">
 	 	</c:if>
 		<c:if test="${phone != null}">
		<form action="update" method="post">
			<input type="hidden" name="id" value="${phone.id}"/>
	  	</c:if>
	  		<input type="hidden" name="userId" value="${userId}"/>
			<p>DDD:</p> <input type="number" name="ddd" value="${phone.ddd}"/>
			<p>Number:</p> <input type="text" name="number" value="${phone.number}"/>
			<p>Type:</p> <input type="text" name="type" value="${phone.type}"/>
			<p><input type="submit" value="Save"/></p>
		</form>
	</body>
</html>