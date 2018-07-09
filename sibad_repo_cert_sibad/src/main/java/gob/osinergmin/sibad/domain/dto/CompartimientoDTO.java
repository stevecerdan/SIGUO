package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class CompartimientoDTO {
	
	private Long idCompartimiento;
	private String estado;
	private Long numero; 
	private Long idAlmacenamiento; 
	private Long capacidad;
	private String idUnidMediCompartimiento;
	private Date fechaProximaPrueba;

	//Vita Compartimiento
	private Long idUnidadSupervisada;
	private String numeroProgramacion;
	
	
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}
	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	public Long getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}
	public String getIdUnidMediCompartimiento() {
		return idUnidMediCompartimiento;
	}
	public void setIdUnidMediCompartimiento(String idUnidMediCompartimiento) {
		this.idUnidMediCompartimiento = idUnidMediCompartimiento;
	}
	public Date getFechaProximaPrueba() {
		return fechaProximaPrueba;
	}
	public void setFechaProximaPrueba(Date fechaProximaPrueba) {
		this.fechaProximaPrueba = fechaProximaPrueba;
	}
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public String getNumeroProgramacion() {
		return numeroProgramacion;
	}
	public void setNumeroProgramacion(String numeroProgramacion) {
		this.numeroProgramacion = numeroProgramacion;
	}
	
}
