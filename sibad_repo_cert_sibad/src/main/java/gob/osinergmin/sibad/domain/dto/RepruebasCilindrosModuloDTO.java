package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

import javax.persistence.Column;


public class RepruebasCilindrosModuloDTO {
	private Long idModulo;
	private Long idUnidSuperv;
    private String idCilindro;
	private String codigoOsinerg;
    private String nombreUnidad;
    private String nroModulo;
    private String nroCilindro;
    private String numeroSerie;
    private Date fechaProximaRep; 
    
    public String getCodigoOsinerg() {
		return codigoOsinerg;
	}
    public void setCodigoOsinerg(String codigoOsinerg) {
		this.codigoOsinerg = codigoOsinerg;
	}
    public Long getIdUnidSuperv() {
		return idUnidSuperv;
	}
    public void setIdUnidSuperv(Long idUnidSuperv) {
		this.idUnidSuperv = idUnidSuperv;
	}
    public String getNumeroSerie() {
		return numeroSerie;
	}
    public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
    public Date getFechaProximaRep() {
		return fechaProximaRep;
	}
    public void setFechaProximaRep(Date fechaProximaRep) {
		this.fechaProximaRep = fechaProximaRep;
	}
    public String getNombreUnidad() {
		return nombreUnidad;
	}
    public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
    public String getNroCilindro() {
		return nroCilindro;
	}
    public void setNroCilindro(String nroCilindro) {
		this.nroCilindro = nroCilindro;
	}
    public String getNroModulo() {
		return nroModulo;
	}
    public void setNroModulo(String nroModulo) {
		this.nroModulo = nroModulo;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public String getIdCilindro() {
		return idCilindro;
	}
	public void setIdCilindro(String idCilindro) {
		this.idCilindro = idCilindro;
	}
	
}
