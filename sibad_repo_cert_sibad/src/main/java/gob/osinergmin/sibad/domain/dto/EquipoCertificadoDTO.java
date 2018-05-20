/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.util.Date;


/**
 *
 * @author jpiro
 */
public class EquipoCertificadoDTO {
	
	private Long idEquipoCertificado;
    private Long idAlcanceAcreditacion;
    private Long idTipoEquipo;
    private String tipoEquipo;
    private String descripcionEquipo;
    private String marca;
    private String modelo;
    private String serie;
    private String otroDato;
    private Date fechaCalibracion;
    private Date fechaProximaCalibracion;
    private String estado;
    private Long idTipoMotivo;
    private String observacion;
    
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
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}
	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getOtroDato() {
		return otroDato;
	}
	public void setOtroDato(String otroDato) {
		this.otroDato = otroDato;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Date getFechaCalibracion() {
		return fechaCalibracion;
	}
	public void setFechaCalibracion(Date fechaCalibracion) {
		this.fechaCalibracion = fechaCalibracion;
	}
	public Date getFechaProximaCalibracion() {
		return fechaProximaCalibracion;
	}
	public void setFechaProximaCalibracion(Date fechaProximaCalibracion) {
		this.fechaProximaCalibracion = fechaProximaCalibracion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdTipoMotivo() {
		return idTipoMotivo;
	}
	public void setIdTipoMotivo(Long idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	} 
}
