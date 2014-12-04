package control.filme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;
import model.DAO.FilmeDAO;

/**
 * Servlet implementation class ServletExibirFilmes
 */
@WebServlet("/exibirFilmesExibicao")
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
		FilmeDAO dao = new FilmeDAO();
		List<Filme> todosFilmes = dao.lerTodos();
		List<Filme> filmesExibicao = new ArrayList<Filme>();
		
		for(Filme f : todosFilmes){
			if(f.getStatus().equals("Exibição")){
				filmesExibicao.add(f);
			}
		}
		
		request.setAttribute("filmesExibicao", filmesExibicao);
		
		RequestDispatcher dispachante = request.getRequestDispatcher("filme/exibirFilmeExibicao.jsp");
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
