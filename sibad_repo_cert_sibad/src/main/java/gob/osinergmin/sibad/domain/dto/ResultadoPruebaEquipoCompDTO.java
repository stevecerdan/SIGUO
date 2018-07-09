package gob.osinergmin.sibad.domain.dto;

import javax.persistence.Column;

public class ResultadoPruebaEquipoCompDTO {

    private Long idResultadoPruebaEquipoComp;
	private Long idResultadoPruebaReprueba;
	private Long idEquipoComponente;
	private String descripcionEquipo;
    private String tipoEquipo;
    private String componenteTanque;
	
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
	public String getDescripcionEquipo() {
		return descripcionEquipo;
	}
	public void setDescripcionEquipo(String descripcionEquipo) {
		this.descripcionEquipo = descripcionEquipo;
	}
	public String getTipoEquipo() {
		return tipoEquipo;
	}
	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}
	public String getComponenteTanque() {
		return componenteTanque;
	}
	public void setComponenteTanque(String componenteTanque) {
		this.componenteTanque = componenteTanque;
	}
	
}
