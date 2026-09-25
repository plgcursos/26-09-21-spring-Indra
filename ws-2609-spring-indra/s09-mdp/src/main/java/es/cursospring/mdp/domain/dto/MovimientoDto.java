package es.cursospring.mdp.domain.dto;

public record MovimientoDto(
	Integer idMovimiento,
	Integer idTarjeta,
	Double importe
) {}
