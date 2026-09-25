package es.cursospring.mdp.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@SuppressWarnings("serial")

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PersonaFisica implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	int idPersona;
	String nombre;
	String apellido1;
	String apellido2;
	String nif;
	
	@Enumerated(EnumType.STRING)
	Genero sexo;
	String municipio;
	String provincia;
	
	public PersonaFisica() {
	}

	public PersonaFisica(String nombre, String apellido1, String apellido2, String nif, Genero sexo, String municipio,
			String provincia) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nif = nif;
		this.sexo = sexo;
		this.municipio = municipio;
		this.provincia = provincia;
	}


	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getApellidos() {
		return apellido1 + " " + apellido2;
	}

	public String getNombreCompleto() {
		return nombre + " " + getApellidos();
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPersona;
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
		PersonaFisica other = (PersonaFisica) obj;
		if (idPersona != other.idPersona)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PF.(" + idPersona + ", " + (nombre != null ? nombre + ", " : "")
				+ (apellido1 != null ? apellido1 + ", " : "")
				+ (apellido2 != null ? apellido2 + ", " : "")
				+ (nif != null ? nif + ", " : "") + ")";
	}

	public static <T extends PersonaFisica> TreeSet<T> ordenaId(Collection <T> personas) {
		TreeSet<T> ordenada = new TreeSet<>(new Comparator<T>() {
			@Override
			public int compare(T pf1, T pf2) {
				return ((PersonaFisica)pf1).idPersona - ((PersonaFisica)pf2).idPersona;
			}
		});
		ordenada.addAll(personas);
		return ordenada;
	}
}
