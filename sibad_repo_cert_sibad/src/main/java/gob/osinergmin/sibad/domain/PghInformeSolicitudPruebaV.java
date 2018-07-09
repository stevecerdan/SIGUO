package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_INFORME_SOLICITUD_PRUEBA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghInformeSolicitudPruebaV.findById", query = "SELECT s FROM PghInformeSolicitudPruebaV s WHERE s.idInformeIndiceRiesgo =:idInformeIndiceRiesgo "), 
    })
public class PghInformeSolicitudPruebaV {

	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_INFORME_SOLICITUD_PRUEBA")
	private Long idInformeSolicitudPrueba;
	
	@Column(name = "ID_INFORME_INDICE_RIESGO")
	private Long idInformeIndiceRiesgo;
	
	@Column(name = "NRO_SOLICITUD_UNIDAD_SUPERVISA") 
	private String nroSolcitudUnidadSupervisada; 
	
	@Column(name = "NUMERO_TANQUE") 
	private String numeroTanque; 
	
	@Column(name = "NUMERO_COMPARTIMIENTO") 
	private String numeroCompartimiento; 
	
	@Column(name = "FECHA_SOLICITUD") 
	private Date fechaSolicitud; 
	
	@Column(name = "FECHA_PROXIMA_PRUEBA") 
	private Date fechaProxPrueba;

	
	public PghInformeSolicitudPruebaV() {

	}

	public Long getIdInformeSolicitudPrueba() {
		return idInformeSolicitudPrueba;
	}
	

	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}

	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public void setIdInformeSolicitudPrueba(Long idInformeSolicitudPrueba) {
		this.idInformeSolicitudPrueba = idInformeSolicitudPrueba;
	}

	public String getNroSolcitudUnidadSupervisada() {
		return nroSolcitudUnidadSupervisada;
	}

	public void setNroSolcitudUnidadSupervisada(String nroSolcitudUnidadSupervisada) {
		this.nroSolcitudUnidadSupervisada = nroSolcitudUnidadSupervisada;
	}

	public String getNumeroTanque() {
		return numeroTanque;
	}

	public void setNumeroTanque(String numeroTanque) {
		this.numeroTanque = numeroTanque;
	}

	public String getNumeroCompartimiento() {
		return numeroCompartimiento;
	}

	public void setNumeroCompartimiento(String numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}

	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	} 
			
			
	
}
