package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class DestinatarioCorreoFilter extends BasePaginatorFilter{

	private Long idDestinatarioCorreo;
	private Long idCorreo;
	private Long idPersonal;
	
	public Long getIdDestinatarioCorreo() {
		return idDestinatarioCorreo;
	}
	public void setIdDestinatarioCorreo(Long idDestinatarioCorreo) {
		this.idDestinatarioCorreo = idDestinatarioCorreo;
	}
	public Long getIdCorreo() {
		return idCorreo;
	}
	public void setIdCorreo(Long idCorreo) {
		this.idCorreo = idCorreo;
	}
	public Long getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(Long idPersonal) {
		this.idPersonal = idPersonal;
	}
	
}
