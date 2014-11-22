package control;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;
import model.Genero;
import model.DAO.FilmeDAO;
import model.DAO.GeneroDAO;
import control.util.JPAUtil;

/**
 * Servlet implementation class ServletAlterarFilme
 */
@WebServlet("/alterarFilme")
public class ServletAlterarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EntityManager manager = JPAUtil.getEntityManager();
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
		
		FilmeDAO dao = new FilmeDAO(manager);
		Filme f1 = dao.lerPorId(id);
		GeneroDAO daoGenero = new GeneroDAO(manager);
		List<Genero> listaGeneros = daoGenero.lerTodos();
		
		request.setAttribute("filme", f1);
		request.setAttribute("generosCadastrados", listaGeneros);
		request.getRequestDispatcher("restrito/filme/salvarFilme.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
