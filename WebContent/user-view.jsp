<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>User phone management</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/user-manager-challenge/css/main.css">
	</head>
	<body>
		<div class="center">
			<img src="/user-manager-challenge/img/logo.png" class="logo">
		</div>
		<table>
			<tbody>
				<tr class="list-item-white">	
					<td><img src="/user-manager-challenge/img/icon_user.png" class="user-icon"></td>
					<td>${user.id}</td> 
					<td>${user.name}</td> 
					<td>${user.email}</td> 
					<td><a href="edit?id=${user.id}"><img src="/user-manager-challenge/img/icon_edit.png" class="icon-small background-white-gray"></a></td>
					<td><a href="/user-manager-challenge/phones/new?userId=${user.id}"><img src="/user-manager-challenge/img/icon_new_phone.png" class="icon-small background-white-gray"></a></td>
				</tr>
			</tbody>
		</table>
		<c:if test="${!empty user.phones}">
			<table>
				<thead>
					<tr>
						<th>DDD</th>
						<th>Number</th>
						<th>Type</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="phone" items="${user.phones}" varStatus="count">
						<tr class="row-line">	
							<td>${phone.ddd}</td> 
							<td>${phone.number}</td> 
							<td>${phone.type}</td> 
							<td>
								<a href="/user-manager-challenge/phones/edit?userId=${phone.user.id}&id=${phone.id}"><img src="/user-manager-challenge/img/icon_edit.png" class="icon-small"></a> 
							</td>
							<td>
								<a href="/user-manager-challenge/phones/delete?userId=${phone.user.id}&id=${phone.id}"><img src="/user-manager-challenge/img/icon_delete.png" class="icon-small"></a>
							</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<div class="center footer">
			<a class="link-button link-button-margin" href="list">Back</a>
			<a class="link-button logout" href="/user-manager-challenge/logout">Logout</a>
		</div>		
	</body>
</html>