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
		</div>
		<form action="<c:url value="/usecase/merge/${projeto.id}/${usecase.id}" context="/" />" method="post" name="addusecase">
	             <div class="form-group">
	               <label for="ator">Ator</label>
	               <input value="${usecase.ator}" type="text" name="ator" id="ator" class="form-control" placeholder="ator" required>
	             </div>
	
	          	<div class="form-group">
	                <label for="usecase">Use Case</label>
	                <textarea rows="7" name="usecase" id="usecase" class="form-control" placeholder="descreva aqui o caso de uso" required>${usecase.usecase}</textarea>
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
	             
	              <div class="form-group">
	               <label for="status">Status</label>
	               <select name="status" id="status" class="form-control">
	               	<option selected="selected" hidden="true"> ${usecase.status} </option>
	               	<option>Planejamento</option>
	               	<option>Execução</option>
	               	<option>Concluído</option>
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
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>