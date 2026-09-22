package es.cursospring.springboot_web.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.clientes")
public class ClienteProperties {

	private Integer cantidadMaxima; // cantidad-maxima

	public ClienteProperties(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}
}
