package gob.osinergmin.sibad.domain.dto;

public class ResultadoPersonaNaturalDTO {
	private Long idResultadoPersonaNatural;
	private Long idResultadoRevision;
	private Long idPersonaNatural;
	private Long idTipoDocumento;
	private String tipoDocumento;
	private String numeroDocumento;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private String nombreCompleto;
	private String cip;
	private String telefono;
	
	public Long getIdResultadoPersonaNatural() {
		return idResultadoPersonaNatural;
	}
	
	public void setIdResultadoPersonaNatural(Long idResultadoPersonaNatural) {
		this.idResultadoPersonaNatural = idResultadoPersonaNatural;
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}
	
	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
	
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
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
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCip() {
		return cip;
	}
	
	public void setCip(String cip) {
		this.cip = cip;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}