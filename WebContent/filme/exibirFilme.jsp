<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Cliente"%>
<%@page import="model.Filme"%>
<%@page import="model.Genero"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.catalina.util.*"%>

<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Cinema Unigranrio">
<meta name="author" content="FMD Systems">
<link rel="icon" href="img/favicon.ico">

<title>Cine Unigranrio - O melhor cinema na melhor faculdade</title>

<link href="css/plugins/metismenu.min.css" rel="stylesheet">
<link href="css/menurestrito.css" rel="stylesheet">
<link href="css/plugins/font.min.css" rel="stylesheet" type="text/css">

<link href="css/style.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="header">
				<a class="nameproject" href="/cineunigranrio"><img
					src="img/logo.png" width="200px"></a>
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="/cineunigranrio">Home</a></li>
							<li><a href="#">Sessões</a></li>
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown">Filmes <b
									class="caret active"></b></a>
								<ul class="dropdown-menu">
									<li><a href="exibirfilmesexibicao">Em Exibição</a></li>
									<li><a href="#">Em Breve</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input class="form-control glyphicon" type="search"
									placeholder="&#57347; Pesquisar" />
							</div>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<%
								Cliente usuario = null;

								if ((session == null) || (session.getAttribute("usuario") == null)) {
							%>
							<li><a href="cadastrarCliente">Cadastrar</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Acessar <b class="caret"></b></a>
								<ul class="dropdown-menu"
									style="padding: 15px; min-width: 250px;">
									<li>
										<div class="row">
											<div class="col-md-12">
												<form class="form" role="form" method="post"
													action="autenticarAcessoCliente" accept-charset="UTF-8"
													id="login-nav">
													<div class="form-group">
														<input type="email" class="form-control" name="email"
															placeholder="Email" required>
													</div>
													<div class="form-group">
														<input type="password" class="form-control" name="senha"
															placeholder="Senha" required>
													</div>
													<div class="form-group">
														<button type="submit" class="btn btn-primary btn-block">Confirmar</button>
													</div>
												</form>
											</div>
										</div>
									</li>
									<!-- 									 Em breve inclusão de cadastro com redes sociais -->
									<!-- 																		<li class="divider"></li> -->
									<!-- 																		<li><input class="btn btn-primary btn-block" type="button" -->
									<!-- 																			id="sign-in-google" value="Sign In with Google"> <input -->
									<!-- 																			class="btn btn-primary btn-block" type="button" -->
									<!-- 																			id="sign-in-twitter" value="Sign In with Twitter"></li> -->
								</ul></li>

							<%
								} else {
									usuario = (Cliente) session.getAttribute("usuario");
							%>
							<li class="dropdown"><a href="" class="dropdown-toggle"
								data-toggle="dropdown"> <%=usuario.getPessoa().getNome()%> <span
									class="glyphicon glyphicon-cog"></span>
							</a>
								<ul class="dropdown-menu" role="menu"
									style="padding: 15px; min-width: 250px;">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#"><span class="glyphicon glyphicon-tags"></span>
											&nbsp;Meus Ingressos</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#"><span class="glyphicon glyphicon-list-alt"></span>
											&nbsp;Alterar Informações </a></li>
									<li role="presentation" class="divider"></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="encerrarAcessoCliente" style="color: red;"> <span
											class="glyphicon glyphicon-off"></span> &nbsp;Encerrar Sessão
									</a></li>
								</ul></li>

							<%
								}
							%>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
		<!-- Fim da barra -->
		<%
			Filme filme = (Filme) request.getAttribute("filme");
			String imagem = Base64.encode(filme.getImagem());
		%>

		<h1 class="page-header">
			<i class="fa fa-file-video-o fa-fw"></i>Em Exibi&ccedil;&atilde;o:
			<%=filme.getTitulo()%>
		</h1>
		<div class="panel-body">

			<div class="row">
				<div class="col-md-4 form-group" align="center">
					<strong>Imagem</strong>
					<div class="form-group">
						<img style="width: 280px; height: 400px;"
							src=<%=(imagem == "" || imagem == null ? "img/semimg.jpg"
					: "data:image/jpg;base64," + imagem)%>
							class="img-thumbnail" name="imgC">
					</div>
				</div>

				<div class="col-md-8 form-group">
					<strong>Trailer</strong>
					<div class="embed-responsive embed-responsive-16by9">
						<iframe class="embed-responsive-item form-control"
							src="<%=filme.getTrailer()%>"></iframe>
					</div>
				</div>
			</div>

			<div class=" col-xs-12 form-group">
				<strong>Sinopse</strong><br />
				<%=filme.getSinopse()%>
			</div>
			<div class="col-xs-12 form-group">
				<strong>Diretor</strong> &nbsp;
				<%=filme.getDiretor()%>
			</div>
			<div class="col-xs-12 form-group">
				<strong>Dura&ccedil;&atilde;o</strong> &nbsp;
				<%=filme.getDuracaoFormatada()%>
			</div>
			<div class="col-xs-12 form-group">
				<strong>Generos</strong> &nbsp;
				<%
					for (Genero genero : filme.getGeneros()) {
						out.print(genero.getDescricao() + ". ");
					}
				%>
			</div>
			<div class="col-xs-12 form-group">
				<strong>Faixa Et&aacute;ria</strong> &nbsp;
				<%=filme.getFaixaEtaria()%>
			</div>
			<div class="col-xs-12 form-group">
				<strong>Tipo</strong> &nbsp;
				<%=filme.getTipo()%>
				&nbsp;&nbsp;&nbsp;&nbsp; <strong> <%
				 	if (filme.isLegendado())
				 		out.print("Legendado");
				 	else
				 		out.print("Dublado");
				 %>
				</strong>
			</div>
			<div class="col-xs-12 form-group">
				<strong>Status</strong> &nbsp;
				<%=filme.getStatus()%>
			</div>
		</div>
	</div>


	</div>
	<!-- /container -->
	<hr>
	<div class="footer">
		<div class="container">
			<div class="col-4 col-sm-4 col-lg-4">
				<h2>Social Media</h2>
				<div class="socialmedia">
					<a href="http://fb.com/" target="_blank"><img
						src="img/socialmedia/facebook.png" width="48px"></a> <a
						href="http://twitter.com/" target="_blank"><img
						src="img/socialmedia/twitter.png" width="48px"></a> <a
						href="http://instagram.com/" target="_blank"><img
						src="img/socialmedia/instagram.png" width="48px"></a> <a
						href="http://youtube.com/" target="_blank"><img
						src="img/socialmedia/youtube.png" width="48px"></a>
				</div>
			</div>
			<div class="col-3 col-sm-4 col-lg-4">
				<h2>Mapa do Site</h2>

				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</div>
			<div class="col-3 col-sm-4 col-lg-4">
				<h2>Contato</h2>
				<div align="left" style="float: left;">
					Rua Prof. Jos&eacute; de Souza Herdy, 1.160<br /> 25 de Agosto -
					Duque de Caxias<br /> Rio de Janeiro. CEP 25071-202<br />
					Telefone: (21) 3219-4040<br /> E-mail:
					contato@cineunigranrio.com.br
				</div>
			</div>
		</div>
	</div>

	<hr>
	<div class="footer">
		<div class="container">
			<p class="text-muted" style="float: left;">&copy; Cine Unigranrio
				2014</p>
			<p class="text-muted" align="right">
				by <a href="http://www.fmdsystems.com.br/" target="_blank">FMD
					Systems</a> &amp; <a href="http://www.twitter.com/mxxxrcos"
					target="blank">M.Boscolo</a>
			</p>
		</div>
	</div>

	<!-- Colocado no final do documento para caregar a pÃ¡gina mais rÃ¡pido -->
	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>
