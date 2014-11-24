package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import model.DAO.FuncionarioDAO;

/**
 * Servlet implementation class ServletExcluirFuncionario
 */
@WebServlet("/excluirFuncionario")
public class ServletExcluirFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
		
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.lerPorId(id);
		dao.excluir(funcionario);
		
		response.sendRedirect("/cineunigranrio/funcionarios");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
