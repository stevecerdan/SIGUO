package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class AlmacenamientoFilter extends BasePaginatorFilter{

	private String idUnidadSupervisada;
	private Long idAlmacenamiento;

	public String getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(String idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	
}
