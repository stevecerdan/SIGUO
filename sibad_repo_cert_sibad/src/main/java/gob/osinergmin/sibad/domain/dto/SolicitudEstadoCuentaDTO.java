package gob.osinergmin.sibad.domain.dto;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class SolicitudEstadoCuentaDTO implements Serializable{
	
    private Long idSolicitud;
    private Long idUnidadOperativa;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private Long cmbDepartamento;
    private Long idProvincia;
    private Long idDistrito; 
    private String telefono;
    private String correo;
    private Long idListadoDependencias;
    private String codigoOsinergmin;
    private String radiosetPeriodo;
    private String fechaInicio;
    private String fechaFin;
    
    private String numeroExpediente;
    private String estadoRegistro;
    private String fechaPresentacion;
    private String departamento;
    private String provincia;
    private String distrito;
    private long estado;
    private String actividad;
    private String codigoActividad;
    private String idTipoPeriodo;
    
    private long heditarUO;
    private long numeroSolicitud;
    private long dependenciaId;
    private long notaId;
    private String notaDetalle;
     //siged
    private String nombreDocumento;
    private List<File> listaArchivosSiged;

    private String correoEle;
    private String descDep;
    private String fechaEmision;
    
    

	public void setTipoPrdo(String tipoPrdo) {
		this.tipoPrdo = tipoPrdo;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Long getIdUnidadOperativa() {
		return idUnidadOperativa;
	}

	public void setIdUnidadOperativa(Long idUnidadOperativa) {
		this.idUnidadOperativa = idUnidadOperativa;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getCmbDepartamento() {
		return cmbDepartamento;
	}

	public void setCmbDepartamento(Long cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getIdListadoDependencias() {
		return idListadoDependencias;
	}

	public void setIdListadoDependencias(Long idListadoDependencias) {
		this.idListadoDependencias = idListadoDependencias;
	}

	public String getCodigoOsinergmin() {
		return codigoOsinergmin;
	}

	public void setCodigoOsinergmin(String codigoOsinergmin) {
		this.codigoOsinergmin = codigoOsinergmin;
	}

	public String getRadiosetPeriodo() {
		return radiosetPeriodo;
	}

	public void setRadiosetPeriodo(String radiosetPeriodo) {
		this.radiosetPeriodo = radiosetPeriodo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public List<File> getListaArchivosSiged() {
		return listaArchivosSiged;
	}

	public void setListaArchivosSiged(List<File> listaArchivosSiged) {
		this.listaArchivosSiged = listaArchivosSiged;
	}	
	
	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(String fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}	
	
	public long getEstado() {
		return estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	
	
	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}
		
	public String getIdTipoPeriodo() {
		return idTipoPeriodo;
	}

	public void setIdTipoPeriodo(String idTipoPeriodo) {
		this.idTipoPeriodo = idTipoPeriodo;
	}
	
	public long getHeditarUO() {
		return heditarUO;
	}

	public void setHeditarUO(long heditarUO) {
		this.heditarUO = heditarUO;
	}
	
	public long getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(long numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	@Override
    public String toString() {
        return "FormatoUnoDTO{" + "idSolicitud=" + idSolicitud + ", idUnidadOperativa=" + idUnidadOperativa + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", direccion=" + direccion + ", cmbDepartamento=" + cmbDepartamento + ", idProvincia=" + idProvincia + ", idDistrito=" + idDistrito + ", telefono=" + telefono + ", idListadoDependencias=" + idListadoDependencias + ", codigoOsinergmin=" + codigoOsinergmin + ", radiosetPeriodo=" + radiosetPeriodo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

	public void setDependenciaId(long dependenciaId) {
		this.dependenciaId = dependenciaId;
	}

	public long getDependenciaId() {
		return dependenciaId;
	}
	
	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getCorreoEle() {
		return correoEle;
	}

	public void setCorreoEle(String correoEle) {
		this.correoEle = correoEle;
	}

	public String getDescDep() {
		return descDep;
	}

	public void setDescDep(String descDep) {
		this.descDep = descDep;
	}

	public void setNotaId(long notaId) {
		this.notaId = notaId;
	}

	public long getNotaId() {
		return notaId;
	}
	
    public String getNotaDetalle() {
		return notaDetalle;
	}

	public void setNotaDetalle(String notaDetalle) {
		this.notaDetalle = notaDetalle;
	}

	private String tipoPrdo;
    
	public String getTipoPrdo() {
		return tipoPrdo;
	}

}