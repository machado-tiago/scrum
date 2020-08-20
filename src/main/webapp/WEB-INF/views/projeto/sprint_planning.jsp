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
		<link  type="text/css" rel="stylesheet" href="/css/sprints.css">
	
	<script type="text/javascript">
		var spclicked;	
		document.addEventListener('readystatechange', function sprintSelected() {
			if (document.readyState === "complete") {
				if (""!="${sprintSelectedId}"){
					spclicked= "${sprintSelectedId}";
				}else{
					spclicked = document.querySelector('.label-sprinthead').id;
			// 		spclicked = document.getElementsByClassName('label-sprinthead')[0].id;
				}
				ativarSprint();
			}	
		});
		
		function ativarSprint(){
				document.getElementById(spclicked).style.backgroundColor = "#107381";
				document.getElementById("a-sprint"+spclicked).click();
		}
		
		function sprintClicked(id){
			if (spclicked!=null) {
				document.getElementById(spclicked).style.backgroundColor = "#17a2b8";
			}
			spclicked = id;
			ativarSprint();
		}
		
		function sendUC(uc_id){
			document.getElementById("backlog"+uc_id).href = "/usecase/" + uc_id + "/tosprint/" + spclicked;
		}
		
		function calcFim(){
			document.getElementById("salvar"+spclicked).style="display: inline;";
			document.getElementById("iniciar"+spclicked).style="display: none;";
			document.getElementById("excluir"+spclicked).style="display: none;";
			try {
	 			var duracao =  parseInt(document.getElementById("duracao"+spclicked).value,10);
				var inicio = new Date(document.getElementById("inicio"+spclicked).value);
				var fim = new Date(inicio);
				fim.setDate(inicio.getDate()+duracao);
				document.getElementById("fim"+spclicked).value = fim.toISOString().substring(0,10);
			} catch (e) {
				console.log(e);
			}
		}
	</script>	

	<title>Scrum App</title>
</head>

<body class="d-flex flex-column h-100 m-0 p-0 ">
	<c:import url="../templates/nav.jsp"></c:import>

