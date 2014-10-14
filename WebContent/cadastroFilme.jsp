<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="model.Funcionario"%>
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
		Funcionario usuario = (Funcionario) session.getAttribute("usuario");
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
						<%=usuario.getNome()%> &nbsp;<i class="fa fa-caret-down"></i>
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
									class="input-group-btn"> <span class="input-group-btn">
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
								<li><a href="">Exibi&ccedil;&atilde;o</a></li>
								<li><a href="">Lan&ccedil;amento</a></li>
							</ul> <!-- /.nav-second-level --></li>
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
				<div class="col-lg-12">
					<h1 class="page-header">
						<i class="fa fa-video-camera fa-fw"></i>Cadastro de Filme
					</h1>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<form role="form">
									<div class="form-group">
										<label>T&iacute;tulo</label> <input class="form-control"
											placeholder="T&iacute;tulo">
									</div>
									<div class="form-group">
										<label>Dura&ccedil;&atilde;o</label>
										<div class='input-group date' id='datetimepicker5'>
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-time"></span></span> <input type='text'
												class="form-control" name="data" data-date-format="HH:MM:SS"
												placeholder="HH:MM:SS" required maxlength="8">
										</div>
									</div>
									<div class="form-group">
										<label>Diretor</label> <input class="form-control"
											placeholder="Diretor">
									</div>
									<div class="form-group">
										<label>Faixa Et&aacute;ria</label> <select
											class="form-control">
											<option>Livre</option>
											<option>12</option>
											<option>14</option>
											<option>16</option>
											<option>18</option>
										</select>
									</div>
									<div class="form-group">
										<label>Tipo &nbsp;&nbsp;&nbsp;&nbsp;</label> <label
											class="radio-inline"> <input type="radio" name="tipo"
											id="2D" value="2D" checked>2D
										</label> <label class="radio-inline"> <input type="radio"
											name="tipo" id="3D" value="3D">3D
										</label> <label class="checkbox-inline" style="margin-left: 40px;">
											<input type="checkbox">Legendado
										</label>
									</div>
									<div class="form-group">
										<label>Status</label> &nbsp;&nbsp;<label class="radio-inline">
											<input type="radio" name="status" id="lancamento"
											value="lancamento" checked>Lan&ccedil;amento
										</label><label class="radio-inline"> <input type="radio"
											name="status" id="exibicao" value="exibicao">Exibi&ccedil;&atilde;o
										</label>
									</div>

									<div class="form-group">
										<label>Sinopse</label>
										<textarea class="form-control" rows="3"></textarea>
									</div>

									<div class="form-group">
										<form id="demoform" action="#" method="post">
											<select multiple="multiple" size="10"
												name="duallistbox_demo1[]">
												<option value="option1">Option 1</option>
												<option value="option2">Option 2</option>
												<option value="option3" selected="selected">Option
													3</option>
												<option value="option4">Option 4</option>
												<option value="option5">Option 5</option>
												<option value="option6" selected="selected">Option
													6</option>
												<option value="option7">Option 7</option>
												<option value="option8">Option 8</option>
												<option value="option9">Option 9</option>
												<option value="option0">Option 10</option>
											</select> <br>
										</form>
										<script>
											var demo1 = $(
													'select[name="duallistbox_demo1[]"]')
													.bootstrapDualListbox();
											$("#demoform")
													.submit(
															function() {
																alert($(
																		'[name="duallistbox_demo1[]"]')
																		.val());
																return false;
															});
										</script>
									</div>


									<div class="form-group">
										<label>Static Control</label>
										<p class="form-control-static">email@example.com</p>
									</div>
									<div class="form-group">
										<label>File input</label> <input type="file">
									</div>
									<div class="form-group">
										<label>Text area</label>
										<textarea class="form-control" rows="3"></textarea>
									</div>
									<div class="form-group">
										<label>Checkboxes</label>
										<div class="checkbox">
											<label> <input type="checkbox" value="">Checkbox
												1
											</label>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox" value="">Checkbox
												2
											</label>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox" value="">Checkbox
												3
											</label>
										</div>
									</div>
									<div class="form-group">
										<label>Inline Checkboxes</label> <label
											class="checkbox-inline"> <input type="checkbox">1
										</label> <label class="checkbox-inline"> <input
											type="checkbox">2
										</label> <label class="checkbox-inline"> <input
											type="checkbox">3
										</label>
									</div>
									<div class="form-group">
										<label>Radio Buttons</label>
										<div class="radio">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios1" value="option1" checked>Radio 1
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios2" value="option2">Radio 2
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios3" value="option3">Radio 3
											</label>
										</div>
									</div>
									<div class="form-group">
										<label>Inline Radio Buttons</label> <label
											class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" id="optionsRadiosInline1"
											value="option1" checked>1
										</label> <label class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" id="optionsRadiosInline2"
											value="option2">2
										</label> <label class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" id="optionsRadiosInline3"
											value="option3">3
										</label>
									</div>
									<div class="form-group">
										<label>Selects</label> <select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select>
									</div>
									<div class="form-group">
										<label>Multiple Selects</label> <select multiple
											class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select>
									</div>
									<button type="submit" class="btn btn-default">Submit
										Button</button>
									<button type="reset" class="btn btn-default">Reset
										Button</button>
								</form>
							</div>
							<!-- /.col-lg-6 (nested) -->
							<div class="col-lg-6">
								<h1>Disabled Form States</h1>
								<form role="form">
									<fieldset disabled>
										<div class="form-group">
											<label for="disabledSelect">Disabled input</label> <input
												class="form-control" id="disabledInput" type="text"
												placeholder="Disabled input" disabled>
										</div>
										<div class="form-group">
											<label for="disabledSelect">Disabled select menu</label> <select
												id="disabledSelect" class="form-control">
												<option>Disabled select</option>
											</select>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox">Disabled
												Checkbox
											</label>
										</div>
										<button type="submit" class="btn btn-primary">Disabled
											Button</button>
									</fieldset>
								</form>
								<h1>Form Validation States</h1>
								<form role="form">
									<div class="form-group has-success">
										<label class="control-label" for="inputSuccess">Input
											with success</label> <input type="text" class="form-control"
											id="inputSuccess">
									</div>
									<div class="form-group has-warning">
										<label class="control-label" for="inputWarning">Input
											with warning</label> <input type="text" class="form-control"
											id="inputWarning">
									</div>
									<div class="form-group has-error">
										<label class="control-label" for="inputError">Input
											with error</label> <input type="text" class="form-control"
											id="inputError">
									</div>
								</form>
								<h1>Input Groups</h1>
								<form role="form">
									<div class="form-group input-group">
										<span class="input-group-addon">@</span> <input type="text"
											class="form-control" placeholder="Username">
									</div>
									<div class="form-group input-group">
										<input type="text" class="form-control"> <span
											class="input-group-addon">.00</span>
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon"><i class="fa fa-eur"></i>
										</span> <input type="text" class="form-control"
											placeholder="Font Awesome Icon">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">$</span> <input type="text"
											class="form-control"> <span class="input-group-addon">.00</span>
									</div>
									<div class="form-group input-group">
										<input type="text" class="form-control"> <span
											class="input-group-btn">
											<button class="btn btn-default" type="button">
												<i class="fa fa-search"></i>
											</button>
										</span>
									</div>
								</form>
							</div>
							<!-- /.col-lg-6 (nested) -->
						</div>
						<!-- /.row (nested) -->
					</div>


				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<script src="js/jquery.min.js"></script>
	
	<script src="js/plugins/jquery.min.js"></script>

	<script src="js/script.js"></script>

	<script src="js/plugins/metisMenu.min.js"></script>

	<script src="js/menuRestrito.js"></script>
	
	<script src="js/plugins/jquery.bootstrap-duallistbox.js"></script>
	
	<script src="js/plugins/duallist.js"></script>

</body>

</html>

