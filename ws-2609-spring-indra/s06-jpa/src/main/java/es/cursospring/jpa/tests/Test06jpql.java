package es.cursospring.jpa.tests;

import java.util.List;

import es.cursospring.jpa.domain.Cliente;
import es.cursospring.jpa.domain.Movimiento;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test06jpql {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		
//		Movimiento m = new Movimiento();
//		m.getTipo().getTipoMovimiento();
		
		//Todos los movimientos cuyo tipo sea 'COMPRA'
		String jpql = 
				"""
				select m from Movimiento m 
				where lower(m.tipo.tipoMovimiento) = :tipo 
				and m.idMovimiento < 15
				""";
		TypedQuery<Movimiento> q = em.createQuery(jpql, Movimiento.class);
		q.setParameter("tipo", "compra");
		List<Movimiento> resu = q.getResultList();
		
		resu.forEach(System.out::println);
		
		em.close();
	}
}
