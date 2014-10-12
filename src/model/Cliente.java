package model;

import java.util.Date;

public class Cliente extends Pessoa{

	private Date dataNascimento;

	public Cliente() {
		super();
	}

	public Cliente(String cpf, String nome, String email, String senha, Date dataNascimento) throws Exception {
		super(cpf, nome, email, senha);
		this.setDataNascimento(dataNascimento);
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
}
