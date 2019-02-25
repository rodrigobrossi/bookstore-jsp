<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Loja de Livros</title>
</head>
<% 
	String path  = this.getServletContext().getContextPath();
%>
<body>
	<center>
		<h1>Gestão de Livros</h1>
		<h2>
			<a href="<%=path%>/new">Adicionar um novo Livro</a> &nbsp;&nbsp;&nbsp; 
			<a href="<%=path%>/list">Listar todos os livros</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
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