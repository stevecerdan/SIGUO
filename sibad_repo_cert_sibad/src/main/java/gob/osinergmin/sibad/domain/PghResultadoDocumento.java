package gob.osinergmin.sibad.domain;

import java.sql.Date;

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
@Table(name = "PGH_RESULTADO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoDocumento.findByIdResultado", query = "SELECT a FROM PghResultadoDocumento a WHERE a.idResultadoDocumento = idResultadoDocumento")
})
public class PghResultadoDocumento extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_DOCUMENTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_DOCUMENTO")
	private Long idResultadoDocumento;
	 
	@Column(name = "ID_RESULTADO_REVISION")
	private Long idResultadoRevision;
	 
	@Column(name = "ID_DOCUMENTO_ADJUNTO")
	private Long idDocumentoAdjunto;

	public PghResultadoDocumento() {
		
	}

	public PghResultadoDocumento(Long idResultadoDocumento) {
		
		this.idResultadoDocumento = idResultadoDocumento;
	}

	public PghResultadoDocumento(Long idDocumentoAdjunto, Long idResultadoRevision, Long idResultadoDocumento) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.idResultadoRevision = idResultadoRevision;
		this.idResultadoDocumento = idResultadoDocumento;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public Long getIdResultadoDocumento() {
		return idResultadoDocumento;
	}
	public void setIdResultadoDocumento(Long idResultadoDocumento) {
		this.idResultadoDocumento = idResultadoDocumento;
	}
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	 
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoDocumento != null ? idResultadoDocumento.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoDocumento)) {
            return false;
        }
        PghResultadoDocumento other = (PghResultadoDocumento) object;
        if ((this.idResultadoDocumento == null && other.idResultadoDocumento != null) || (this.idResultadoDocumento != null && !this.idResultadoDocumento.equals(other.idResultadoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoDocumento[ idResultadoDocumento=" + idResultadoDocumento + " ]";
    } 
}
