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
public class TrazSolicitudFilter extends BasePaginatorFilter{
	
	private Long idTrazSolicitud;
	private Long idSolicitudPruebaReprueba;
    private String estado;
    
	
	public Long getIdTrazSolicitud() {
		return idTrazSolicitud;
	}
	public void setIdTrazSolicitud(Long idTrazSolicitud) {
		this.idTrazSolicitud = idTrazSolicitud;
	}
	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}
	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
