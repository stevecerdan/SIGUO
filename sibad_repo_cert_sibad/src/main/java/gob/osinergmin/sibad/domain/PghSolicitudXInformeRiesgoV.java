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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_SOLICITUD_X_INFO_RIESGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghSolicitudXInformeRiesgoV.findByInfoRiesgo", query = "SELECT r FROM PghSolicitudXInformeRiesgoV r WHERE r.nroInformeIndiceRiesgo like :nroInformeIndiceRiesgo")
                                                                                                                                             
})

public class PghSolicitudXInformeRiesgoV{
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_INFORME_INDICE_RIESGO")
	private Long idInformeIndiceRiesgo;
	
	@Column(name = "NUMERO_INFORME_INDICE_RIESGO")
	private String nroInformeIndiceRiesgo;
	
	@Column(name = "FECHA_INFORME_INDICE_RIESGO")
	private Date fechaInformeIndiceRiesgo;
	
	@Column(name = "LISTA_TANQUES_COMPARTIMIENTOS")
    private String listaTanquesCompartimientos;

	public PghSolicitudXInformeRiesgoV() {
		
	}
	
	public PghSolicitudXInformeRiesgoV(Long idInformeIndiceRiesgo) {
		
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}

	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public String getNroInformeIndiceRiesgo() {
		return nroInformeIndiceRiesgo;
	}

	public void setNroInformeIndiceRiesgo(String nroInformeIndiceRiesgo) {
		this.nroInformeIndiceRiesgo = nroInformeIndiceRiesgo;
	}

	public Date getFechaInformeIndiceRiesgo() {
		return fechaInformeIndiceRiesgo;
	}

	public void setFechaInformeIndiceRiesgo(Date fechaInformeIndiceRiesgo) {
		this.fechaInformeIndiceRiesgo = fechaInformeIndiceRiesgo;
	}

	public String getListaTanquesCompartimientos() {
		return listaTanquesCompartimientos;
	}

	public void setListaTanquesCompartimientos(String listaTanquesCompartimientos) {
		this.listaTanquesCompartimientos = listaTanquesCompartimientos;
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
        if (!(object instanceof PghSolicitudXInformeRiesgoV)) {
            return false;
        }
        PghSolicitudXInformeRiesgoV other = (PghSolicitudXInformeRiesgoV) object;
        if ((this.idInformeIndiceRiesgo == null && other.idInformeIndiceRiesgo != null) || (this.idInformeIndiceRiesgo != null && !this.idInformeIndiceRiesgo.equals(other.idInformeIndiceRiesgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSolicitudXInformeRiesgoV[ idInformeIndiceRiesgo=" + idInformeIndiceRiesgo + " ]";
    }
	
}
