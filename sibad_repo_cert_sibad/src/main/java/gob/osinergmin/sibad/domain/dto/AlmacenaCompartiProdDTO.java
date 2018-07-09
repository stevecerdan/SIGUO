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
public class AlmacenaCompartiProdDTO {
	
	private Long idProductoXCompartimiento;
	private Long idUnidSupervTanque;
	private Long idAlmacenamiento;
	private String numeroTanque;
	private Long idCompartimiento;
	private Long numeroCompartimiento;
	private Long capacidad;
	private Long idProducto;
	private String nombreLargoProducto;
	private Date fechaProxPrueba;
	private Long idUnidadMedida;
	private String descripcionMedida;
	private String abreviaturaMedida;
	private String numero;
	
	public Long getIdProductoXCompartimiento() {
		return idProductoXCompartimiento;
	}
	public void setIdProductoXCompartimiento(Long idProductoXCompartimiento) {
		this.idProductoXCompartimiento = idProductoXCompartimiento;
	}
	public Long getIdUnidSupervTanque() {
		return idUnidSupervTanque;
	}
	public void setIdUnidSupervTanque(Long idUnidSupervTanque) {
		this.idUnidSupervTanque = idUnidSupervTanque;
	}
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}
	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	public String getNumeroTanque() {
		return numeroTanque;
	}
	public void setNumeroTanque(String numeroTanque) {
		this.numeroTanque = numeroTanque;
	}
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	public Long getNumeroCompartimiento() {
		return numeroCompartimiento;
	}
	public void setNumeroCompartimiento(Long numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}
	public Long getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreLargoProducto() {
		return nombreLargoProducto;
	}
	public void setNombreLargoProducto(String nombreLargoProducto) {
		this.nombreLargoProducto = nombreLargoProducto;
	}
	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}
	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	}
	public Long getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(Long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public String getDescripcionMedida() {
		return descripcionMedida;
	}
	public void setDescripcionMedida(String descripcionMedida) {
		this.descripcionMedida = descripcionMedida;
	}
	public String getAbreviaturaMedida() {
		return abreviaturaMedida;
	}
	public void setAbreviaturaMedida(String abreviaturaMedida) {
		this.abreviaturaMedida = abreviaturaMedida;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
