<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
		 <nav class="navbar fixed-top justify-content-center bg-info border-bottom border-secondary">
			<ul class=" nav justify-content-center">
			  <li class="nav-item py-3 px-3">
			    <a class="nav-link btn btn-outline-warning px-4" href="<c:url value="/home" context="/" />">Home</a>
			  </li>
			  <li class="nav-item py-3 px-3">
			    <a class="nav-link btn btn-outline-warning px-4" href="#">Meus Projetos</a>
			  </li>
			  <li class="nav-item py-3 px-3">
			    <a class="nav-link btn btn-outline-warning px-4" href="#">Projetos em Andamento</a>
			  </li>
			  <li class="nav-item py-3 px-3">
			    <a class="nav-link btn btn-outline-warning px-4" href="#">Projetos Encerrados</a>
			  </li>
			  <li class="nav-item py-3 px-3">
			    <a class="nav-link btn btn-outline-warning px-4" href="<c:url value="/projeto/form" context="/" />" >Novo Projeto</a>
			  </li>
			</ul>
		</nav>
		<div class="navbar m-5"></div>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>