package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

import javax.persistence.Column;

public class ProgramacionVDTO {

	 private Long idProgramacion; 
	 private String tipoRevision; 
	 private Long IdResultadoRevision;
	 private String numeroProgramacion; 
	 private Long unidadAlmacenamiento;
	 private Long compartimiento;
	 private String tipoProgramacion;
	 private Date fechaProgramacion; 
	 private String estado;
	 private String numeroSerie;
	 private Long idCompartimiento;
	 private Long idUnidadSupervisada;
	 private Date fechaInicio;
	 private Date fechaFin;
     private String resultadoRevision;
     private String flagPersona;
     private Long idPersonaJuridica;
     private Date fechaActual;
	 private Date fechaCreacion;

	 
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public String getTipoRevision() {
		return tipoRevision;
	}
	public Long getIdResultadoRevision() {
		return IdResultadoRevision;
	}
	public void setIdResultadoRevision(Long idResultadoRevision) {
		IdResultadoRevision = idResultadoRevision;
	}
	public void setTipoRevision(String tipoRevision) {
		this.tipoRevision = tipoRevision;
	}
	public String getNumeroProgramacion() {
		return numeroProgramacion;
	}
	public void setNumeroProgramacion(String numeroProgramacion) {
		this.numeroProgramacion = numeroProgramacion;
	}
	public Long getUnidadAlmacenamiento() {
		return unidadAlmacenamiento;
	}
	public void setUnidadAlmacenamiento(Long unidadAlmacenamiento) {
		this.unidadAlmacenamiento = unidadAlmacenamiento;
	}
	public Long getCompartimiento() {
		return compartimiento;
	}
	public void setCompartimiento(Long compartimiento) {
		this.compartimiento = compartimiento;
	}
	public String getTipoProgramacion() {
		return tipoProgramacion;
	}
	public void setTipoProgramacion(String tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}
	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getResultadoRevision() {
		return resultadoRevision;
	}
	public void setResultadoRevision(String resultadoRevision) {
		this.resultadoRevision = resultadoRevision;
	}
	public String getFlagPersona() {
		return flagPersona;
	}
	public void setFlagPersona(String flagPersona) {
		this.flagPersona = flagPersona;
	}
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
		 
}
