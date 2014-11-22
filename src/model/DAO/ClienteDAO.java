package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Cliente;
import model.Pessoa;
import control.util.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente>{
	
	public ClienteDAO(){
		super();
	}

	public ClienteDAO(EntityManager manager){
		super(manager);
	}
	
	public Cliente verificarPessoa(Pessoa pessoa){
		Cliente c1;
		
		Query consulta = this.getEntityManager().createQuery("from Cliente c where c.pessoa =:pessoa");
		consulta.setParameter("pessoa", pessoa);
		
		try{
			c1 = (Cliente) consulta.getSingleResult();
		}catch (NoResultException e){
			c1 = null;
		}
		
		return c1;
	}
	
	public Cliente lerPorEmail(String email){
		Cliente c1;
		
		Query consulta = this.getEntityManager().createQuery("from Cliente c where c.pessoa.email =:email");
		consulta.setParameter("email", email);
		
		try{
			c1 = (Cliente) consulta.getSingleResult();
		}catch (NoResultException e){
			c1 = null;
		}
		
		return c1;
	}
}
