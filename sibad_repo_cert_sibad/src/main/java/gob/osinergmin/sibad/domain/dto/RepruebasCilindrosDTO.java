package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

public class RepruebasCilindrosDTO {
	 
	private Long idSolicitudPruebaRp;
	private Long idUnidSuperv;
	private Long idEmpresaAcred;
	private Long idTipoPrueba;
	private String numeroReprueba;
	private String nombreEmpresaAcred;
	private String modulo;
	private String cilindro;
	private String estado;
	private Date fechaCreacion;
	private Date fechaProgramada;
	private Date fechaRegistro;
	private Date fechaCertificado;
	private String resultado;
	
	public Long getIdEmpresaAcred() {
		return idEmpresaAcred;
	}
	public void setIdEmpresaAcred(Long idEmpresaAcred) {
		this.idEmpresaAcred = idEmpresaAcred;
	}
	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getCilindro() {
		return cilindro;
	}
	public void setCilindro(String cilindro) {
		this.cilindro = cilindro;
	}
	public Long getIdUnidSuperv() {
		return idUnidSuperv;
	}
	public void setIdUnidSuperv(Long idUnidSuperv) {
		this.idUnidSuperv = idUnidSuperv;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaCertificado() {
		return fechaCertificado;
	}
	public void setFechaCertificado(Date fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaProgramada() {
		return fechaProgramada;
	}
	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public Long getIdSolicitudPruebaRp() {
		return idSolicitudPruebaRp;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getModulo() {
		return modulo;
	}
	public void setIdSolicitudPruebaRp(Long idSolicitudPruebaRp) {
		this.idSolicitudPruebaRp = idSolicitudPruebaRp;
	}
	public String getNombreEmpresaAcred() {
		return nombreEmpresaAcred;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getNumeroReprueba() {
		return numeroReprueba;
	}
	public void setNombreEmpresaAcred(String nombreEmpresaAcred) {
		this.nombreEmpresaAcred = nombreEmpresaAcred;
	}
	public String getResultado() {
		return resultado;
	}
	public void setNumeroReprueba(String numeroReprueba) {
		this.numeroReprueba = numeroReprueba;
	}

}
