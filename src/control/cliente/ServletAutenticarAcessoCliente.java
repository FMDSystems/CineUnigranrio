package control.cliente;

import java.io.IOException;
import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.util.JPAUtil;
import model.Cliente;
import model.DAO.ClienteDAO;

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
		request.setCharacterEncoding("UTF-8");
		EntityManager manager = JPAUtil.getEntityManager();
		ClienteDAO daoCliente = new ClienteDAO(manager);
		RequestDispatcher pagina = request.getRequestDispatcher("cliente/login.jsp");
		boolean error = false;
		Cliente cliente = null;

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String msg = "Erro: ";

		// verificar se email passada pelo request está vazia
		if (email == null || email == "") {
			msg += "Email inválido!";
			error = true;
		} else { 
			if(senha == null || senha == ""){
				msg += "Senha inválida!";
				error = true;
			}else{
				try {
					senha = this.criptografarSenha(request.getParameter("senha"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				cliente = daoCliente.lerPorEmail(email);
				
				if(cliente == null){
					msg += "Email inexistente!";
					error = true;
				}else{
					if(senha.equals(cliente.getPessoa().getSenha())){
						error = false;
					}else{
						msg +="Senha está incorreta";
						request.setAttribute("email", email);
						error = true;
					}
				}
			}
		}

		if (error) {
			request.setAttribute("mensagem", msg);
			pagina.forward(request, response);
		} else {
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("usuario", cliente);
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
