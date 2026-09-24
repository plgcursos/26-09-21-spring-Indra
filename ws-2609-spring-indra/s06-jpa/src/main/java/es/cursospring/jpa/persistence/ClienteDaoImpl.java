package es.cursospring.jpa.persistence;

import java.util.List;
import java.util.Optional;

import es.cursospring.jpa.domain.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ClienteDaoImpl implements ClienteDao {

	private EntityManagerFactory emf = Emf.getEmf();
	
	@Override
	public Cliente save(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> findByIdLazy(Integer id) {
		try(EntityManager em = emf.createEntityManager()){
			Cliente c = em.find(Cliente.class, id);
			return Optional.ofNullable(c);
		}
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		try(EntityManager em = emf.createEntityManager()){
			String jpql = 
				"""
				select c from Cliente c
				left join fetch c.cuentas cue
				left join fetch cue.tarjetas
				where c.idPersona = :id
				""";
			TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
			q.setParameter("id", id);
			return Optional.ofNullable(q.getSingleResultOrNull());
		}
	}
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
