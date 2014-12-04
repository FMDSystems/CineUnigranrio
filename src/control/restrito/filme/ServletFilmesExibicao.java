package control.restrito.filme;

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
 * Servlet implementation class ServletFilmesExibicao
 */
@WebServlet("/filmesExibicao")
public class ServletFilmesExibicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFilmesExibicao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FilmeDAO dao = new FilmeDAO();

		List<Filme> todosFilmes = dao.lerTodos();
		List<Filme> listaFilmes = new ArrayList<Filme>();
		
		for(Filme f : todosFilmes){
			if(f.getStatus().equals("Exibição")){
				listaFilmes.add(f);
			}
		}
		
		request.setAttribute("listaFilmes",listaFilmes);
		
		RequestDispatcher dispachante = request
				.getRequestDispatcher("restrito/filme/filmes.jsp");
		dispachante.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
