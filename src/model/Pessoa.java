package model;

import java.io.Serializable;
import java.security.MessageDigest;

public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long matricula;
	
	private String cpf;
	private String nome;
	private String email;
	private String senha;

	public Pessoa() {
		super();
	}

	public Pessoa(String cpf, String nome, String email, String senha)
			throws Exception {
		super();
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public Long getId() {
		return matricula;
	}
	
	public void setId(Long id) {
		this.matricula = id;
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

	public void setSenha(String senha) throws Exception {
		this.criptografarSenha(senha);
	}

	public void criptografarSenha(String senha) throws Exception {

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senhaCP = hexString.toString();
		this.senha = senhaCP;
	}
	
	@Override
	public int hashCode()
	{
		if (this.matricula == null)
			return 0;

		return this.matricula.hashCode();
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
		Pessoa other = (Pessoa) obj;
		if (matricula == null)
		{
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	
}
