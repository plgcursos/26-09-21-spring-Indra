package es.cursospring.springdata.domain.dto;

public record MovimientoDto(
	Integer idMovimiento,
	Integer idTarjeta,
	Double importe
) {}
