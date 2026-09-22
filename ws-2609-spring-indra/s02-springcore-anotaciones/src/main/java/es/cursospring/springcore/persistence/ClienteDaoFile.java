package es.cursospring.springcore.persistence;

import java.io.Serializable;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class ClienteDaoFile implements ClienteDao, Serializable {

	public ClienteDaoFile() {
		System.out.println("Constructor por defecto ClienteDaoFile");
	}
	
	@Override
	public void findAll() {
		System.out.println("Retorna todos los clientes desde Fichero");
	}

}
