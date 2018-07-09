/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author jpiro
 */
public class SolicitudPruebaRepruebaDTO {
	
	private Long idSolicitudPruebaReprueba;
	private String nroSolicitudUnidadSupervisa;
	private Long idTipoPrueba;
	private String tipoPrueba;
	private Long idEmpresaAcreditada;
	private Long idPersonaJuridica;
	private String empresaAcreditada;
	private Long idUnidSupervTanque;
	private Long idUnidSupervModulo;
	private Long idCompartimiento;
	private Long idCilindroGNV;
	private Long idTanqueGLP;
	private String flagInspeccion;
	private Long numeroCompartimiento;
	private Long idAlmacenamiento;
	private String numeroTanque;
	private Long idModulo;
	private Long modulo;
	private Long cilindro;
	private String estado;
	private String numeroSerie;
	private Date fechaSolicitud;
	private Date fechaCreacion;
	private Date fechaFin;
	private Long idResultadoPruebaReprueba;
	private Date fechaInicio;
	private String resultadoPrueba;
	private Date fechaProxPrueba;
	private String flagInformeIndiceRiesgo;
	private Date fechaInforme;
	
	private String numeroCertificado;
	private String numeroInforme;
	
	private String unidAlmacenamiento1;
	private String unidAlmacenamiento2;
	private String nombreUnid;
	private String direccion;
	private String ubigeo;
	
	/*private String estado2;
	private String estado3;
	private String estado4;*/
		
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
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	public Long getNumeroCompartimiento() {
		return numeroCompartimiento;
	}
	public void setNumeroCompartimiento(Long numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}
	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
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
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
	//--------------------------
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	public Long getIdCilindroGNV() {
		return idCilindroGNV;
	}
	public void setIdCilindroGNV(Long idCilindroGNV) {
		this.idCilindroGNV = idCilindroGNV;
	}
	public Long getIdTanqueGLP() {
		return idTanqueGLP;
	}
	public void setIdTanqueGLP(Long idTanqueGLP) {
		this.idTanqueGLP = idTanqueGLP;
	}
	public String getFlagInspeccion() {
		return flagInspeccion;
	}
	public void setFlagInspeccion(String flagInspeccion) {
		this.flagInspeccion = flagInspeccion;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public Long getModulo() {
		return modulo;
	}
	public void setModulo(Long modulo) {
		this.modulo = modulo;
	}
	public Long getCilindro() {
		return cilindro;
	}
	public void setCilindro(Long cilindro) {
		this.cilindro = cilindro;
	}
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getResultadoPrueba() {
		return resultadoPrueba;
	}
	public void setResultadoPrueba(String resultadoPrueba) {
		this.resultadoPrueba = resultadoPrueba;
	}
	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}
	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	}
	public String getUnidAlmacenamiento1() {
		return unidAlmacenamiento1;
	}
	public void setUnidAlmacenamiento1(String unidAlmacenamiento1) {
		this.unidAlmacenamiento1 = unidAlmacenamiento1;
	}
	public String getUnidAlmacenamiento2() {
		return unidAlmacenamiento2;
	}
	public void setUnidAlmacenamiento2(String unidAlmacenamiento2) {
		this.unidAlmacenamiento2 = unidAlmacenamiento2;
	}
	public String getNombreUnid() {
		return nombreUnid;
	}
	public void setNombreUnid(String nombreUnid) {
		this.nombreUnid = nombreUnid;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getNumeroCertificado() {
		return numeroCertificado;
	}
	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}
	public String getNumeroInforme() {
		return numeroInforme;
	}
	public void setNumeroInforme(String numeroInforme) {
		this.numeroInforme = numeroInforme;
	}
	public Date getFechaInforme() {
		return fechaInforme;
	}
	public void setFechaInforme(Date fechaInforme) {
		this.fechaInforme = fechaInforme;
	}
	public String getFlagInformeIndiceRiesgo() {
		return flagInformeIndiceRiesgo;
	}
	public void setFlagInformeIndiceRiesgo(String flagInformeIndiceRiesgo) {
		this.flagInformeIndiceRiesgo = flagInformeIndiceRiesgo;
	}
		
	//--------------------------
	
	/*public String getEstado2() {
		return estado2;
	}
	public void setEstado2(String estado2) {
		this.estado2 = estado2;
	}
	public String getEstado3() {
		return estado3;
	}
	public void setEstado3(String estado3) {
		this.estado3 = estado3;
	}
	public String getEstado4() {
		return estado4;
	}
	public void setEstado4(String estado4) {
		this.estado4 = estado4;
	}*/
}
