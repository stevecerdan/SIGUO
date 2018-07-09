package gob.osinergmin.sibad.domain.dto;

public class UnidadSupervisadaVDTO {

    private Long idUnidadSupervisada;
    private String nombreUnidad;   
    private String direccion;  
    private Long idEmpresaSupervisada;
    private String numeroIdentificacion;   
    private String razonSocial;
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getIdEmpresaSupervisada() {
		return idEmpresaSupervisada;
	}
	public void setIdEmpresaSupervisada(Long idEmpresaSupervisada) {
		this.idEmpresaSupervisada = idEmpresaSupervisada;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}     
}
