package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class InformeIndiceRiesgoDTO {

    private Long idInformeIndiceRiesgo;
	private String numeroInformeIndiceRiesgo;	
	private Long idPersonaJuridica;
	private Date fechaInformeIniceRiesgo;
	private String flagPersona;	
	private Long idDocumentoAdjunto;
	
	
	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}
	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}
	public String getNumeroInformeIndiceRiesgo() {
		return numeroInformeIndiceRiesgo;
	}
	public void setNumeroInformeIndiceRiesgo(String numeroInformeIndiceRiesgo) {
		this.numeroInformeIndiceRiesgo = numeroInformeIndiceRiesgo;
	}
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	public Date getFechaInformeIniceRiesgo() {
		return fechaInformeIniceRiesgo;
	}
	public void setFechaInformeIniceRiesgo(Date fechaInformeIniceRiesgo) {
		this.fechaInformeIniceRiesgo = fechaInformeIniceRiesgo;
	}
	public String getFlagPersona() {
		return flagPersona;
	}
	public void setFlagPersona(String flagPersona) {
		this.flagPersona = flagPersona;
	}
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	
	
}
