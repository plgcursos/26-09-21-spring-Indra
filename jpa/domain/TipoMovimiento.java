package domain;

import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

@SuppressWarnings("serial")

public class TipoMovimiento implements Comparable<TipoMovimiento>, Serializable{
	
	private int idTipoMovimiento;
	private String tipoMovimiento;
	
	public TipoMovimiento() {
	}

	public TipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoMovimiento;
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
		TipoMovimiento other = (TipoMovimiento) obj;
		if (idTipoMovimiento != other.idTipoMovimiento)
			return false;
		return true;
	}

	@Override
	public int compareTo(TipoMovimiento o) {
		if(this.idTipoMovimiento == o.idTipoMovimiento) return 0;
		else {
			Collator col = Collator.getInstance(new Locale("es"));
			col.setStrength(Collator.TERTIARY);
			return col.compare(this.tipoMovimiento+this.idTipoMovimiento, o.tipoMovimiento+o.idTipoMovimiento);
		}
	}
}
