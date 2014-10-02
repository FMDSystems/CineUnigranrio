package model;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String cpf, String nome, String email, String senha) {
		super();
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
