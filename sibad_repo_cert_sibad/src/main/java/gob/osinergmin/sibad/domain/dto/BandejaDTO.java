package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;

public class BandejaDTO implements Serializable{
	
    private Long idRegistroEmergencia;
    private Long idFormulario;
    private Long idTipoFormato;
    private Long idtipoFormulario;
    private String descTipoFormulario;
    private Long idUnidadOperativa;
    private String codigoOsinergmin;
    
    private String numeroEmergencia;
    private String numeroExpediente;
    private String descEstadoRegistro;
    private Long estadoRegistro;
    private Long estado;
    private String fechaPresentacion;
    private Long idFormularioRegistro;
    private Long Finalizar;
    private String fechaCreacion;
    
    private Long idRegistroSolicitud;
    private Long numeroSolicitud;
    private String fechaInicio;
    private String fechaFin;
    private Long estadoSolicitud;
    private String descEstadoSolicitud;
    private String ruc;
    private String razonSocial;
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }



    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    public Long getFinalizar() {
        return Finalizar;
    }



    public void setFinalizar(Long finalizar) {
        Finalizar = finalizar;
    }



    public Long getIdFormularioRegistro() {
        return idFormularioRegistro;
    }



    public void setIdFormularioRegistro(Long idFormularioRegistro) {
        this.idFormularioRegistro = idFormularioRegistro;
    }



    public String getDescTipoFormulario() {
        return descTipoFormulario;
    }



    public void setDescTipoFormulario(String descTipoFormulario) {
        this.descTipoFormulario = descTipoFormulario;
    }



    public String getDescEstadoRegistro() {
        return descEstadoRegistro;
    }



    public void setDescEstadoRegistro(String descEstadoRegistro) {
        this.descEstadoRegistro = descEstadoRegistro;
    }



    public Long getIdRegistroEmergencia() {
        return idRegistroEmergencia;
    }



    public void setIdRegistroEmergencia(Long idRegistroEmergencia) {
        this.idRegistroEmergencia = idRegistroEmergencia;
    }



    public Long getIdFormulario() {
        return idFormulario;
    }



    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
    }



    public Long getIdTipoFormato() {
        return idTipoFormato;
    }



    public void setIdTipoFormato(Long idTipoFormato) {
        this.idTipoFormato = idTipoFormato;
    }



    public Long getIdtipoFormulario() {
        return idtipoFormulario;
    }



    public void setIdtipoFormulario(Long idtipoFormulario) {
        this.idtipoFormulario = idtipoFormulario;
    }



    public Long getIdUnidadOperativa() {
        return idUnidadOperativa;
    }



    public void setIdUnidadOperativa(Long idUnidadOperativa) {
        this.idUnidadOperativa = idUnidadOperativa;
    }



    public String getCodigoOsinergmin() {
        return codigoOsinergmin;
    }



    public void setCodigoOsinergmin(String codigoOsinergmin) {
        this.codigoOsinergmin = codigoOsinergmin;
    }



    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }



    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }



    public String getNumeroExpediente() {
        return numeroExpediente;
    }



    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }



    public Long getEstadoRegistro() {
        return estadoRegistro;
    }



    public void setEstadoRegistro(Long estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }



    public String getFechaPresentacion() {
        return fechaPresentacion;
    }



    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }



    public Long getEstado() {
        return estado;
    }



    public void setEstado(Long estado) {
        this.estado = estado;
    }


    public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public Long getNumeroSolicitud() {
		return numeroSolicitud;
	}



	public void setNumeroSolicitud(Long numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

   

	public Long getIdRegistroSolicitud() {
		return idRegistroSolicitud;
	}



	public void setIdRegistroSolicitud(Long idRegistroSolicitud) {
		this.idRegistroSolicitud = idRegistroSolicitud;
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



	public Long getEstadoSolicitud() {
		return estadoSolicitud;
	}

    

	public String getDescEstadoSolicitud() {
		return descEstadoSolicitud;
	}



	public void setDescEstadoSolicitud(String descEstadoSolicitud) {
		this.descEstadoSolicitud = descEstadoSolicitud;
	}



	public void setEstadoSolicitud(Long estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

   

	public String getRuc() {
		return ruc;
	}



	public void setRuc(String ruc) {
		this.ruc = ruc;
	}



	@Override
    public String toString() {
        return "FormatoTresDTO{" + "idRegistroEmergencia=" + 
    idRegistroEmergencia + "," + "idFormulario=" + 
    idFormulario + ", idTipoFormato=" + idTipoFormato + 
    ", idtipoFormulario=" + idtipoFormulario + 
    ", idUnidadOperativa=" + idUnidadOperativa +
    ", codigoOsinergmin=" + codigoOsinergmin +
    ", razonSocial=" + razonSocial +
    ", numeroEmergencia=" + numeroEmergencia +
    ", numeroExpediente=" + numeroExpediente +
    ", estadoRegistro=" + estadoRegistro +
    ", fechaPresentacion=" + fechaPresentacion +"}";
    }
}