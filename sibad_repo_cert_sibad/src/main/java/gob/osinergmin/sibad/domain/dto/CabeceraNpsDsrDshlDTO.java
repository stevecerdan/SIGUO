package gob.osinergmin.sibad.domain.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CabeceraNpsDsrDshlDTO {
	
	public static final SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 
	
	private String codigoOsinergmin;
	private String nroExpediente;
	private Date fechaInicioSupervision;
	private Date fechaFinSupervision;
	private String fechaInicioSupervisionString;
	private String fechaFinSupervisionString;
	private String codigoActividad;
	private String nombreActividad;
	private String tipoSupervision;
	private String resultado;
	private String nroOrdenServicio;
	private Long idSupervision;
	private Long codigoResultado;
	private String rho;
	private String codigoMedidaSeguridadEjecutada;
	private String nombreMedidaSeguridadEjecutada;
	private String productosScopSuspendidos;
	private String nombreEmpresaSupervisora;
	private String nombreSupervisor;
	private String nombreEspecialistaOsinergmin;
	private String nombreUnidadOrganicaOsinergmin;
	private Date fechaLimiteMedidaSeguridadEjecutada;
	private String fechaLimiteMedidaSeguridadEjecutadaString;
	private Long idActividad;
	
	public String getCodigoOsinergmin() {
		return codigoOsinergmin;
	}

	public void setCodigoOsinergmin(String codigoOsinergmin) {
		this.codigoOsinergmin = codigoOsinergmin;
	}

	public String getNroExpediente() {
		return nroExpediente;
	}

	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}

	public Date getFechaInicioSupervision() {
		return fechaInicioSupervision;
	}

	public void setFechaInicioSupervision(Date fechaInicioSupervision) {
		this.fechaInicioSupervision = fechaInicioSupervision;
	}

	public Date getFechaFinSupervision() {
		return fechaFinSupervision;
	}

	public void setFechaFinSupervision(Date fechaFinSupervision) {
		this.fechaFinSupervision = fechaFinSupervision;
	}

	public String getFechaInicioSupervisionString() {
		return fechaInicioSupervisionString;
	}

	public void setFechaInicioSupervisionString(String fechaInicioSupervisionString) {
		this.fechaInicioSupervisionString = fechaInicioSupervisionString;
	}

	public String getFechaFinSupervisionString() {
		return fechaFinSupervisionString;
	}

	public void setFechaFinSupervisionString(String fechaFinSupervisionString) {
		this.fechaFinSupervisionString = fechaFinSupervisionString;
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

	public String getTipoSupervision() {
		return tipoSupervision;
	}

	public void setTipoSupervision(String tipoSupervision) {
		this.tipoSupervision = tipoSupervision;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getNroOrdenServicio() {
		return nroOrdenServicio;
	}

	public void setNroOrdenServicio(String nroOrdenServicio) {
		this.nroOrdenServicio = nroOrdenServicio;
	}

	public Long getIdSupervision() {
		return idSupervision;
	}

	public void setIdSupervision(Long idSupervision) {
		this.idSupervision = idSupervision;
	}

	public Long getCodigoResultado() {
		return codigoResultado;
	}

	public void setCodigoResultado(Long codigoResultado) {
		this.codigoResultado = codigoResultado;
	}

	public String getRho() {
		return rho;
	}

	public void setRho(String rho) {
		this.rho = rho;
	}

	public String getCodigoMedidaSeguridadEjecutada() {
		return codigoMedidaSeguridadEjecutada;
	}

	public void setCodigoMedidaSeguridadEjecutada(
			String codigoMedidaSeguridadEjecutada) {
		this.codigoMedidaSeguridadEjecutada = codigoMedidaSeguridadEjecutada;
	}

	public String getNombreMedidaSeguridadEjecutada() {
		return nombreMedidaSeguridadEjecutada;
	}

	public void setNombreMedidaSeguridadEjecutada(
			String nombreMedidaSeguridadEjecutada) {
		this.nombreMedidaSeguridadEjecutada = nombreMedidaSeguridadEjecutada;
	}

	public String getProductosScopSuspendidos() {
		return productosScopSuspendidos;
	}

	public void setProductosScopSuspendidos(String productosScopSuspendidos) {
		this.productosScopSuspendidos = productosScopSuspendidos;
	}

	public String getNombreEmpresaSupervisora() {
		return nombreEmpresaSupervisora;
	}

	public void setNombreEmpresaSupervisora(String nombreEmpresaSupervisora) {
		this.nombreEmpresaSupervisora = nombreEmpresaSupervisora;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public String getNombreEspecialistaOsinergmin() {
		return nombreEspecialistaOsinergmin;
	}

	public void setNombreEspecialistaOsinergmin(String nombreEspecialistaOsinergmin) {
		this.nombreEspecialistaOsinergmin = nombreEspecialistaOsinergmin;
	}

	public String getNombreUnidadOrganicaOsinergmin() {
		return nombreUnidadOrganicaOsinergmin;
	}

	public void setNombreUnidadOrganicaOsinergmin(
			String nombreUnidadOrganicaOsinergmin) {
		this.nombreUnidadOrganicaOsinergmin = nombreUnidadOrganicaOsinergmin;
	}

	public String getFechaInicioSupervisionCadena() {
		if(fechaInicioSupervision!=null){
			return DF.format(fechaInicioSupervision);
		}else{
			return null;
		}
	}

	public String getFechaFinSupervisionCadena() {
		if(fechaFinSupervision!=null){
			return DF.format(fechaFinSupervision);
		}else{
			return null;
		}
	}

	public Date getFechaLimiteMedidaSeguridadEjecutada() {
		return fechaLimiteMedidaSeguridadEjecutada;
	}

	public void setFechaLimiteMedidaSeguridadEjecutada(
			Date fechaLimiteMedidaSeguridadEjecutada) {
		this.fechaLimiteMedidaSeguridadEjecutada = fechaLimiteMedidaSeguridadEjecutada;
	}
	
	public String getFechaLimiteMedidaSeguridadEjecutadaCadena() {
		if(this.fechaLimiteMedidaSeguridadEjecutada!=null){
			return DF.format(this.fechaLimiteMedidaSeguridadEjecutada);
		}else{
			return null;
		}
	}

	public String getFechaLimiteMedidaSeguridadEjecutadaString() {
		return fechaLimiteMedidaSeguridadEjecutadaString;
	}

	public void setFechaLimiteMedidaSeguridadEjecutadaString(
			String fechaLimiteMedidaSeguridadEjecutadaString) {
		this.fechaLimiteMedidaSeguridadEjecutadaString = fechaLimiteMedidaSeguridadEjecutadaString;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	
}
