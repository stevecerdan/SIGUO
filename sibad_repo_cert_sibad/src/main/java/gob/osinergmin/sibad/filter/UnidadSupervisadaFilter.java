package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class UnidadSupervisadaFilter extends BasePaginatorFilter {
	
	private String codigoOsinergmin;
	private Long idUnidadSupervisada;

	public String getCodigoOsinergmin() {
		return codigoOsinergmin;  
	}

	public void setCodigoOsinergmin(String codigoOsinergmin) {
		this.codigoOsinergmin = codigoOsinergmin;
	}

	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	

}
