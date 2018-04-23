package gob.osinergmin.sibad.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the SIBAD_TABLA_GENERAL database table.
 * 
 */
@Entity
@Table(name="SIBAD_TABLA_GENERAL")
public class SibadTablaGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String codigo;

	private String descripcion;

	private long estado;

	private String nombre;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sibadTablaGeneral")
	private List<SibadTablaDetalle> sibadTablaDetalles;

	public SibadTablaGeneral() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getEstado() {
		return this.estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SibadTablaDetalle> getSibadTablaDetalles() {
		return this.sibadTablaDetalles;
	}

	public void setSibadTablaDetalles(List<SibadTablaDetalle> sibadTablaDetalles) {
		this.sibadTablaDetalles = sibadTablaDetalles;
	}

	
	public SibadTablaDetalle addSibadTablaDetalles(SibadTablaDetalle sibadTablaDetalles) {
		getSibadTablaDetalles().add(sibadTablaDetalles);
		sibadTablaDetalles.setSibadTablaGeneral(this);

		return sibadTablaDetalles;
	}

	public SibadTablaDetalle removeSibadTablaDetalles(SibadTablaDetalle sibadTablaDetalles) {
		getSibadTablaDetalles().remove(sibadTablaDetalles);
		sibadTablaDetalles.setSibadTablaGeneral(null);

		return sibadTablaDetalles;
	}
}