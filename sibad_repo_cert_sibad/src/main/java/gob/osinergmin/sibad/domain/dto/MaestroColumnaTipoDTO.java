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
public class MaestroColumnaTipoDTO {
	private Long idMaestroColumna;
    private String dominio;
    private String descripcion;
    private String aplicacion;
    
	public Long getIdMaestroColumna() {
		return idMaestroColumna;
	}
	public void setIdMaestroColumna(Long idMaestroColumna) {
		this.idMaestroColumna = idMaestroColumna;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
    
}
