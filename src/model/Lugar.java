package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Lugares")
public class Lugar implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Lugar_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Lugar_ID", sequenceName = "Seq_Lugar", allocationSize = 1)
	private Long id;
	
	private Character fila;
	private int numero;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Sala sala;
	
	@OneToMany(mappedBy="lugar", fetch=FetchType.LAZY)
	private List<Ingresso> ingressos;

	public Lugar() {
		super();
	}

	public Lugar(Character fila, int numero, Sala sala) {
		super();
		this.setFila(fila);
		this.setNumero(numero);
		this.setSala(sala);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getFila() {
		return this.fila;
	}

	public void setFila(Character fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Métodos do relacionamento
	 * @return
	 */
	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	
	public void addIngresso(Ingresso i){
		this.getIngressos().add(i);
	}

	public void removeIngresso(Ingresso i){
		this.getIngressos().remove(i);
	}

	@Override
	public String toString(){
		return this.getFila().toString() + this.getNumero();
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
		Lugar other = (Lugar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
