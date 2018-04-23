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
public class EmpresaAcreditadaDTO {
	private Long idAlcanceAcreditacion;
	private String ruc;
    private String razonSocial;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String telefono;
    private String email;
    private String web;
    private String resolucionCedula;
    private Date fechaIVigencia;
    private Date fechaUActualizacion;
    private Date fechaAcreditacion;
    private Date fechaVencimiento;
    private String tipoOrganismo;
    private String tipoPrueba;
    private String registro;
    private String estadoEmpresa;
    private String estadoAlcance;

	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getResolucionCedula() {
		return resolucionCedula;
	}

	public void setResolucionCedula(String resolucionCedula) {
		this.resolucionCedula = resolucionCedula;
	}

	public Date getFechaIVigencia() {
		return fechaIVigencia;
	}

	public void setFechaIVigencia(Date fechaIVigencia) {
		this.fechaIVigencia = fechaIVigencia;
	}

	public Date getFechaUActualizacion() {
		return fechaUActualizacion;
	}

	public void setFechaUActualizacion(Date fechaUActualizacion) {
		this.fechaUActualizacion = fechaUActualizacion;
	}

	public Date getFechaAcreditacion() {
		return fechaAcreditacion;
	}

	public void setFechaAcreditacion(Date fechaAcreditacion) {
		this.fechaAcreditacion = fechaAcreditacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoOrganismo() {
		return tipoOrganismo;
	}

	public void setTipoOrganismo(String tipoOrganismo) {
		this.tipoOrganismo = tipoOrganismo;
	}

	public String getTipoPrueba() {
		return tipoPrueba;
	}

	public void setTipoPrueba(String tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}

	
}
