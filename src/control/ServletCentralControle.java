package control;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.FilmeDAO;
import model.DAO.FuncionarioDAO;
import control.util.JPAUtil;

/**
 * Servlet implementation class ServletExibirCentralControle
 */
@WebServlet("/centralControle")
public class ServletCentralControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCentralControle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (sessao != null) {
			EntityManager manager = JPAUtil.getEntityManager();
			FilmeDAO daoFilme = new FilmeDAO(manager);
			FuncionarioDAO daoFuncionario = new FuncionarioDAO(manager);
			int qtdFilmes = daoFilme.lerTodos().size();
			int qtdFuncionarios = daoFuncionario.lerTodos().size();
			
			request.setAttribute("qtdFilmes", qtdFilmes);
			request.setAttribute("qtdFuncionarios", qtdFuncionarios);
			
			RequestDispatcher menuRestrito = request
					.getRequestDispatcher("restrito/menuRestrito.jsp");
			menuRestrito.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Sessão Expirada!");
			request.getRequestDispatcher("acessoRestrito").forward(request, response);
		}
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
