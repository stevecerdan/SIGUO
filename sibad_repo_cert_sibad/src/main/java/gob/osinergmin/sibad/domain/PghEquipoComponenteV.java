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
    @NamedQuery(name = "PghEquipoComponenteV.findByFilterC", query = "SELECT eq FROM PghEquipoComponenteV eq WHERE eq.idEquipoCertificado = :idEquipoCertificado"),
    @NamedQuery(name = "PghEquipoComponenteV.findBycbxResultadoComponente", query = "SELECT eq FROM PghEquipoComponenteV eq WHERE eq.idEmpresaAcreditada = :idEmpresaAcreditada and"+
																														    " eq.idEquipoCertificado = :idEquipoCertificado and" +
																															" eq.idTipoPrueba = '1467' and" +
																															" eq.estadoEquipo = 'A' and" +
																															" (upper(eq.estadoAlcance) = 'A' or" + 
																															" upper(eq.estadoAlcance) = 'S')")
   
    
})

public class PghEquipoComponenteV extends Auditoria{
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EQUIPO_COMPONENTE")
    private Long idEquipoComponente;
    
    @Column(name = "ID_EQUIPO_CERTIFICADO")
    private Long idEquipoCertificado;
    
    @Column(name = "EQUIPO")
    private String descripcionEquipo;
    
    @Column(name = "ID_TIPO_EQUIPO")
    private Long idTipoEquipo;
    
    @Column(name = "TIPO_EQUIPO")
    private String tipoEquipo;
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcreditada;
    
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
        
    @Column(name = "ESTADO_ALCANCE")
    private String estadoAlcance;
    
    @Column(name = "ESTADO_EQUIPO")
    private String estadoEquipo;
    
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
	
	public Long getIdComponenteTanque() {
		return idComponenteTanque;
	}

	public void setIdComponenteTanque(Long idComponenteTanque) {
		this.idComponenteTanque = idComponenteTanque;
	}

	public String getComponenteTanque() {
		return componenteTanque;
	}

	public void setComponenteTanque(String componenteTanque) {
		this.componenteTanque = componenteTanque;
	}
	//------
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}

	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}

	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}

	public String getEstadoEquipo() {
		return estadoEquipo;
	}

	public void setEstadoEquipo(String estadoEquipo) {
		this.estadoEquipo = estadoEquipo;
	}
	
	public String getDescripcionEquipo() {
		return descripcionEquipo;
	}

	public void setDescripcionEquipo(String descripcionEquipo) {
		this.descripcionEquipo = descripcionEquipo;
	}

	public String getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
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
