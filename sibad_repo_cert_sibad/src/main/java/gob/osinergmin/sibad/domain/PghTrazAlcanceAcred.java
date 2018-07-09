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
@Table(name = "PGH_TRAZ_ALCANCE_ACRED")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghTrazAlcanceAcred.findByTraz", query = "SELECT t FROM PghTrazAlcanceAcred t WHERE t.idTrazAlcanceAcred = (SELECT max(t.idTrazAlcanceAcred) FROM PghTrazAlcanceAcred t WHERE t.idAlcanceAcreditacion = :idAlcanceAcreditacion and t.estadoAccion = :estadoAccion)")
})

public class PghTrazAlcanceAcred {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TRAZ_ALCANCE_ACRED_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_TRAZ_ALCANCE_ACRED")
	private Long idTrazAlcanceAcred;
	 
	@Basic(optional = false)
	@Column(name = "ID_ALCANCE_ACREDITACION")
	private Long idAlcanceAcreditacion;
	 
	@Basic(optional = false)
	@Column(name = "ESTADO")
	private String estado; 
	 
	@Basic(optional = false)
	@Column(name = "ESTADO_ACCION")
	private String estadoAccion; 
	 
	@Basic(optional = false)
	@Column(name = "ID_DOCUMENTO_ADJUNTO")
	private Long idDocumentoAdjunto;
	 
	@Column(name = "ID_TIPO_MOTIVO")
	private String idTipoMotivo;
	 
	@Basic(optional = false)
	@Column(name = "FECHA_ULTIMO_ESTADO", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm")
	private Date fechaUltimoEstado;

	@Column(name = "OBSERVACION")
	private String observacion;

	public PghTrazAlcanceAcred() {
		super();
	}

	public PghTrazAlcanceAcred(Long idTrazAlcanceAcred, Long idAlcanceAcreditacion, String estado,
			String estadoAccion, Long idDocumentoAdjunto, String idTipoMotivo, Date fechaUltimoEstado,
			String observacion) {
		super();
		this.idTrazAlcanceAcred = idTrazAlcanceAcred;
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
		this.estado = estado;
		this.estadoAccion = estadoAccion;
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.idTipoMotivo = idTipoMotivo;
		this.fechaUltimoEstado = fechaUltimoEstado;
		this.observacion = observacion;
	}

	public Long getIdTrazAlcanceAcred() {
		return idTrazAlcanceAcred;
	}

	public void setIdTrazAlcanceAcred(Long idTrazAlcanceAcred) {
		this.idTrazAlcanceAcred = idTrazAlcanceAcred;
	}

	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
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

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public String getIdTipoMotivo() {
		return idTipoMotivo;
	}

	public void setIdTipoMotivo(String idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
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
        hash += (idTrazAlcanceAcred != null ? idTrazAlcanceAcred.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTrazAlcanceAcred)) {
            return false;
        }
        PghTrazAlcanceAcred other = (PghTrazAlcanceAcred) object;
        if ((this.idTrazAlcanceAcred == null && other.idTrazAlcanceAcred != null) || (this.idTrazAlcanceAcred != null && !this.idTrazAlcanceAcred.equals(other.idTrazAlcanceAcred))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghTrazAlcanceAcred[ idTrazAlcanceAcred=" + idTrazAlcanceAcred + " ]";
    } 
	 
	 
}
