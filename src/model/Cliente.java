package model;

import java.util.Date;

public class Cliente extends Pessoa{

	private Date dataNascimento;

	public Cliente() {
		super();
	}

	public Cliente(int cpf, int nome, int email, int senha, Date dataNascimento) {
		super(cpf, nome, email, senha);
		setDataNascimento(dataNascimento);
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
