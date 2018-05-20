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
    
}
