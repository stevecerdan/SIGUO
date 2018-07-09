package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class CompartimientoFilter extends BasePaginatorFilter {
	
    private Long idAlmacenamiento;
    private Long idUnidadSupervisada;
    private Long idCompartimiento;
    private Date fechaProxPrueba;

	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}
	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	}
	
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}

}
