package model;

import java.io.Serializable;
import java.util.Date;

public class Ingresso implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Date dataCompra;
	private String tipoDesconto;
	private Cliente cliente;
	private Sessao sessao;
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
