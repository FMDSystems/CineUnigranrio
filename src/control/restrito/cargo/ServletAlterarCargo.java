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
 * Servlet implementation class ServletAlterarCargo
 */
@WebServlet("/alterarCargo")
public class ServletAlterarCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarCargo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
				
		CargoDAO dao = new CargoDAO();		
		Cargo c1 = dao.lerPorId(id);
		
		request.setAttribute("cargo", c1);
		request.getRequestDispatcher("restrito/cargo/salvarCargo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
