package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Pessoa;
import model.DAO.ClienteDAO;
import model.DAO.PessoaDAO;
import control.util.JPAUtil;

/**
 * Servlet implementation class ServletCadastrarCliente
 */
@WebServlet("/salvarCliente")
public class ServletSalvarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalvarCliente() {
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
		PessoaDAO daoPessoa = new PessoaDAO(manager);
		ClienteDAO daoCliente = new ClienteDAO(manager);
		Pessoa pessoa = null;
		Cliente cliente = null;
		String msg = "Erro: ";
		boolean error = false;
		RequestDispatcher pagina = request
				.getRequestDispatcher("cliente/confirmacaoCliente.jsp");
		Date data = null;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nascimento = request.getParameter("data");

		if (cpf == null || cpf == "") {
			msg += "CPF Inválido!";
			error = true;
		} else {
			pessoa = daoPessoa.lerPorCPF(cpf);
		}

		if (pessoa == null) {
			if (nome == null || nome == "") {
				msg += "Nome Inválido!";
				error = true;
			} else if (email == null || email == "") {
				msg += "Email Inválido!";
				error = true;
			} else if (senha == null || senha == "") {
				msg += "Senha Inválida!";
				error = true;
			} else if (nascimento == null || nascimento == "") {
				msg += "Data de Nascimento Inválida!";
				error = true;
			} else {
				try {
					pessoa = new Pessoa(cpf, nome, email, senha);
					data = DATE_FORMAT.parse(nascimento);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				daoPessoa.abrirTransacao();
				pessoa = daoPessoa.salvar(pessoa);
				cliente = new Cliente(data, pessoa);
				cliente = daoCliente.salvar(cliente);
				daoCliente.gravarTransacao();
				error = false;
			}
		} else {
			cliente = daoCliente.verificarPessoa(pessoa);
			if(cliente == null){
				if (nascimento == null || nascimento == "") {
					msg += "Data de Nascimento Inválida!";
					error = true;
				} else {
					try {
						data = DATE_FORMAT.parse(nascimento);
					} catch (Exception e) {
						e.printStackTrace();
					}
					cliente = new Cliente(data, pessoa);
					cliente = daoCliente.salvar(cliente);
					error = false;
				}
			}else{
				msg+="Esses dados já foram cadastrados!";
				error = true;
			}
		}

		if(error){
			request.setAttribute("mensagem", msg);
			request.getRequestDispatcher("cliente/login.jsp").forward(request, response);
		}else{
			request.setAttribute("cliente", cliente);
			pagina.forward(request, response);			
		}
		

	}
}
