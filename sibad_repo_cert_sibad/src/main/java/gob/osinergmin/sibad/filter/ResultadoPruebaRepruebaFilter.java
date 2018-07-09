package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ResultadoPruebaRepruebaFilter extends BasePaginatorFilter{

	private Long idResultadoPruebaReprueba;
	private Long idSolicitudPruebaReprueba;
	private Date fechaInicio;
	private String horaInicio;
	private Date fechaFin;
	private String horaFin;
	private String flagResultadoCompartimiento;
	private String flagResutadoTuberia;
	private String flagResultadoFinal;
	private String resultadoPrueba;
	private String observacion;
	private String numeroCertificado;
	private Date fechaEmisionCertificado;
	private String numeroInforme;
	private Date fechaProximaPrueba;
	
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}
	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}
	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getFlagResultadoCompartimiento() {
		return flagResultadoCompartimiento;
	}
	public void setFlagResultadoCompartimiento(String flagResultadoCompartimiento) {
		this.flagResultadoCompartimiento = flagResultadoCompartimiento;
	}
	public String getFlagResutadoTuberia() {
		return flagResutadoTuberia;
	}
	public void setFlagResutadoTuberia(String flagResutadoTuberia) {
		this.flagResutadoTuberia = flagResutadoTuberia;
	}
	public String getFlagResultadoFinal() {
		return flagResultadoFinal;
	}
	public void setFlagResultadoFinal(String flagResultadoFinal) {
		this.flagResultadoFinal = flagResultadoFinal;
	}
	public String getResultadoPrueba() {
		return resultadoPrueba;
	}
	public void setResultadoPrueba(String resultadoPrueba) {
		this.resultadoPrueba = resultadoPrueba;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getNumeroCertificado() {
		return numeroCertificado;
	}
	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}
	public Date getFechaEmisionCertificado() {
		return fechaEmisionCertificado;
	}
	public void setFechaEmisionCertificado(Date fechaEmisionCertificado) {
		this.fechaEmisionCertificado = fechaEmisionCertificado;
	}
	public String getNumeroInforme() {
		return numeroInforme;
	}
	public void setNumeroInforme(String numeroInforme) {
		this.numeroInforme = numeroInforme;
	}
	public Date getFechaProximaPrueba() {
		return fechaProximaPrueba;
	}
	public void setFechaProximaPrueba(Date fechaProximaPrueba) {
		this.fechaProximaPrueba = fechaProximaPrueba;
	}
	
	
}
