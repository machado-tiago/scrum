<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> 
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/css/estilo1.css" context="/"/>" > 
	
	<title>Scrum App</title>
</head>
<body style="height: 100vh;" class="d-flex flex-column m-0 p-0 ">
	<div class="d-flex h-100">
		<div class="row w-100 align-items-center m-0 p-0">
	      <div class="col-12 col-lg-7 m-0 p-0">
	      	<div class="d-flex justify-content-center">
				<img class="img-fluid" alt="Scrum App" src="/img/metodo-scrum.jpg">
	      	</div>
	      </div>
	      
        <div class="col m-0 p-0">
        	<div class="row justify-content-center m-0 p-0">
	        	<div class="card col-8 col-lg-6">
			          <div class="card-body">
			            <h4 class="card-title text-center">Entrar</h4>
			            <form class="form-signin">
			              <div class="form-group">
			                <label for="inputEmail">Email</label>
			                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
			              </div>
			              
			              <div class="form-group">
			                <label for="inputPassword">Senha</label>
			                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			              </div>
			              
						  <br>
			              <a class="btn btn-md btn-primary btn-block text-uppercase" href="<c:url value="/home" context="/" />" >Entrar</a>
			              <hr class="my-4">
			              <button class="btn btn-md btn-secondary btn-block text-uppercase" type="submit">Registrar</button>
			            </form>
			        </div>
	      		</div>
        	</div>
	    </div>
    </div>
	</div>
  	<jsp:include page="templates/footer.jsp" />
  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>