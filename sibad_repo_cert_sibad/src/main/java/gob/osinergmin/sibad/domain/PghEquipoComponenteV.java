/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "VIEW_EQUIPO_COMPONENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghEquipoComponenteV.findByComponente", query = "SELECT eq FROM PghEquipoComponenteV eq WHERE eq.idEquipoComponente = :idEquipoComponente"),
    @NamedQuery(name = "PghEquipoComponenteV.findByFilterC", query = "SELECT eq FROM PghEquipoComponenteV eq WHERE eq.idEquipoCertificado = :idEquipoCertificado")
   
    
})

public class PghEquipoComponenteV extends Auditoria{
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EQUIPO_COMPONENTE")
    private Long idEquipoComponente;
    
    @Column(name = "ID_EQUIPO_CERTIFICADO")
    private Long idEquipoCertificado;
    
    @Column(name = "ID_COMPONENTE_TANQUE")
    private Long idComponenteTanque;
    
    @Column(name = "COMPONENTE_TANQUE")
    private String componenteTanque;
    @Size(max = 200)
    
    
    public PghEquipoComponenteV() {
    }

    public PghEquipoComponenteV(Long idEquipoComponente) {
        this.idEquipoComponente = idEquipoComponente;
    }
    
    public PghEquipoComponenteV(Long idEquipoComponente, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idEquipoComponente = idEquipoComponente;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	public Long getIdEquipoComponente() {
		return idEquipoComponente;
	}

	public void setIdEquipoComponente(Long idEquipoComponente) {
		this.idEquipoComponente = idEquipoComponente;
	}

	public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}

	public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}

	public String getComponenteTanque() {
		return componenteTanque;
	}

	public void setComponenteTanque(String componenteTanque) {
		this.componenteTanque = componenteTanque;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoComponente != null ? idEquipoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEquipoComponenteV)) {
            return false;
        }
        PghEquipoComponenteV other = (PghEquipoComponenteV) object;
        if ((this.idEquipoComponente == null && other.idEquipoComponente != null) || (this.idEquipoComponente != null && !this.idEquipoComponente.equals(other.idEquipoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEquipoComponenteV[ idEquipoComponente=" + idEquipoComponente + " ]";
    }
    
}
