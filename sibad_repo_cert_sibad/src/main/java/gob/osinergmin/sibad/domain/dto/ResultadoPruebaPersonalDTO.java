package gob.osinergmin.sibad.domain.dto;

public class ResultadoPruebaPersonalDTO {

    private Long idResultadoPruebaPersonal;
	private Long idResultadoPruebaReprueba;
	private Long idSedePersonalAutorizado;
	
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	
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
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	
}
