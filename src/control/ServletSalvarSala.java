package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.Base64;

import model.Lugar;
import model.Sala;
import model.DAO.LugarDAO;
import model.DAO.SalaDAO;

/**
 * Servlet implementation class ServletSalvarGenero
 */
@WebServlet("/salvarGenero")
public class ServletSalvarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalvarSala() {
		super();
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
		SalaDAO dao = new SalaDAO();
		String mensagem = null;
		String idS = request.getParameter("id");
		int numero = Integer.valueOf(request.getParameter("numero"));
		int capacidade = Integer.valueOf(request.getParameter("capacidade"));
		int colunas = Integer.valueOf(request.getParameter("coluna"));
		int filas = Integer.valueOf(request.getParameter("fila"));
		
		Sala s1 = null;

		if (idS == null || idS == "") {
			if(capacidade>=20 && capacidade<=100){
				s1 = new Sala(numero,capacidade);
				s1 = dao.salvar(s1);
				this.gerarLugares(capacidade,colunas, filas, s1);
				mensagem = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Sala Cadastrado com Sucesso!!!";
			}else{
				mensagem = "Erro: Deu ruim";
			}

		} else {
			if(capacidade>=20 && capacidade<=100){
			Long id = Long.valueOf(idS);
				s1 = dao.lerPorId(id);
//				s1.setCapacidade(capacidade);
				s1.setNumero(numero);
				s1 = dao.salvar(s1);
				
				mensagem = "<span class='glyphicon glyphicon-ok'></span>&nbsp;Sala Alterado com Sucesso!!!";
			}else{
				mensagem = "Erro: Deu ruim";
			}
		}
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("genero", s1);
		request.getRequestDispatcher(
				"restrito/sala/confirmacaoSala.jsp").forward(request,
				response);
	}

	
	private void gerarLugares(int capacidade, int coluna, int fila, Sala s){
		LugarDAO daoLugar = new LugarDAO();
		Lugar l1 = null;
		char[] f = {'A','B','C','D','E','F','G','H','I','J'};
		
		for(int i=0;i<=coluna;i++)
			for(int x=0;x<=fila;x++){
				l1 = new Lugar(f[i],x, s);
				daoLugar.salvar(l1);
			}
			
		}
		
	}

