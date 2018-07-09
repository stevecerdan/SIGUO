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
@Table(name = "PGH_RESULTADO_PRUEBA_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoPruebaPersonal.findByIdResultadoPruebaReprueba", query = "SELECT r FROM PghResultadoPruebaPersonal r WHERE r.idResultadoPruebaReprueba = :idResultadoPruebaReprueba")
                                                                                                                                             
})

public class PghResultadoPruebaPersonal extends Auditoria{
  private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_PRUEBA_PERSONAL1", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_PRUEBA_PERSONAL")
	private Long idResultadoPruebaPersonal;
	
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	
	@Column(name = "ID_SEDE_PERSONAL_AUTORIZADO")
	private Long idSedePersonalAutorizado;

	public PghResultadoPruebaPersonal() {
		
	}
	
	public PghResultadoPruebaPersonal(Long idResultadoPruebaPersonal) {
		
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
	}
	
	public PghResultadoPruebaPersonal(Long idResultadoPruebaPersonal, Long idResultadoPruebaReprueba,
			Long idSedePersonalAutorizado) {
		
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}

	public Long getIdResultadoPruebaPersonal() {
		return idResultadoPruebaPersonal;
	}

	public void setIdResultadoPruebaPersonal(Long idResultadoPruebaPersonal) {
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
	}

	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}

	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}

	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoPruebaPersonal != null ? idResultadoPruebaPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPruebaPersonal)) {
            return false;
        }
        PghResultadoPruebaPersonal other = (PghResultadoPruebaPersonal) object;
        if ((this.idResultadoPruebaPersonal == null && other.idResultadoPruebaPersonal != null) || (this.idResultadoPruebaPersonal != null && !this.idResultadoPruebaPersonal.equals(other.idResultadoPruebaPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPruebaPersonal[ idResultadoPruebaPersonal=" + idResultadoPruebaPersonal + " ]";
    }
	
}
