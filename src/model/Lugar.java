package model;

public class Lugar implements Comparable<Lugar> {
	private char fila;
	private Integer numero;
	private Sala sala;

	public Lugar() {
		super();
	}

	public Lugar(char fila, Integer numero, Sala sala) {
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

	public void setNumero(Integer numero) {
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
			return this.numero.compareTo(l.getNumero());
		} else {
			return -1;
		}
	}

}
