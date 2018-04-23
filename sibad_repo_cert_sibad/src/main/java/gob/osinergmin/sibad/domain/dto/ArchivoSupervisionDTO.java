package gob.osinergmin.sibad.domain.dto;

import java.util.List;

public class ArchivoSupervisionDTO {
	
	private Long idArchivo;
	private String tipoDocumento;
	private String descripcion;
	private String nombreArchivo;
	private byte[] archivo;
	private List<Long> idImagenes;
	private String provieneSiged;
	
	public Long getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public List<Long> getIdImagenes() {
		return idImagenes;
	}
	public void setIdImagenes(List<Long> idImagenes) {
		this.idImagenes = idImagenes;
	}
	public String getProvieneSiged() {
		return provieneSiged;
	}
	public void setProvieneSiged(String provieneSiged) {
		this.provieneSiged = provieneSiged;
	}		
	
}
