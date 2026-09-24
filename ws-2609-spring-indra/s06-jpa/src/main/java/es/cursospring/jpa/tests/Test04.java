package es.cursospring.jpa.tests;

import es.cursospring.jpa.domain.TipoMovimiento;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;

public class Test04 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		
		TipoMovimiento buscado = em.find(TipoMovimiento.class, 6);
		System.out.println(buscado);
		buscado.setTipoMovimiento("CAMBIADO");
		// NO LO QUIERO ACTUALIZAR
		
		TipoMovimiento tm = new TipoMovimiento("OTRO NUEVO");
		
		em.getTransaction().begin();
		em.persist(tm);
		em.getTransaction().commit();
		
//		em.createQuery("select m from TipoMovimiento m", TipoMovimiento.class).getResultList().forEach(System.out::println);
		em.close();
	}
}
