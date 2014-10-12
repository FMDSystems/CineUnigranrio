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

import model.Funcionario;

/**
 * Servlet implementation class ServletAutenticarAcessoRestrito
 */
@WebServlet("/autenticarAcessoRestrito")
public class ServletAutenticarAcessoRestrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAutenticarAcessoRestrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean error = false;
		Funcionario func1 = null;
		try {
			func1 = new Funcionario("111.111.111-11", "Administrador",
					"admin@cineuni.com.br", "admin", 1234);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Smatricula = request.getParameter("matricula");
		int matricula;
		if (Smatricula == null)
			matricula = 0;
		else
			matricula = Integer.parseInt(Smatricula);
		String senha = null;
		try {
			senha = this.criptografarSenha(request.getParameter("senha"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher acessoRestrito = request
				.getRequestDispatcher("acessoRestrito.jsp");
		RequestDispatcher menuRestrito = request
				.getRequestDispatcher("menuRestrito.jsp");

		if (senha == null)
			senha = "";

		if (matricula == func1.getMatricula()) {
			if (senha.equals(func1.getSenha())) {
				error = false;
			} else {
				request.setAttribute("mensagem",
						"Matricula correta porém senha inválida!");
				request.setAttribute("matricula", matricula);
				error = true;
			}
		} else {
			request.setAttribute("mensagem", "Matricula inválido!");
			error = true;
		}

		if (error) {
			acessoRestrito.forward(request, response);
		} else {
			if (request.getSession() != null) {
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("usuario", func1);
			}else{
				request.getSession(false).invalidate();
			}
			menuRestrito.forward(request, response);
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
