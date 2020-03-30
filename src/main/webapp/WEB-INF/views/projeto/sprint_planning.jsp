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
		<div class="row  align-items-center py-3">
			<h3 class="col-4  my-3">Sprint Planning - ${projeto.nome}</h3>
			<div class="ml-auto col-5">
				<div class="d-flex justify-content-end  align-items-center">
					<div class="mr-auto">
						<strong>Sprint Atual: </strong>	
						<p class="m-0 text-center">${projeto.sprintAtual}</p>
					</div>
					
					<div class="">
						<strong>Status: </strong>
						<p class="m-0">${projeto.status.toUpperCase()}</p>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-9 form-group">
				
				<div>Product Backlog</div>
				<table class="table table-hover table-sm">
					<thead>
						<tr>
							<th>#</th>
							<th>Use Case</th>
							<th>Ator</th>
							<th>Prioridade</th>
							<th>Status</th>
							<th>Requisitos</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="uc" items="${projeto.sprints.get(0).usecases}" varStatus="loop">
							<tr>
								<td>${projeto.sprints.get(0).indexOf(uc)}</td>
								<td>${uc.usecase}</td>
								<td>${uc.ator}</td>
								<td>${uc.prioridade}</td>
								<td>${uc.status}</td>
								<td>
									<a href='<c:url value="/req/${uc.id}" context="/"></c:url>' class="btn btn-secondary btn-sm">abrir</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>			
	</section>	

		
	<c:import url="../templates/footer.jsp"></c:import>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>