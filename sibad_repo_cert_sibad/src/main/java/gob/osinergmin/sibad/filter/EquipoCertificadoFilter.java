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
    private Long idEmpresaAcreditada;
    private Long idTipoEquipo;
    
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
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}
	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}
	
}
