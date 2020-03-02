<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Home - Scrum App</title>
</head>
<body>
	
	<div class="container">
		<c:if test = "${not empty mensagemForm}">
			<div class="alert alert-info" role="alert">
				${mensagemForm}
			</div>
		</c:if>
		<div class="d-flex justify-content-between m-3">
			<h3>Projetos em Andamento</h3>
			<a class="btn btn-primary" href="<c:url value="/projeto/form" context="/" />"> Novo	Projeto</a>
		</div>
		<table class="table table-hover table-sm">
			<thead>
				<tr>
					<th>#</th>
					<th>Projeto</th>
					<th>Status</th>
					<th>Product Owner</th>
					<th>Scrum Master</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="projeto" items="${projetos}" varStatus="loop">
					<tr><!-- colocar um link em cada linha -->
						<td>${loop.count}</td>
						<td>${projeto.nome}</td>
						<td>${projeto.status}</td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>

	<jsp:include page="templates/footer.jsp"></jsp:include>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>