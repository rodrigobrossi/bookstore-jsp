<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RGB - Contract management.</title>
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
		<h1>Gestão de Usuários</h1>
		<h2>
			<a href="<%=path%>/login/new">Adicionar um novo usuário.</a>
			&nbsp;&nbsp;&nbsp;
			<a href="<%=path%>/login/list">Listar todos os usuários.</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${login != null}">
			<form action="/login/update" method="post">
		</c:if>
		<c:if test="${login == null}">
			<form action="/login/insert" method="post">
		</c:if>
		<table id="books">
			<caption>
				<h2>
					<c:if test="${login != null}">
                        Editar Livro
                    </c:if>
					<c:if test="${login == null}">
                        Adicionar um novo livro
                    </c:if>
				</h2>
			</caption>
			<c:if test="${login != null}">
				<input type="hidden" name="id" value="<c:out value='${login.id}' />" />
			</c:if>
			<tr>
				<th>Login:</th>
				<td><input type="text" name="login" size="45"
					value="<c:out value='${login.login}' />" /></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="passwd" size="45"
					value="<c:out value='${login.passwd}' />" /></td>
			</tr>
			<tr>
				<th>Confirm your password:</th>
				<td><input type="password" name="confirm" size="45"
					value="<c:out value='${login.passwd}' />" /></td>
			</tr>
			<tr>
				<th>Permissions:</th>
				<td><select id="perm" name="perm">
					<option value="0" selected="<c:out default='None' value='${login.permissions}==0 ? Selected : None' />">Administrator</option>
					<option value="1" selected="<c:out default='None' value='${login.permissions}==0 ? Selected : None' />">Advanced User</option>
					<option value="2" selected="<c:out default='None' value='${login.permissions}==0 ? Selected : None' />">User</option>
					<option value="3" selected="<c:out default='None' value='${login.permissions}==0 ? Selected : None' />">Client</option>
				</select>
				
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