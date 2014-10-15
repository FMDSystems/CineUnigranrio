package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;

/**
 * Servlet implementation class ServletCadastrarCliente
 */
@WebServlet("/cadastrarCliente")
public class ServletCadastrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastrarCliente() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date data = null;
		RequestDispatcher dispachante = request.getRequestDispatcher("confirmacaoCliente.jsp");
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String nascimento = request.getParameter("data");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		try {
			data = DATE_FORMAT.parse(nascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Cliente cliente = null;
		try {
			cliente = new Cliente(cpf,nome,email,senha,data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cliente", cliente);
		dispachante.forward(request, response);
		
	}
}
