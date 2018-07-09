/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class EmpresaAcreditadaFilter extends BasePaginatorFilter{
	
	private Long idAlcanceAcreditacion;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String estadoEmpresa;
    private String estadoAccion;
    private String estadoAlcance;
    private Long idOrganismoAcreditador;
    private String idTipoPrueba;
    private String email;
    
    private Long idEmpresaAcreditada;
    private Long idPersonaJuridica;
    private String estado;
    
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
	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}
	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}
	public String getEstadoAccion() {
		return estadoAccion;
	}
	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}
	public String getEstadoAlcance() {
		return estadoAlcance;
	}
	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}
	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}
	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}
	public String getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(String idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	//-----
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
