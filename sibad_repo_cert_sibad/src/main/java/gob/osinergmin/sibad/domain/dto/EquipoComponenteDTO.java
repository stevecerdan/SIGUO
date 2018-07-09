/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author jpiro
 */
public class EquipoComponenteDTO {
	
	private Long idEquipoComponente;
	private Long idEquipoCertificado;
	private Long idComponenteTanque;
    private String componenteTanque;
    
    private Long idTipoEquipo;
    private Long idEmpresaAcreditada;
    private Long idTipoPrueba;
    private String estadoAlcance;
    private String estadoEquipo;
    private String tipoEquipo;
    private String descripcionEquipo;
    
	public Long getIdEquipoComponente() {
		return idEquipoComponente;
	}
	public void setIdEquipoComponente(Long idEquipoComponente) {
		this.idEquipoComponente = idEquipoComponente;
	}
	public String getComponenteTanque() {
		return componenteTanque;
	}
	public void setComponenteTanque(String componenteTanque) {
		this.componenteTanque = componenteTanque;
	}
	
	public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}
	
	public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}
	public Long getIdComponenteTanque() {
		return idComponenteTanque;
	}
	public void setIdComponenteTanque(Long idComponenteTanque) {
		this.idComponenteTanque = idComponenteTanque;
	}
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
	public String getEstadoAlcance() {
		return estadoAlcance;
	}
	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}
	public String getEstadoEquipo() {
		return estadoEquipo;
	}
	public void setEstadoEquipo(String estadoEquipo) {
		this.estadoEquipo = estadoEquipo;
	}
	public String getTipoEquipo() {
		return tipoEquipo;
	}
	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}
	public String getDescripcionEquipo() {
		return descripcionEquipo;
	}
	public void setDescripcionEquipo(String descripcionEquipo) {
		this.descripcionEquipo = descripcionEquipo;
	}
    
}
