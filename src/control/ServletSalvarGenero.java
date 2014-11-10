package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genero;
import model.DAO.GeneroDAO;

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
		GeneroDAO dao = new GeneroDAO();
		String mensagem = null;
		String idS = request.getParameter("id");
		String descricao = request.getParameter("descricao");
		Genero g1 = null;

		if (idS == null || idS == "") {
			g1 = new Genero(descricao);
			g1 = dao.salvar(g1);

			mensagem = "<span class='glyphicon glyphicon-ok'></span>&nbsp;G&ecirc;nero Cadastrado com Sucesso!!!";
		} else {
			Long id = Long.valueOf(idS);
			g1 = dao.lerPorId(id);
			g1.setDescricao(descricao);
			g1 = dao.salvar(g1);

			mensagem = "<span class='glyphicon glyphicon-ok'></span>&nbsp;G&ecirc;nero Alterado com Sucesso!!!";
		}
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("genero", g1);
		request.getRequestDispatcher(
				"restrito/genero/confirmacaoGenero.jsp").forward(request,
				response);
	}

}
