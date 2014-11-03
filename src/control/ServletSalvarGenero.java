package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genero;

/**
 * Servlet implementation class ServletSalvarGenero
 */
@WebServlet("/salvarGenero")
public class ServletSalvarGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		Genero g1 = new Genero(descricao);
		
		request.setAttribute("mensagem", "<span class='glyphicon glyphicon-ok'></span>&nbsp;G&ecirc;nero Cadastrado com Sucesso!!!");
		request.setAttribute("genero", g1);
		request.getRequestDispatcher("restrito/genero/confirmacaoGenero.jsp").forward(request, response);
		
	}

}
