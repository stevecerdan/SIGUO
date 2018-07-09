package gob.osinergmin.sibad.filter;

public class CompartAlmacenamientoFilter {
	private Long idAlmacenamiento;
	private Long idUnidadSupervisada;
	private String numeroSerie;
	private Long idCompartimiento;
	private String numero;
	
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
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
