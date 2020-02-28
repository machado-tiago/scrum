<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html  style="min-height: 100%;"> 
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/css/estilo1.css" context="/"/>" > 
	
	<title>Scrum App</title>
</head>
<body>
<div class="d-flex p-0 my-5">
 <div>
    <div class="row my-5 justify-content-around">
      <div class="col">
		<img class="img-fluid" alt="Scrum App" src="/img/metodo-scrum.jpg">
      </div>
      <div class="col-3">
        <div class="card card-signin flex-row">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h4 class="card-title text-center">Registrar</h4>
            <form class="form-signin">
              <div class="form-group">
                <label for="inputUserame">Usuário</label>
                <input type="text" id="inputUserame" class="form-control" placeholder="Username" required autofocus>
              </div>

              <div class="form-group">
                <label for="inputEmail">Email</label>
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
              </div>
              
              <hr>

              <div class="form-group">
                <label for="inputPassword">Senha</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
              </div>
              
              <div class="form-group">
                <label for="inputConfirmPassword">Confirmar senha</label>
                <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
              </div>
              
              <br>

              <button class="btn btn-md btn-primary btn-block text-uppercase" type="submit">Registrar</button>
              <a class="d-block text-center mt-2 small" href="<c:url value="/home" context="/" />" >Entrar</a>
              <hr class="my-4">
              <button class="btn btn-md btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Entrar com Google</button>
              <button class="btn btn-md btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Entrar com Facebook</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  	<jsp:include page="templates/footer.jsp" />
  	<!--
  	<c:import url="templates/footer.jsp" />
  	-->
  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>