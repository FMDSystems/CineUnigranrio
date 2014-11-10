package model;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private int matricula;
	
	private Cargo cargo;

	public Funcionario(String cpf, String nome, String email, String senha,
			int matricula) throws Exception {
		super(cpf, nome, email, senha);
		this.setMatricula(matricula);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Funcionario() {
		super();
	}
	
	@Override
	public String toString(){
		return this.getMatricula() + " - " + this.getNome() + "(" + this.getCargo() + ")";
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
		Funcionario other = (Funcionario) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
