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
<link href="css/flexslider.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="header">
				<a class="nameproject" href="/cineunigranrio"><img src="img/logo.png"
					width="200px"></a>
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
							<li class="active"><a href="/cineunigranrio">Home</a></li>
							<li><a href="#">Sessões</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Filmes <b class="caret"></b></a>
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
								HttpSession sessao = request.getSession(false);

								if ((sessao==null)||(sessao.getAttribute("usuario") == null)) {
							%>
							<li><a href="cadastrarCliente">Cadastrar</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Acessar <b class="caret"></b></a>
								<ul class="dropdown-menu"
									style="padding: 15px; min-width: 250px;">
									<li>
										<div class="row">
											<div class="col-md-12">
												<form class="form" role="form" method="post" action="autenticarAcessoCliente"
													accept-charset="UTF-8" id="login-nav">
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
									usuario = (Cliente) sessao.getAttribute("usuario");
							%>
							<li class="dropdown"><a href="" class="dropdown-toggle"
								data-toggle="dropdown"> <%=usuario.getNome()%> <span
									class="glyphicon glyphicon-cog"></span>
							</a>
								<ul class="dropdown-menu" role="menu"
									style="padding: 15px; min-width: 250px;">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#"><span
									class="glyphicon glyphicon-tags"></span> &nbsp;Meus Ingressos</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#"><span
									class="glyphicon glyphicon-list-alt"></span> &nbsp;Alterar Informações </a></li>
									<li role="presentation" class="divider"></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="encerrarAcessoCliente" style="color: red;"> <span
									class="glyphicon glyphicon-off"></span> &nbsp;Encerrar Sessão</a></li>
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

		<!-- Letreiro -->
		<div class="row">
			<div class="col-md-9">
				<div class="letreiro">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<a href="cadastrarCliente"><img src="img/banner1.jpg"
									alt="First slide"></a>
							</div>
							<div class="item">
								<img src="img/banner2.jpg" alt="Second slide">
							</div>
							<div class="item">
								<img src="img/banner3.jpg" alt="Third slide">
							</div>
						</div>
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left"></span></a> <a
							class="right carousel-control" href="#myCarousel" role="button"
							data-slide="next"><span
							class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div> <!-- Fim Letreiro -->

		<div class="page-header">
			<h1>Em Exibi&ccedil;&atilde;o</h1>
		</div>

		<div class="flexslider carousel">
			<ul class="slides">
				<li>
					<div class="thumbnail">
						<a href="jsp/maze-runner.jsp"> <img
							src="img/filmes/em-exibicao/maze-runner.jpg"></a>
						<div class="caption" align="center">
							<h4>Maze Runner</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/maze-runner.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/as-tartarugas-ninja.jsp"><img
							src="img/filmes/em-exibicao/as-tartarugas-ninja.jpg"></a>
						<div class="caption" align="center">
							<h4>As Tartarugas Ninjas</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/as-tartarugas-ninja.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/deus-nao-esta-morto.jsp"><img
							src="img/filmes/em-exibicao/deus-nao-esta-morto.jpg"></a>
						<div class="caption" align="center">
							<h4>Deus N&atilde;o Est&aacute; Morto</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/deus-nao-esta-morto.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/livrai-nos-do-mal.jsp"><img
							src="img/filmes/em-exibicao/livrai-nos-do-mal.jpg"></a>
						<div class="caption" align="center">
							<h4>Livrai-nos do Mal</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/livrai-nos-do-mal.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/o-protetor.jsp"><img
							src="img/filmes/em-exibicao/o-protetor.jpg"></a>
						<div class="caption" align="center">
							<h4>O Protetor</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/o-protetor.jsp" class="btn btn-default" role="button">Saiba
									Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/se-eu-ficar.jsp"><img
							src="img/filmes/em-exibicao/se-eu-ficar.jpg"></a>
						<div class="caption" align="center">
							<h4>Se Eu Ficar</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/se-eu-ficar.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/sera-que.jsp"><img
							src="img/filmes/em-exibicao/sera-que.jpg"></a>
						<div class="caption" align="center">
							<h4>Ser&aacute; Que?</h4>
							<p>
								<a href="#" class="btn btn-primary" role="button">Comprar</a> <a
									href="jsp/sera-que.jsp" class="btn btn-default" role="button">Saiba
									Mais</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
		</div>

		<div class="page-header">
			<h1>Em Breve</h1>
		</div>
		<div class="flexslider carousel">
			<ul class="slides">
				<li>
					<div class="thumbnail">
						<a href="jsp/anabelle.jsp"> <img
							src="img/filmes/em-breve/anabelle.jpg"></a>
						<div class="caption" align="center">
							<h4>Annabelle</h4>
							<p>
								<a href="jsp/anabelle.jsp" class="btn btn-default" role="button">Saiba
									Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/o-fisico.jsp"><img
							src="img/filmes/em-breve/o-fisico.jpg"></a>
						<div class="caption" align="center">
							<h4>O F&iacute;sico</h4>
							<p>
								<a href="jsp/o-fisico.jsp" class="btn btn-default" role="button">Saiba
									Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/o-homem-mais-procurado.jsp"><img
							src="img/filmes/em-breve/o-homem-mais-procurado.jpg"></a>
						<div class="caption" align="center">
							<h4>O Homem Mais Procurado</h4>
							<p>
								<a href="jsp/o-homem-mais-procurado.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/o-inventor-de-jogos.jsp"><img
							src="img/filmes/em-breve/o-inventor-de-jogos.jpg"></a>
						<div class="caption" align="center">
							<h4>O Inventor de Jogos</h4>
							<p>
								<a href="jsp/o-inventor-de-jogos.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/trash.jsp"><img
							src="img/filmes/em-breve/trash.jpg"></a>
						<div class="caption" align="center">
							<h4>Trash - A Esperan&ccedil;a Vem do Lixo</h4>
							<p>
								<a href="jsp/trash.jsp" class="btn btn-default" role="button">Saiba
									Mais</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="thumbnail">
						<a href="jsp/um-amor-de-vizinha.jsp"><img
							src="img/filmes/em-breve/um-amor-de-vizinha.jpg"></a>
						<div class="caption" align="center">
							<h4>Um Amor de Vizinha</h4>
							<p>
								<a href="jsp/um-amor-de-vizinha.jsp" class="btn btn-default"
									role="button">Saiba Mais</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
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
				<a href="acessoRestrito">&Aacute;rea Restrita</a><br />
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
	<script src="js/flexslider.js"></script>
	<script type="text/javascript">
		(function() {

			// store the slider in a local variable
			var $window = $(window), flexslider;

			// tiny helper function to add breakpoints
			function getGridSize() {
				return (window.innerWidth < 600) ? 2
						: (window.innerWidth < 900) ? 3 : 4;
			}

			$(function() {
				SyntaxHighlighter.all();
			});

			$window.load(function() {
				$('.flexslider').flexslider({
					animation : "slide",
					animationSpeed : 400,
					animationLoop : false,
					itemWidth : 210,
					itemMargin : 5,
					minItems : getGridSize(), // use function to pull in initial value
					maxItems : getGridSize(), // use function to pull in initial value
					start : function(slider) {
						$('body').removeClass('loading');
						flexslider = slider;
					}
				});
			});

			// check grid size on resize event
			$window.resize(function() {
				var gridSize = getGridSize();

				flexslider.vars.minItems = gridSize;
				flexslider.vars.maxItems = gridSize;
			});
		}());
	</script>
</body>
</html>
