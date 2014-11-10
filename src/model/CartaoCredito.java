package model;

import java.io.Serializable;
import java.util.Date;

public class CartaoCredito implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Integer numero;

	private String nome;

	private Date validade;

	private String operadora;

	private int cvc;

	private Cliente cliente;

	public CartaoCredito() {
		super();
	}

	public CartaoCredito(Integer numero, String nome, Date validade,
			String operadora, int cvc, Cliente cliente) {
		super();
		this.setNumero(numero);
		this.setNome(nome);
		this.setValidade(validade);
		this.setOperadora(operadora);
		this.setCVC(cvc);
		this.setCliente(cliente);
	}
	
	public Long getID(){
		return this.id;
	}
	
	public void setID(Long novoID){
		this.id = novoID;
	}
	
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
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
		return this.operadora + " - " 
				+ "**** **** ****"
				+ this.numero.toString().charAt(12)
				+ this.numero.toString().charAt(13)
				+ this.numero.toString().charAt(14)
				+ this.numero.toString().charAt(15);
	}
	
	@Override
	public int hashCode()
	{
		if (this.id == null)
			return 0;

		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoCredito other = (CartaoCredito) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
