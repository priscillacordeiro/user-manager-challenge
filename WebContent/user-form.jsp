<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Management</title>
	</head>
	<body>
		<form action="create" method="post">
			<p>Name:</p> <input type="text" name="name"/>
			<p>E-mail:</p> <input type="text" name="email"/>
			<p>Password:</p> <input type="password" name="password"/>
			
			<input type="submit"/>
		</form>
	</body>
</html>