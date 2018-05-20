package gob.osinergmin.sibad.domain.dto;

import javax.persistence.Column;

public class EquipoComponenteCrudDTO {

	private Long idEquipoComponente;
	private Long idEquipoCertificado;
	private Long idEquipoTanque;
	
	public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}
	public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}
	public Long getIdEquipoComponente() {
		return idEquipoComponente;
	}
	public void setIdEquipoComponente(Long idEquipoComponente) {
		this.idEquipoComponente = idEquipoComponente;
	}
	public Long getIdEquipoTanque() {
		return idEquipoTanque;
	}
	public void setIdEquipoTanque(Long idEquipoTanque) {
		this.idEquipoTanque = idEquipoTanque;
	}
}
