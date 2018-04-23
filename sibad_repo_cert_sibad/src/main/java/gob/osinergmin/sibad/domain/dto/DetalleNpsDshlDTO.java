package gob.osinergmin.sibad.domain.dto;

public class DetalleNpsDshlDTO {
	
	private Long item;	
	private String baseLegal;
	private String incumplimiento;	
	private Long idDetalleSupervision;
	private boolean tieneMediosProbatorios;
	
	public Long getItem() {
		return item;
	}
	public void setItem(Long item) {
		this.item = item;
	}
	public String getBaseLegal() {
		return baseLegal;
	}
	public void setBaseLegal(String baseLegal) {
		this.baseLegal = baseLegal;
	}
	public String getIncumplimiento() {
		return incumplimiento;
	}
	public void setIncumplimiento(String incumplimiento) {
		this.incumplimiento = incumplimiento;
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
	
}
