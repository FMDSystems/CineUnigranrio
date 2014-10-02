package model;

public class Cargo {

	private int nivel;
	private String nome;
	private Funcionario funcionario;

	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cargo(int nivel, String nome, Funcionario funcionario) {
		super();
		this.setNivel(nivel);
		this.setNome(nome);
		this.setFuncionario(funcionario);
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

}
