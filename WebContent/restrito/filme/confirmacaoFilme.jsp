<%@page import="java.io.OutputStream"%>
<%@page
	import="com.sun.xml.internal.messaging.saaj.util.ByteOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Filme"%>
<%@page import="model.Genero"%>
<%@page import="org.apache.catalina.util.*"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Cinema Unigranrio">
<meta name="author" content="FMD Systems">

<title>Cine Unigranrio - &Aacute;rea Restrita</title>

<link href="css/style.css" rel="stylesheet">
<link href="css/plugins/metismenu.min.css" rel="stylesheet">
<link href="css/menurestrito.css" rel="stylesheet">
<link href="css/plugins/font.min.css" rel="stylesheet" type="text/css">

</head>

<body>
	<%
		java.util.Date now = new java.util.Date();
			Funcionario usuario = (Funcionario) session
			.getAttribute("usuarioRestrito");
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
						<%=usuario.getPessoa().getNome()%>&nbsp;<i
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
									class="input-group-btn"></span> <span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="centralControle"><i
								class="fa fa-dashboard fa-fw"></i> Central de Controle</a></li>
						<li><a href="filmes" class="active"><i
								class="fa fa-video-camera fa-fw"></i> Filmes<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="">Exibi&ccedil;&atilde;o</a></li>
								<li><a href="">Lan&ccedil;amento</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="generos"><i class="fa fa-certificate fa-fw"></i>
								G&ecirc;neros</a></li>
						<li><a href=""><i class="fa fa-film fa-fw"></i>
								Sess&otilde;es</a></li>
						<li><a href=""><i class="fa fa-institution fa-fw"></i>
								Salas</a></li>
						<li><a href="#"><i class="fa fa-group fa-fw"></i>
								Funcion&aacute;rios</a></li>
						<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
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
				<%
					String mensagem = (String) request.getAttribute("mensagem");

							if (mensagem != null) {
								out.print("<br/><div class='alert alert-success' role='alert'>");
								out.print("<a class='close' data-dismiss='alert' href=''#''>x</a>");
								out.print(mensagem);
								out.print("</div>");
							}

							Filme filme = (Filme) request.getAttribute("filme");
							Long id = filme.getId();
							
							String imagem = Base64.encode(filme.getImagem());
				%>
				<h1 class="page-header">
					<i class="fa fa-file-video-o fa-fw"></i><%=filme.getTitulo()%>
				</h1>
				<div class="panel-body">

					<div class="row">
						<div class="col-xs-6 col-md-4 form-group" align="center">
							<div class="form-group">
								<img style="width: 180px; height: 220px;"
									src=<%= (imagem == "" ||imagem==null ? "img/semimg.jpg":"data:image/jpg;base64,"+imagem) %>
									 class="img-thumbnail">
							</div>
						</div>
						<div class=" col-xs-12 col-sm-6 col-md-8 form-group">
							<strong>Sinopse</strong><br />
							<%=filme.getSinopse()%></div>
						<div class="col-xs-12 col-sm-6 col-md-8 form-group">
							<strong>Diretor</strong> &nbsp;
							<%=filme.getDiretor()%>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8 form-group">
							<strong>Dura&ccedil;&atilde;o</strong> &nbsp;
							<%=filme.getDuracaoFormatada()%>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8 form-group">
							<strong>Generos</strong> &nbsp;
							<%
								for (Genero genero : filme.getGeneros()) {
														out.print(genero.getDescricao() + ". ");
													}
							%>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8 form-group">
							<strong>Faixa Et&aacute;ria</strong> &nbsp;
							<%=filme.getFaixaEtaria()%>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8 form-group">
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
						<div class="col-xs-12 col-sm-6 col-md-8 form-group">
							<strong>Status</strong> &nbsp;
							<%=filme.getStatus()%>
						</div>
					</div>
				</div>
			</div>

			<div align="center">
				<!-- Cadastrar Novo -->
				<a href="cadastrarFilme" class="btn btn-success"> <i
					class="glyphicon glyphicon-plus"></i> Novo Filme
				</a>

				<!-- Alterar -->
				<a href="alterarFilme?id=<%=id%>" class="btn btn-info"> <i
					class="glyphicon glyphicon-edit"></i> Alterar Filme
				</a>

				<!-- Excluir -->
				<a href="excluirFilme" data-id="<%=id%>" class="btn btn-danger confirm-delete">
					<i class="glyphicon glyphicon-remove"></i> Excluir Filme
				</a>


				<!-- Voltar -->
				<a href="filmes" class="btn btn-warning"> <i
					class="fa fa-undo fa-fw"></i>Filmes
				</a>
			</div>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">Excluir Filme</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir o filme
						selecionado?</div>
					<div class="modal-footer">
						<a class="btn btn-warning" data-dismiss="modal"><i
							class="fa fa-undo fa-fw"></i>Cancelar</a> <a id="btn-excluir"
							class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i>Excluir
							Filme</a>
						<form action="#" method="get" name="excluir">
							<input type="hidden" name="id" id="txtExcluir">
						</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/plugins/metisMenu.min.js"></script>
	<script src="js/menuRestrito.js"></script>

	<script type="text/javascript">
		$('.confirm-delete').on('click', function(e) {
			e.preventDefault();

			var id = $(this).data('id');
			$('#myModal').data('id', id).modal('show');
		});

		$('#btn-excluir').click(function() {
			var id = $('#myModal').data('id');

			document.getElementById("txtExcluir").value = id;
			document.forms['excluir'].action = "excluirFilme?id='" + id + "'";
			document.forms['excluir'].submit();

		});
	</script>

</body>

</html>

