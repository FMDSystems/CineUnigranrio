package model;

public class Lugar implements Comparable<Lugar> {
	private Character fila;
	private int numero;
	private Sala sala;

	public Lugar() {
		super();
	}

	public Lugar(Character fila, int numero, Sala sala) {
		super();
		this.setFila(fila);
		this.setNumero(numero);
		this.setSala(sala);
	}

	public Character getFila() {
		return this.fila;
	}

	public void setFila(Character fila) {
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
		int fila = this.fila.compareTo(l.getFila());
		
		if (fila == 0) {
			return this.numero - l.getNumero();
		} else {
			return fila;
		}
	}

}
