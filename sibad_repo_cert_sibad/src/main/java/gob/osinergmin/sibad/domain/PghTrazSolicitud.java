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
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PGH_SOLICITUD_TRAZABILIDAD")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghTrazSolicitud.findByTrazSol", query = "SELECT t FROM PghTrazSolicitud t WHERE t.idTrazSolicitud = (SELECT max(t.idTrazSolicitud) FROM PghTrazSolicitud t WHERE t.idSolicitudPruebaReprueba = :idSolicitudPruebaReprueba and t.estado = :estado)")
})

public class PghTrazSolicitud {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_SOLICITUD_TRAZABILIDAD")
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_SOLICITUD_TRAZABILIDAD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private Long idTrazSolicitud;
	 
	@Basic(optional = false)
	@Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
	private Long idSolicitudPruebaReprueba;
	
	@Column(name = "ID_TIPO_MOTIVO")
	private Long idTipoMotivo;
	 
	@Basic(optional = false)
	@Column(name = "ESTADO")
	private String estado;
	 
	@Basic(optional = false)
	@Column(name = "FECHA_ULTIMO_ESTADO", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm")
	private Date fechaUltimoEstado;

	@Column(name = "OBSERVACION")
	private String observacion;

	public PghTrazSolicitud() {
		super();
	}

	public PghTrazSolicitud(Long idTrazSolicitud, Long idSolicitudPruebaReprueba, String estado,
			String estadoAccion, Long idDocumentoAdjunto, Long idTipoMotivo, Date fechaUltimoEstado,
			String observacion) {
		super();
		this.idTrazSolicitud = idTrazSolicitud;
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
		this.idTipoMotivo = idTipoMotivo;
		this.estado = estado;
		this.fechaUltimoEstado = fechaUltimoEstado;
		this.observacion = observacion;
	}

	public Long getIdTrazSolicitud() {
		return idTrazSolicitud;
	}

	public void setIdTrazSolicitud(Long idTrazSolicitud) {
		this.idTrazSolicitud = idTrazSolicitud;
	}

	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}

	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}

	public Long getIdTipoMotivo() {
		return idTipoMotivo;
	}

	public void setIdTipoMotivo(Long idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaUltimoEstado() {
		return fechaUltimoEstado;
	}

	public void setFechaUltimoEstado(Date fechaUltimoEstado) {
		this.fechaUltimoEstado = fechaUltimoEstado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	 
	@PrePersist
    void createdAt() {		
            this.fechaUltimoEstado= new Date();
    } 
	 
	 
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrazSolicitud != null ? idTrazSolicitud.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTrazSolicitud)) {
            return false;
        }
        PghTrazSolicitud other = (PghTrazSolicitud) object;
        if ((this.idTrazSolicitud == null && other.idTrazSolicitud != null) || (this.idTrazSolicitud != null && !this.idTrazSolicitud.equals(other.idTrazSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghTrazSolicitud[ idTrazSolicitud=" + idTrazSolicitud + " ]";
    } 
	 
	 
}
