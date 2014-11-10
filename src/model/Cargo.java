package model;

import java.io.Serializable;

public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private int nivel;
	private String nome;
	
	private Funcionario funcionario;

	public Cargo() {
		super();
	}

	public Cargo(int nivel, String nome) {
		super();
		this.setNivel(nivel);
		this.setNome(nome);
	}

	public Long getID(){
		return this.id;
	}
	
	public void setID(Long idNovo){
		this.id = idNovo;
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	

	@Override
	public String toString() {
		return this.nivel + " - " + this.nome;
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
		Cargo other = (Cargo) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
