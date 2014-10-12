package model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Filme implements Comparable<Filme>{

	private String titulo;

	private Date duracao;

	private String sinopse;

	private String diretor;

	private boolean legendado;

	private int faixaEtaria;

	private String status;

	private String tipo;

	private Set<Sessao> listaSessoes;

	private Set<Genero> listaGeneros;

	public Filme(String titulo, Date duracao, String sinopse, String diretor,
			boolean legendado, int faixaEtaria, String status, String tipo) {
		super();
		this.setTitulo(titulo);
		this.setDuracao(duracao);
		this.setSinopse(sinopse);
		this.setDiretor(diretor);
		this.setLegendado(legendado);
		this.setFaixaEtaria(faixaEtaria);
		this.setStatus(status);
		this.setTipo(tipo);
		this.listaSessoes = new TreeSet<Sessao>();
		this.listaGeneros = new TreeSet<Genero>();
	}
	
	public Filme() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public boolean isLegendado() {
		return legendado;
	}

	public void setLegendado(boolean legendado) {
		this.legendado = legendado;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//Criar métodos add e remove da lista de Sessoes
	public Set<Sessao> getSessao() {
		return listaSessoes;
	}
	//Criar métodos add e remove da lista de Generos
	public Set<Genero> getGenero() {
		return listaGeneros;
	}
	
	public void addGenero(Genero novo){
		if(this.listaGeneros.contains(novo))
			return;
		this.listaGeneros.add(novo);
		novo.addFilme(this);
	}
	
	public void removeGenero(Genero antigo){
		if(! this.listaGeneros.contains(antigo))
			return;
		
		this.listaGeneros.remove(antigo);
		antigo.removeFilme(this);
	}

	@Override
	public String toString() {
		return this.titulo + " - " + this.tipo + " : " + this.duracao;
	}

	@Override
	public int compareTo(Filme f) {
		return this.titulo.compareTo(f.getTitulo());
	}

}
