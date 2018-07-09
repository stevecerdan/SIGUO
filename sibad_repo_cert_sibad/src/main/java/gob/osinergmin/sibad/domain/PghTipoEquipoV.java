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

/*
 * @author jpiro
 */
@Entity
@Table(name = "VIEW_TIPO_EQUIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTipoEquipoV.findByTipos", query = "SELECT t FROM PghTipoEquipoV t WHERE t.idEmpresaAcreditada = :idEmpresaAcreditada and" +
																						    		" t.idTipoPrueba = '1467' and" + 
																									" (upper(t.estadoAlcance) = 'A' or" + 
																									" upper(t.estadoAlcance) = 'S')")
})

public class PghTipoEquipoV{
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_EQUIPO")
    private Long idTipoEquipo;
    @Size(max = 10)
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcreditada;
    @Size(max = 10)
    
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
    @Size(max = 10)
    
    @Column(name = "TIPO_EQUIPO")
    private String tipoEquipo;
    @Size(max = 200)
    
    @Column(name = "ESTADO_ALCANCE")
    private String estadoAlcance;
    
    public PghTipoEquipoV() {
    }
    
    public PghTipoEquipoV(Long idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}

	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public String getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEquipo != null ? idTipoEquipo.hashCode() : 0);
        return hash;
    }
	
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTipoEquipoV)) {
            return false;
        }
        PghTipoEquipoV other = (PghTipoEquipoV) object;
        if ((this.idTipoEquipo == null && other.idTipoEquipo != null) || (this.idTipoEquipo != null && !this.idTipoEquipo.equals(other.idTipoEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghTipoEquipoV[ idTipoEquipo=" + idTipoEquipo + " ]";
    }
}
