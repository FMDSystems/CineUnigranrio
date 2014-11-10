package control;

import java.io.IOException;
import java.security.MessageDigest;

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
		request.setCharacterEncoding("UTF-8");
		boolean error = false;
		Cliente cli1 = null;
		try {
			cli1 = new Cliente("111.111.111-11", "Administrador", "admin@cineuni.com.br", "admin", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String senha = null;
		try {
			senha = this.criptografarSenha(request.getParameter("senha"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public String criptografarSenha(String senha) throws Exception {

		 MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		 byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		
		 StringBuilder hexString = new StringBuilder();
		 for (byte b : messageDigest) {
		 hexString.append(String.format("%02X", 0xFF & b));
		 }
		 String senhaCP = hexString.toString();
		 return senhaCP;
	}

}
