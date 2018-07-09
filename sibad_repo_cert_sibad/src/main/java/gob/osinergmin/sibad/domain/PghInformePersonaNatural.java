package gob.osinergmin.sibad.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PGH_INFORME_PERSONA_NATURAL")

public class PghInformePersonaNatural {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_INFORME_PERSONA_NATURAL_S", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_INFORME_PERSONA_NATURAL")
	private Long idInformePersonaNatural;
	
	@Column(name = "ID_INFORME_INDICE_RIESGO")
	private Long idInformeIndiceRiesgo;
	
	@Column(name = "ID_PERSONA_NATURAL")
	private Long idPersonaNatural;

	
	public PghInformePersonaNatural() {

	}

	public PghInformePersonaNatural(Long idInformePersonaNatural) {
		this.idInformePersonaNatural = idInformePersonaNatural;
	}

	public PghInformePersonaNatural(Long idInformePersonaNatural, Long idInformeIndiceRiesgo, Long idPersonaNatural) {
		this.idInformePersonaNatural = idInformePersonaNatural;
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
		this.idPersonaNatural = idPersonaNatural;
	}

	public Long getIdInformePersonaNatural() {
		return idInformePersonaNatural;
	}

	public void setIdInformePersonaNatural(Long idInformePersonaNatural) {
		this.idInformePersonaNatural = idInformePersonaNatural;
	}

	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}

	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformePersonaNatural != null ? idInformePersonaNatural.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghInformePersonaNatural)) {
            return false;
        }
        PghInformePersonaNatural other = (PghInformePersonaNatural) object;
        if ((this.idInformePersonaNatural == null && other.idInformePersonaNatural != null) || (this.idInformePersonaNatural != null && !this.idInformePersonaNatural.equals(other.idInformePersonaNatural))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghInformePersonaNatural[ idInformePersonaNatural=" + idInformePersonaNatural + " ]";
    }

	

}
