package es.cursospring.springboot_web.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursospring.springboot_web.repository.ClienteDao;
import jakarta.annotation.PostConstruct;

@Service
public class Servicio1Impl implements Servicio1, Serializable {

	private final ClienteDao cDao;
	private String mensaje;
	
	
//	@Autowired
	public Servicio1Impl(@Autowired ClienteDao cDao) {
		System.out.println("Constructor con 1 parametro Servicio1Impl");
		this.cDao = cDao;
	}
	
	@Override
	public List<String> servicio() {
		System.out.println("Ejecutando el servicio 1");
		return cDao.findAll();
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
