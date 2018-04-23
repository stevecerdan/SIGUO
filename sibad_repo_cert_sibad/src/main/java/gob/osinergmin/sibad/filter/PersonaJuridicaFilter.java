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
public class PersonaJuridicaFilter extends BasePaginatorFilter{
    private Long idPersonaJuridica;
    private String ruc;
    
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
    
}
