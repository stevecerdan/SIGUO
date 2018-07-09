package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class SolicitudXInformeRiesgoFilter extends BasePaginatorFilter{

	private Long idInformeIndiceRiesgo;
	private String nroInformeIndiceRiesgo;
	
	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}
	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}
	public String getNroInformeIndiceRiesgo() {
		return nroInformeIndiceRiesgo;
	}
	public void setNroInformeIndiceRiesgo(String nroInformeIndiceRiesgo) {
		this.nroInformeIndiceRiesgo = nroInformeIndiceRiesgo;
	}
	
	
}
