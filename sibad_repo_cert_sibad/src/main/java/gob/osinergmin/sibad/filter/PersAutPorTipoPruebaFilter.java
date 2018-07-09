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
public class PersAutPorTipoPruebaFilter extends BasePaginatorFilter{
	
	private Long idEmpresaAcreditada;
	private String idTipoPrueba;
	private String flagSedePersonalAutoriazado;
		
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	public String getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(String idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getFlagSedePersonalAutoriazado() {
		return flagSedePersonalAutoriazado;
	}
	public void setFlagSedePersonalAutoriazado(String flagSedePersonalAutoriazado) {
		this.flagSedePersonalAutoriazado = flagSedePersonalAutoriazado;
	}
	
}
