package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PGH_SEDE_PERSONAL_AUTORIZADO")
@XmlRootElement

public class PghSedePersonalAutorizado extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEDE_PERSONAL_AUTORIZADO")
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_SEDE_PERSONAL_AUTORIZADO_", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idSedePersonalAutorizado;

    @Column(name = "FLAG_SEDE_PERSONAL_AUTORIZADO")
    private String flagSedePersonalAutorizado;
   
    
    @Column(name = "ID_SEDE_ACREDITACION")
    private Long idSedeAcreditacion;
   
    @Column(name = "ID_PERSONA_NATURAL")
    private Long idPersonaNatural;
   
    @Column(name = "ID_CARGO")
    private Long idCargo;
  
    @Column(name = "ID_ESPECIALIDAD")
    private Long idEspecialidad;

	public PghSedePersonalAutorizado() {
		
	}

	public PghSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}

	public PghSedePersonalAutorizado(Long idSedePersonalAutorizado, String flagSedePersonalAutorizado,
			Long idSedeAcreditacion, Long idPersonaNatural, Long idCargo, Long idEspecialidad) {
		super();
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
		this.flagSedePersonalAutorizado = flagSedePersonalAutorizado;
		this.idSedeAcreditacion = idSedeAcreditacion;
		this.idPersonaNatural = idPersonaNatural;
		this.idCargo = idCargo;
		this.idEspecialidad = idEspecialidad;
	}
	
    public PghSedePersonalAutorizado(Long idSedePersonalAutorizado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
		
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
		this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
	}

	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}

	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}

	public String getFlagSedePersonalAutorizado() {
		return flagSedePersonalAutorizado;
	}

	public void setFlagSedePersonalAutorizado(String flagSedePersonalAutorizado) {
		this.flagSedePersonalAutorizado = flagSedePersonalAutorizado;
	}

	public Long getIdSedeAcreditacion() {
		return idSedeAcreditacion;
	}

	public void setIdSedeAcreditacion(Long idSedeAcreditacion) {
		this.idSedeAcreditacion = idSedeAcreditacion;
	}

	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

  
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedePersonalAutorizado != null ? idSedePersonalAutorizado.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghSedePersonalAutorizado)) {
            return false;
        }
        PghSedePersonalAutorizado other = (PghSedePersonalAutorizado) object;
        if ((this.idSedePersonalAutorizado == null && other.idSedePersonalAutorizado != null) || (this.idSedePersonalAutorizado != null && !this.idSedePersonalAutorizado.equals(other.idSedePersonalAutorizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSedePersonalAutorizado[ idSedePersonalAutorizado=" + idSedePersonalAutorizado + " ]";
    }
     
    
    


}
