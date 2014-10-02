package model;

import java.util.Date;
import java.util.Set;

public class Filme {

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

	public Filme(String titulo, Date duracao, String sinopse, String diretor,
			boolean legendado, int faixaEtaria, String status, String tipo) {
		super();
		setTitulo(titulo);
		setDuracao(duracao);
		setSinopse(sinopse);
		setDiretor(diretor);
		setLegendado(legendado);
		setFaixaEtaria(faixaEtaria);
		setStatus(status);
		setTipo(tipo);
		setSessao(sessao);
		setGenero(genero);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", duracao=" + duracao + "]";
	}

}
