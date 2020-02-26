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
	<div class="aw-layout-page">
		<nav
			class="navbar  navbar-fixed-top  navbar-default  js-sticky-reference"
			id="main-navbar">
			<div class="container-fluid">

				<div class="navbar-header">
					<a class="navbar-brand  hidden-xs" href="#"> <img
						alt="Scrum App" src="/layout/images/scrum-logo.png" />
					</a>

					<ul class="nav  navbar-nav">
						<li><a href="#" class="js-sidebar-toggle"> <i
								class="fa  fa-bars"></i>
						</a></li>
					</ul>
				</div>

				<ul class="nav navbar-nav  navbar-right">
					<li><a href="#"><em class="fa  fa-sign-out"></em></a></li>
				</ul>

			</div>
		</nav>

		<aside class="aw-layout-sidebar  js-sidebar">
			<div class="aw-layout-sidebar__content">

				<nav class="aw-menu  js-menu">
					<ul class="aw-menu__list">

						<li class="aw-menu__item">
							<a href="dashboard.html"><i class="fa  fa-fw  fa-home"></i><span>Dashboard</span></a>
						</li>

						<li class="aw-menu__item  is-active">
							<a href="#"><i class="fa  fa-fw  fa-file-text"></i>
								<span>Cadastros</span><i class="aw-menu__navigation-icon  fa"></i>
							</a>

							<ul class="aw-menu__list  aw-menu__list--sublist">
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="cadastro-produto.html">Cadastro de produto</a></li>
								<li class="aw-menu__item  aw-menu__item--link  is-active"><a
									href="pesquisa-produtos.html">Pesquisa de produtos</a></li>
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="tabela-sem-dados.html">Tabela sem dados</a></li>
							</ul>
						</li>

						<li class="aw-menu__item  is-expanded"><a href="#"> <i
								class="fa  fa-fw  fa-file-text"></i><span>Páginas comuns</span>
								<i class="aw-menu__navigation-icon  fa"></i>
						</a>

							<ul class="aw-menu__list  aw-menu__list--sublist">
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="pagina-vazia.html">Página vazia</a></li>
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="login.html">Login</a></li>
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="esqueceu-a-senha.html">Esqueceu a senha</a></li>
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="403.html">403</a></li>
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="404.html">404</a></li>
								<li class="aw-menu__item  aw-menu__item--link"><a
									href="500.html">500</a></li>
							</ul></li>

					</ul>
				</nav>
			
			</div>
		</aside>
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
			
			<footer class="aw-layout-footer  js-content">
				<div class="container-fluid">
					<span class="aw-footer-disclaimer">&copy; 2020 Tiago Machado - Todos os direitos reservados.</span>
				</div>
			</footer>
	</div>
	<script type="text/javascript" src="<c:url value="/javascripts/vendors.min.js" context="/" />" > </script>
	<script type="text/javascript" src="<c:url value="/javascripts/algaworks.min.js" context="/" />" ></script>
</body>
</html>