package model;

public class Funcionario extends Pessoa{

	private int matricula;
	public Funcionario() {
	super();
	}

	public Funcionario(String cpf, String nome, String email, String senha, int matricula) {
		super(cpf, nome, email, senha);
		setMatricula(matricula);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
