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
public class SedePersonalAutorizadoDTO {
	
	private Long idSedePersonalAutorizado;
	private Long idAlcanceAcreditacion;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String flagPersonalAutorizado;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long idCargo;
    private Long idEspecialidad;
    private String especialidadCargo;
    private Long cip;
    
   
    private String flagSedePersonalAutorizado;
    private Long idSedeAcreditacion;
    private Long idPersonaNatural;

    
	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}
	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getFlagPersonalAutorizado() {
		return flagPersonalAutorizado;
	}
	public void setFlagPersonalAutorizado(String flagPersonalAutorizado) {
		this.flagPersonalAutorizado = flagPersonalAutorizado;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public Long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}
	public Long getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getEspecialidadCargo() {
		return especialidadCargo;
	}
	public void setEspecialidadCargo(String especialidadCargo) {
		this.especialidadCargo = especialidadCargo;
	}
	public Long getCip() {
		return cip;
	}
	public void setCip(Long cip) {
		this.cip = cip;
	}
	public String getFlagSedePersonalAutorizado() {
		return flagSedePersonalAutorizado;
	}
	public void setFlagSedePersonalAutorizado(String flagSedePersonalAutorizado) {
		this.flagSedePersonalAutorizado = flagSedePersonalAutorizado;
	}
	public Long getIdSedeAcreditacion() {
		return idSedeAcreditacion;
	}
	public void setIdSedeAcreditacion(Long idSedeAcreditacion) {
		this.idSedeAcreditacion = idSedeAcreditacion;
	}
	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}
	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
	
	
}
