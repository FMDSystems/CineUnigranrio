package model;

public class Lugar implements Comparable<Lugar> {
	private char fila;
	private int numero;
	private Sala sala;

	public Lugar() {
		super();
	}

	public Lugar(char fila, int numero, Sala sala) {
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

	// Alterar o método setSala para a códificação correta
	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public int compareTo(Lugar l) {
		if (this.fila == l.getFila()) {
			if (this.numero == l.getNumero()) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return -1;
		}
	}

}
