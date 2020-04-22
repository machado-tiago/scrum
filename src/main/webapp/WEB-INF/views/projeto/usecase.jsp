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
			<h3 class="col-6  my-3">Use Case</h3>
			<button class="btn btn-outline-danger mr-3 ml-auto" data-toggle="modal" data-target="#uc_exclude-modal" type="button">Excluir</button>
		</div>
		<form action="<c:url value="/usecase/merge/${projeto.id}/${usecase.id}" context="/" />" method="post" name="addusecase">

	             <div class="form-group">
	               <label for="usecase">Caso de Uso</label>
	               <input value="${usecase.usecase}" type="text" name="usecase" id="usecase" class="form-control" required>
	             </div>

	             <div class="form-group">
	               <label for="ator">Ator</label>
	               <input value="${usecase.ator}" type="text" name="ator" id="ator" class="form-control" required>
	             </div>
	
	          	<div class="form-group">
	                <label for="userstory">Descrição</label>
	                <textarea rows="7" name="userstory" id="userstory" class="form-control" required>${usecase.userstory}</textarea>
	             </div>
	             
         	     <div class="form-group">
	                <label for="fluxoAlternativo">Fluxo Alternativo</label>
	                <textarea rows="4" name="fluxoAlternativo" id="fluxoAlternativo" class="form-control">${usecase.fluxoAlternativo}</textarea>
	             </div>
	             
	             <div class="form-group">
	               <label for="prioridade">Prioridade</label>
	               <select name="prioridade" id="prioridade" class="form-control">
	               	<option selected="selected" hidden="true"> ${usecase.prioridade} </option>
	               	<option>Baixa</option>
	               	<option>Média</option>
	               	<option>Alta</option>
	               	<option>Muito Alta</option>
	               </select>
	             </div>
	             
				
				<!-- SALVAR NO RESUMO	              -->
	              <div class="form-group">
	               <label for="usecasestatus">Status</label>
	               <select name="usecasestatus" id="stausecasestatus" class="form-control">
	               	<option selected="selected" hidden="true"> ${usecase.getUseCaseStatus().ordinal()+1} - ${usecase.useCaseStatus.descricao} </option>
	               	<c:forEach var="item" items="${usecasestatus}" varStatus="loop" >
	               		<option value="${item}"> ${loop.count} - ${item.descricao}</option>
	               	</c:forEach>
	               </select>
	             </div>
	             
			  <br>
		      <div class="modal-footer">
		        <a href="<c:url value="/projeto/planning/${projeto.id}" context="/" />" type="button" class="btn btn-secondary">Voltar</a>
		        <button type="submit" class="btn btn-primary">Salvar</button>
		      </div>
           </form>
	</section>	

		
	<c:import url="../templates/footer.jsp"></c:import>
	
	<div class="modal" id="uc_exclude-modal" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header alert alert-danger">
	        <h5 class="modal-title ">Confirmar Exclusão!</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <div class="card-body">
	            <form method="post" action="<c:url context="/" value="/usecase/del/${projeto.id}/${usecase.id}" /> ">
	            	<div class="form-group">
		                <p>Tem certeza que deseja excluir o registro?
		                Essa ação não poderá ser desfeita.</p>
	              </div>
	              
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-danger">Excluir</button>
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