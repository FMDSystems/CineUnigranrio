package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Genero_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Genero_ID", sequenceName = "Seq_Genero", allocationSize = 1)
	private Long id;
	
	private String descricao;
	
	@ManyToMany
	private List<Filme> filmes;
	
	public Genero(){
		super();
	}
	
	public Genero(String descricao) {
		super();
		this.setDescricao(descricao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Filme> getListaFilmes() {
		return filmes;
	}

	public void setListaFilmes(List<Filme> listaFilmes) {
		this.filmes = listaFilmes;
	}

	
	@Override
	public String toString(){
		return this.getDescricao();
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
		Genero other = (Genero) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
