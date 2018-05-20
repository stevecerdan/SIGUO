package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PGH_PROGRAMACION")
@NamedQueries({
    @NamedQuery(name = "PghProgramacion.findByIdCompartimiento", query = "SELECT t FROM PghProgramacion t WHERE t.idCompartimiento = :idCompartimiento and rownum = 1 order by t.idProgramacion desc "), 
})

public class PghProgramacion extends Auditoria{
	
	private static final long serialVersionUID = 1L;

	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_PROGRAMACION_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_PROGRAMACION")
	 private Long idProgramacion;
	  
	 @Column(name = "NUMERO_PROGRAMACION")
	 private String numeroProgramacion; 
	 
	 @Column(name = "TIPO_PROGRAMACION")
	 private String tipoProgramacion; 
	 
	 @Column(name = "TIPO_REVISION")
	 private String tipoRevision; 
	 
	 @Column(name = "FECHA_PROGRAMACION")
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date fechaProgramacion; 
	 
	 @Column(name = "ID_COMPARTIMIENTO") 
	 private Long idCompartimiento; 
	 
	 @Basic(optional = false)
	 @Column(name = "ESTADO")
	 private String estado;
	 
	 
	public PghProgramacion() {
		
	}
	 
	public PghProgramacion(Long idProgramacion) {
			
		this.idProgramacion = idProgramacion;
	}
 
	public PghProgramacion(Long idProgramacion, String numeroProgramacion, String tipoProgramacion, String tipoRevision,Date fechaProgramacion, Long idCompartimiento, String estado) {
		
		this.idProgramacion = idProgramacion;
		this.numeroProgramacion = numeroProgramacion;
		this.tipoProgramacion = tipoProgramacion;
		this.tipoRevision = tipoRevision;
		this.fechaProgramacion = fechaProgramacion;
		this.idCompartimiento = idCompartimiento;
		this.estado = estado;
	}
	
	public PghProgramacion(Long idProgramacion, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
		
		this.idProgramacion = idProgramacion;
		this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
	}
	
	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public String getNumeroProgramacion() {
		return numeroProgramacion;
	}

	public void setNumeroProgramacion(String numeroProgramacion) {
		this.numeroProgramacion = numeroProgramacion;
	}

	public String getTipoProgramacion() {
		return tipoProgramacion;
	}

	public void setTipoProgramacion(String tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}

	public String getTipoRevision() {
		return tipoRevision;
	}

	public void setTipoRevision(String tipoRevision) {
		this.tipoRevision = tipoRevision;
	}

	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}

	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}

	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
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
        hash += (idProgramacion != null ? idProgramacion.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghProgramacion)) {
            return false;
        }
        PghProgramacion other = (PghProgramacion) object;
        if ((this.idProgramacion == null && other.idProgramacion != null) || (this.idProgramacion != null && !this.idProgramacion.equals(other.idProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghProgramacion[ idProgramacion=" + idProgramacion + " ]";
    }
    
	@PrePersist
    void createdAt() {		
            this.fechaProgramacion = new Date();
    }

}
