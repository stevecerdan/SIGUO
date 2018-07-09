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
@Table(name = "VIEW_TIPO_PRUEBAS_ORG")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghTipoPruebaOrganismo.findByIdTipoPrueba", query = "SELECT c FROM PghTipoPruebaOrganismo c WHERE c.idOrganismoAcreditador = :idOrganismoAcreditador")
	
})
public class PghTipoPruebaOrganismo{
    
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
    @Size(max = 10)
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 200)
    
    @Column(name = "ID_ORGANISMO_ACREDITADOR")
    private Long idOrganismoAcreditador;
    @Size(max = 10)
    
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 256)

    public PghTipoPruebaOrganismo() {
    }

    public PghTipoPruebaOrganismo(Long idTipoPrueba) {
        this.idTipoPrueba = idTipoPrueba;
    }

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}

	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPrueba != null ? idTipoPrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTipoPruebaOrganismo)) {
            return false;
        }
        PghTipoPruebaOrganismo other = (PghTipoPruebaOrganismo) object;
        if ((this.idTipoPrueba == null && other.idTipoPrueba != null) || (this.idTipoPrueba != null && !this.idTipoPrueba.equals(other.idTipoPrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghTipoPruebaOrganismo[ idTipoPrueba=" + idTipoPrueba + " ]";
    }
    
}
