package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;

/**
 * Servlet implementation class ServletExibirFilmes
 */
@WebServlet("/exibirfilmesexibicao")
public class ServletExibirFilmesExibicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExibirFilmesExibicao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Pega Todos os filmes que estão em exibição do DAO joga em uma lista e
		 * passa por setAttribute.
		 * 
		 * Depois Forward
		 */

		Date duracao1 = null;
		try {
			duracao1 = new SimpleDateFormat("HH:mm:ss").parse("02:38:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date duracao2 = null;
		try {
			duracao2 = new SimpleDateFormat("HH:mm:ss").parse("01:54:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Filme filme1 = new Filme(
				"Livrai-nos do Mal",
				duracao1,
				"O policial Ralph Sarchie (Eric Bana) tem uma intuição especial, que sempre o leva a combater casos extremos e perigosos. Em uma mesma semana ele se depara com um bebê jogado no lixo e uma mãe que atira seu filho na jaula dos leões em um zoológico. Intrigado pelos acontecimentos, ele começa a investigar as pessoas responsáveis, suspeitando que alguma força sobrenatural esteja por trás das histórias. Com a ajuda de um padre especializado em demonologia (Edgar Ramírez), Sarchie descobre uma verdade assustadora, muito além do seu mundo cético e racional. ",
				"Scott Derrickson", true, 16, "exibição", "3D");

		Filme filme2 = new Filme(
				"Maze Runner Correr ou Morrer",
				duracao2,
				"Em um mundo pós-apocalíptico, o jovem Thomas é abandonado em uma comunidade formada por garotos após sua memória ter sido apagada. Logo ele se vê preso em um labirinto, onde será preciso unir forças com outros jovens para que possa escapar. ",
				"Wes Ball", true, 14, "exibição", "3D");
		
		Set<Filme> listaFilmesExibicao = new TreeSet<Filme>();
		listaFilmesExibicao.add(filme1);
		listaFilmesExibicao.add(filme2);
		
		request.setAttribute("filmesExibicao", listaFilmesExibicao);

		RequestDispatcher dispachante = request
				.getRequestDispatcher("exibirFilmes.jsp");
		dispachante.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
