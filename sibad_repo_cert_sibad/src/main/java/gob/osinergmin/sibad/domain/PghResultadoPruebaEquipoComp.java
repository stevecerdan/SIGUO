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

@Entity
@Table(name = "PGH_RESUL_PRUEBA_EQUIPO_COMP")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "PghResultadoPruebaEquipoComp.findByIdResultadoPRE", query = "SELECT r FROM PghResultadoPruebaPersonal r WHERE r.idResultadoPruebaReprueba = :idResultadoPruebaReprueba")
                                                                                                                                             
})*/

public class PghResultadoPruebaEquipoComp extends Auditoria{
  private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESUL_PRUEBA_EQUIPO_COMP_", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESUL_PRUEBA_EQUIPO_COMP")
	private Long idResultadoPruebaEquipoComp;
	
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	
	@Column(name = "ID_EQUIPO_COMPONENTE")
	private Long idEquipoComponente;

	public PghResultadoPruebaEquipoComp() {
		
	}
	
	public PghResultadoPruebaEquipoComp(Long idResultadoPruebaEquipoComp) {
		
		this.idResultadoPruebaEquipoComp = idResultadoPruebaEquipoComp;
	}
	
	public PghResultadoPruebaEquipoComp(Long idResultadoPruebaEquipoComp, Long idResultadoPruebaReprueba,
			Long idEquipoComponente) {
		
		this.idResultadoPruebaEquipoComp = idResultadoPruebaEquipoComp;
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
		this.idEquipoComponente = idEquipoComponente;
	}

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

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoPruebaEquipoComp != null ? idResultadoPruebaEquipoComp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPruebaEquipoComp)) {
            return false;
        }
        PghResultadoPruebaEquipoComp other = (PghResultadoPruebaEquipoComp) object;
        if ((this.idResultadoPruebaEquipoComp == null && other.idResultadoPruebaEquipoComp != null) || (this.idResultadoPruebaEquipoComp != null && !this.idResultadoPruebaEquipoComp.equals(other.idResultadoPruebaEquipoComp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPruebaEquipoComp[ idResultadoPruebaEquipoComp =" + idResultadoPruebaEquipoComp + " ]";
    }
	
}
