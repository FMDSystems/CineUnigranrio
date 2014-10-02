package model;

import java.util.Date;

public class CartaoCredito {

	private int numero;

	private String nome;

	private Date validade;

	private String operadora;

	private int CVC;

	private Cliente cliente;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public int getCVC() {
		return CVC;
	}

	public void setCVC(int cVC) {
		CVC = cVC;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CartaoCredito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartaoCredito(int numero, String nome, Date validade,
			String operadora, int cvc, Cliente cliente) {
		super();
		setNumero(numero);
		setNome(nome);
		setValidade(validade);
		setOperadora(operadora);
		setCVC(cvc);
		setCliente(cliente);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoCredito other = (CartaoCredito) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartaoCredito [numero=" + numero + ", nome=" + nome + "]";
	}

}
