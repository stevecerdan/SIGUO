package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ProgramacionFilter extends BasePaginatorFilter{

	private Long idCompartimiento;
	private Long idUnidadSupervisada;
	private String tipoRevision;
	private String numeroProgramacion;
	private Long unidadAlmacenamiento;
	private String estado;
	private Date fechaActual;

	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}

	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public String getTipoRevision() {
		return tipoRevision;
	}

	public void setTipoRevision(String tipoRevision) {
		this.tipoRevision = tipoRevision;
	}

	public String getNumeroProgramacion() {
		return numeroProgramacion;
	}

	public void setNumeroProgramacion(String numeroProgramacion) {
		this.numeroProgramacion = numeroProgramacion;
	}

	public Long getUnidadAlmacenamiento() {
		return unidadAlmacenamiento;
	}

	public void setUnidadAlmacenamiento(Long unidadAlmacenamiento) {
		this.unidadAlmacenamiento = unidadAlmacenamiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
			
}
