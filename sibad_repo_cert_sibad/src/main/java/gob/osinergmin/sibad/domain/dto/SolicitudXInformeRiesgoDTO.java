package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class SolicitudXInformeRiesgoDTO {

    private Long idInformeIndiceRiesgo;
	private String nroInformeIndiceRiesgo;
	private Date fechaInformeIndiceRiesgo;
	private String listaTanquesCompartimientos;
	
	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}
	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}
	public String getNroInformeIndiceRiesgo() {
		return nroInformeIndiceRiesgo;
	}
	public void setNroInformeIndiceRiesgo(String nroInformeIndiceRiesgo) {
		this.nroInformeIndiceRiesgo = nroInformeIndiceRiesgo;
	}
	public Date getFechaInformeIndiceRiesgo() {
		return fechaInformeIndiceRiesgo;
	}
	public void setFechaInformeIndiceRiesgo(Date fechaInformeIndiceRiesgo) {
		this.fechaInformeIndiceRiesgo = fechaInformeIndiceRiesgo;
	}
	public String getListaTanquesCompartimientos() {
		return listaTanquesCompartimientos;
	}
	public void setListaTanquesCompartimientos(String listaTanquesCompartimientos) {
		this.listaTanquesCompartimientos = listaTanquesCompartimientos;
	}
	
	
}
