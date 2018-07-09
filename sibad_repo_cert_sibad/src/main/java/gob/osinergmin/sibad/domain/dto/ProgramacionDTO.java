package gob.osinergmin.sibad.domain.dto;

import java.util.Date;


public class ProgramacionDTO {
	
	 private Long idProgramacion;
	 private String numeroProgramacion; 
	 private String tipoProgramacion; 
	 private String tipoRevision; 
	 private Date fechaProgramacion; 
	 private Long idCompartimiento; 
	 private String estado;
    
	 
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public String getNumeroProgramacion() {
		return numeroProgramacion;
	}
	public void setNumeroProgramacion(String numeroProgramacion) {
		this.numeroProgramacion = numeroProgramacion;
	}
	public String getTipoProgramacion() {
		return tipoProgramacion;
	}
	public void setTipoProgramacion(String tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}
	public String getTipoRevision() {
		return tipoRevision;
	}
	public void setTipoRevision(String tipoRevision) {
		this.tipoRevision = tipoRevision;
	}
	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
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

}
