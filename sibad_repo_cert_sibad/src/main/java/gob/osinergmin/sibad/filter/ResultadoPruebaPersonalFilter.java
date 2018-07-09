package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ResultadoPruebaPersonalFilter extends BasePaginatorFilter{

	private Long idResultadoPruebaPersonal;
	private Long idResultadoPruebaReprueba;
	private Long idSedePersonalAutorizado;
	
	public Long getIdResultadoPruebaPersonal() {
		return idResultadoPruebaPersonal;
	}
	public void setIdResultadoPruebaPersonal(Long idResultadoPruebaPersonal) {
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
	}
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}
	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}
	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
	
	
}
