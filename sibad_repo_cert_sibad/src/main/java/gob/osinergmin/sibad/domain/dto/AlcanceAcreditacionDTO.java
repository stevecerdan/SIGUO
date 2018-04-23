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
 * @author jpiro
 */
public class AlcanceAcreditacionDTO {
	private Long idAlcanceAcreditacion;
    private Long idTipoPrueba;
    private String resolucionCedula;
    private String registro;
    private Date fechaUActualizacion;
    private Date fechaAcreditacion;
    private Date fechaVencimiento;
    private String estado;
    
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getResolucionCedula() {
		return resolucionCedula;
	}
	public void setResolucionCedula(String resolucionCedula) {
		this.resolucionCedula = resolucionCedula;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public Date getFechaUActualizacion() {
		return fechaUActualizacion;
	}
	public void setFechaUActualizacion(Date fechaUActualizacion) {
		this.fechaUActualizacion = fechaUActualizacion;
	}
	public Date getFechaAcreditacion() {
		return fechaAcreditacion;
	}
	public void setFechaAcreditacion(Date fechaAcreditacion) {
		this.fechaAcreditacion = fechaAcreditacion;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}
