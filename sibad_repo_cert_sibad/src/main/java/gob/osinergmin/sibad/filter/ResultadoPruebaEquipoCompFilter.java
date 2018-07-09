package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class ResultadoPruebaEquipoCompFilter extends BasePaginatorFilter{

	private Long idResultadoPruebaEquipoComp;
	private Long idResultadoPruebaReprueba;
	private Long idEquipoComponente;
	
	public Long getIdResultadoPruebaEquipoComp() {
		return idResultadoPruebaEquipoComp;
	}
	public void setIdResultadoPruebaEquipoComp(Long idResultadoPruebaEquipoComp) {
		this.idResultadoPruebaEquipoComp = idResultadoPruebaEquipoComp;
	}
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}
	public Long getIdEquipoComponente() {
		return idEquipoComponente;
	}
	public void setIdEquipoComponente(Long idEquipoComponente) {
		this.idEquipoComponente = idEquipoComponente;
	}
	
}
