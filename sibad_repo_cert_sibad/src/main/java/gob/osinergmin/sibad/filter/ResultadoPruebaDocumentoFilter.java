package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ResultadoPruebaDocumentoFilter extends BasePaginatorFilter{

	private Long idResultadoPruebaDocumento;
	private Long idDocumentoAdjunto;
	private Long idResultadoPruebaReprueba;
	private String descripcionDocumento;
	
	public Long getIdResultadoPruebaDocumento() {
		return idResultadoPruebaDocumento;
	}
	public void setIdResultadoPruebaDocumento(Long idResultadoPruebaDocumento) {
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
	}
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
	public void setIdResultadoPruebaReprueba(Long idResutadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResutadoPruebaReprueba;
	}
	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}
	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}
	
	
}
