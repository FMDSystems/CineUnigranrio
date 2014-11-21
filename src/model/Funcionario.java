package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Funcionarios")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Funcionario_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Funcionario_ID", sequenceName = "Seq_Funcionario", allocationSize = 1)
	private Long matricula;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Cargo cargo;
	
	@OneToOne
	private Pessoa pessoa;

	public Funcionario(Cargo cargo, Pessoa pessoa) {
		this.setCargo(cargo);
		this.setPessoa(pessoa);
	}
	
	public Funcionario() {
		super();
	}
	
	public Long getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	/*
	 * Métodos do Relacionamento
	 * @return
	 */
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	@Override
	public String toString(){
		return this.getMatricula() + " - " + this.getPessoa().getNome() + "(" + this.getCargo() + ")";
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
		Funcionario other = (Funcionario) obj;
		if (matricula == null)
		{
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
