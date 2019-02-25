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
	String path = this.getServletContext().getContextPath();
%>
<body>
	<center>
		<h1>Gestão de Livros</h1>
		<h2>
			<a href="<%=path%>/new">Adicionar um novo Livro</a>
			&nbsp;&nbsp;&nbsp; <a href="<%=path%>/list">Listar todos os
				livros</a>
			<p>USF-Universidade São Francisco</p>

		</h2>
	</center>
	<div align="center">
		<table id="books">
			<caption>
				<h2>Lista de Livros</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Título</th>
				<th>Autor</th>
				<th>Preço</th>
				<th>Ações</th>
			</tr>


			<c:forEach var="book" items="${listBook}">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
					<td><a href="edit?id=<c:out value='${book.id}' />">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${book.id}' />">Deletar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>