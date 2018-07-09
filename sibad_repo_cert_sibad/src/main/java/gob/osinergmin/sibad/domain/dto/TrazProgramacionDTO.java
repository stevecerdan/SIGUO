package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class TrazProgramacionDTO {
	
	 private Long idTrazProgramacion;
	 private Long idProgramacion; 
	 private Date fechaUltimoEstado; 
	 private String estado;
	 private Long idTipoMotivo;
	 private String observacion;
	 
	public Long getIdTrazProgramacion() {
		return idTrazProgramacion;
	}
	public void setIdTrazProgramacion(Long idTrazProgramacion) {
		this.idTrazProgramacion = idTrazProgramacion;
	}
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
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
