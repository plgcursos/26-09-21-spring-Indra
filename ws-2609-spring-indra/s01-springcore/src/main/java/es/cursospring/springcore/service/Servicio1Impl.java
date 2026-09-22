package es.cursospring.springcore.service;

import java.io.Serializable;

import es.cursospring.springcore.persistence.ClienteDao;

public class Servicio1Impl implements Servicio1, Serializable {

	private final ClienteDao cDao;
	private String mensaje;
	
	public Servicio1Impl(ClienteDao cDao) {
		System.out.println("Constructor con 1 parametro Servicio1Impl");
		this.cDao = cDao;
	}
	
	@Override
	public void servicio() {
		System.out.println("Ejecutando el servicio 1");
		cDao.findAll();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

//	public ClienteDao getcDao() {
//		return cDao;
//	}
//
//	public void setcDao(ClienteDao cDao) {
//		this.cDao = cDao;
//	}
	
	
}
