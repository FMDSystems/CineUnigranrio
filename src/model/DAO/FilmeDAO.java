package model.DAO;

import javax.persistence.EntityManager;
import control.util.GenericDAO;
import model.Filme;

public class FilmeDAO extends GenericDAO<Filme>{

	public FilmeDAO(){
		super();
	}
	
	public FilmeDAO(EntityManager manager){
		super(manager);
	}
}
