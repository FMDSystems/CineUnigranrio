<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Filme"%>
<%@page import="model.Genero"%>
<%@page import="java.util.List"%>

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

<link href="css/plugins/metisMenu.min.css" rel="stylesheet">

<link href="css/menurestrito.css" rel="stylesheet">

<link href="css/plugins/font.min.css" rel="stylesheet" type="text/css">


</head>

<body>
	<%
		java.util.Date now = new java.util.Date();
		Funcionario usuario = (Funcionario) session.getAttribute("usuarioRestrito");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		@SuppressWarnings("unchecked")
		List<Filme> listaFilmes = (List<Filme>) request.getAttribute("listaFilmes");
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
						<%=usuario.getPessoa().getNome()%> &nbsp;<i class="fa fa-caret-down"></i>
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
						<li><a class="active" href="filmes"><i
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
						<i class="fa fa-video-camera fa-fw"></i>Filmes
					</h1>
				</div>
				<div class="row">
					<div class="col-xs-6" align="left" style="left:10px;">
						<%
							if(!listaFilmes.isEmpty()){
								out.print("Total de Filmes: " + listaFilmes.size());
							}
						%>
						
					</div>
					<div class="col-xs-6" align="right" style="margin-bottom: 10px; margin-top: -4px;">
						<a class="btn btn-success" href="cadastrarFilme"> <i
							class="fa fa-plus"></i> Novo Filme
						</a>
					</div>
				</div>
				<!-- /.col-lg-12 -->
				<table class="table table-hover">
					<thead>
					<tr>
						<th class="text-center">T&iacute;tulo</th>
						<th class="text-center"><strong>Dura&ccedil;&atilde;o</strong></th>
						<th class="text-center"><strong>Tipo</strong></th>
						<th class="text-center"><strong>G&ecirc;nero</strong></th>
						<th class="text-center"><strong>Status</strong></th>
						<th class="text-center"><strong>A&ccedil;&otilde;es</strong></th>
					</tr>
					</thead>
					
						<%
						if(listaFilmes.isEmpty()){
							out.print("<tr>");
							out.print("<td colspan='6' align='center'><strong> N&atilde;o h&aacute; filmes cadastrados! </strong></td>");
							out.print("</tr>");
						}else{
							for (Filme filme : listaFilmes) {
								Long id = filme.getId();
								out.print("<tr valign='bottom'>");
								out.print("<td align='center' style='vertical-align:middle;'>" + filme.getTitulo() + "</td>");
								out.print("<td align='center' style='vertical-align:middle;'>" + filme.getDuracaoFormatada()+ "</td>");
								out.print("<td align='center' style='vertical-align:middle;'>" + filme.getTipo() + "</td>");
								out.print("<td align='center' style='vertical-align:middle;'>");
								
								for (Genero genero : filme.getGeneros()) {
									out.print(genero.getDescricao() + ". ");
								}
								out.print("</td>");
								out.print("<td align='center' style='vertical-align:middle;'>" + filme.getStatus() + "</td>");
								
								out.print("<td align='left' width='10%'><div class='tooltip-demo row'>");
								
								//Alterar
								out.print("<div class='col-md-1' style='margin-bottom:5px;'>");
								out.print("<a href='alterarFilme?id="+id.longValue()+"' class='btn btn-xs btn-info' data-toggle='tooltip' data-placement='top' title='Alterar'><i class='fa fa-edit'></i></a>");
								out.print("</div>");
								
								//Detalhar
								out.print("<div class='col-md-1' style='margin-bottom:5px;'>");
								out.print("<a href='detalharFilme?id="+id.longValue()+"'class='btn btn-xs btn-warning' data-toggle='tooltip' data-placement='top' title='Detalhar'><i class='glyphicon glyphicon-list-alt'></i></a>");
								out.print("</div>");
								
								//Excluir
								out.print("<div class='col-md-1'>");
								out.print("<a class='btn btn-xs btn-danger confirm-delete' data-id="+id.longValue()+" data-toggle='tooltip' data-placement='top' title='Excluir'><i class='glyphicon glyphicon-trash'></i></a>");
								out.print("</div>");
								out.print("</div></td>");
								out.print("</tr>");
							}
						}
						%>
				</table>
			</div>
			<!-- /.row -->
			
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">Excluir Filme </h4>
					</div>
					<div class="modal-body">
					Deseja realmente excluir o filme selecionado?
					</div>
					<div class="modal-footer">
						<a class="btn btn-warning" data-dismiss="modal"><i class="fa fa-undo fa-fw"></i>Cancelar</a>
						<a id="btn-excluir" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i>Excluir Filme</a>
					<form action="#" method="get" name="excluir"><input type="hidden" name="id" id="txtExcluir"></form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
			
		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->

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
		document.forms['excluir'].action = "excluirFilme?id='"+id+"'";
		document.forms['excluir'].submit();  
		
	});
    </script>
		
	<script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
	
</body>

</html>

