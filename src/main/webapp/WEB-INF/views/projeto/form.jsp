<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix= "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<title>Novo Projeto</title>
</head>
<body>
	<form name="addprojeto" action="<c:url value="/projeto/add" context="/"/>" method="post">
		<span>${mensagemForm}</span>
		<br>
		<input type="text" id="nome" name="nome" placeholder="Nome do Projeto">
		<input type="text" id="objetivo" name="objetivo" placeholder="Objetivo">
		<input type="submit" id="saveProject" name="saveProject" value="Salvar">
	</form>
</body>
</html>