package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Funcionario;
import model.Pessoa;
import control.util.GenericDAO;

public class FuncionarioDAO extends GenericDAO<Funcionario>{

	public FuncionarioDAO(){
		super();
	}
	
	public FuncionarioDAO(EntityManager manager){
		super(manager);
	}
	
	public Funcionario verificarPessoa(Pessoa pessoa){
		Funcionario f1;
		
		Query consulta = this.getEntityManager().createQuery("from Funcionario f where f.pessoa =:pessoa");
		consulta.setParameter("pessoa", pessoa);
		
		try{
			f1 = (Funcionario) consulta.getSingleResult();
		}catch (NoResultException e){
			f1 = null;
		}
		
		return f1;
	}
	
}
