<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
		<nav class="navbar  fixed-top  navbar-default  js-sticky-reference"	id="main-navbar">
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

						<li class="aw-menu__item  is-expanded">
						<a href="#">
							<i class="fa  fa-fw  fa-file-text"></i>
							<span>Páginas comuns</span>
							<i class="aw-menu__navigation-icon  fa"></i>
						</a>

							<ul class="aw-menu__list  aw-menu__list--sublist">
								<li class="aw-menu__item  aw-menu__item--link">
									<a href="pagina-vazia.html">Página vazia</a>
								</li>
								<li class="aw-menu__item  aw-menu__item--link">
									<a href="login.html">Login</a>
								</li>
								<li class="aw-menu__item  aw-menu__item--link">
									<a href="esqueceu-a-senha.html">Esqueceu a senha</a>
								</li>
								<li class="aw-menu__item  aw-menu__item--link">
									<a	href="403.html">403</a>
								</li>
								<li class="aw-menu__item  aw-menu__item--link">
									<a href="404.html">404</a>
								</li>
								<li class="aw-menu__item  aw-menu__item--link">
									<a	href="500.html">500</a>
								</li>
							</ul>
						</li>

					</ul>
				</nav>
			
			</div>
		</aside>
</body>
</html>