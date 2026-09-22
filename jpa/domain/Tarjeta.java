package domain;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Tarjeta implements Comparable<Tarjeta>, Serializable{
	
	private int idTarjeta;
	private String pan;
	private String marca;
	private TipoTarjeta tipo;
	private int anyoVencimiento;
	private int mesVencimiento;
	private Cuenta cuenta;

	public Tarjeta() {
	}

	public Tarjeta(String pan, String marca, TipoTarjeta tipo, int anyoVencimiento, int mesVencimiento, Cuenta cuenta) {
		this.pan = pan;
		this.marca = marca;
		this.tipo = tipo;
		this.anyoVencimiento = anyoVencimiento;
		this.mesVencimiento = mesVencimiento;
		this.cuenta = cuenta;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TipoTarjeta getTipo() {
		return tipo;
	}

	public void setTipo(TipoTarjeta tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public int getAnyoVencimiento() {
		return anyoVencimiento;
	}

	public void setAnyoVencimiento(int anyoVencimiento) {
		this.anyoVencimiento = anyoVencimiento;
	}

	public int getMesVencimiento() {
		return mesVencimiento;
	}

	public void setMesVencimiento(int mesVencimiento) {
		this.mesVencimiento = mesVencimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTarjeta;
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
		Tarjeta other = (Tarjeta) obj;
		if (idTarjeta != other.idTarjeta)
			return false;
		return true;
	}

	@Override
	public int compareTo(Tarjeta o) {
		return idTarjeta - o.idTarjeta;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", pan=" + pan + ", marca=" + marca + "]";
	}
}
