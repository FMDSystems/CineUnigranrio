package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Cargos")
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Cargo_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Cargo_ID", sequenceName = "Seq_Cargo", allocationSize = 1)
	private Long id;
	
	private int nivel;
	private String nome;
	
	@OneToMany(mappedBy="cargo")
	private List<Funcionario> funcionarios;

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

	/**
	 * Métodos do Relacionamentos
	 * @return
	 */
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void addFuncionario(Funcionario f){
		this.getFuncionarios().add(f);
	}
	
	public void removeFuncionario(Funcionario f){
		this.getFuncionarios().remove(f);
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
