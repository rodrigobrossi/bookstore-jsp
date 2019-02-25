<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		</h2>
	</center>
	<div align="center">
		<c:if test="${book != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${book == null}">
			<form action="insert" method="post">
		</c:if>
		<table id="books">
			<caption>
				<h2>
					<c:if test="${book != null}">
                        Editar Livro
                    </c:if>
					<c:if test="${book == null}">
                        Adicionar um novo livro
                    </c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="id" value="<c:out value='${book.id}' />" />
			</c:if>
			<tr>
				<th>Título:</th>
				<td><input type="text" name="title" size="45"
					value="<c:out value='${book.title}' />" /></td>
			</tr>
			<tr>
				<th>Autor:</th>
				<td><input type="text" name="author" size="45"
					value="<c:out value='${book.author}' />" /></td>
			</tr>
			<tr>
				<th>Preço:</th>
				<td><input type="text" name="price" size="5"
					value="<c:out value='${book.price}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>