package model;

import java.util.Set;
import java.util.TreeSet;

public class Genero implements Comparable<Genero>{
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
	
	//Criar métodos add e remove da lista Filmes
	public Set<Filme> getFilme() {
		return this.listaFilmes;
	}
	
	public void addFilme(Filme novo){
		if(this.listaFilmes.contains(novo))
			return;
		
		this.listaFilmes.add(novo);
		novo.addGenero(this);
	}

	public void removeFilme(Filme antigo){
		if(! this.listaFilmes.contains(antigo))
			return;
		
		this.listaFilmes.remove(antigo);
		antigo.removeGenero(this);
	}
	
	@Override
	public int compareTo(Genero g) {
		return this.descricao.compareTo(g.getDescricao());
	}
	
	public String toString(){
		return this.getDescricao();
	}
	
}
