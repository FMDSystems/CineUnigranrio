package model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Sessao implements Comparable<Sessao> {
	private Date data;
	private Date horarioInicio;
	private float valor;
	private Sala sala;
	private Set<Ingresso> listaIngressos;
	private Filme filme;

	public Sessao() {
		super();
	}

	public Sessao(Date data, Date horarioInicio, float valor, Sala sala,
			Set<Ingresso> ingresso, Filme filme) {
		super();
		this.setData(data);
		this.setHorarioInicio(horarioInicio);
		this.setValor(valor);
		this.setSala(sala);
		this.listaIngressos = new TreeSet<Ingresso>();
		this.setFilme(filme);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Sala getSala() {
		return sala;
	}

	// Alterar o método setSala para a códificação correta
	public void setSala(Sala sala) {
		this.sala = sala;
	}

	// Criar métodos add e remove da lista de Generos
	public Set<Ingresso> getIngresso() {
		return listaIngressos;
	}

	public Filme getFilme() {
		return filme;
	}

	// Alterar o método setFilme para a códificação correta
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public int compareTo(Sessao s) {
		int filme = this.filme.compareTo(s.getFilme());

		if (filme == 0) {
			int sala = this.sala.compareTo(s.getSala());
			if (sala == 0) {
				return this.horarioInicio.compareTo(s.getHorarioInicio());
			} else {
				return sala;
			}
		} else {
			return filme;
		}
	}

}
