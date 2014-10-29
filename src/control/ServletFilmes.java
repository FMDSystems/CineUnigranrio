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
import model.Genero;

/**
 * Servlet implementation class ServletFilmesRestrito
 */
@WebServlet("/filmes")
public class ServletFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletFilmes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		
		Genero genero1 = new Genero("Ação");
		Genero genero2 = new Genero("Drama");
		Genero genero3 = new Genero("Terror");
		

		Filme filme1 = new Filme(
				"Livrai-nos do Mal",
				duracao1,
				"O policial Ralph Sarchie (Eric Bana) tem uma intuição especial, que sempre o leva a combater casos extremos e perigosos. Em uma mesma semana ele se depara com um bebê jogado no lixo e uma mãe que atira seu filho na jaula dos leões em um zoológico. Intrigado pelos acontecimentos, ele começa a investigar as pessoas responsáveis, suspeitando que alguma força sobrenatural esteja por trás das histórias. Com a ajuda de um padre especializado em demonologia (Edgar Ramírez), Sarchie descobre uma verdade assustadora, muito além do seu mundo cético e racional. ",
				"Scott Derrickson", true, "16 Anos", "exibição", "3D");
		
		filme1.addGenero(genero1);
		filme1.addGenero(genero2);

		Filme filme2 = new Filme(
				"Maze Runner Correr ou Morrer",
				duracao2,
				"Em um mundo pós-apocalíptico, o jovem Thomas é abandonado em uma comunidade formada por garotos após sua memória ter sido apagada. Logo ele se vê preso em um labirinto, onde será preciso unir forças com outros jovens para que possa escapar. ",
				"Wes Ball", true, "14 Anos", "exibição", "3D");
		
		filme2.addGenero(genero1);
		filme2.addGenero(genero2);
		filme2.addGenero(genero3);
		
		Set<Filme> listaFilmes = new TreeSet<Filme>();
		listaFilmes.add(filme1);
		listaFilmes.add(filme2);

		request.setAttribute("listaFilmes", listaFilmes);

		RequestDispatcher dispachante = request
				.getRequestDispatcher("restrito/filme/filmes.jsp");
		dispachante.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
