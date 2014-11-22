package model;

import java.io.Serializable;
import java.security.MessageDigest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Pessoas")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Pessoa_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Pessoa_ID", sequenceName = "Seq_Pessoa", allocationSize = 1)
	private Long id;
	
	@Column(name="cpf", unique=true)
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	
	@OneToOne(mappedBy="pessoa")
	private Cliente cliente;
	
	@OneToOne(mappedBy="pessoa")
	private Funcionario funcionario;

	public Pessoa() {
		super();
	}

	public Pessoa(String cpf, String nome, String email, String senha)
			throws Exception {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	/**
	 * Métodos do Relacionamento
	 * @return
	 */
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		Pessoa other = (Pessoa) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return this.getNome();
	}

	
}
