package model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Sessao {
	private Date data;
	private int tempoInicio;
	private int tempoFim;
	private float valor;
	private Sala sala;
	private Set<Ingresso> listaIngressos;
	private Filme filme;
	
	public Sessao(){
		super();
	}

	public Sessao(Date data, int tempoInicio, int tempoFim, float valor,
			Sala sala, Set<Ingresso> ingresso, Filme filme) {
		super();
		this.setData(data);
		this.setTempoInicio(tempoInicio);
		this.setTempoFim(tempoFim);
		this.setValor(valor);
		this.setSala(sala);
		this.listaIngressos = new TreeSet<Ingresso>();
		this.setFilme(filme);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getTempoInicio() {
		return tempoInicio;
	}

	public void setTempoInicio(int tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	public int getTempoFim() {
		return tempoFim;
	}

	public void setTempoFim(int tempoFim) {
		this.tempoFim = tempoFim;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Sala getSala() {
		return sala;
	}
	// Alterar o método setSala para a códificação correta
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	//Criar métodos add e remove da lista de Generos
	public Set<Ingresso> getIngresso() {
		return listaIngressos;
	}

	public Filme getFilme() {
		return filme;
	}
	// Alterar o método setFilme para a códificação correta
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
