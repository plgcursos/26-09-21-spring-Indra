package es.cursospring.jpa.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@SuppressWarnings("serial")

@Entity
@Table(name = "movimientos")
public class Movimiento implements Comparable<Movimiento>, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimiento")
	private int idMovimiento;
	
	@Transient
	private Extracto extracto;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_mov")
	private TipoMovimiento tipo;
	
	@ManyToOne
	@JoinColumn(name = "fk_tarjeta")
	private Tarjeta tarjeta;
	
	private LocalDate fecha;
	private double importe;
	private String proveedor;
	
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Movimiento() {
	}

	public Movimiento(TipoMovimiento tipo, Tarjeta tarjeta, LocalDate fecha, double importe, String proveedor, Extracto extracto) {
		this.tipo = tipo;
		this.tarjeta = tarjeta;
		this.fecha = fecha;
		this.importe = importe;
		this.proveedor = proveedor;
		this.extracto = extracto;
//		datos Extracto
//		La clase de negocio debera buscar el extracto si existe o crearlo
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(fecha);
//		int anyo = cal.get(Calendar.YEAR);
//		int mes = cal.get(Calendar.MONTH);
	}
	
	public Movimiento(TipoMovimiento tipo, Tarjeta tarjeta, int dia, int mes, int anyo, double importe, String proveedor, Extracto extracto) {
		this(tipo, tarjeta, null, importe, proveedor, extracto);
		fecha = LocalDate.of(anyo, mes, dia);
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Extracto getExtracto() {
		return extracto;
	}

	public void setExtracto(Extracto extracto) {
		this.extracto = extracto;
	}

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getFechaFormat() {
		return fecha.format(FORMATO_FECHA);
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void setFecha(int anyo, int mes, int dia) {
		fecha = LocalDate.of(anyo, mes, dia);
	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMovimiento;
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
		Movimiento other = (Movimiento) obj;
		if (idMovimiento != other.idMovimiento)
			return false;
		return true;
	}

	@Override
	public int compareTo(Movimiento o) {
		if(this.idMovimiento == o.idMovimiento) return 0;
		else return this.fecha.compareTo(o.fecha);
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", tipo=" + tipo + ", fecha=" + fecha + ", importe="
				+ importe + ", proveedor=" + proveedor + "]";
	}

	
}
