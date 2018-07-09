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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "PGH_TRAZ_PROGRAMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTrazProgramacion.findByIdProgramacion", query = "SELECT t FROM PghTrazProgramacion t WHERE t.idProgramacion = :idProgramacion and t.estado = 'C' and rownum = 1"),
    @NamedQuery(name = "PghTrazProgramacion.findByEstado", query = "SELECT t FROM PghTrazProgramacion t WHERE t.idTrazProgramacion = (SELECT max(t.idTrazProgramacion) FROM PghTrazProgramacion WHERE t.idProgramacion = :idProgramacion and t.estado = :estado)")

})

public class PghTrazProgramacion {

	private static final long serialVersionUID = 1L;

	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TRAZ_COMPARTIMIENTO_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_TRAZ_PROGRAMACION")
	 private Long idTrazProgramacion;
	  
	 @Column(name = "ID_PROGRAMACION")
	 private Long idProgramacion; 
	 	 
	 @Column(name = "FECHA_ULTIMO_ESTADO", updatable = false)
	 @Temporal(TemporalType.DATE)
	 private Date fechaUltimoEstado; 
	 
	 @Basic(optional = false)
	 @Column(name = "ESTADO")
	 private String estado;
	 
	 @Column(name = "ID_TIPO_MOTIVO")
	 private Long idTipoMotivo;
	 
	 @Column(name = "OBSERVACION")
	 private String observacion;

	public PghTrazProgramacion() {
		
	}

	public PghTrazProgramacion(Long idTrazProgramacion, Long idProgramacion, Date fechaUltimoEstado, String estado,
			Long idTipoMotivo, String observacion) {
		
		this.idTrazProgramacion = idTrazProgramacion;
		this.idProgramacion = idProgramacion;
		this.fechaUltimoEstado = fechaUltimoEstado;
		this.estado = estado;
		this.idTipoMotivo = idTipoMotivo;
		this.observacion = observacion;
	}


	public Long getIdTrazProgramacion() {
		return idTrazProgramacion;
	}

	public void setIdTrazProgramacion(Long idTrazProgramacion) {
		this.idTrazProgramacion = idTrazProgramacion;
	}

	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public Date getFechaUltimoEstado() {
		return fechaUltimoEstado;
	}

	public void setFechaUltimoEstado(Date fechaUltimoEstado) {
		this.fechaUltimoEstado = fechaUltimoEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getIdTipoMotivo() {
		return idTipoMotivo;
	}

	public void setIdTipoMotivo(Long idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrazProgramacion != null ? idTrazProgramacion.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTrazProgramacion)) {
            return false;
        }
        PghTrazProgramacion other = (PghTrazProgramacion) object;
        if ((this.idTrazProgramacion == null && other.idTrazProgramacion != null) || (this.idTrazProgramacion != null && !this.idTrazProgramacion.equals(other.idTrazProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghTrazProgramacion[ idTrazProgramacion=" + idTrazProgramacion + " ]";
    }
    
	 
}
