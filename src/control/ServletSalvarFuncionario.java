package control;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.Funcionario;
import model.Pessoa;
import model.DAO.CargoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.PessoaDAO;
import control.util.JPAUtil;

/**
 * Servlet implementation class ServletSalvarFuncionario
 */
@WebServlet("/salvarFuncionario")
public class ServletSalvarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarFuncionario() {
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
		EntityManager m = JPAUtil.getEntityManager();
		PessoaDAO	daoPessoa = new PessoaDAO(m);
		FuncionarioDAO daoFuncionario = new FuncionarioDAO(m);
		CargoDAO daoCargo = new CargoDAO(m);
		Pessoa pessoa = null;
		Funcionario funcionario = null;
		Cargo cargo = null;
		String msg = "Erro: ";
		boolean error = false;
		RequestDispatcher pagina = request.getRequestDispatcher("restrito/funcionario/confirmacaoFuncionario.jsp");
		
		String idS = request.getParameter("id");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String cargoS = request.getParameter("cargos");
		
		cargo = daoCargo.lerPorId(Long.valueOf(cargoS));
		if(idS == null || idS == ""){
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
				} else {
					try {
						pessoa = new Pessoa(cpf,nome,email,senha);
					} catch (Exception e) {
						e.printStackTrace();
					}
					daoPessoa.abrirTransacao();
					pessoa = daoPessoa.salvar(pessoa);
					funcionario = new Funcionario(cargo,pessoa);
					funcionario = daoFuncionario.salvar(funcionario);
					daoPessoa.gravarTransacao();
					error = false;
					msg = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Funcionário Cadastrado com Sucesso!!!";
				}
			}else{
				funcionario = daoFuncionario.verificarPessoa(pessoa);
				if(funcionario == null){
					funcionario = new Funcionario(cargo,pessoa);
					funcionario = daoFuncionario.salvar(funcionario);
					error = false;
					msg = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Funcionário Cadastrado com Sucesso!!!";
				}else{
					msg += "Esses dados já foram cadastrados!";
					error = true;
				}
			}
		}else{
			Long id = Long.valueOf(idS);
			funcionario = daoFuncionario.lerPorId(id);
			pessoa = daoPessoa.lerPorCPF(cpf);
			pessoa.setCpf(cpf);
			pessoa.setEmail(email);
			pessoa.setNome(nome);
			if(!senha.equals("")){
				try {
					pessoa.setSenha(senha);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			cargo = daoCargo.lerPorId(Long.valueOf(cargoS));
			funcionario.setPessoa(pessoa);
			funcionario.setCargo(cargo);
			funcionario = daoFuncionario.salvar(funcionario);
			
			msg = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Funcionário Alterado com Sucesso!!!";
		}
		
		
		if(error){
			request.setAttribute("mensagem", msg);
			request.getRequestDispatcher("restrito/funcionario/salvarFuncionario.jsp").forward(request, response);
		}else{
			request.setAttribute("mensagem", msg);
			request.setAttribute("funcionario", funcionario);
			pagina.forward(request, response);
		}
		
	}

}
