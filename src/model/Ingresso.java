package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Ingressos")
public class Ingresso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Ingresso_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Ingresso_ID", sequenceName = "Seq_Ingresso", allocationSize = 1)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	private String tipoDesconto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Sessao sessao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Lugar lugar;

	public Ingresso() {
		super();
	}

	public Ingresso(Date dataCompra, String tipoDesconto, Cliente cliente,
			Sessao sessao, Lugar Lugar) {
		super();
		this.setDataCompra(dataCompra);
		this.setTipoDesconto(tipoDesconto);
		this.setCliente(cliente);
		this.setSessao(sessao);
		this.setLugar(Lugar);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString(){
		return "Sessão: " + this.getSessao().toString()
				+ "Data Compra: " + this.getDataCompra().toString()
				+ "Lugar: " + this.getLugar().toString();
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
		Ingresso other = (Ingresso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
