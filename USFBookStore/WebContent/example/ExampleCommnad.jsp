<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			Date date = new Date();

			out.println("<h1>Example commnad " + date.toString() + "</h1>");

			String path = this.getServletContext().getContextPath();
			
		%>


		<h1>Gestão de Livros</h1>
		<h2>
			<a href="<%=path%>/new">Adicionar um novo Livro</a>
			&nbsp;&nbsp;&nbsp; <a href="<%=path%>/list">Listar todos os
				livros</a>

		</h2>
		
		<p> Você escolheu uma opção invalida do sistema! Por favor dirija-se a tela de listagem ou inclusão de livros.</p>  
	</center>
</body>
</html>