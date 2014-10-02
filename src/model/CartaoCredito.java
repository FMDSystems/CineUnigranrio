package model;

import java.util.Date;

public class CartaoCredito {

	private int numero;

	private String nome;

	private Date validade;

	private String operadora;

	private int cvc;

	private Cliente cliente;

	public CartaoCredito() {
		super();
	}

	public CartaoCredito(int numero, String nome, Date validade,
			String operadora, int cvc, Cliente cliente) {
		super();
		this.setNumero(numero);
		this.setNome(nome);
		this.setValidade(validade);
		this.setOperadora(operadora);
		this.setCVC(cvc);
		this.setCliente(cliente);
	}
	
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getValidade() {
		return this.validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public int getCVC() {
		return this.cvc;
	}

	public void setCVC(int cvc) {
		this.cvc = cvc;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return this.operadora + " - " + this.numero;
	}

}
