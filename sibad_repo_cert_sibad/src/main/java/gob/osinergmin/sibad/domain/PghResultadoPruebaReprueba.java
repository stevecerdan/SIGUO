package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PGH_RESULTADO_PRUEBA_REPRUEBA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoPruebaReprueba.findByIdPruebaReprueba", query = "SELECT a FROM PghResultadoPruebaReprueba a WHERE a.idResultadoPruebaReprueba = :idResultadoPruebaReprueba")
        
})

public class PghResultadoPruebaReprueba  extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_PRUEBA_REPRUEBA1", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	
	@Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
	private Long idSolicitudPruebaReprueba;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "HORA_INICIO")
	private String horaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "HORA_FIN")
	private String horaFin;
	
	@Column(name = "FLAG_RESULTADO_COMPARTIMIENTO")
	private String flagResultadoCompartimiento;
	
	@Column(name = "FLAG_RESULTADO_TUBERIA")
	private String flagResutadoTuberia;
	
	@Column(name = "FLAG_RESULTADO_FINAL")
	private String flagResultadoFinal;
	
	@Column(name = "RESULTADO_PRUEBA")
	private String resultadoPrueba;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "NUMERO_CERTIFICADO")
	private String numeroCertificado;
	
	@Column(name = "FECHA_EMISION_CERTIFICADO")
	private Date fechaEmisionCertificado;
	
	@Column(name = "NUMERO_INFORME")
	private String numeroInforme;
	
	@Column(name = "FECHA_INFORME")
	private Date fechaInforme;
	
	@Column(name = "FECHA_PROXIMA_PRUEBA")
	private Date fechaProximaPrueba;

	public PghResultadoPruebaReprueba() {
		
	}
	
	public PghResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public PghResultadoPruebaReprueba(Long idResultadoPruebaReprueba, Long idSolicitudPruebaReprueba, Date fechaInicio,
			String horaInicio, Date fechaFin, String horaFin, String flagResultadoCompartimiento,
			String flagResutadoTuberia, String flagResultadoFinal, String resultadoPrueba, String observacion,
			String numeroCertificado, Date fechaEmisionCertificado, String numeroInforme, Date fechaProximaPrueba) {
		
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.fechaFin = fechaFin;
		this.horaFin = horaFin;
		this.flagResultadoCompartimiento = flagResultadoCompartimiento;
		this.flagResutadoTuberia = flagResutadoTuberia;
		this.flagResultadoFinal = flagResultadoFinal;
		this.resultadoPrueba = resultadoPrueba;
		this.observacion = observacion;
		this.numeroCertificado = numeroCertificado;
		this.fechaEmisionCertificado = fechaEmisionCertificado;
		this.numeroInforme = numeroInforme;
		this.fechaProximaPrueba = fechaProximaPrueba;
	}
	
	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}

	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}

	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaInforme() {
		return fechaInforme;
	}
	
	public void setFechaInforme(Date fechaInforme) {
		this.fechaInforme = fechaInforme;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getFlagResultadoCompartimiento() {
		return flagResultadoCompartimiento;
	}

	public void setFlagResultadoCompartimiento(String flagResultadoCompartimiento) {
		this.flagResultadoCompartimiento = flagResultadoCompartimiento;
	}

	public String getFlagResutadoTuberia() {
		return flagResutadoTuberia;
	}

	public void setFlagResutadoTuberia(String flagResutadoTuberia) {
		this.flagResutadoTuberia = flagResutadoTuberia;
	}

	public String getFlagResultadoFinal() {
		return flagResultadoFinal;
	}

	public void setFlagResultadoFinal(String flagResultadoFinal) {
		this.flagResultadoFinal = flagResultadoFinal;
	}

	public String getResultadoPrueba() {
		return resultadoPrueba;
	}

	public void setResultadoPrueba(String resultadoPrueba) {
		this.resultadoPrueba = resultadoPrueba;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNumeroCertificado() {
		return numeroCertificado;
	}

	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}

	public Date getFechaEmisionCertificado() {
		return fechaEmisionCertificado;
	}

	public void setFechaEmisionCertificado(Date fechaEmisionCertificado) {
		this.fechaEmisionCertificado = fechaEmisionCertificado;
	}

	public String getNumeroInforme() {
		return numeroInforme;
	}

	public void setNumeroInforme(String numeroInforme) {
		this.numeroInforme = numeroInforme;
	}

	public Date getFechaProximaPrueba() {
		return fechaProximaPrueba;
	}

	public void setFechaProximaPrueba(Date fechaProximaPrueba) {
		this.fechaProximaPrueba = fechaProximaPrueba;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoPruebaReprueba != null ? idResultadoPruebaReprueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPruebaReprueba)) {
            return false;
        }
        PghResultadoPruebaReprueba other = (PghResultadoPruebaReprueba) object;
        if ((this.idResultadoPruebaReprueba == null && other.idResultadoPruebaReprueba != null) || (this.idResultadoPruebaReprueba != null && !this.idResultadoPruebaReprueba.equals(other.idResultadoPruebaReprueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPruebaReprueba[ idResultadoPruebaReprueba=" + idResultadoPruebaReprueba + " ]";
    }
	
}
