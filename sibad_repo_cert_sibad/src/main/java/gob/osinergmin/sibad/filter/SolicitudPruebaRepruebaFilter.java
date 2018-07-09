/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

/**
 * @author jpiro
 */
public class SolicitudPruebaRepruebaFilter extends BasePaginatorFilter{
	
	private Long idSolicitudPruebaReprueba;
	private String nroSolicitudUnidadSupervisa;
	private Long idEmpresaAcreditada;
	private String empresaAcreditada;
	private String numeroTanque;
	private String estado;
	private Long idUnidSupervTanque;
	private Long idUnidSupervModulo;
	private Long idTipoPrueba;
	private String tipoPrueba;
	private String resultadoPrueba;
	private Long numeroCompartimiento;
	private String flagInformeIndiceRiesgo;
	private Date fechaProxPrueba;
	
	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}
	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}
	public String getNroSolicitudUnidadSupervisa() {
		return nroSolicitudUnidadSupervisa;
	}
	public void setNroSolicitudUnidadSupervisa(String nroSolicitudUnidadSupervisa) {
		this.nroSolicitudUnidadSupervisa = nroSolicitudUnidadSupervisa;
	}
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	public String getEmpresaAcreditada() {
		return empresaAcreditada;
	}
	public void setEmpresaAcreditada(String empresaAcreditada) {
		this.empresaAcreditada = empresaAcreditada;
	}
	public String getNumeroTanque() {
		return numeroTanque;
	}
	public void setNumeroTanque(String numeroTanque) {
		this.numeroTanque = numeroTanque;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdUnidSupervTanque() {
		return idUnidSupervTanque;
	}
	public void setIdUnidSupervTanque(Long idUnidSupervTanque) {
		this.idUnidSupervTanque = idUnidSupervTanque;
	}
	public Long getIdUnidSupervModulo() {
		return idUnidSupervModulo;
	}
	public void setIdUnidSupervModulo(Long idUnidSupervModulo) {
		this.idUnidSupervModulo = idUnidSupervModulo;
	}
	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getTipoPrueba() {
		return tipoPrueba;
	}
	public void setTipoPrueba(String tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
	}
	public String getResultadoPrueba() {
		return resultadoPrueba;
	}
	public void setResultadoPrueba(String resultadoPrueba) {
		this.resultadoPrueba = resultadoPrueba;
	}
	public Long getNumeroCompartimiento() {
		return numeroCompartimiento;
	}
	public void setNumeroCompartimiento(Long numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}
	public String getFlagInformeIndiceRiesgo() {
		return flagInformeIndiceRiesgo;
	}
	public void setFlagInformeIndiceRiesgo(String flagInformeIndiceRiesgo) {
		this.flagInformeIndiceRiesgo = flagInformeIndiceRiesgo;
	}
	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}
	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	}
	
}
