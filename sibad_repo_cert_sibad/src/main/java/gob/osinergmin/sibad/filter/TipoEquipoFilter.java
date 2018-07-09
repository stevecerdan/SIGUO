/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

/*
 * @author
 */

public class TipoEquipoFilter extends BasePaginatorFilter{
	
    private Long idTipoEquipo;
    private Long idEmpresaAcreditada;
    
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}
	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
     
}
