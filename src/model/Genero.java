package model;

import java.util.Set;
import java.util.TreeSet;

public class Genero {
	private String descricao;
	private Set<Filme> listaFilmes;
	
	public Genero(){
		super();
	}
	
	public Genero(String descricao) {
		super();
		this.setDescricao(descricao);
		this.listaFilmes = new TreeSet<Filme>();
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Filme> getFilme() {
		return listaFilmes;
	}
	
}
