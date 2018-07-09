package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class TrazSolicitudDTO {
	
	 private Long idTrazSolicitud;
	 private Long idSolicitudPruebaReprueba; 
	 private Date fechaUltimoEstado; 
	 private String estado;
	 private Long idTipoMotivo;
	 private String observacion;
	 
	public Long getIdTrazSolicitud() {
		return idTrazSolicitud;
	}
	public void setIdTrazSolicitud(Long idTrazSolicitud) {
		this.idTrazSolicitud = idTrazSolicitud;
	}
	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}
	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}
	public Date getFechaUltimoEstado() {
		return fechaUltimoEstado;
	}
	public void setFechaUltimoEstado(Date fechaUltimoEstado) {
		this.fechaUltimoEstado = fechaUltimoEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdTipoMotivo() {
		return idTipoMotivo;
	}
	public void setIdTipoMotivo(Long idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	 
	
}
