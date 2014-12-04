package control.restrito.cargo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.DAO.CargoDAO;

/**
 * Servlet implementation class ServletExcluirCargo
 */
@WebServlet("/excluirCargo")
public class ServletExcluirCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirCargo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
				
		CargoDAO dao = new CargoDAO();		
		Cargo c1 = dao.lerPorId(id);
		dao.excluir(c1);
		
		response.sendRedirect("/cineunigranrio/cargos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
