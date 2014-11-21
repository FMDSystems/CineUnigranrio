package model.DAO;

import javax.persistence.EntityManager;

import model.Funcionario;
import control.util.GenericDAO;

public class FuncionarioDAO extends GenericDAO<Funcionario>{

	public FuncionarioDAO(){
		super();
	}
	
	public FuncionarioDAO(EntityManager manager){
		super(manager);
	}
	
}
