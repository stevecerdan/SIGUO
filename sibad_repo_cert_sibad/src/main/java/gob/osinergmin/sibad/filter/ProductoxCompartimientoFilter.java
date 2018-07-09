package gob.osinergmin.sibad.filter;

import javax.persistence.Column;

public class ProductoxCompartimientoFilter {
	private Long idCompartimiento;
	private Long idResultadoRevision;
	private Long idProgramacion;
	private Long idAlmacenamiento;
	private Long idUnidMediCompartimiento;
	
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}
	
	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	public Long getIdUnidMediCompartimiento() {
		return idUnidMediCompartimiento;
	}
	public void setIdUnidMediCompartimiento(Long idUnidMediCompartimiento) {
		this.idUnidMediCompartimiento = idUnidMediCompartimiento;
	}
	
}
