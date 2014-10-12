package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Cliente;

/**
 * Servlet implementation class ServletValidarAcessoCliente
 */
@WebServlet("/autenticarAcessoCliente")
public class ServletAutenticarAcessoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutenticarAcessoCliente() {
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
		boolean error = false;
		Cliente cli1 = new Cliente("111.111.111-11", "Administrador", "admin@cineuni.com.br", "admin", null);
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		RequestDispatcher login = request.getRequestDispatcher("login.jsp");
		
		if (email == null)
			email = "";
		if (senha == null)
			senha = "";

		if (email.equals(cli1.getEmail())) {
			if (senha.equals(cli1.getSenha())) {
				error = false;
			} else {
				request.setAttribute("mensagem",
						"Email correto porém senha inválida!");
				request.setAttribute("email", email);
				error = true;
			}
		} else {
			request.setAttribute("mensagem", "Email inválido!");
			error = true;
		}
		
		if(error){
			login.forward(request, response);
		}else{
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("usuario", cli1);
			response.sendRedirect("/cineunigranrio");
		}
		
	}

}
