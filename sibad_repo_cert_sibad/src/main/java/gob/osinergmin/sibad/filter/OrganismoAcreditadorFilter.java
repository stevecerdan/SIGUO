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
public class OrganismoAcreditadorFilter extends BasePaginatorFilter{
	
	private Long idOrganismoAcreditador;

	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}

	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}
    
}
