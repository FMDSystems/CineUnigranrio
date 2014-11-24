package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.Funcionario;
import model.DAO.CargoDAO;
import model.DAO.FuncionarioDAO;

/**
 * Servlet implementation class ServletAlterarFuncionario
 */
@WebServlet("/alterarFuncionario")
public class ServletAlterarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarFuncionario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
		
		FuncionarioDAO daoFuncionario = new FuncionarioDAO();
		Funcionario funcionario = daoFuncionario.lerPorId(id);
		CargoDAO daoCargo = new CargoDAO();
		List<Cargo> todosCargos = daoCargo.lerTodos();
		
		request.setAttribute("cargos", todosCargos);		
		request.setAttribute("funcionario", funcionario);
		request.getRequestDispatcher("restrito/funcionario/salvarFuncionario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
