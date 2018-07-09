package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class ResultadoRevisionDTO {
	private Long idResultadoRevision;
	private Long idProgramacion;
	private Long idPersonaJuridica;
	private Date fechaInicio;
	private Date fechaFin;
	private String horaInicio;
	private String horaFin;
	private String tipoPersonal;
	private String flagPersona;
	private String resultadoRevision;
	private String observacion;
	private String estadoResultado;
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	public String getTipoPersonal() {
		return tipoPersonal;
	}
	
	public void setTipoPersonal(String tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	
	public String getFlagPersona() {
		return flagPersona;
	}
	
	public void setFlagPersona(String flagPersona) {
		this.flagPersona = flagPersona;
	}
	
	public String getResultadoRevision() {
		return resultadoRevision;
	}
	
	public void setResultadoRevision(String resultadoRevision) {
		this.resultadoRevision = resultadoRevision;
	}
	
	public String getEstadoResultado() {
		return estadoResultado;
	}
	
	public void setEstadoResultado(String estadoResultado) {
		this.estadoResultado = estadoResultado;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
