package es.cursospring.mdp.domain;

import java.text.Collator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@SuppressWarnings("serial")

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(
	name = "id_cliente",
	referencedColumnName = "id_persona"
)
public class Cliente extends PersonaFisica implements Comparable<Cliente>{
	
	@Column(name="nrocliente")
	private int nroCliente;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Cuenta> cuentas;
	
	public Cliente() {
	}

	public Cliente(String nombre, String apellido1, String apellido2, String nif, Genero sexo, String municipio, String privincia, int nroCliente) {
		super(nombre, apellido1, apellido2, nif, sexo, municipio, privincia);
		this.nroCliente = nroCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}


	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void addCuenta(Cuenta cuenta) {
		if (cuentas == null) cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta);
	}

	@Override
	public int compareTo(Cliente otra) {
		if(idPersona == otra.idPersona) return 0;
		else {
			Collator col = Collator.getInstance(new Locale("es"));
			col.setStrength(Collator.TERTIARY);
			return col.compare(this.apellido1+this.apellido2+this.nombre+this.idPersona, otra.apellido1+otra.apellido2+otra.nombre+otra.idPersona);
		}
	}


}
