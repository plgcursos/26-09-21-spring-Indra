package es.cursospring.jpa.tests;

import java.util.Optional;

import es.cursospring.jpa.domain.Cliente;
import es.cursospring.jpa.persistence.ClienteDao;
import es.cursospring.jpa.persistence.ClienteDaoImpl;

public class Test09Dao {
	public static void main(String[] args) {
		
		ClienteDao cDao = new ClienteDaoImpl();
		
		Optional<Cliente> c = cDao.findById(19);
		Cliente cli = c.get();
		
		System.out.println(cli);
		cli.getCuentas().forEach(System.out::println);
		
	}
}
