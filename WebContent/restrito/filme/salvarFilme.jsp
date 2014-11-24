<%@page import="java.util.ArrayList"%>
<%@page import="sun.misc.BASE64Decoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Filme"%>
<%@page import="model.Genero"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
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
<link href="css/plugins/fileinput.css" rel="stylesheet">
<link href="css/plugins/font.min.css" rel="stylesheet" type="text/css">
<link href="css/plugins/bootstrap-multiselect.css" rel="stylesheet" type="text/css">
<link href="css/plugins/bootstrap-formhelpers.min.css" rel="stylesheet"
	type="text/css">

</head>

<body>
	<%
		java.util.Date now = new java.util.Date();
		Funcionario usuario = (Funcionario) session.getAttribute("usuarioRestrito");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		@SuppressWarnings("unchecked")
		List<Genero> todosGeneros = (List<Genero>) request.getAttribute("todosGeneros");
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
						<li><a href="filmes" class="active"><i
								class="fa fa-video-camera fa-fw"></i> Filmes<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="filmes">Exibi&ccedil;&atilde;o</a></li>
								<li><a href="filmes">Lan&ccedil;amento</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="generos"><i class="fa fa-certificate fa-fw"></i>
								G&ecirc;neros</a></li>
						<li><a href=""><i class="fa fa-film fa-fw"></i>
								Sess&otilde;es</a></li>
						<li><a href=""><i class="fa fa-institution fa-fw"></i>
								Salas</a></li>
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
				<h1 class="page-header">
					<%
						String mensagem = (String) request.getAttribute("mensagem");

						String id 		   = "";
						String titulo      = "";
						String diretor	   = "";
						String duracao 	   = "";
						String faixaEtaria = "";
						String tipo		   = "";
						String status	   = "";
						String sinopse	   = "";
						boolean legenda    = false;
						String trailer     = "";
						String imagem 	   = "";
						byte[] bytImg 	   = null;						
						List<Genero> generosCadastrados = null;
						String re = "required";
						
						if (request.getAttribute("filme") != null){
							Filme f = (Filme) request.getAttribute("filme");
							
							id			 = String.valueOf(f.getId());
							titulo		 = f.getTitulo();
							diretor		 = f.getDiretor();
							duracao		 = f.getDuracaoFormatada();
							faixaEtaria  = f.getFaixaEtaria();
							tipo 		 = f.getTipo();
							status 		 = f.getStatus();
							legenda 	 = f.isLegendado();
							sinopse		 = f.getSinopse();
							generosCadastrados = f.getGeneros();
							trailer 	 = f.getTrailer();
							bytImg = f.getImagem();
							imagem = Base64.encode(bytImg);
							re = "";
						}
						
						if(generosCadastrados==null){
							generosCadastrados = new ArrayList<Genero>();
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
				<form role="form" action="salvarFilme" method="post" enctype="multipart/form-data">
					<div class="panel-body">
						<!--  ID -->
						<input type="hidden" name="id" value="<%=id%>">
						<!-- /ID -->
						
						<div class="row">
						<!-- Imagem -->
							<div class="col-md-4 form-group" align="center">
								<strong>Imagem</strong>
								<div class="form-group">
									<img src=<%= (imagem == "" ||imagem==null ? "img/semimg.jpg":"data:image/jpg;base64,"+imagem) %> 
									id="prev-img" style='width:180px;height:220px;' class='img-thumbnail'>
									<br/><br/>
									<div class="fileUpload btn btn-primary btn-file">
									<i class="glyphicon glyphicon-folder-open"></i>&nbsp;&nbsp;Selecionar
									<input type="file" name="imagem" accept=".jpg,.jpeg" <%=re %> id="file-input"/> 
									</div>

								</div>
							</div>
						<!-- /Imagem -->
						
						<!-- Titulo -->
							<div class="col-md-8 form-group">
								<br /> <label>T&iacute;tulo</label> <input type="text"
									name="titulo" value="<%=titulo%>"  class="form-control" placeholder="T&iacute;tulo"
									autofocus required>
							</div>
						<!-- /Titulo -->

						<!-- Diretor -->
							<div class="col-md-8 form-group">
								<label>Diretor</label> <input type="text" name="diretor"
									class="form-control"  value="<%=diretor%>"  placeholder="Diretor" required>
							</div>
						<!-- /Diretor -->	
						
						<div class="col-md-8 row">
						<!--  Duracao -->
								<div class="form-group col-md-6">
									<label>Dura&ccedil;&atilde;o</label>

									<div class="input-group">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-time"></span></span> <input
											class="form-control" type="text" style="width: 100px;"
											required="required" placeholder="HH:MM" maxlength="5"
											name="duracao"  value="<%=duracao %>" pattern="[0-9]{2}:[0-9]{2}$"
											onkeyup="
											var v = this.value;
											if (v.match(/^\d{2}$/) !== null) {
												this.value = v + ':';
											}" />

									</div>
								</div>
						<!-- /Duracao -->

						<!--  Faixa Etaria -->
								<div class="form-group col-md-6">
									<label>Faixa Et&aacute;ria</label> 
									<select class="form-control"
										name="faixaEtaria" style="width: 100px;" required="required" >
										<%
											out.print(
												"<option value='Livre' "+(faixaEtaria.equals("Livre") ? "selected" : "")+">Livre</option>"+
												"<option value='12 Anos' "+(faixaEtaria.equals("12 Anos") ? "selected" : "")+">12 Anos</option>" +
												"<option value='14 Anos' " +(faixaEtaria.equals("14 Anos")? "selected" : "")+">14 Anos</option>" +
												"<option value='16 Anos' "+(faixaEtaria.equals("16 Anos") ? "selected" : "")+">16 Anos</option>" +
												"<option value='18 Anos' "+(faixaEtaria.equals("18 Anos") ? "selected" : "")+">18 Anos</option>");
										%>
										
									</select>
								</div>
							</div>
						<!--  /Faixa Etaria -->
						
						<div class="col-md-8 row">
						<!--  Tipo -->
								<div class="form-group col-md-6">
									<label>Tipo &nbsp;</label> 
									
									<%
											out.print("<label class='radio-inline'>" +
													"<input type='radio' name='tipo' required='required' id='2D' value='2D'"+(tipo.equals("2D") ? "checked" : "")+" >2D"+
													"</label>");
											out.print("<label class='radio-inline'> <input type='radio'"+
													"name='tipo' required='required' id='3D' value='3D' "+(tipo.equals("3D") ? "checked": "")+">3D"+
													"</label>");
									%>
									 
								</div>
							<!--  /Tipo -->
							
							<!--  Legenda -->
								<div class="form-group col-md-6">
									<%
										out.print("<label><input type='checkbox' name='legenda'"+
												"value='legendado'" +(legenda == true ? "checked" : "")+"> Legendado"+
													"</label>");
									%>
									
								</div>
							<!--  /Legenda -->
						</div>
							
						<div class="col-md-8 row">	
							<!--  Status -->
							<div class="col-md-6 form-group">
								<label>Status &nbsp;</label>
								
								<%
									out.print("<label class='radio-inline'>");
									out.print("<input type='radio' name='status' required='required'  id='Lançamento' value='Lançamento'"+(status.equals("Lançamento")?"checked":"")+" >Lan&ccedil;amento");
									out.print("</label>");
									out.print("<label class='radio-inline'>");
									out.print("<input type='radio' name='status' required='required id='Exibição' value='Exibição'"+(status.equals("Exibição")?"checked":"")+">Exibi&ccedil;&atilde;o");
									out.print("</label>");
								%>
							</div>
							<!-- /Status -->
							
							<!-- Generos -->
							 <div class="col-md-6 form-group">

								<i class="fa fa-certificate fa-fw"></i><strong>Gêneros</strong>
								<br/>
								<select id="listaGeneros" multiple="multiple" name="listaGeneros" class="form-control" style="overflow: scroll;">
									<%for(Genero genero : todosGeneros){
										out.print("<option value='"+genero.getId()+"'"+(generosCadastrados.contains(genero)?"selected":"")+">"+genero.getDescricao()+"</option>");
										} %>
								</select>
							  </div>
							<!-- /Generos -->
					  </div>
							
						<!-- Trailer -->
							<div class="col-xs-12 form-group">
								<br /> <label>Trailer</label> <input type="url"
									name="trailer" value="<%=trailer%>"  class="form-control" placeholder="Cole aqui a URL do video">
							</div>
						<!-- /Trailer -->

							
						<!-- Sinopse -->
						<div class="col-xs-12 form-group">
							<label>Sinopse</label>
							<textarea class="form-control" name="sinopse" required="required" rows="5" required><%=sinopse %></textarea>
						</div>
						<!-- /Sinopse -->
					</div>

					<div align="center">
						<button type="submit" class="btn btn-success">
							<i class="glyphicon glyphicon-ok"></i> Gravar
						</button>
						<a href="filmes" class="btn btn-warning"> <i
							class="fa fa-undo fa-fw"></i>Voltar
						</a>
					</div>
					</div>
				</form>
			</div>
		</div>
	</div>



	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/plugins/metisMenu.min.js"></script>
	<script src="js/menuRestrito.js"></script>
	<script src="js/plugins/bootstrap-formhelpers.min.js"></script>
	<script src="js/plugins/bootstrap-multiselect.js"></script>

	<!-- Imagem -->
	<script type="text/javascript">
	function pegarImagem(input){
		var img = document.getElementById('prev-img');
		var fileInput = document.getElementById('file-input');

        var fileUrl = window.URL.createObjectURL(fileInput.files[0]);
        img.src = fileUrl;
	}
	
	$("#file-input").change(function(){
	    pegarImagem(this);
	});
	
	</script>
	<!-- /Imagem -->

	<!-- Generos -->
	<script type="text/javascript">
    $(document).ready(function() {
        $('#listaGeneros').multiselect({
        	includeSelectAllOption: true
        });
    });
	</script>
	<!-- /Generos -->

</body>

</html>

