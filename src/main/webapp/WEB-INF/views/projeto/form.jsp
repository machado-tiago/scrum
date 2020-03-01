<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/layout/stylesheets/vendors.min.css" context="/"/> ">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/layout/stylesheets/algaworks.min.css" context="/"/> ">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/layout/stylesheets/application.css" context="/" /> ">

<title>Scrum App</title>
</head>
<body>
	<c:import url="../templates/nav.jsp"></c:import>
		
		<section class="aw-layout-content  js-content">
			<div class="page-header">
				<div class="container-fluid">
					<h1>
						Cadastro de Projeto
					</h1>
				</div>
			</div>
		
			<div class="container-fluid">
			<!--
				<div class="alert  alert-danger  alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<i class="fa  fa-exclamation-circle"></i> Já existe um projeto com o nome informado.
				</div>
			-->	
				<form method="post" name="addprojeto" action="<c:url value="/projeto/add" context="/"/>" 
					class="form-vertical  js-form-loading">
					
					<span>${mensagemForm}</span> <br>
					 
					<div class="form-group">
						<label for="nome">Nome*</label>
						<input id="nome" name="nome" type="text" class="form-control"/>
					</div>
			
					<div class="form-group">
						<label for="objetivo">Objetivos*</label>
						<textarea id="objetivo" name ="objetivo" rows="5" class="form-control"></textarea>
					</div>
			
					<div class="form-group">
						<label for="orcamento">Orçamento</label>
						<input id="orcamento" name="orcamento" type="text" class="form-control" placeholder="R$"/>
					</div>
					
					<div class="form-group">
						<button class="btn  btn-primary" type="submit">Salvar</button>
						<a href="<c:url value="/" context="/" />" class="btn  btn-default">Cancelar</a>
					</div>
			
				</form>
				</div>
				
			</section>
			
	<c:import url="../templates/footer.jsp"></c:import>
	
	<script type="text/javascript" src="<c:url value="/javascripts/vendors.min.js" context="/" />" > </script>
	<script type="text/javascript" src="<c:url value="/javascripts/algaworks.min.js" context="/" />" ></script>
</body>
</html>