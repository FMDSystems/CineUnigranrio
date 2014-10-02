package model;

import java.util.Date;
import java.util.Set;

public class Ingresso {
	private Date dataCompra;
	private String tipoDesconto;
	private Cliente cliente;
	private Sessao sessao;

	public Ingresso() {
		super();
	}

	public Ingresso(Date dataCompra, String tipoDesconto, Cliente cliente,
			Sessao sessao) {
		super();
		this.setDataCompra(dataCompra);
		this.setTipoDesconto(tipoDesconto);
		this.setCliente(cliente);
		this.setSessao(sessao);
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

}