<section>
	<div class="container">
		<div class="row align-items-center py-3">
			<h3 class="col-6  my-3">Sprint Planning - ${projeto.nome}</h3>
			<div class="ml-auto col-6">
				<div class="d-flex justify-content-end  align-items-center">
					<div class="ml-auto">
						<strong >Sprint Atual: </strong>	
						<p class="m-0 text-center">${projeto.getSprintAtualIndex()}</p>
					</div>
					
					<div class="ml-5">
						<strong>Status Projeto: </strong>
						<p class="m-0">${projeto.projectStatus.descricao}</p>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row w-100 px-3">
			<div class="col-auto form-group">
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
								<th>Esforço (dias)</th>
								<th>Sprint</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="uc" items="${projeto.sprints.get(0).usecases}" varStatus="loop">
								<tr draggable="true">
									<td>
										<a id="ucopen" href='<c:url value="/usecase/open/${projeto.id}/${uc.id}" context="/"></c:url>' class="w-100 btn btn-secondary btn-sm">${loop.count}</a>
									</td>
									<td>${uc.usecase}</td>
									<td>${uc.prioridade}</td>
									<td>${uc.dias}</td>
									<td>
										<a id="backlog${uc.id}" onclick="sendUC(${uc.id})" href="#" class="py-1 px-2 badge badge-pill badge-info">Send ></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
			<div class="col-8 ml-auto p-0">
				<div>
					<span>Sprints</span>
					<a href='<c:url context="/" value="/${projeto.id}/sprint/add"> </c:url>' class="btn badge badge-pill badge-primary px-3 py-1 m-2">+Add</a>
				</div>
					<nav class="d-flex flex-wrap menu-botoes">
						<c:forEach var="sprint" items="${projeto.sprints}" varStatus="loop" begin="1" >
							<label id="${sprint.id}"  for="sprintradio${sprint.id}" onclick="sprintClicked(${sprint.id})" class="col-1 sprints label-sprinthead m-0 btn btn-sm btn-info">SPRINT ${loop.count}</label>
							<input class="sprinthead" id="sprintradio${sprint.id}" name="sprint" type="radio">
							<a class="a-sprint" id="a-sprint${sprint.id}" href="#sprint${sprint.id}"></a>
					     </c:forEach>
					</nav>
				<div id="quadro" class="h-100 border">
					<c:forEach var="sprint" items="${projeto.sprints}" varStatus="loop" begin="1" >
						<div class="sprints" id="sprint${sprint.id}" >
							<div class="input-group input-group-sm  align-items-left my-3 p-0">
								    <div class="input-group-prepend col-3 pl-0">
                                        <label class="input-group-text" for="sprintStatus">Status</label>
                                        <input id="duracao${sprint.id}" class="form-control form-control-sm" name="sprintStatus" type="text" value="${sprint.sprintStatus.descricao}" readonly>
                                    </div>
								  	<div class="input-group-prepend col-2">
										<label class="input-group-text " for="duracao">Dias</label>
										<input onchange="calcFim()" id="duracao${sprint.id}" class="form-control form-control-sm" name="duracao" type="number" min="1" step="1" value="${sprint.duracao}">
								  	</div>
								  	<div class="input-group-prepend col-3">
										<label class="input-group-text" for="inicio">Início</label>
										<input id="inicio${sprint.id}" onchange="calcFim()" class="form-control form-control-sm" name="inicio" type="date" value="${sprint.inicio}">
								  	</div>
								  	<div class="input-group-prepend col-3">
										<label class="input-group-text " for="fim">Fim</label>
										<input id="fim${sprint.id}" class="form-control form-control-sm" name="fim" readonly="readonly" type="date" value="${sprint.fim}">
								  	</div>
								  	<div class="ml-auto p-0 m-0 col-auto">
									  	<button id="salvar${sprint.id}" style="display: none;" class="btn btn-block btn-sm btn-primary m-0" type="button" >Salvar</button>
									  	<button id="iniciar${sprint.id}" style="display: none;" class="btn btn-block btn-sm btn-primary m-0" data-toggle="modal" data-target="#sp_exclude-modal" type="button">Iniciar</button>
										<button id="excluir${sprint.id}" class="btn btn-sm btn-block btn-outline-danger m-0"  data-toggle="modal" data-target="#sp_exclude-modal" type="button">Excluir</button>
								  	</div>
								</div>
			 					<table class="table table-hover table-sm">
									<thead>
										<tr>
											<th>#</th>
											<th>Use Case</th>
											<th>Prioridade</th>
											<th>Esforço (dias)</th>
											<th>Status</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
						      			<c:forEach var="casodeuso" items="${sprint.usecases}" varStatus="loop2">
											<tr draggable="true">
												<td>
													<a id="ucopen" href='<c:url value="/usecase/open/${projeto.id}/${casodeuso.id}" context="/"></c:url>' class="w-100 btn btn-secondary btn-sm">${loop2.count}</a>
												</td>
												<td>${casodeuso.usecase}</td>
												<td>${casodeuso.prioridade}</td>
												<td>${casodeuso.dias}</td>
												<td>${casodeuso.useCaseStatus.getDescricao()}</td>
												<td>
													<a id="uctobacklog" href='<c:url value="/usecase/tobacklog/${casodeuso.id}" context="/"></c:url>' class="h-50 btn btn-outline-danger btn-sm px-2">X</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
						 </div>	
			 		</c:forEach>
				</div>
			</div>	
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
			                <input type="text" name="usecase" id="usecase" class="form-control" placeholder="nome do caso de uso" required>
			              </div>
			             
			              <div class="form-group">
			                <label for="ator">Ator</label>
			                <input type="text" name="ator" id="ator" class="form-control" placeholder="ator" required>
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
		
		            	<div class="form-group">
				                <label for="userstory">User Story</label>
				                <textarea rows="7" name="userstory" id="userstory" class="form-control" placeholder="descreva aqui a história do usuário" required></textarea>
			              </div>
			              
			             <div class="form-group">
			                <label for="fluxoAlternativo">Fluxo Alternativo</label>
			                <textarea rows="4" name="fluxoAlternativo" id="fluxoAlternativo" class="form-control" placeholder="descreva o fluxo alternativo"></textarea>
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