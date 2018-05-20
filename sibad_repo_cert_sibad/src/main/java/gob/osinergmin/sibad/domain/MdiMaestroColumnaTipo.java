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
@Table(name = "MDI_MAESTRO_COLUMNA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "MdiMaestroColumnaTipo.findByIdMaster", query = "SELECT c FROM MdiMaestroColumnaTipo c WHERE c.idMaestroColumna=:idMaestroColumna "),
    @NamedQuery(name = "MdiMaestroColumnaTipo.findByFilter", query = "SELECT c FROM MdiMaestroColumnaTipo c WHERE upper(c.dominio) like :dominio and upper(c.aplicacion) like :aplicacion")
	
})
public class MdiMaestroColumnaTipo extends Auditoria{
    
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MAESTRO_COLUMNA")
    private Long idMaestroColumna;
    @Size(max = 10)
    
    @Column(name = "DOMINIO")
    private String dominio;
    @Size(max = 20)
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 200)
    
    @Column(name = "APLICACION")
    private String aplicacion;
    @Size(max = 25)

    public MdiMaestroColumnaTipo() {
    }

    public MdiMaestroColumnaTipo(Long idMaestroColumna) {
        this.idMaestroColumna = idMaestroColumna;
        //this.mdiMaestroTabla.getDescripcion()
    }
    
    public MdiMaestroColumnaTipo(Long idMaestroColumna, String descripcion,String dominio) {
        this.idMaestroColumna = idMaestroColumna;
        this.descripcion= descripcion;
        this.dominio=dominio;        
    }
    
    public MdiMaestroColumnaTipo(Long idMaestroColumna, String descripcion) {
        this.idMaestroColumna = idMaestroColumna;
        this.descripcion= descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdMaestroColumna() {
        return idMaestroColumna;
    }

    public void setIdMaestroColumna(Long idMaestroColumna) {
        this.idMaestroColumna = idMaestroColumna;
    }

    public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaestroColumna != null ? idMaestroColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiMaestroColumnaTipo)) {
            return false;
        }
        MdiMaestroColumnaTipo other = (MdiMaestroColumnaTipo) object;
        if ((this.idMaestroColumna == null && other.idMaestroColumna != null) || (this.idMaestroColumna != null && !this.idMaestroColumna.equals(other.idMaestroColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.MdiMaestroColumnaTipo[ idMaestroColumna=" + idMaestroColumna + " ]";
    }
    
}
