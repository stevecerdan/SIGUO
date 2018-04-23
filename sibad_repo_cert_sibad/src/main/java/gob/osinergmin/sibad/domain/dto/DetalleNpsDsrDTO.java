package gob.osinergmin.sibad.domain.dto;

import java.util.List;

public class DetalleNpsDsrDTO {
	
	private Long item;	
	private String infraccion;
	private String escenario;
	private Long rowSpanInfraccion;
	private Long rowSpanEscenario;
	private Long prioridad;
	private Long idDetalleSupervision;
	private boolean tieneMediosProbatorios; 
	private List<String> comentarios;
	private String condicionVerificada;
	
	public Long getItem() {
		return item;
	}
	public void setItem(Long item) {
		this.item = item;
	}
	public String getInfraccion() {
		return infraccion;
	}
	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}
	public String getEscenario() {
		return escenario;
	}
	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}
	public Long getRowSpanInfraccion() {
		return rowSpanInfraccion;
	}
	public void setRowSpanInfraccion(Long rowSpanInfraccion) {
		this.rowSpanInfraccion = rowSpanInfraccion;
	}
	public Long getRowSpanEscenario() {
		return rowSpanEscenario;
	}
	public void setRowSpanEscenario(Long rowSpanEscenario) {
		this.rowSpanEscenario = rowSpanEscenario;
	}
	public List<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}
	public Long getIdDetalleSupervision() {
		return idDetalleSupervision;
	}
	public void setIdDetalleSupervision(Long idDetalleSupervision) {
		this.idDetalleSupervision = idDetalleSupervision;
	}
	public boolean isTieneMediosProbatorios() {
		return tieneMediosProbatorios;
	}
	public void setTieneMediosProbatorios(boolean tieneMediosProbatorios) {
		this.tieneMediosProbatorios = tieneMediosProbatorios;
	}
	public Long getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}
	public String getCondicionVerificada() {
		return condicionVerificada;
	}
	public void setCondicionVerificada(String condicionVerificada) {
		this.condicionVerificada = condicionVerificada;
	}
	
}
