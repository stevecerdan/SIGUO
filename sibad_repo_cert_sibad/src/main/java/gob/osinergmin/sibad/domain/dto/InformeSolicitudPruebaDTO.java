package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class InformeSolicitudPruebaDTO {

    private Long idInformeSolicitudPrueba;
	private Long idSolicitudPruebaReprueba;
	private Long idInformeIndiceRiesgo;
	private Date FechaProximaPrueba;
	
	//VIEW
	
	private String nroSolcitudUnidadSupervisada; 	
	private String numeroTanque; 	
	private String numeroCompartimiento; 	
	private Date fechaSolicitud; 	
	
	
	public Long getIdInformeSolicitudPrueba() {
		return idInformeSolicitudPrueba;
	}
	public void setIdInformeSolicitudPrueba(Long idInformeSolicitudPrueba) {
		this.idInformeSolicitudPrueba = idInformeSolicitudPrueba;
	}
	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}
	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}
	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}
	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}
	public Date getFechaProximaPrueba() {
		return FechaProximaPrueba;
	}
	public void setFechaProximaPrueba(Date fechaProximaPrueba) {
		FechaProximaPrueba = fechaProximaPrueba;
	}
	public String getNroSolcitudUnidadSupervisada() {
		return nroSolcitudUnidadSupervisada;
	}
	public void setNroSolcitudUnidadSupervisada(String nroSolcitudUnidadSupervisada) {
		this.nroSolcitudUnidadSupervisada = nroSolcitudUnidadSupervisada;
	}
	public String getNumeroTanque() {
		return numeroTanque;
	}
	public void setNumeroTanque(String numeroTanque) {
		this.numeroTanque = numeroTanque;
	}
	public String getNumeroCompartimiento() {
		return numeroCompartimiento;
	}
	public void setNumeroCompartimiento(String numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	
}
