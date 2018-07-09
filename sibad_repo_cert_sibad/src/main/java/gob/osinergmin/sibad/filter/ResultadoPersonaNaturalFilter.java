package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ResultadoPersonaNaturalFilter extends BasePaginatorFilter{
	private Long idResultadoPersonaNatural;
	private Long idResultadoRevision;
	private String numeroDocumento;
	
	public Long getIdResultadoPersonaNatural() {
		return idResultadoPersonaNatural;
	}
	
	public void setIdResultadoPersonaNatural(Long idResultadoPersonaNatural) {
		this.idResultadoPersonaNatural = idResultadoPersonaNatural;
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
}
