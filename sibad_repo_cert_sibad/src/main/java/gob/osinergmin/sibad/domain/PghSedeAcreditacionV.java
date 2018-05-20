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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 * 
 */
@Entity
@Table(name = "PGH_SEDE_ACREDITACION")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghSedeAcreditacionV.findByIdSede", query = "SELECT s FROM PghSedeAcreditacionV s WHERE s.idSedeAcreditacion=:idSedeAcreditacion "),
    @NamedQuery(name = "PghSedeAcreditacionV.findByFilter", query = "SELECT s FROM PghSedeAcreditacionV s WHERE s.idAlcanceAcreditacion = :idAlcanceAcreditacion and upper(s.estado) = :estado")
	
})
public class PghSedeAcreditacionV extends Auditoria{
    
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEDE_ACREDITACION")
    private Long idSedeAcreditacion;
    @Size(max = 10)
    
    @Column(name = "ID_ALCANCE_ACREDITACION")
    private Long idAlcanceAcreditacion;
    @Size(max = 10)
    
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 512)
    
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 1)

    public PghSedeAcreditacionV() {
    }

    public PghSedeAcreditacionV(Long idSedeAcreditacion) {
        this.idSedeAcreditacion = idSedeAcreditacion;
        //this.mdiMaestroTabla.getDescripcion()
    }
    
    public PghSedeAcreditacionV(Long idSedeAcreditacion, String direccion,String estado) {
        this.idSedeAcreditacion = idSedeAcreditacion;
        this.direccion= direccion;
        this.estado=estado;        
    }
    
    public PghSedeAcreditacionV(Long idSedeAcreditacion, String direccion) {
        this.idSedeAcreditacion = idSedeAcreditacion;
        this.direccion= direccion;
    }

	public Long getIdSedeAcreditacion() {
		return idSedeAcreditacion;
	}

	public void setIdSedeAcreditacion(Long idSedeAcreditacion) {
		this.idSedeAcreditacion = idSedeAcreditacion;
	}

	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
        hash += (idSedeAcreditacion != null ? idSedeAcreditacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghSedeAcreditacionV)) {
            return false;
        }
        PghSedeAcreditacionV other = (PghSedeAcreditacionV) object;
        if ((this.idSedeAcreditacion == null && other.idSedeAcreditacion != null) || (this.idSedeAcreditacion != null && !this.idSedeAcreditacion.equals(other.idSedeAcreditacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSedeAcreditacionV[ idSedeAcreditacion=" + idSedeAcreditacion + " ]";
    }
    
}
