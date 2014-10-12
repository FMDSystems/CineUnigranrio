<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Cliente"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Cinema Unigranrio">
<meta name="author" content="FMD Systems">
<link rel="icon" href="img/favicon.ico">

<title>Cine Unigranrio - O melhor cinema na melhor faculdade</title>

<link href="css/style.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/datepicker.css" rel="stylesheet">

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
							<li><a href="#">Sess�es</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Filmes <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">Em Exibi��o</a></li>
									<li><a href="#">Em Breve</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-right" role="search"
							style="margin-right: 5px;">
							<div class="form-group">
								<input class="form-control glyphicon" type="search"
									placeholder="&#57347; Pesquisar" />
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
		<!-- Fim da barra -->
		<%
			Cliente cliente = null;
			String nome = null;
			String email = null;
			if (request.getAttribute("cliente") != null) {
				cliente = (Cliente) request.getAttribute("cliente");
				nome = cliente.getNome();
				email = cliente.getEmail();
			} else {
				nome = "";
				email = "";
			}
		%>

		<div class="alert alert-success" align="center">
			<span class="glyphicon glyphicon-ok"></span> &nbsp;<strong>Parab&eacute;ns,
				<%=nome%> !
			</strong> Suas informa&ccedil;&otilde;es foram cadastradas com sucesso!<br />
			Voc&ecirc; receber&aacute; um e-mail em <i><%=email%></i> confirmando
			seu cadastro e suas informa&ccedil;&otilde;es.
			<p></p>
		</div>
		<div class="" align="center">
			Ir para o in&iacute;cio do site j&aacute; <strong>Autenticado.</strong>
			<form action="/cineunigranrio" method="post">
				<%
					HttpSession sessao = request.getSession(true);
					sessao.setAttribute("usuario", cliente);
				%>
				<button type="submit" class="btn btn-primary">Autenticado</button>
			</form>

			Ir para o in&iacute;cio do site <strong>Sem
				Autentica&ccedil;&atilde;o.</strong>
			<form action="/cineunigranrio" method="post">
				<button type="submit" class="btn btn-warning">Sem
					Autentica&ccedil;&atilde;o</button>
			</form>
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

	<!-- Colocado no final do documento para caregar a pagina mais rapido -->
	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-datepicker.pt-BR.js"></script>
	<script type="text/javascript">
		$('#datetimepicker5').datepicker({
			format : "dd/mm/yyyy",
			todayBtn : true,
			language : "pt-BR",
			autoclose : true,
			todayHighlight : true
		});
	</script>
</body>
</html>
