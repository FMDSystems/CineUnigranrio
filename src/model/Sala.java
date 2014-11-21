package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Salas")
public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Sala_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Sala_ID", sequenceName = "Seq_Sala", allocationSize = 1)
	private Long id;
	
	private int numero;
	private int capacidade;
	
	@OneToMany(mappedBy = "sala")
	private List<Sessao> sessoes;
	
	@OneToMany(mappedBy = "sala")
	private List<Lugar> lugares;
	
	public Sala(){
		super();
	}
	
	public Sala(int numero, int capacidade) {
		super();
		this.setNumero(numero);
		this.setCapacidade(capacidade);
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

	/**
	 * Métodos do relacionamento
	 * @return
	 */
	
	public List<Sessao> getSessoes() {
		return this.sessoes;
	}

	public void addSessao(Sessao s){
		this.getSessoes().add(s);
	}
	
	public void removeSessao(Sessao s){
		this.getSessoes().remove(s);
	}
	
	public List<Lugar> getLugares() {
		return lugares;
	}
	
	public void addLugar(Lugar l){
		this.getLugares().add(l);
	}
	
	public void removeLugar(Lugar l){
		this.getLugares().remove(l);
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
