package es.cursospring.springdata.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@SuppressWarnings("serial")

@Entity
@Table(name = "cuentas")
public class Cuenta implements Comparable<Cuenta>, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private int idCuenta;
	
	@Column(name = "numero")
	private String nroCuenta;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "cuenta")
	private Set<Tarjeta> tarjetas;
	
	
	@Transient
	private Set<Extracto> extractos;
	
	public Cuenta() {
	}

	public Cuenta(int idCuenta, String nroCuenta, Cliente cliente) {
		this.idCuenta = idCuenta;
		this.nroCuenta = nroCuenta;
		this.cliente = cliente;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(Set<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	public void addTarjeta(Tarjeta tarjeta) {
		if(tarjetas == null) tarjetas = new HashSet<>();
		tarjetas.add(tarjeta);
	}

	public Set<Extracto> getExtractos() {
		return extractos;
	}

	public void setExtractos(Set<Extracto> extractos) {
		this.extractos = extractos;
	}
	
	public void addExtracto(Extracto extracto) {
		if(extractos == null) extractos = new TreeSet<>();
		extractos.add(extracto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCuenta;
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
		Cuenta other = (Cuenta) obj;
		if (idCuenta != other.idCuenta)
			return false;
		return true;
	}

	@Override
	public int compareTo(Cuenta o) {
		return idCuenta - o.idCuenta;
	}

	@Override
	public String toString() {
		StringBuilder cuenta = new StringBuilder();
		for (int i = 0; i < nroCuenta.length(); i++) {
			if (i % 4 == 0 && i != 0) cuenta.append(" ");
			cuenta.append(nroCuenta.charAt(i));
		}
		return cuenta.toString() + " " + tarjetas;
	}
}
