package control;

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

import model.Funcionario;
import model.DAO.FuncionarioDAO;
import control.util.JPAUtil;

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
		request.setCharacterEncoding("UTF-8");
		EntityManager manager = JPAUtil.getEntityManager();
		FuncionarioDAO dao = new FuncionarioDAO(manager);
		boolean error = false;
		String msg = "Erro:";
		Funcionario func = null;
		RequestDispatcher acessoRestrito = request.getRequestDispatcher("restrito/acessoRestrito.jsp");
		
		String sMatricula = request.getParameter("matricula");
		Long matricula;
		String senha = request.getParameter("senha");
		
		//verificar se matricula passada pelo request está vazia
		if (sMatricula == null || sMatricula == ""){
			matricula = null;
			msg += " Matricula inválida!";
			error = true;
		}else{ //senão está vazia converte String para Long
			matricula = Long.parseLong(sMatricula);
			
			//verificar se senha passada pelo request está vazia
			if(senha == null ||  senha == ""){
				msg += " Senha inválida!";
				error = true;
			}else{ //senão criptografa senha
				try {
					senha = this.criptografarSenha(senha);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				func = dao.lerPorId(matricula); //busca o objeto funcionario pelo dao
				
				if(func == null){ //verifica se achou o funcionario
					msg += " Matricula inexistente!";
					error = true;
				}else{
					if(senha.equals(func.getPessoa().getSenha())){ //compara a senha digitada com a senha do funcionario cadastrado
						error = false;
					}else{
						msg += " Senha está incorreta!";
						request.setAttribute("matricula", matricula);
						error = true;
					}
				}
			}
		}
		
		if (error) {
			request.setAttribute("mensagem", msg);
			acessoRestrito.forward(request, response);
		} else {
			if (request.getSession() != null) {
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("usuarioRestrito", func);
			}else{
				request.getSession(false).invalidate();
			}
			response.sendRedirect("centralControle");
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
