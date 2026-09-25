package es.cursospring.springdata.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("serial")

public class Extracto implements Comparable<Extracto>, Serializable{
	
	private int idExtracto;
	private int anyo;
	private int mes;
	private Cuenta cuenta;
	private Set<Movimiento> movimientos;

	public Extracto() {
	}

	public Extracto(int anyo, int mes, Cuenta cuenta) {
		this.anyo = anyo;
		this.mes = mes;
		this.cuenta = cuenta;
	}

	public int getIdExtracto() {
		return idExtracto;
	}

	public void setIdExtracto(int idExtracto) {
		this.idExtracto = idExtracto;
	}

	public String getNumeroExtracto() {
		return cuenta.getNroCuenta() + this.anyo + this.mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Set<Movimiento> getMovimientos() {
		return new TreeSet<Movimiento>(movimientos);
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public void addMovimiento(Movimiento mov) {
		if(movimientos == null) movimientos = new HashSet<Movimiento>();
		movimientos.add(mov);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idExtracto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extracto other = (Extracto) obj;
		if (idExtracto != other.idExtracto)
			return false;
		return true;
	}

	@Override
	public int compareTo(Extracto o) {
		if(idExtracto == o.idExtracto) return 0;
		else return this.getNumeroExtracto().compareTo(o.getNumeroExtracto());
	}
	
	
}
