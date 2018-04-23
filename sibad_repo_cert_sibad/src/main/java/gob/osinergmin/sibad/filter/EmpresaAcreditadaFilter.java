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
    private String telefono;
    
    
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
    
	
}
