package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class TrazProgramacionFilter extends BasePaginatorFilter  {

	private Long idProgramacion;
	private String estado;

	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
