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
@WebServlet("/exibirFilmesBreve")
public class ServletExibirFilmesBreve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExibirFilmesBreve() {
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
		List<Filme> filmesBreve = new ArrayList<Filme>();
		
		for(Filme f : todosFilmes){
			if(f.getStatus().equals("Lançamento")){
				filmesBreve.add(f);
			}
		}
		
		request.setAttribute("filmesBreve", filmesBreve);
		
		RequestDispatcher dispachante = request.getRequestDispatcher("filme/exibirFilmeBreve.jsp");
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
