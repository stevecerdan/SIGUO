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
@Table(name = "PGH_INFORME_INDICE_RIESGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghInformeIndiceRiesgo.findByIdInformeIndiceRiesgo", query = "SELECT a FROM PghInformeIndiceRiesgo a WHERE a.idInformeIndiceRiesgo = :idInformeIndiceRiesgo")
                                                                                                                                             
})
public class PghInformeIndiceRiesgo extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_INFORME_INDICE_RIESGO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_INFORME_INDICE_RIESGO")
	private Long idInformeIndiceRiesgo;
	
	@Column(name = "NUMERO_INFORME_INDICE_RIESGO")
	private String numeroInformeIndiceRiesgo;
	
	@Column(name = "ID_PERSONA_JURIDICA")
	private Long idPersonaJuridica;

	@Column(name = "FECHA_INFORME_INDICE_RIESGO")
	private Date fechaInformeIniceRiesgo;
	
	@Column(name = "FLAG_PERSONA")
	private String flagPersona;
	
	@Column(name = "ID_DOCUMENTO_ADJUNTO")
	private Long idDocumentoAdjunto;

	
	public PghInformeIndiceRiesgo() {

	}

	public PghInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public PghInformeIndiceRiesgo(Long idInformeIndiceRiesgo, String numeroInformeIndiceRiesgo, Long idPersonaJuridica,
			Date fechaInformeIniceRiesgo, String flagPersona, Long idDocumentoAdjunto) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
		this.numeroInformeIndiceRiesgo = numeroInformeIndiceRiesgo;
		this.idPersonaJuridica = idPersonaJuridica;
		this.fechaInformeIniceRiesgo = fechaInformeIniceRiesgo;
		this.flagPersona = flagPersona;
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}

	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public String getNumeroInformeIndiceRiesgo() {
		return numeroInformeIndiceRiesgo;
	}

	public void setNumeroInformeIndiceRiesgo(String numeroInformeIndiceRiesgo) {
		this.numeroInformeIndiceRiesgo = numeroInformeIndiceRiesgo;
	}

	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}

	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}

	public Date getFechaInformeIniceRiesgo() {
		return fechaInformeIniceRiesgo;
	}

	public void setFechaInformeIniceRiesgo(Date fechaInformeIniceRiesgo) {
		this.fechaInformeIniceRiesgo = fechaInformeIniceRiesgo;
	}

	public String getFlagPersona() {
		return flagPersona;
	}

	public void setFlagPersona(String flagPersona) {
		this.flagPersona = flagPersona;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformeIndiceRiesgo != null ? idInformeIndiceRiesgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghInformeIndiceRiesgo)) {
            return false;
        }
        PghInformeIndiceRiesgo other = (PghInformeIndiceRiesgo) object;
        if ((this.idInformeIndiceRiesgo == null && other.idInformeIndiceRiesgo != null) || (this.idInformeIndiceRiesgo != null && !this.idInformeIndiceRiesgo.equals(other.idInformeIndiceRiesgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghInformeIndiceRiesgo[ idInformeIndiceRiesgo=" + idInformeIndiceRiesgo + " ]";
    }
	
}
