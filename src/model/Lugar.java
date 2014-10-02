package model;

public class Lugar {
	private char fila;
	private int numero;
	private Sala sala;
	
	public Lugar(){
		super();
	}

	public Lugar(char fila, int numero, Sala sala){
		super();
		this.setFila(fila);
		this.setNumero(numero);
		this.setSala(sala);
	}
	
	public char getFila() {
		return this.fila;
	}

	public void setFila(char fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	

}
