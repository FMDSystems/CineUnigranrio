package model.DAO;

import javax.persistence.EntityManager;

import model.Sala;
import control.util.GenericDAO;

public class SalaDAO extends GenericDAO<Sala>{

	public SalaDAO(){
		super();
	}
	
	public SalaDAO(EntityManager manager){
		super(manager);
	}
}
