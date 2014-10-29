<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Filme"%>
<%@page import="model.Genero"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date;"%>
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
<link href="css/datepicker.css" rel="stylesheet">
<link href="css/plugins/fileinput.css" rel="stylesheet">
<link href="css/plugins/font.min.css" rel="stylesheet" type="text/css">
<link href="css/plugins/bootstrap-formhelpers.min.css" rel="stylesheet"
	type="text/css">

</head>

<body>
	<%
		java.util.Date now = new java.util.Date();
		Funcionario usuario = (Funcionario) session
		.getAttribute("usuarioRestrito");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Set<Genero> generosCadastrados = (Set<Genero>) request.getAttribute("generosCadastrados");
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
						<%=usuario.getNome()%>&nbsp;<i class="fa fa-caret-down"></i>
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
				<h1 class="page-header">
					<%
						String mensagem = (String) request.getAttribute("mensagem");
						request.setAttribute("todosGeneros", generosCadastrados);

						String titulo      = "";
						String diretor	   = "";
						Date   duracao 	   = null;
						String faixaEtaria = "";
						String tipo		   = "";
						String status	   = "";
						boolean legenda    = false;
						
						if (request.getAttribute("filme") != null){
							Filme f = (Filme) request.getAttribute("fime");
							
							titulo		 = f.getTitulo();
							diretor		 = f.getDiretor();
							duracao		 = f.getDuracao();
							faixaEtaria  = f.getFaixaEtaria();
							tipo 		 = f.getTipo();
							status 		 = f.getStatus();
							legenda 	 = f.isLegendado();
							
						}
						
						
						if (mensagem != null) {
							out.print("<div class='alert alert-danger' role='alert'>");
							out.print("<a class='close' data-dismiss='alert' href=''#''>x</a>");
							out.print(mensagem);
							out.print("</div>");
						}
						
						
					%>
					<i class="fa fa-video-camera fa-fw"></i>Salvar Filme
				</h1>
				<form role="form" action="salvarFilme" method="post"
					enctype="multipart/form-data">
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-6 col-md-4 form-group" align="center">
								<strong>Imagem</strong>
								<div class="form-group">
									<input id="file-3" type="file" name="imagem">
								</div>
							</div>
							<div class=" col-xs-12 col-sm-6 col-md-8 form-group">
								<br /> <label>T&iacute;tulo</label> <input type="text"
									name="titulo" value="<%=titulo%>"  class="form-control" placeholder="T&iacute;tulo"
									autofocus required>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-8 form-group">
								<label>Diretor</label> <input type="text" name="diretor"
									class="form-control"  value="<%=diretor%>"  placeholder="Diretor" required>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-8 row">
								<div class="form-group col-xs-7">
									<label>Dura&ccedil;&atilde;o</label>

									<div class="input-group">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-time"></span></span> <input
											class="form-control" type="text" style="width: 100px;"
											required="required" placeholder="HH:MM" maxlength="5"
											name="duracao"  value="<% String duracaoS = duracao == null ? "" : duracao.getHours() + ":" +duracao.getMinutes(); out.print(duracaoS); %>" pattern="[0-9]{2}:[0-9]{2}$"
											onkeyup="
											var v = this.value;
											if (v.match(/^\d{2}$/) !== null) {
												this.value = v + ':';
											}" />

									</div>
								</div>


								<div class="form-group col-xs-5">
									<label>Faixa Et&aacute;ria</label> 
									<select class="form-control"
										name="faixaEtaria" style="width: 100px;">
										<%
											out.print(
												"<option"+(faixaEtaria == "Livre" ? "selected" : "")+">Livre</option>"+
												"<option"+(faixaEtaria == "12 Anos" ? "selected" : "")+">12 Anos</option>" +
												"<option"+(faixaEtaria == "14 Anos" ? "selected" : "")+">14 Anos</option>" +
												"<option"+(faixaEtaria == "16 Anos" ? "selected" : "")+">16 Anos</option>" +
												"<option"+(faixaEtaria == "18 Anos" ? "selected" : "")+">18 Anos</option>");
										%>
										
									</select>
								</div>
							</div>

							<div class="col-xs-12 col-sm-6 col-md-8 form-group">
								<div class="form-group col-xs-7">
									<label>Tipo &nbsp;</label> 
									
									<%
											out.print("<label class='radio-inline'>" +
													"<input type='radio' name='tipo' id='2D' value='2D'"+(tipo == "2D" ? "checked" : "")+">2D"+
													"</label>");
											out.print("<label class='radio-inline'> <input type='radio'"+
													"name='tipo' id='3D' value='3D' "+(tipo =="3D" ? "checked": "")+">3D"+
													"</label>");
									%>
									 
								</div>
								<div class="form-group col-xs-5">
									 
									<%
										if(legenda){
											out.print("<label><input type='checkbox' name='legenda'"+
													"value='legendado' checked> Legendado"+
													"</label>");
										}else{
											out.print("<label><input type='checkbox' name='legenda'"+
													"value='legendado'> Legendado"+
													"</label>");
										}
									%>
									
								</div>
							</div>

							<div class="col-xs-12 col-sm-6 col-md-8 form-group">
								<label>Status</label> &nbsp;&nbsp;
								
								<%
								%>
								<label class="radio-inline">
									<input type="radio" name="status" id="lancamento"
									value="Lançamento" checked>Lan&ccedil;amento
								</label><label class="radio-inline"> <input type="radio"
									name="status" id="exibicao" value="Exibição">Exibi&ccedil;&atilde;o
								</label>
							</div>
						</div>
						<div id="demoform">
							<select multiple="multiple" size="3" style="overflow: scroll;"
								name="listaGeneros">
								<%for(Genero genero : generosCadastrados){
									out.print("<option value='"+genero.getDescricao()+"'>"+genero.getDescricao()+"</option>");
									} %>
							</select><br />
						</div>

						<!-- Sinopse -->
						<div class="form-group">
							<label>Sinopse</label>
							<textarea class="form-control" name="sinopse" rows="4" required></textarea>
						</div>
					</div>

					<div align="center">
						<button type="submit" class="btn btn-success">
							<i class="glyphicon glyphicon-ok"></i> Gravar
						</button>
						<a href="filmes" class="btn btn-warning"> <i
							class="fa fa-undo fa-fw"></i>Voltar
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>



	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/plugins/metisMenu.min.js"></script>
	<script src="js/menuRestrito.js"></script>
	<script src="js/plugins/jquery.bootstrap-duallistbox.js"></script>
	<script src="js/plugins/bootstrap-formhelpers.min.js"></script>
	<script src="js/plugins/fileinput.js"></script>

	<script type="text/javascript">
		$("#file-3")
				.fileinput(
						{
							initialPreview : [ "<img src='img/semimg.svg' class='file-preview-image' alt='Sem Imagem' title='Sem Imagem'>" ],
							overwriteInitial : true,
							maxFileSize : 2048,
							showUpload : false,
							showCaption : false,
							browseClass : "btn btn-primary",
							fileType : "image.*",
							allowedFileExtensions : [ "jpg", "jpeg", "png" ],
							showRemove : false,
							msgSizeTooLarge : "Limite máximo atingido. Máximo permitido é de <b>{maxSize} KB</b>",
							msgLoading : "Carregando",
							msgProgress : "Carregando",
							previewSettings : {
								image : {
									width : "134px",
									height : "180px"
								}
							}
						});
	</script>


	<script type="text/javascript">
		var demo1 = $('select[name="listaGeneros"]')
				.bootstrapDualListbox(
						{
							filterTextClear : 'Limpar',
							infoTextEmpty : '',
							infoText : '{0}',
							filterPlaceHolder : 'Filtro',
							selectedListLabel : 'Selecionados',
							nonSelectedListLabel : 'Gêneros',
							infoTextFiltered : '<span class="label label-warning">Filtrado</span> {0} de {1}'
						});

		$('select[name="listaGeneros"]').bootstrapDualListbox('refresh', true);
	</script>

</body>

</html>

