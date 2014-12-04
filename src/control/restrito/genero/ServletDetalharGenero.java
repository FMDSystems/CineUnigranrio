package control.restrito.genero;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genero;
import model.DAO.GeneroDAO;

/**
 * Servlet implementation class ServletDetalharGenero
 */
@WebServlet("/detalharGenero")
public class ServletDetalharGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = (String) request.getParameter("id");
		Long id = Long.valueOf(idS);
				
		GeneroDAO dao = new GeneroDAO();		
		Genero g1 = dao.lerPorId(id);
		
		request.setAttribute("genero", g1);
		request.getRequestDispatcher("restrito/genero/confirmacaoGenero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
