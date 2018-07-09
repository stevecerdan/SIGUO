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
public class PersonaNaturalVFilter extends BasePaginatorFilter{
    
	private Long idPersonaNatural;
    private String numeroDoc;
    private Long cip;
	
    public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}
	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	public Long getCip() {
		return cip;
	}
	public void setCip(Long cip) {
		this.cip = cip;
	}
    
}
