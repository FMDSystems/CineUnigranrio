package model;

public abstract class Pessoa {
	private int cpf;
	private int nome;
	private int email;
	private int senha;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int cpf, int nome, int email, int senha) {
		super();
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	public int getEmail() {
		return email;
	}
	public void setEmail(int email) {
		this.email = email;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
}
