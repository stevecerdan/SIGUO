package gob.osinergmin.sibad.domain.dto;


public class ResultadoPruebaDocumentoVDTO {

	private Long idResultadoPruebaDocumento;
	private Long idResultadoPruebaReprueba;
	private Long idDocumentoAdjunto;
	private String nombreDocumento;
	private String descripcionDocumento;
	private byte[] archivoAdjunto;
	
	public Long getIdResultadoPruebaDocumento() {
		return idResultadoPruebaDocumento;
	}
	public void setIdResultadoPruebaDocumento(Long idResultadoPruebaDocumento) {
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
	}
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public String getNombreDocumento() {
		return nombreDocumento;
	}
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}
	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}
	public byte[] getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	
	
}
