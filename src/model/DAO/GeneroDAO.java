package model.DAO;

import javax.persistence.EntityManager;
import model.Genero;
import control.util.GenericDAO;

public class GeneroDAO  extends GenericDAO<Genero>{

	public GeneroDAO(){
		super();
	}
	
	public GeneroDAO(EntityManager manager){
		super(manager);
	}
}
