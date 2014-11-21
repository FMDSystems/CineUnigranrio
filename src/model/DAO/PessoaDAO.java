package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Pessoa;
import control.util.GenericDAO;

public class PessoaDAO extends GenericDAO<Pessoa> {
	
	public PessoaDAO(){
		super();
	}
	
	public PessoaDAO(EntityManager manager){
		super(manager);
	}

	public Pessoa lerPorCPF(String cpf){
		Pessoa p1;
		
		Query consulta = this.getEntityManager().createNamedQuery("from Pessoa p where p.cpf =:cpf");
		consulta.setParameter("cpf", cpf);
		
		try{
			p1 = (Pessoa) consulta.getSingleResult();
		}catch (NoResultException e){
			p1 = null;
		}
		
		return p1;
	}
	
	public Pessoa lerPorNome(String nome){
		Pessoa p1;
		
		Query consulta = this.getEntityManager().createNamedQuery("from Pessoa p where p.nome =:nome");
		consulta.setParameter("nome", nome);
		
		try{
			p1 = (Pessoa) consulta.getSingleResult();
		}catch (NoResultException e){
			p1 = null;
		}
		
		return p1;
	}
	
}
