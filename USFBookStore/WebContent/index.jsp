<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RGB Applications</title>
<style>
#users {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 80%;
}

#users td, #users th {
	border: 1px solid #ddd;
	padding: 8px;
}

#users tr:nth-child(even) {
	background-color: #f2f2f2;
}

#users tr:hover {
	background-color: #ddd;
}

#users th {
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
	<div align="center">
		<form action="login/" method="POST">
			<div id="users" style="width:50%; diplay:table;">
				<div style="diplay:table-row;">
					<div style="width: 300px; diplay:table-cell;">Login:</div>
					<div style="diplay:table-cell;"><input type="text" name="login" id="login" /></div>
				</div>
				<div style="diplay:table-row;">
					<div style="width: 300px; diplay:table-cell;">Password:</div>
					<div style="diplay:table-cell;"><input type="password" name="login" id="login" /></div>
				</div>
			</div>
			<div style="overflow: hidden; float: center; ">
				<input type="submit" value="Entrar" />
			</div>
			
		</form>
		<a href="adm/login/LoginForm.jsp">Subscribe to this application!</a>
	</div>
</body>
</html>