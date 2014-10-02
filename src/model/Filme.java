package model;

import java.util.Date;
import java.util.Set;

public class Filme implements Comparable<Filme>{

	private String titulo;

	private Date duracao;

	private String sinopse;

	private String diretor;

	private boolean legendado;

	private int faixaEtaria;

	private String status;

	private String tipo;

	private Set<Sessao> sessao;

	private Set<Genero> genero;

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
		this.setSessao(sessao);
		this.setGenero(genero);
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

	public Set<Sessao> getSessao() {
		return sessao;
	}

	public void setSessao(Set<Sessao> sessao) {
		this.sessao = sessao;
	}



	public Set<Genero> getGenero() {
		return genero;
	}

	public void setGenero(Set<Genero> genero) {
		this.genero = genero;
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
