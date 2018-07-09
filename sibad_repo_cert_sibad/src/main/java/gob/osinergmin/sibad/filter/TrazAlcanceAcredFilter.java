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
public class TrazAlcanceAcredFilter extends BasePaginatorFilter{
	
	private Long idTrazAlcanceAcred;
	private Long idAlcanceAcreditacion;
    private String estadoAccion;
    
	public Long getIdTrazAlcanceAcred() {
		return idTrazAlcanceAcred;
	}
	public void setIdTrazAlcanceAcred(Long idTrazAlcanceAcred) {
		this.idTrazAlcanceAcred = idTrazAlcanceAcred;
	}
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public String getEstadoAccion() {
		return estadoAccion;
	}
	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}
	
}
