<%@page import="usf.model.bookstore.login.ILogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Loja de Livros</title>
<style>
#books {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 80%;
}

#books td, #books th {
	border: 1px solid #ddd;
	padding: 8px;
}

#books tr:nth-child(even) {
	background-color: #f2f2f2;
}

#books tr:hover {
	background-color: #ddd;
}

#books th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>

<%
	//Importante para o local aonde está o contexto de aplicação.
	String path = this.getServletContext().getContextPath();
%>
<body>
	<center>
		<h1>Gestão de Livros</h1>
		<h2>
			<a href="<%=path%>/login/new">Adicionar um novo usuário</a>
			&nbsp;&nbsp;&nbsp; <a href="<%=path%>/login/list">Listar todos os
				usuários</a>
		</h2>
	</center>
	<div align="center">
		<table id="books">
			<caption>
				<h2>Lista de Livros</h2>
			</caption>
			<tr>
				<th>Login ID</th>
				<th>Login</th>
				<th>PWD</th>
				<th>Permissions</th>
				<th>Ações</th>
			</tr>


			<c:forEach var="login" items="${listUsers}">
				<tr>
					<td><c:out value="${login.id}" /></td>
					<td><c:out value="${login.login}" /></td>
					<td><c:out value="${login.passwd}" /></td>
					<td><c:out value="${login.permissions}" /></td>
					<td><a href="../login/edit?id=<c:out value='${login.id}' />">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="../login/delete?id=<c:out value='${login.id}' />">Deletar</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>