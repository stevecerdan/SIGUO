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
public class SedePersonalAutorizadoFilter extends BasePaginatorFilter{
	
	private Long idSedePersonalAutorizado;
	private Long idAlcanceAcreditacion;
	private String flagPersonalAutorizado;
	private String numeroDocumento;
	
	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}
	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public String getFlagPersonalAutorizado() {
		return flagPersonalAutorizado;
	}
	public void setFlagPersonalAutorizado(String flagPersonalAutorizado) {
		this.flagPersonalAutorizado = flagPersonalAutorizado;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}
