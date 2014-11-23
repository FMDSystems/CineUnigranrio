package control;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Filme;
import model.Genero;
import model.DAO.FilmeDAO;
import model.DAO.GeneroDAO;
import control.util.JPAUtil;

/**
 * Servlet implementation class ServletCadastrarFilme
 */
@WebServlet("/salvarFilme")
@MultipartConfig(maxFileSize = 16177215)
// upload maximo de 16MB
public class ServletSalvarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalvarFilme() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EntityManager manager = JPAUtil.getEntityManager();
		GeneroDAO daoGenero = new GeneroDAO(manager);
		FilmeDAO daoFilme = new FilmeDAO(manager);

		Date duracao = null;
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm");
		String idS = request.getParameter("id");
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
		Filme filme = null;
		String[] generos = request.getParameterValues("listaGeneros");
		Part imagem = request.getPart("imagem");
		
		if (idS == null || idS.equals("")) {

			filme = new Filme(titulo, duracao, sinopse, diretor,
					Boolean.parseBoolean(legendaS), faixaEtaria, status, tipo);
			filme.setImagem(this.uploadFoto(imagem));
			Genero g = null;
			for (int i = 0; i < generos.length; i++) {
				Long idGenero = Long.parseLong(generos[i]);
				g = daoGenero.lerPorId(idGenero);
				filme.addGenero(g);
			}
			filme = daoFilme.salvar(filme);
		} else {
			Long id = Long.valueOf(idS);
			filme = daoFilme.lerPorId(id);
			filme.setTitulo(titulo);
			filme.setDiretor(diretor);
			filme.setDuracao(duracao);
			filme.setFaixaEtaria(faixaEtaria);
			filme.setTipo(tipo);
			filme.setLegendado(Boolean.parseBoolean(legendaS));
			filme.setStatus(status);
			filme.setSinopse(sinopse);
			filme.getGeneros().removeAll(filme.getGeneros());
			filme.setImagem(this.uploadFoto(imagem));

			Genero g = null;
			for (int i = 0; i < generos.length; i++) {
				Long idGenero = Long.parseLong(generos[i]);
				g = daoGenero.lerPorId(idGenero);
				filme.addGenero(g);
			}
			filme = daoFilme.salvar(filme);
		}

		request.setAttribute(
				"mensagem",
				"<span class='glyphicon glyphicon-ok'></span>&nbsp;Filme Cadastrado com Sucesso!!!");
		request.setAttribute("filme", filme);
		request.getRequestDispatcher("restrito/filme/confirmacaoFilme.jsp")
				.forward(request, response);

	}

	private byte[] uploadFoto(final Part imagem)
			throws IOException {
		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = imagem;
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}

		byte[] buffer = null;
		buffer = new byte[inputStream.available()];
		inputStream.read(buffer);
		inputStream.close();

		return buffer;
	}

}
