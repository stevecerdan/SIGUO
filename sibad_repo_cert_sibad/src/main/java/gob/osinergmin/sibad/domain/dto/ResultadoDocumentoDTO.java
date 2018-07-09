package gob.osinergmin.sibad.domain.dto;

public class ResultadoDocumentoDTO {
	
	private Long idResultadoDocumento;
	private Long idResultadoRevision;
	private Long idDocumentoAdjunto;
	private String nombreDocumento;
	private byte[] archivoAdjunto;
	
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	
	public Long getIdResultadoDocumento() {
		return idResultadoDocumento;
	}
	public void setIdResultadoDocumento(Long idResultadoDocumento) {
		this.idResultadoDocumento = idResultadoDocumento;
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public String getNombreDocumento() {
		return nombreDocumento;
	}
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	public byte[] getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	
}
