package gob.osinergmin.sibad.filter;

import javax.persistence.Column;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ResultadoDocumentoFilter extends BasePaginatorFilter{
	private Long idResultadoDocumento;
	private Long idResultadoRevision;
	private Long idDocumentoAdjunto;
	
	public Long getIdResultadoDocumento() {
		return idResultadoDocumento;
	}
	public void setIdResultadoDocumento(Long idResultadoDocumento) {
		this.idResultadoDocumento = idResultadoDocumento;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
}
