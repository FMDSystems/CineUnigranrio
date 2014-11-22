package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;
import model.DAO.FilmeDAO;

/**
 * Servlet implementation class ServletExcluirFilme
 */
@WebServlet("/excluirFilme")
public class ServletExcluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirFilme() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
		
		FilmeDAO dao = new FilmeDAO();
		Filme f1 = dao.lerPorId(id);
		dao.excluir(f1);
		
		response.sendRedirect("/cineunigranrio/filmes");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
