package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Cargo;
import control.util.GenericDAO;

public class CargoDAO extends GenericDAO<Cargo>{

	public CargoDAO() {
		super();
	}

	public CargoDAO(EntityManager manager) {
		super(manager);
	}

	public Cargo lerCargo(String cargo){
		Cargo c1;
		
		Query consulta = this.getEntityManager().createNamedQuery("from Cargo c where c.nome =:nome");
		consulta.setParameter("nome", cargo);
		
		try{
			c1 = (Cargo) consulta.getSingleResult();
		}catch (NoResultException e){
			c1 = null;
		}
		
		return c1;
	}
}
