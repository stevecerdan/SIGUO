package gob.osinergmin.sibad.domain.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class AlcanceAcreditacionDTO {
	
	private Long idAlcanceAcreditacion;
	private Long idEmpresaAcreditada;
    private Long idTipoPrueba;
    private String resolucionCedula;
    private Long idPrimerAlcanceAcreditacion;
    private Long idDocumentoAdjunto;
    private Long idDocumentoAlcanceAcreditada;
    private Long idTipoOrganismo;
    private String normaEvualada;
    private Date fechaUActualizacion;
    private Date fechaAcreditacion;
    private Date fechaVencimiento;
    private String estado;
    private String estadoAccion;
    private Long idOrganismoAcreditador;
    
    private Date fechaUltimaActualizacion;
    private Date fechaInicioVigencia;
   
    
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}
	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getResolucionCedula() {
		return resolucionCedula;
	}
	public void setResolucionCedula(String resolucionCedula) {
		this.resolucionCedula = resolucionCedula;
	}
	public Long getIdPrimerAlcanceAcreditacion() {
		return idPrimerAlcanceAcreditacion;
	}
	public void setIdPrimerAlcanceAcreditacion(Long idPrimerAlcanceAcreditacion) {
		this.idPrimerAlcanceAcreditacion = idPrimerAlcanceAcreditacion;
	}
	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public Long getIdDocumentoAlcanceAcreditada() {
		return idDocumentoAlcanceAcreditada;
	}
	public void setIdDocumentoAlcanceAcreditada(Long idDocumentoAlcanceAcreditada) {
		this.idDocumentoAlcanceAcreditada = idDocumentoAlcanceAcreditada;
	}
	public Long getIdTipoOrganismo() {
		return idTipoOrganismo;
	}
	public void setIdTipoOrganismo(Long idTipoOrganismo) {
		this.idTipoOrganismo = idTipoOrganismo;
	}
	public String getNormaEvualada() {
		return normaEvualada;
	}
	public void setNormaEvualada(String normaEvualada) {
		this.normaEvualada = normaEvualada;
	}
	public Date getFechaUActualizacion() {
		return fechaUActualizacion;
	}
	public void setFechaUActualizacion(Date fechaUActualizacion) {
		this.fechaUActualizacion = fechaUActualizacion;
	}
	public Date getFechaAcreditacion() {
		return fechaAcreditacion;
	}
	public void setFechaAcreditacion(Date fechaAcreditacion) {
		this.fechaAcreditacion = fechaAcreditacion;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoAccion() {
		return estadoAccion;
	}
	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}
	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}
	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}
	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}
	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
    

}
