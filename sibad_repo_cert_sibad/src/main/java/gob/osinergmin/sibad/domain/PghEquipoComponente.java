/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_EQUIPO_COMPONENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghEquipoComponente.findByIdEquipoComponente", query = "SELECT a FROM PghEquipoComponente a WHERE a.idEquipoComponente like :idEquipoComponente"),
    @NamedQuery(name = "PghEquipoComponente.deleteByIdEquipoCertificado", query = "DELETE FROM PghEquipoComponente a WHERE a.idEquipoCertificado like :idEquipoCertificado")
    //@NamedQuery(name = "MdiPersonaJuridica.findByFilter", query = "SELECT p FROM MdiPersonaJuridica p WHERE upper(p.ruc) like :ruc and upper(p.razonSocial) like :razonSocial ")

})
public class PghEquipoComponente extends Auditoria{
    
	
	private static final long serialVersionUID = 1L;


	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_EQUIPO_COMPONENTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_EQUIPO_COMPONENTE")
	private Long idEquipoComponente;
	
	//@Basic(optional = false)
	@Column(name = "ID_EQUIPO_CERTIFICADO")
	private Long idEquipoCertificado;
	
	//@Basic(optional = false)
	@Column(name = "ID_COMPONENTE_TANQUE")
    private Long idEquipoTanque;
    
    public PghEquipoComponente() {
    }

    public PghEquipoComponente(Long IdEquipoComponente) {
        this.idEquipoComponente = IdEquipoComponente;
    }
    
    public Long getIdEquipoComponente() {
		return idEquipoComponente;
	}
    public void setIdEquipoComponente(Long idEquipoComponente) {
		this.idEquipoComponente = idEquipoComponente;
	}
    public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}
    public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}
    public Long getIdEquipoTanque() {
		return idEquipoTanque;
	}
    public void setIdEquipoTanque(Long idEquipoTanque) {
		this.idEquipoTanque = idEquipoTanque;
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
        if (!(object instanceof PghEquipoComponente)) {
            return false;
        }
        PghEquipoComponente other = (PghEquipoComponente) object;
        if ((this.idEquipoComponente == null && other.idEquipoComponente != null) || (this.idEquipoComponente != null && !this.idEquipoComponente.equals(other.idEquipoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEquipoComponente[ idEquipoComponente=" + idEquipoComponente + " ]";
    }
    
//    @PreUpdate
//    void updatedAt() {
//            this.fechaUltimaActualizacion= new Date();
//    }
    
}

