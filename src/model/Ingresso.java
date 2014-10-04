package model;

import java.util.Date;

public class Ingresso implements Comparable<Ingresso>{
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
	// Alterar o método setCliente para a códificação correta
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sessao getSessao() {
		return sessao;
	}
	// Alterar o método setSessao para a códificação correta
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Lugar getLugar() {
		return lugar;
	}
	// Alterar o método setLugar para a códificação correta
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	@Override
	public int compareTo(Ingresso i) {
		return this.dataCompra.compareTo(i.getDataCompra());
	}

}
