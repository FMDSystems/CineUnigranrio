package model;

import java.util.Set;
import java.util.TreeSet;

public class Sala implements Comparable<Sala>{
	private int numero;
	private int capacidade;
	private Sessao sessao;
	private Set<Lugar> listaLugares;
	
	public Sala(){
		super();
	}
	
	public Sala(int numero, int capacidade, Sessao sessao) {
		super();
		this.setNumero(numero);
		this.setCapacidade(capacidade);
		this.setSessao(sessao);
		this.listaLugares = new TreeSet<Lugar>();
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return this.capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Sessao getSessao() {
		return this.sessao;
	}
	// Alterar o método setSessao para a códificação correta
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	//Criar métodos add e remove da lista de Lugares
	public Set<Lugar> getLugar() {
		return this.listaLugares;
	}

	@Override
	public int compareTo(Sala o) {
		return this.numero - o.getNumero();
	}
	
}
