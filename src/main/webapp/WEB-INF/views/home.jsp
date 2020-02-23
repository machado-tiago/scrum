<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Scrum App</title>
</head>
<body>
	<h2>Scrum App</h2>
	<span>${mensagemForm}</span>
	<br>
	<a href="<c:url value="/projeto/form" context="/" />"> Novo
		Projeto</a>
</body>
</html>