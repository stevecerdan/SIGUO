/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author 
 */
public class TipoEquipoDTO {
	
	private Long idTipoEquipo;
    private Long idEmpresaAcreditada;
    private Long idTipoPrueba;
    private String tipoEquipo;
    private String estadoAlcance;
    
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
	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getTipoEquipo() {
		return tipoEquipo;
	}
	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}
	public String getEstadoAlcance() {
		return estadoAlcance;
	}
	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}
    
}
