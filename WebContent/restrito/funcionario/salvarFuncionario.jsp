<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.annotations.Check"%>
<%@page import="javax.persistence.UniqueConstraint"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Cargo"%>
<%@page import="model.Pessoa"%>
<%@page import="java.util.List"%>
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
		List<Cargo> todosCargos = (List<Cargo>) request.getAttribute("cargos");
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
						<li><a href="generos"><i
								class="fa fa-certificate fa-fw"></i> G&ecirc;neros</a></li>
						<li><a href=""><i class="fa fa-film fa-fw"></i>
								Sess&otilde;es</a></li>
						<li><a href=""><i class="fa fa-institution fa-fw"></i>
								Salas</a></li>
						<li><a href="funcionarios" class="active"><i class="fa fa-group fa-fw"></i>
								Funcion&aacute;rios</a></li>
						<li><a href="cargos" ><i class="fa fa-sitemap fa-fw"></i>
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
				<%
						String mensagem = (String) request.getAttribute("mensagem");

						Pessoa p1 = null;
						Cargo cargo = null;
						String nome = "";
						String cpf = "";
						String email = "";
						String id = "";
						String re = "required";
						
						if(todosCargos == null || todosCargos.isEmpty()){
							todosCargos = new ArrayList<Cargo>();
						}
						
						if (request.getAttribute("funcionario") != null){
							Funcionario f = (Funcionario) request.getAttribute("funcionario");
							p1 = f.getPessoa();
							nome = p1.getNome();
							cpf = p1.getCpf();
							email = p1.getEmail();
							cargo = f.getCargo();
							re = "";
							id = String.valueOf(f.getMatricula());
						}
						
						if (mensagem != null) {
							out.print("<div class='alert alert-danger' role='alert'>");
							out.print("<a class='close' data-dismiss='alert' href=''#''>x</a>");
							out.print(mensagem);
							out.print("</div>");
						}
					%>
					<h1 class="page-header">
						<i class="fa fa-group fa-fw"></i>Salvar Funcionário
					</h1>
				</div>
					</div>
				<form action="salvarFuncionario" method="post">
					<div class="row form-group col-md-12" >
					
						<!--  ID -->
						<input type="hidden" name="id" value="<%=id%>">
						<!-- /ID -->
						
						<div class="row col-md-12">
						<!-- CPF -->
						<div class="col-md-4" style="margin-bottom: 10px;">
							<label>CPF</label>
							<div class="input-group ">
								<input type="text" class="form-control"	placeholder="CPF" name="cpf" value="<%=cpf%>"
								onkeypress="javascript: mascara(this, cpf_mask);" autofocus required maxlength="14"> 
								<span class="input-group-btn"> </span><span class="input-group-btn">
									<a class="btn btn-primary" type="button" title="Buscar CPF">
										<i class="fa fa-search"></i>
									</a>
								</span>
							</div>
						</div>
						<!-- /CPF -->
						
						<!-- Cargo -->
						<div class="col-md-7" style="margin-bottom: 10px;">
							<label><i class="fa fa-sitemap fa-fw"></i><strong>Cargo</strong></label>
							<% 
							if(cargo == null){
								cargo = new Cargo();
							}
							out.print("<select name='cargos' class='form-control' style='width:200px;'>");
							for(Cargo c : todosCargos){
								out.print("<option value='"+c.getID()+"' "+(cargo.equals(c)?"selected":"") +">"+c.getNome()+"</option>");
							}
							out.print("</select>");
							%>
						</div>
						<!-- /Cargo -->
						</div>
						
						
						<!-- Nome -->
						<div class="col-md-12 form-group" style="margin-bottom: 10px;">											
							<label>Nome</label>
							<input type="text" name="nome" value="<%=nome %>" placeholder="Nome" class="form-control" required> 
						</div>
						<!-- /Nome -->
						
						<!-- Email -->
						<div class="col-md-12 form-group" style="margin-bottom: 10px;">											
							<label>Email</label>
							<input type="email" name="email" value="<%=email %>" placeholder="Email" class="form-control" required> 
						</div>
						<!-- /Email -->
						
						<div class="row col-md-12">
						<!-- Senha -->
						<div class="col-md-4 form-group" style="margin-bottom: 10px;">											
							<label>Senha</label>
							<input type="password" name="senha" placeholder="Senha" class="form-control" <%=re%>> 
						</div>
						<!-- /Senha -->
						
						</div>
					 <br/>
					<div class="col-md-10 form-group" style="margin-top: 10px;" align="center">
						<button type="submit" class="btn btn-success">
							<i class="glyphicon glyphicon-ok"></i> Gravar
						</button>
						<a href="funcionarios" class="btn btn-warning"> <i
							class="fa fa-undo fa-fw"></i>Voltar
						</a>
					</div>
					</div>
				</form>
		</div>
	</div>
	<!-- /#wrapper -->

	<script src="js/jquery.min.js"></script>

	<script src="js/script.js"></script>

	<script src="js/plugins/metisMenu.min.js"></script>

	<script src="js/menuRestrito.js"></script>
</body>

</html>

