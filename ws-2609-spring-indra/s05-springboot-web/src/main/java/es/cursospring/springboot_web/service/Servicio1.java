package es.cursospring.springboot_web.service;

import java.util.List;

public interface Servicio1 {

	List<String> servicio();
	String getMensaje();
	void setMensaje(String mensaje);
}
