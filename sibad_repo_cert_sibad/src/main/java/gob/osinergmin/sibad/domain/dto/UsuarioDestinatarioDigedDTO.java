package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;

public class UsuarioDestinatarioDigedDTO implements Serializable{
	
	String codigoActividad;
	String usuarioPrincipal;
	String usuarioSecundario;

	
	
	
	public String getCodigoActividad() {
		return codigoActividad;
	}
	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}
	public String getUsuarioPrincipal() {
		return usuarioPrincipal;
	}
	public void setUsuarioPrincipal(String usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}
	public String getUsuarioSecundario() {
		return usuarioSecundario;
	}
	public void setUsuarioSecundario(String usuarioSecundario) {
		this.usuarioSecundario = usuarioSecundario;
	}

}
