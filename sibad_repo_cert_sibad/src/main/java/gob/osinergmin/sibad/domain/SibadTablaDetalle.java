package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the SIBAD_TABLA_DETALLE database table.
 * 
 */
@Entity
@Table(name="SIBAD_TABLA_DETALLE")
public class SibadTablaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String codigo;

	private long estado;

	private String nombre;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@JoinColumn(name = "ID_TABGEN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
	private SibadTablaGeneral sibadTablaGeneral;

	public SibadTablaDetalle() {
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

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public SibadTablaGeneral getSibadTablaGeneral() {
		return this.sibadTablaGeneral;
	}

	public void setSibadTablaGeneral(SibadTablaGeneral sibadTablaGeneral) {
		this.sibadTablaGeneral = sibadTablaGeneral;
	}

	
}