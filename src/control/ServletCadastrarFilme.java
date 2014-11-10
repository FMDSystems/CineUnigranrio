package control;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genero;

/**
 * Servlet implementation class ServletCadastroFilme
 */
@WebServlet("/cadastrarFilme")
public class ServletCadastrarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastrarFilme() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getSession(false) != null) {

			Genero genero1 = new Genero("Ação");
			Genero genero2 = new Genero("Suspense");
			Genero genero3 = new Genero("Terror");
			Genero genero4 = new Genero("Drama");
			Genero genero5 = new Genero("Comédia");
			Genero genero6 = new Genero("Romance");

			Set<Genero> listaGeneros = new TreeSet<Genero>();
			listaGeneros.add(genero1);
			listaGeneros.add(genero2);
			listaGeneros.add(genero3);
			listaGeneros.add(genero4);
			listaGeneros.add(genero5);
			listaGeneros.add(genero6);
			
			request.setAttribute("generosCadastrados", listaGeneros);
			
			RequestDispatcher despachante = request
					.getRequestDispatcher("restrito/filme/salvarFilme.jsp");
			despachante.forward(request, response);

		}else{
			
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
