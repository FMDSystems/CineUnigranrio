package model;

public class Cargo implements Comparable<Cargo>{

	private int nivel;
	private String nome;
	private Funcionario funcionario;

	public Cargo() {
		super();
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
	
	// Alterar o método setFuncionário para a códificação correta
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return this.nivel + " - " + this.nome;
	}
	
	@Override
	public int compareTo(Cargo c){
		return this.nivel - c.getNivel();
	}

}
