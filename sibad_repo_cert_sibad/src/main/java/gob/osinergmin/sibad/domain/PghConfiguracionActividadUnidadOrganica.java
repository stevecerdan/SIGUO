package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PGH_CNF_ACT_UNI_ORGANICA")
@NamedQueries({
    @NamedQuery(name = "PghConfiguracionActividadUnidadOrganica.findAll", query = "SELECT t FROM PghConfiguracionActividadUnidadOrganica t"),
    @NamedQuery(name = "PghConfiguracionActividadUnidadOrganica.findByTipoAgente", query = "SELECT t FROM PghConfiguracionActividadUnidadOrganica t WHERE t.idTipoAgente = :idTipoAgente AND t.estado = '1' ")
})
public class PghConfiguracionActividadUnidadOrganica implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_CNF_ACT_UNI_ORGANICA")
    private Long idConfiguracionActividadUnidadOrganica;
    
    @Column(name = "ID_ACTIVIDAD")
    private Long idTipoAgente;
    
    @Column(name = "ID_UNIDAD_ORGANICA")
    private Long idUnidadOrganica;

    @Column(name = "ESTADO")
    private String estado;
    
    public PghConfiguracionActividadUnidadOrganica() {
    }

    public PghConfiguracionActividadUnidadOrganica(Long idConfiguracionActividadUnidadOrganica) {
        this.idConfiguracionActividadUnidadOrganica = idConfiguracionActividadUnidadOrganica;
    }

	public Long getIdConfiguracionActividadUnidadOrganica() {
		return idConfiguracionActividadUnidadOrganica;
	}

	public void setIdConfiguracionActividadUnidadOrganica(
			Long idConfiguracionActividadUnidadOrganica) {
		this.idConfiguracionActividadUnidadOrganica = idConfiguracionActividadUnidadOrganica;
	}

	public Long getIdTipoAgente() {
		return idTipoAgente;
	}

	public void setIdTipoAgente(Long idTipoAgente) {
		this.idTipoAgente = idTipoAgente;
	}

	public Long getIdUnidadOrganica() {
		return idUnidadOrganica;
	}

	public void setIdUnidadOrganica(Long idUnidadOrganica) {
		this.idUnidadOrganica = idUnidadOrganica;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguracionActividadUnidadOrganica != null ? idConfiguracionActividadUnidadOrganica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PghConfiguracionActividadUnidadOrganica)) {
            return false;
        }
        PghConfiguracionActividadUnidadOrganica other = (PghConfiguracionActividadUnidadOrganica) object;
        if ((this.idConfiguracionActividadUnidadOrganica == null && other.idConfiguracionActividadUnidadOrganica != null) || (this.idConfiguracionActividadUnidadOrganica != null && !this.idConfiguracionActividadUnidadOrganica.equals(other.idConfiguracionActividadUnidadOrganica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinerg.sibad.domain.PghConfiguracionActividadUnidadOrganica[ idConfiguracionActividadUnidadOrganica=" + idConfiguracionActividadUnidadOrganica + " ]";
    }
    
}
