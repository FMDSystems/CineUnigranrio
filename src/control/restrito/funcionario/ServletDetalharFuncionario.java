package control.restrito.funcionario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import model.DAO.FuncionarioDAO;

/**
 * Servlet implementation class ServletDetalharFuncionario
 */
@WebServlet("/detalharFuncionario")
public class ServletDetalharFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharFuncionario() {
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
		Funcionario f1 = dao.lerPorId(id);
		
		request.setAttribute("funcionario", f1);
		request.getRequestDispatcher("restrito/funcionario/confirmacaoFuncionario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
