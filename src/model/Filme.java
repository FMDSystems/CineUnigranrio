package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Filmes")
public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Filme_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Filme_ID", sequenceName = "Seq_Filme", allocationSize = 1)
	private Long id;

	private String titulo;
	private Date duracao;
	private String sinopse;
	private String diretor;
	private boolean legendado;
	private String faixaEtaria;
	private String status;
	private String tipo;
	private String trailer;

	@Lob
	private byte[] imagem;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Sessao> sessoes;

	@ManyToMany
	@JoinTable(name = "filme_generos", 
	joinColumns = { @JoinColumn(name = "filme_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "genero_id") })
	private List<Genero> generos;

	public Filme(String titulo, Date duracao, String sinopse, String diretor,
			boolean legendado, String faixaEtaria, String status, String tipo) {
		super();
		this.setTitulo(titulo);
		this.setDuracao(duracao);
		this.setSinopse(sinopse);
		this.setDiretor(diretor);
		this.setLegendado(legendado);
		this.setFaixaEtaria(faixaEtaria);
		this.setStatus(status);
		this.setTipo(tipo);
	}

	public Filme() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public boolean isLegendado() {
		return legendado;
	}

	public void setLegendado(boolean legendado) {
		this.legendado = legendado;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	/**
	 * Métodos do relacionamento
	 * @return
	 */
	public List<Sessao> getSessoes() {
		return sessoes;
	}
	
	public void addSessao(Sessao s){
		this.getSessoes().add(s);
	}

	public void removeSessao(Sessao s){
		this.getSessoes().remove(s);
	}
	
	public List<Genero> getGeneros() {
		return generos;
	}
	
	public void addGenero (Genero g){
		this.getGeneros().add(g);
	}
	
	public void removeGenero (Genero g){
		this.getGeneros().remove(g);
	}

	@Override
	public String toString() {
		return this.titulo + " - " + this.tipo + " : " + this.duracao;
	}

	@Override
	public int hashCode() {
		if (this.id == null)
			return 0;

		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
