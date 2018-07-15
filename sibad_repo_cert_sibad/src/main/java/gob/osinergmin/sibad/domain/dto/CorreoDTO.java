package gob.osinergmin.sibad.domain.dto;

public class CorreoDTO {

	private Long idCorreo;
	private String codigoFuncionalidad;
	private String asunto;
	private String mensaje;
	
	public Long getIdCorreo() {
		return idCorreo;
	}
	public void setIdCorreo(Long idCorreo) {
		this.idCorreo = idCorreo;
	}
	public String getCodigoFuncionalidad() {
		return codigoFuncionalidad;
	}
	public void setCodigoFuncionalidad(String codigoFuncionalidad) {
		this.codigoFuncionalidad = codigoFuncionalidad;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
