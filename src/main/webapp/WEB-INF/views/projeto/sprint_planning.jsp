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
			<h3 class="col-6  my-3">Sprint Planning - ${projeto.nome}</h3>
			<div class="ml-auto col-6">
				<div class="d-flex justify-content-end  align-items-center">
					<div class="ml-auto">
						<strong >Sprint Atual: </strong>	
						<p class="m-0 text-center">${projeto.sprintAtual}</p>
					</div>
					
					<div class="ml-5">
						<strong>Status: </strong>
						<p class="m-0">${projeto.status.toUpperCase()}</p>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
				<div>
					<span>Product Backlog</span>
					<button data-toggle="modal" data-target="#usecase-modal" class="btn badge badge-pill badge-primary px-3 py-1 m-2">+Add</button>
					
				</div>
					<table class="table table-hover table-sm">
						<thead>
							<tr>
								<th>#</th>
								<th>Use Case</th>
								<th>Prioridade</th>
								<th>Status</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="uc" items="${projeto.getSprint(0).usecases}" varStatus="loop">
								<tr>
									<td>
										<a href='<c:url value="/usecase/open/${projeto.id}/${uc.id}" context="/"></c:url>' class="w-100 btn btn-secondary btn-sm">${loop.count}</a>
									</td>
									<td>${uc.usecase}</td>
									<td>${uc.prioridade}</td>
									<td>${uc.status}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		</div>			
	</section>	

		
	<c:import url="../templates/footer.jsp"></c:import>
	
	<div class="modal" id="usecase-modal" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">New Use Case</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <div class="card-body">
			            <form action="<c:url value="/usecase/add" context="/" />" method="post" name="addusecase">
							<input hidden="true" name="id" value="${projeto.id}"></input>


			              <div class="form-group">
			                <label for="usecase">Use Case</label>
			                <input type="text" name="usecase" id="usecase" class="form-control" placeholder="caso de uso" required>
			              </div>
			              
			              <div class="form-group">
			                <label for="ator">Ator</label>
			                <input type="text" name="ator" id="ator" class="form-control" placeholder="ator" required>
			              </div>
		
		            	<div class="form-group">
				                <label for="descricao">Descrição</label>
				                <textarea rows="7" name="descricao" id="descricao" class="form-control" placeholder="descreva aqui o caso de uso" required></textarea>
			              </div>
			              
			             <div class="form-group">
			                <label for="fluxoAlternativo">Fluxo Alternativo</label>
			                <textarea rows="4" name="fluxoAlternativo" id="fluxoAlternativo" class="form-control" placeholder="descreva o fluxo alternativo"></textarea>
			             </div>
			              
			              <div class="form-group">
			                <label for="prioridade">Prioridade</label>
			                <select name="prioridade" id="prioridade" class="form-control">
			                	<option selected="selected" hidden="true" value=""> -- selecione uma opção -- </option>
			                	<option>Baixa</option>
			                	<option>Média</option>
			                	<option>Alta</option>
			                	<option>Muito Alta</option>
			                </select>
			              </div>
						  <br>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					        <button type="submit" class="btn btn-primary">Salvar</button>
					      </div>
			            </form>
			        </div>
	      </div>
	    </div>
	  </div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>