package model.DAO;

import javax.persistence.EntityManager;

import model.Cliente;
import control.util.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente>{
	
	public ClienteDAO(){
		super();
	}

	public ClienteDAO(EntityManager manager){
		super(manager);
	}
}
