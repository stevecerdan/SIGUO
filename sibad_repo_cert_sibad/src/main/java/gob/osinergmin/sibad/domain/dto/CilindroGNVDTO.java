package gob.osinergmin.sibad.domain.dto;

public class CilindroGNVDTO {
	private Long idCilindro;
	private Long idModulo;
	private Long idUnidadSupervisada;
	private Long numero;
	private String numeroSerie;
	private String estado;
	public Long getIdCilindro() {
		return idCilindro;
	}
	public void setIdCilindro(Long idCilindro) {
		this.idCilindro = idCilindro;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
