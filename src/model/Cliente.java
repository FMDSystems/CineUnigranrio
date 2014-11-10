package model;

import java.io.Serializable;
import java.util.Date;

public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Date dataNascimento;

	public Cliente() {
		super();
	}

	public Cliente(String cpf, String nome, String email, String senha, Date dataNascimento) throws Exception {
		super(cpf, nome, email, senha);
		this.setDataNascimento(dataNascimento);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString(){
		return this.getCpf() + " - " + this.getNome();
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
		Cliente other = (Cliente) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
