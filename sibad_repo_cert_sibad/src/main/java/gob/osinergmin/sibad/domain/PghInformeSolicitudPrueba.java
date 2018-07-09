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
@Table(name = "PGH_INFORME_SOLICITUD_PRUEBA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghInformeSolicitudPrueba.findById", query = "SELECT s FROM PghInformeSolicitudPrueba s WHERE s.idInformeIndiceRiesgo =:idInformeIndiceRiesgo "), 
    })
public class PghInformeSolicitudPrueba{
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_INFORME_SOLICITUD_PRUEBA_", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_INFORME_SOLICITUD_PRUEBA")
	private Long idInformeSolicitudPrueba;
	
	@Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
	private Long idSolicitudPruebaReprueba;
	
	@Column(name = "ID_INFORME_INDICE_RIESGO")
	private Long idInformeIndiceRiesgo;
	
	@Column(name = "FECHA_PROXIMA_PRUEBA")
	private Date FechaProximaPrueba;

	public PghInformeSolicitudPrueba() {
	
	}

	public PghInformeSolicitudPrueba(Long idInformeSolicitudPrueba) {
		this.idInformeSolicitudPrueba = idInformeSolicitudPrueba;
	}

	public PghInformeSolicitudPrueba(Long idInformeSolicitudPrueba, Long idSolicitudPruebaReprueba,
			Long idInformeIndiceRiesgo, Date fechaProximaPrueba) {

		this.idInformeSolicitudPrueba = idInformeSolicitudPrueba;
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
		FechaProximaPrueba = fechaProximaPrueba;
	}

	public Long getIdInformeSolicitudPrueba() {
		return idInformeSolicitudPrueba;
	}

	public void setIdInformeSolicitudPrueba(Long idInformeSolicitudPrueba) {
		this.idInformeSolicitudPrueba = idInformeSolicitudPrueba;
	}

	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}

	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}

	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}

	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}
		
	public Date getFechaProximaPrueba() {
		return FechaProximaPrueba;
	}

	public void setFechaProximaPrueba(Date fechaProximaPrueba) {
		FechaProximaPrueba = fechaProximaPrueba;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformeSolicitudPrueba != null ? idInformeSolicitudPrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghInformeSolicitudPrueba)) {
            return false;
        }
        PghInformeSolicitudPrueba other = (PghInformeSolicitudPrueba) object;
        if ((this.idInformeSolicitudPrueba == null && other.idInformeSolicitudPrueba != null) || (this.idInformeSolicitudPrueba != null && !this.idInformeSolicitudPrueba.equals(other.idInformeSolicitudPrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghInformeSolicitudPrueba[ idInformeSolicitudPrueba=" + idInformeSolicitudPrueba + " ]";
    }

	
	
	

}
