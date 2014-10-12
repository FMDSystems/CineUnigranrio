package model;

public class Lugar implements Comparable<Lugar> {
	private Character fila;
	private Integer numero;
	private Sala sala;

	public Lugar() {
		super();
	}

	public Lugar(Character fila, Integer numero, Sala sala) {
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
		int valor = this.fila.compareTo(l.getFila());
		
		if (valor == 0) {
			return this.numero.compareTo(l.getNumero());
		} else {
			return valor;
		}
	}

}
