package gob.osinergmin.sibad.domain.dto;

public class PersonalSupervisionDTO {
	private Long idPersonal;
    private String nombreUsuarioSiged;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long idPersonalSiged;
    private String nombreCompleto;
    private String correoElectronico;
    private String numeroDocIdentidad;
    private String aplicacion;
	public Long getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(Long idPersonal) {
		this.idPersonal = idPersonal;
	}
	public String getNombreUsuarioSiged() {
		return nombreUsuarioSiged;
	}
	public void setNombreUsuarioSiged(String nombreUsuarioSiged) {
		this.nombreUsuarioSiged = nombreUsuarioSiged;
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
	public Long getIdPersonalSiged() {
		return idPersonalSiged;
	}
	public void setIdPersonalSiged(Long idPersonalSiged) {
		this.idPersonalSiged = idPersonalSiged;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getNumeroDocIdentidad() {
		return numeroDocIdentidad;
	}
	public void setNumeroDocIdentidad(String numeroDocIdentidad) {
		this.numeroDocIdentidad = numeroDocIdentidad;
	}
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

}
