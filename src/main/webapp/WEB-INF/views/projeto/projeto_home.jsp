<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="h-100"> 
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


<title>Scrum App</title>
</head>
<body class="d-flex flex-column h-100 m-0 p-0 ">
	<c:import url="../templates/nav.jsp"></c:import>
		
	
	<section class="container">
			<c:if test = "${not empty mensagemForm}">
				<div class="alert alert-warning container-fluid" role="alert"> <!-- ajustar para exibir a mensagem --> 
					${mensagemForm}
				</div>
			</c:if>
			<h3 class="py-3 my-3">Projeto</h3>
			
			<form method="post" name="addprojeto" action="<c:url value="/projeto/add" context="/"/>" 
				class="form-vertical  js-form-loading">
				 
				<div class="form-group">
					<label for="nome">Nome*</label>
					<input id="nome" name="nome" type="text" class="form-control" required/>
				</div>
		
				<div class="form-group">
					<label for="objetivo">Objetivos*</label>
					<textarea id="objetivo" name ="objetivo" rows="5" class="form-control" required></textarea>
				</div>

				<div class="d-flex">
					<div class="flex-fill mr-1">
						<label for="colaboradores">Equipe</label>
						<select multiple class="form-control" id="colaboradores" name="colaboradores">
							<c:forEach var="colaborador" items="${listaColab}" >
								<option value="${colaborador.id}">${colaborador.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group flex-fill ml-1">
						<label for="orcamento">Orçamento</label>
						<input id="orcamento" name="orcamento" type="text" class="form-control" placeholder="R$"/>
					</div>
				</div>		
				
		
			</form>
		</section>
			
		<c:import url="../templates/footer.jsp"></c:import>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>