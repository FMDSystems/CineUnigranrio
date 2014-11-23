package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.DAO.CargoDAO;

/**
 * Servlet implementation class ServletSalvarCargo
 */
@WebServlet("/salvarCargo")
public class ServletSalvarCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarCargo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CargoDAO dao = new CargoDAO();
		String mensagem = null;
		String idS = request.getParameter("id");
		String nivel = request.getParameter("nivel");
		String nome = request.getParameter("nome");
		Cargo c1 = null;
		
		if(idS == null || idS == ""){
			c1 = new Cargo(Integer.parseInt(nivel),nome);
			c1 = dao.salvar(c1);
			
			mensagem = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Cargo Cadastrado com Sucesso!!!";
		}else{
			Long id = Long.valueOf(idS);
			c1 = dao.lerPorId(id);
			c1.setNivel(Integer.parseInt(nivel));
			c1.setNome(nome);
			c1 = dao.salvar(c1);
			
			mensagem = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Cargo Alterado com Sucesso!!!";
		}
		
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("cargo", c1);
		request.getRequestDispatcher("restrito/cargo/confirmacaoCargo.jsp").forward(request, response);
	}

}
