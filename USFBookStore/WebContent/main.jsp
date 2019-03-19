<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RGB Application</title>
</head>
<body>
	<!-- Main screen -->
	<h1>Esta aplicação é um exemplo de controle de livros.</h1>
	<%
		out.print("<br> Gestão de Livros");

		String path = this.getServletContext().getContextPath();
	%>
	<center>

		<h1>Bem vindo ao software - Gestão de Livros 2.0</h1>
		<h2>
			<a href="<%=path%>/new">Adicionar um novo Livro</a>
			&nbsp;&nbsp;&nbsp; <a href="<%=path%>/list">Listar todos os
				livros</a>

		</h2>
	</center>
</body>
</html>