package es.cursospring.springdata.domain.dto;

public record ClienteDto(
	int idCliente,
	String nombre,
	String apellidos,
	int nroCliente
) {}

//Constructor
//idCliente()
//nombre()
//apellidos()
//nroCliente()
//equals()
//hashCode()
//toString()