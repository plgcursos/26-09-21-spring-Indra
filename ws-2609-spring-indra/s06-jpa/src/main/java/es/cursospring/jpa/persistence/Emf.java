package es.cursospring.jpa.persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Emf {

	private static EntityManagerFactory emf;
	
	private Emf() {}
	
	public static EntityManagerFactory getEmf() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("pu_mdp");
		
		return emf;
	}
}
