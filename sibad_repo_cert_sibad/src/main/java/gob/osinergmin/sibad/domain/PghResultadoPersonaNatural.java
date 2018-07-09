package gob.osinergmin.sibad.domain;

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
@Table(name = "PGH_RESULTADO_PERSONA_NATURAL")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghResultadoPersonaNatural.findById", query = "SELECT s FROM PghResultadoPersonaNaturalV s WHERE s.idResultadoPersonaNatural=:idResultadoPersonaNatural "),
    @NamedQuery(name = "PghResultadoPersonaNatural.findByFilter", query = "SELECT s FROM PghResultadoPersonaNaturalV s WHERE s.idResultadoRevision =:idResultadoRevision")	
	                                                                                                                           
})
public class PghResultadoPersonaNatural extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_REVISION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_PERSONA_NATURAL")
	private Long idResultadoPersonaNatural;
	
	@Column(name = "ID_RESULTADO_REVISION")
	private Long idResultadoRevision;
	
	@Column(name = "ID_PERSONA_NATURAL")
	private Long idPersonaNatural;
	
	public PghResultadoPersonaNatural() {
		// TODO Auto-generated constructor stub
	}
	
	public PghResultadoPersonaNatural(Long idResultadoPersonaNatural, Long idResultadoRevision, Long idPersonaNatural) {
		this.idResultadoPersonaNatural = idResultadoPersonaNatural;
		this.idResultadoRevision = idResultadoRevision;
		this.idPersonaNatural = idPersonaNatural;
	}
	
	public Long getIdResultadoPersonaNatural() {
		return idResultadoPersonaNatural;
	}
	
	public void setIdResultadoPersonaNatural(Long idResultadoPersonaNatural) {
		this.idResultadoPersonaNatural = idResultadoPersonaNatural;
	}
	
	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}
	
	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
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
        hash += (idResultadoPersonaNatural != null ? idResultadoPersonaNatural.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPersonaNatural)) {
            return false;
        }
        PghResultadoPersonaNatural other = (PghResultadoPersonaNatural) object;
        if ((this.idResultadoPersonaNatural == null && other.idResultadoPersonaNatural != null) || (this.idResultadoPersonaNatural != null && !this.idResultadoPersonaNatural.equals(other.idResultadoPersonaNatural))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPersonaNatural[ idResultadoPersonaNatural=" + idResultadoPersonaNatural + " ]";
    }
	
}
