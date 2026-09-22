package es.cursospring.springcore.persistence;

import java.io.Serializable;

public class ClienteDaoFile implements ClienteDao, Serializable {

	public ClienteDaoFile() {
		System.out.println("Constructor por defecto ClienteDaoFile");
	}
	
	@Override
	public void findAll() {
		System.out.println("Retorna todos los clientes desde Fichero");
	}

}
