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
public class EquipoCertificadoFilter extends BasePaginatorFilter{
	
	private Long idEquipoCertificado;
    private Long idAlcanceAcreditacion;
    private Date fechaProximaCalibracion;
    
    public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}
	public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public Date getFechaProximaCalibracion() {
		return fechaProximaCalibracion;
	}
	public void setFechaProximaCalibracion(Date fechaProximaCalibracion) {
		this.fechaProximaCalibracion = fechaProximaCalibracion;
	}
	
}
