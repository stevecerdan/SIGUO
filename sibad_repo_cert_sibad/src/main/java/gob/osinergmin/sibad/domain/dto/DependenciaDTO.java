package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;

public class DependenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idDependencia;
	private String nombre;
	private String estado;

	public Long getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Long idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
