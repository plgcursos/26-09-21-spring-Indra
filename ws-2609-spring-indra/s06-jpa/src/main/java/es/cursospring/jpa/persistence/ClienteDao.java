package es.cursospring.jpa.persistence;

import java.util.List;
import java.util.Optional;

import es.cursospring.jpa.domain.Cliente;

public interface ClienteDao {

	Cliente save(Cliente c);
	Optional<Cliente> findById(Integer id);
	Optional<Cliente> findByIdLazy(Integer id);
	List<Cliente> findAll();
	//...
}
