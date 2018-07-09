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
 * @author 
 */
public class TipoPruebaOrganismoDTO {
	
	private Long idTipoPrueba;
    private String descripcion;
    private Long idOrganismoAcreditador;
    private String razonSocial;
    
	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}
	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
    
}
