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
public class SedeAcreditacionFilter extends BasePaginatorFilter{
    
	private Long idSedeAcreditacion;
	private Long idAlcanceAcreditacion;
    private String estado;
    
	public Long getIdSedeAcreditacion() {
		return idSedeAcreditacion;
	}
	public void setIdSedeAcreditacion(Long idSedeAcreditacion) {
		this.idSedeAcreditacion = idSedeAcreditacion;
	}
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
