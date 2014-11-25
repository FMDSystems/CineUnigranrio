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
 * Servlet implementation class ServletDownloadImagem
 */
@WebServlet("/downloadImagem")
public class ServletDownloadImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDownloadImagem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		Long id = Long.valueOf(idS);
		
		FilmeDAO dao = new FilmeDAO();
		Filme filme = dao.lerPorId(id);
		
		byte[] img = filme.getImagem();
		
		response.getOutputStream().write(img);
		response.setContentType("image/jpeg");
		response.setContentLength(img.length);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
