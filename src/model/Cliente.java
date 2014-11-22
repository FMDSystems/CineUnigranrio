package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable{

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Cliente_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Cliente_ID", sequenceName = "Seq_Cliente", allocationSize = 1)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@OneToOne
	private Pessoa pessoa;

	@OneToMany(mappedBy="cliente")
	private List<Ingresso> ingressos; 
	
	@OneToOne(fetch=FetchType.LAZY)
	private CartaoCredito cartao;
	
	
	
	public Cliente() {
		super();
	}

	public Cliente(Date dataNascimento, Pessoa pessoa) {
		this.setDataNascimento(dataNascimento);
		this.setPessoa(pessoa);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataFormatada(){
		return DATE_FORMAT.format(getDataNascimento());
	}
	
	/**
	 * Métodos do Relacionamento
	 * @return
	 */
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void addIngresso(Ingresso i){
		this.getIngressos().add(i);
	}

	public void removeIngresso(Ingresso i){
		this.getIngressos().remove(i);
	}
	
	public CartaoCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}

	@Override
	public String toString(){
		return this.getPessoa().getCpf() + " - " + this.getPessoa().getNome();
	}
	
	@Override
	public int hashCode()
	{
		if (this.id == null)
			return 0;

		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
