package gob.osinergmin.sibad.domain.dto;

import java.util.Date;


public class SibadNotaDTO {
	
	private long id;
	private String estdo;
	private String detalle;
	private Date fchaCrcion;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEstdo() {
		return estdo;
	}
	public void setEstdo(String estdo) {
		this.estdo = estdo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Date getFchaCrcion() {
		return fchaCrcion;
	}
	public void setFchaCrcion(Date fchaCrcion) {
		this.fchaCrcion = fchaCrcion;
	}
	public String getUsrCrdor() {
		return usrCrdor;
	}
	public void setUsrCrdor(String usrCrdor) {
		this.usrCrdor = usrCrdor;
	}
	private String usrCrdor;

}
