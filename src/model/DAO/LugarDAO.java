package model.DAO;

import javax.persistence.EntityManager;

import model.Lugar;
import control.util.GenericDAO;

public class LugarDAO extends GenericDAO<Lugar>{
	public LugarDAO(){
		super();
	}
	
	public LugarDAO(EntityManager manager){
		super(manager);
	}
}
