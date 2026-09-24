package es.cursospring.aop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.cursospring.aop.aspect.MiLog;

@Service
public class PedidoService {

	public String crearPedido(String producto) {
		if (producto == null || producto.isBlank())
			throw new RuntimeException("Producto incorrecto");
		
		System.out.println("Aplicar logica de negocio para crear pedido de " + producto);
		
		return "Pedido creado: " + producto;
	}
	
	public String cancelarPedido(Integer id) {
		System.out.println("Cancelando el pedido " + id);
		return "Pedido cancelado " + id;
	}
	
	@MiLog
	public List<String> consultarPedidos() {
		System.out.println("Buscando pedidos...");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return List.of("Pedido1", "Pedido2", "Pedido3");
	}
}
