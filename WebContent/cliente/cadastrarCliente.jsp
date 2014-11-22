<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.Date"%>
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
							<li><a href="#">Sessões</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Filmes <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="exibirfilmesexibicao">Em Exibição</a></li>
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



		<div id="loginbox"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">Cadastro</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						Todos os campos são <strong>Obrigat&oacute;rios</strong>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>
					<form id="loginform" class="form-horizontal" role="form" method="post" action="salvarCliente">
						<%
							String mensagem = (String) request.getAttribute("mensagem");

							String nome = "";
							String cpf = "";
							String email = "";
							String data = "";
							
							if(request.getAttribute("cliente") != null){
								Cliente cliente = (Cliente) request.getAttribute("cliente");
								nome = cliente.getPessoa().getNome();
								cpf = cliente.getPessoa().getCpf();
								data = cliente.getDataFormatada();
								email = cliente.getPessoa().getEmail();
							}
							
							if (mensagem != null) {
								out.print("<div class='alert alert-danger' role='alert'>");
								out.print("<a class='close' data-dismiss='alert' href=''#''>x</a>");
								out.print(mensagem);
								out.print("</div>");
							}
						%>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-certificate"></i></span> <input
								id="login-username" type="text" class="form-control" name="cpf"
								value="<%=cpf %>" placeholder="CPF" onkeypress="javascript: mascara(this, cpf_mask);" autofocus required maxlength="14">
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="nome" value="<%=nome %>"
								placeholder="Nome Completo" required>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<div class='input-group date' id='datetimepicker5'>
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span></span> <input type='text'
									class="form-control" name="data" data-date-format="dd/mm/yyyy"
									placeholder="dd/mm/aaaa" required value="<%=data %>"
									onkeyup="
											var v = this.value;
											if (v.match(/^\d{2}$/) !== null) {
												this.value = v + '/';
											} else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
												this.value = v + '/';
											}"
									maxlength="10">
							</div>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input
								id="login-username" type="email" class="form-control"
								name="email" value="<%=email %>" placeholder="E-mail" required>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="senha"
								placeholder="Senha" required>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<div class="checkbox">
								<label><input type="checkbox" value=""> Desejo
									receber informações por email. </label>
							</div>
						</div>

						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->
							<div class="col-sm-12 controls">
								<button type="submit" class="btn btn-success btn-block">Cadastrar</button>

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Já tenho uma conta! <a href="acessoCliente"> Acesse Aqui </a>
								</div>
							</div>
						</div>
					</form>
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
					Systems</a> &amp; <a href="http://www.twitter.com/mxxxrcos" target="blank">M.Boscolo</a>
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
