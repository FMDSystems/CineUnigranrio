<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Sala"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Cinema Unigranrio">
<meta name="author" content="FMD Systems">

<title>Cine Unigranrio - &Aacute;rea Restrita</title>

<link href="css/style.css" rel="stylesheet">

<link href="css/plugins/metisMenu.min.css" rel="stylesheet">

<link href="css/menurestrito.css" rel="stylesheet">

<link href="css/plugins/font.min.css" rel="stylesheet" type="text/css">


</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		Funcionario usuario = (Funcionario) session
				.getAttribute("usuarioRestrito");
		java.util.Date now = new java.util.Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	%>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="centralControle"><img
					src="img/logo_nome.png" width="220px"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li><a><i class="fa fa-calendar fa-fw"></i><%=formato.format(now)%></a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<%=usuario.getPessoa().getNome()%> &nbsp;<i
						class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> Alterar
								Dados</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Ajustes</a>
						</li>
						<li class="divider"></li>
						<li><a href="encerrarAcessoRestrito" style="color: red;"><i
								class="fa fa-sign-out fa-fw"></i> Encerrar Sessão</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control"
									placeholder="Pesquisar..."> <span
									class="input-group-btn"> </span><span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="centralControle"><i
								class="fa fa-dashboard fa-fw"></i> Central de Controle</a></li>
						<li><a href="filmes"><i class="fa fa-video-camera fa-fw"></i>
								Filmes<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="filmesExibicao">Exibi&ccedil;&atilde;o</a></li>
								<li><a href="filmesLacamentos">Lan&ccedil;amento</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="generos"><i class="fa fa-certificate fa-fw"></i>
								G&ecirc;neros</a></li>
						<li><a href=""><i class="fa fa-film fa-fw"></i>
								Sess&otilde;es</a></li>
						<li><a href="salas" class="active"><i
								class="fa fa-institution fa-fw"></i> Salas</a></li>
						<li><a href="funcionarios"><i class="fa fa-group fa-fw"></i>
								Funcion&aacute;rios</a></li>
						<li><a href="cargos"><i class="fa fa-sitemap fa-fw"></i>
								Cargos</a></li>
						<li><a href="#"><i class="fa fa-files-o fa-fw"></i>
								Relat&oacute;rios<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="">Clientes</a></li>
								<li><a href="#">Sess&otilde;es<span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li><a href="#">Mais Vistos</a></li>
										<li><a href="#">Menos Vistos</a></li>
									</ul> <!-- /.nav-third-level --></li>
							</ul> <!-- /.nav-second-level --></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<i class="fa fa-institution fa-fw"></i>Salvar Sala
					</h1>
				</div>
				<%
					String mensagem = (String) request.getAttribute("mensagem");

					int numero = 0;
					int capacidade = 0;
					String id = "";
					char fila = 0;
					int coluna = 0;

					if (request.getAttribute("sala") != null) {
						Sala s = (Sala) request.getAttribute("sala");

						numero = s.getNumero();
						id = String.valueOf(s.getId());
						
					}

					if (mensagem != null) {
						out.print("<div class='alert alert-danger' role='alert'>");
						out.print("<a class='close' data-dismiss='alert' href=''#''>x</a>");
						out.print(mensagem);
						out.print("</div>");
					}
				%>
				<form action="salvarSala" method="post">
					<div class="form-group">
						<br />

						<!--  ID -->
						<input type="hidden" name="id" value="<%=id%>">
						<!-- /ID -->

						<div class="col-lg-12" style="margin-bottom: 10px;">

								<div class="col-xs-6">
									<!--  Número -->
									<label>Número</label> <input type="text" name="numero"
										class="form-control" value="<%=(numero == 0 ? "" : numero)%>"
										placeholder="Número da Sala" autofocus required="required">

									<!-- /Numero -->
								</div>
							
							<br/>
							<i class="fa fa-delicious fa-fw"></i>Lugares
							<div class="row">
								<div class="col-xs-6">
									<!--  Fila -->
									<label>Filas</label>
									<input type="text" name="fila" class="form-control" value="<%=(fila == 0 ? "" : fila)%>"
										placeholder="Quantidade de Filas" required="required">

									<!-- /Fila -->
								</div>

								<div class="col-xs-6">
									<!--  Coluna -->
									<label>Coluna</label> <input type="text"
										name="coluna" class="form-control"
										value="<%=(coluna == 0 ? "" : coluna)%>"
										placeholder="Quantidade de Colunas" required="required">
									<!-- /Coluna -->
								</div>
							</div>

						</div>

					</div>
					<div class="form-group" style="margin-top: 10px;" align="center">
						<button type="submit" class="btn btn-success">
							<i class="glyphicon glyphicon-ok"></i> Gravar
						</button>
						<a href="salas" class="btn btn-warning"> <i
							class="fa fa-undo fa-fw"></i>Voltar
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<script src="js/jquery.min.js"></script>

	<script src="js/script.js"></script>

	<script src="js/plugins/metisMenu.min.js"></script>

	<script src="js/menuRestrito.js"></script>
</body>

</html>

