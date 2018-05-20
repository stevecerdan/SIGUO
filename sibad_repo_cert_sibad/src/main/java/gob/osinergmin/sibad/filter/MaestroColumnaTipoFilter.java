/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

/**
 *
 * @author
 */
public class MaestroColumnaTipoFilter extends BasePaginatorFilter{
    private Long idMaestroColumna;
    private String dominio;
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
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	
    
}
