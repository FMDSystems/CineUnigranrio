package model;

import java.io.Serializable;
import java.util.List;

public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private int numero;
	private int capacidade;
	
	private Sessao sessao;
	private List<Lugar> listaLugares;
	
	public Sala(){
		super();
	}
	
	public Sala(int numero, int capacidade, Sessao sessao) {
		super();
		this.setNumero(numero);
		this.setCapacidade(capacidade);
		this.setSessao(sessao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	public List<Lugar> getListaLugares() {
		return listaLugares;
	}

	public void setListaLugares(List<Lugar> listaLugares) {
		this.listaLugares = listaLugares;
	}
	
	@Override
	public String toString(){
		return "Num.: " + this.getNumero() + " - Capacidade: " + this.getCapacidade();
	}
	
	@Override
	public int hashCode() {
		if (this.id == null)
			return 0;

		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
