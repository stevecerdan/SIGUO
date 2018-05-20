package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class TrazAlcanceAcredDTO {
	
	private Long idTrazAlcanceAcred;
	private Long idAlcanceAcreditacion;
	private String estado; 
	private String estadoAccion; 
	private Long idDocumentoAdjunto;	 
	private String idTipoMotivo;
	private Date fechaUltimoEstado;
	private String observacion;
		
	public Long getIdTrazAlcanceAcred() {
		return idTrazAlcanceAcred;
	}
	public void setIdTrazAlcanceAcred(Long idTrazAlcanceAcred) {
		this.idTrazAlcanceAcred = idTrazAlcanceAcred;
	}
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoAccion() {
		return estadoAccion;
	}
	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public String getIdTipoMotivo() {
		return idTipoMotivo;
	}
	public void setIdTipoMotivo(String idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}
	public Date getFechaUltimoEstado() {
		return fechaUltimoEstado;
	}
	public void setFechaUltimoEstado(Date fechaUltimoEstado) {
		this.fechaUltimoEstado = fechaUltimoEstado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}	

}
