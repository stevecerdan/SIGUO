package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;
import java.util.List;

public class UnidadSupervisadaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private Long idUnidadSupervisada;
    private String codigoOsinergminUnidadSupervisada;
    private String nombreUnidadSupervisada;
    private String rucUnidadSupervisada;
    private Long idSector;
    private String codigoSector;
    private String nombreSector;
    private Long idSubsector;
    private String codigoSubsector;
    private String nombreSubsector;
    private Long idActividad;
    private String codigoActividad;
    private String nombreActividad;
    private Long idTipoAgente;
    private String codigoTipoAgente;
    private String nombreTipoAgente;
    private Long idUnidadOrganica;
    private String estadoUnidadSupervisada;
    private List<String> codigosOsinergminPermitidos;

	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public String getCodigoOsinergminUnidadSupervisada() {
		return codigoOsinergminUnidadSupervisada;
	}

	public void setCodigoOsinergminUnidadSupervisada(
			String codigoOsinergminUnidadSupervisada) {
		this.codigoOsinergminUnidadSupervisada = codigoOsinergminUnidadSupervisada;
	}

	public String getNombreUnidadSupervisada() {
		return nombreUnidadSupervisada;
	}

	public void setNombreUnidadSupervisada(String nombreUnidadSupervisada) {
		this.nombreUnidadSupervisada = nombreUnidadSupervisada;
	}

	public String getRucUnidadSupervisada() {
		return rucUnidadSupervisada;
	}

	public void setRucUnidadSupervisada(String rucUnidadSupervisada) {
		this.rucUnidadSupervisada = rucUnidadSupervisada;
	}

	public Long getIdSector() {
		return idSector;
	}

	public void setIdSector(Long idSector) {
		this.idSector = idSector;
	}

	public String getCodigoSector() {
		return codigoSector;
	}

	public void setCodigoSector(String codigoSector) {
		this.codigoSector = codigoSector;
	}

	public String getNombreSector() {
		return nombreSector;
	}

	public void setNombreSector(String nombreSector) {
		this.nombreSector = nombreSector;
	}

	public Long getIdSubsector() {
		return idSubsector;
	}

	public void setIdSubsector(Long idSubsector) {
		this.idSubsector = idSubsector;
	}

	public String getCodigoSubsector() {
		return codigoSubsector;
	}

	public void setCodigoSubsector(String codigoSubsector) {
		this.codigoSubsector = codigoSubsector;
	}

	public String getNombreSubsector() {
		return nombreSubsector;
	}

	public void setNombreSubsector(String nombreSubsector) {
		this.nombreSubsector = nombreSubsector;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public Long getIdTipoAgente() {
		return idTipoAgente;
	}

	public void setIdTipoAgente(Long idTipoAgente) {
		this.idTipoAgente = idTipoAgente;
	}

	public String getCodigoTipoAgente() {
		return codigoTipoAgente;
	}

	public void setCodigoTipoAgente(String codigoTipoAgente) {
		this.codigoTipoAgente = codigoTipoAgente;
	}

	public String getNombreTipoAgente() {
		return nombreTipoAgente;
	}

	public void setNombreTipoAgente(String nombreTipoAgente) {
		this.nombreTipoAgente = nombreTipoAgente;
	}

	public Long getIdUnidadOrganica() {
		return idUnidadOrganica;
	}

	public void setIdUnidadOrganica(Long idUnidadOrganica) {
		this.idUnidadOrganica = idUnidadOrganica;
	}

	public String getEstadoUnidadSupervisada() {
		return estadoUnidadSupervisada;
	}

	public void setEstadoUnidadSupervisada(String estadoUnidadSupervisada) {
		this.estadoUnidadSupervisada = estadoUnidadSupervisada;
	}
	
	public List<String> getCodigosOsinergminPermitidos() {
		return codigosOsinergminPermitidos;
	}

	public void setCodigosOsinergminPermitidos(
			List<String> codigosOsinergminPermitidos) {
		this.codigosOsinergminPermitidos = codigosOsinergminPermitidos;
	}

	@Override
    public String toString() {
        return "UnidadSupervisadaDTO{" + "idUnidadSupervisada=" + idUnidadSupervisada + '}';
    }

}
