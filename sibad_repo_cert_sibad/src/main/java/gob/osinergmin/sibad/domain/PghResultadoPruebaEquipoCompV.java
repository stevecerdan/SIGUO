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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_RESULT_EQUIPO_COMPONENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoPruebaEquipoCompV.findByIdResultadoPRE", query = "SELECT r FROM PghResultadoPruebaEquipoCompV r WHERE r.idResultadoPruebaReprueba = :idResultadoPruebaReprueba")
                                                                                                                                             
})

public class PghResultadoPruebaEquipoCompV{
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_RESUL_PRUEBA_EQUIPO_COMP")
	private Long idResultadoPruebaEquipoComp;
	
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	
	@Column(name = "ID_EQUIPO_COMPONENTE")
	private Long idEquipoComponente;
	
	@Column(name = "EQUIPO")
    private String descripcionEquipo;
    
    @Column(name = "TIPO_EQUIPO")
    private String tipoEquipo;
        
    @Column(name = "COMPONENTE_TANQUE")
    private String componenteTanque;
    @Size(max = 200)

	public PghResultadoPruebaEquipoCompV() {
		
	}
	
	public PghResultadoPruebaEquipoCompV(Long idResultadoPruebaEquipoComp) {
		
		this.idResultadoPruebaEquipoComp = idResultadoPruebaEquipoComp;
	}
	
	/*public PghResultadoPruebaEquipoCompV(Long idResultadoPruebaEquipoComp, Long idResultadoPruebaReprueba,
			Long idEquipoComponente) {
		
		this.idResultadoPruebaEquipoComp = idResultadoPruebaEquipoComp;
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
		this.idEquipoComponente = idEquipoComponente;
	}*/

	public Long getIdResultadoPruebaEquipoComp() {
		return idResultadoPruebaEquipoComp;
	}

	public void setIdResultadoPruebaEquipoComp(Long idResultadoPruebaEquipoComp) {
		this.idResultadoPruebaEquipoComp = idResultadoPruebaEquipoComp;
	}

	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}

	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public Long getIdEquipoComponente() {
		return idEquipoComponente;
	}

	public void setIdEquipoComponente(Long idEquipoComponente) {
		this.idEquipoComponente = idEquipoComponente;
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

	public String getComponenteTanque() {
		return componenteTanque;
	}

	public void setComponenteTanque(String componenteTanque) {
		this.componenteTanque = componenteTanque;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoPruebaEquipoComp != null ? idResultadoPruebaEquipoComp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPruebaEquipoCompV)) {
            return false;
        }
        PghResultadoPruebaEquipoCompV other = (PghResultadoPruebaEquipoCompV) object;
        if ((this.idResultadoPruebaEquipoComp == null && other.idResultadoPruebaEquipoComp != null) || (this.idResultadoPruebaEquipoComp != null && !this.idResultadoPruebaEquipoComp.equals(other.idResultadoPruebaEquipoComp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPruebaEquipoCompV[ idResultadoPruebaEquipoComp =" + idResultadoPruebaEquipoComp + " ]";
    }
	
}
