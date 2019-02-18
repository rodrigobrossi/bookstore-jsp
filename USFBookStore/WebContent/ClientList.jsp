<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Books Store Application</title>
</head>
<body>
	<center>
		<h1>Client Management</h1>
		<h2>
			<a href=" new">Add New Client</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Clients</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Clients</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<c:forEach var="client" items="${listAll}">
				<tr>
					<td><c:out value="${client.id}" /></td>
					<td><c:out value="${client.firstname}" /></td>
					<td><c:out value="${client.lastname}" /></td>
					<td><a href="edit?id=<c:out value='${client.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${client.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>