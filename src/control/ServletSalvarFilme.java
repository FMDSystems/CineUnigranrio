package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;
import model.Genero;

/**
 * Servlet implementation class ServletCadastrarFilme
 */
@WebServlet("/salvarFilme")
@MultipartConfig(maxFileSize = 16177215) //upload maximo de 16MB
public class ServletSalvarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarFilme() {
        super();
        // TODO Auto-generated constructor stub
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
		Date duracao = null;
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm");
		String titulo = request.getParameter("titulo");
		String diretor = request.getParameter("diretor");
		String duracaoString = request.getParameter("duracao");
		
		try {
			duracao = TIME_FORMAT.parse(duracaoString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String faixaEtaria = request.getParameter("faixaEtaria");
		String tipo = request.getParameter("tipo");
		String legendaS = request.getParameter("legenda");
		String status = request.getParameter("status");
		String sinopse = request.getParameter("sinopse");
		Filme filme = new Filme(titulo, duracao, sinopse, diretor, Boolean.parseBoolean(legendaS), faixaEtaria, status, tipo);
		
		String[] generos = request.getParameterValues("listaGeneros");
		Set<Genero> todosGeneros = (Set<Genero>) request.getAttribute("todosGeneros");
		
		for(Genero g : todosGeneros){
			for(int i=0;i<=generos.length;i++){
				if(g.getDescricao().compareTo(generos[i]) == 0){
					filme.addGenero(g);
				}
			}	
		}
		
		request.setAttribute("mensagem", "<span class='glyphicon glyphicon-ok'></span>&nbsp;Filme Cadastrado com Sucesso!!!");
		request.setAttribute("filme", filme);
		request.getRequestDispatcher("restrito/filme/confirmacaoFilme.jsp").forward(request, response);;
		
	}

}
