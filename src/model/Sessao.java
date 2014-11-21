package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Sessoes")
public class Sessao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Sessao_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Sessao_ID", sequenceName = "Seq_Sessao", allocationSize = 1)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	
	private float valor;
	
	@ManyToOne
	private Sala sala;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sessao")
	private List<Ingresso> ingressos;
	
	@ManyToOne
	private Filme filme;

	public Sessao() {
		super();
	}

	public Sessao(Date data, Date horarioInicio, float valor, Sala sala, Filme filme) {
		super();
		this.setData(data);
		this.setHorarioInicio(horarioInicio);
		this.setValor(valor);
		this.setSala(sala);
		this.setFilme(filme);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * Métodos do relacionamento 
	 * @return
	 */
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
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
		return 	"Filme: " + this.getFilme().toString()
				+ "Sala: " + this.getSala().toString()
				+ "Horário: " + this.getHorarioInicio().toString();
		
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
		Sessao other = (Sessao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
