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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PGH_RESULTADO_REVISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoRevision.findByIdResultado", query = "SELECT a FROM PghResultadoRevision a WHERE a.idResultadoRevision = :idResultadoRevision")
                                                                                                                                             
})
public class PghResultadoRevision extends Auditoria{
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_REVISION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_REVISION")
	private Long idResultadoRevision;
	
	@Column(name = "ID_PROGRAMACION")
	private Long idProgramacion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "HORA_INICIO")
	private String horaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "HORA_FIN")
	private String horaFin;
	
	@Column(name = "TIPO_PERSONAL")
	private String tipoPersonal;
	
	@Column(name = "FLAG_PERSONA")
	private String flagPersona;
	
	@Column(name = "ID_PERSONA_JURIDICA")
	private Long idPersonaJuridica;
	
	@Column(name = "RESULTADO_REVISION")
	private String resultadoRevision;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "ESTADO_RESULTADO")
	private String estadoResultado;
	

	public PghResultadoRevision() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PghResultadoRevision(Long idResultadoRevision) {

		this.idResultadoRevision = idResultadoRevision;
	}
	
	public PghResultadoRevision(Long idResultadoRevision, Long idProgramacion,  Date fechaInicio, String horaInicio,  
								Date fechaFin, String horaFin, String tipoPersonal, String flagPersona, Long idPersonaJuridica, 
								String resultadoRevision, String observacion, String estadoResultado) {
		this.idResultadoRevision = idResultadoRevision;
		this.idProgramacion = idProgramacion;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.fechaFin = fechaFin;
		this.horaFin =  horaFin;
		this.tipoPersonal = tipoPersonal;
		this.flagPersona = flagPersona;
		this.idPersonaJuridica = idPersonaJuridica;
		this.resultadoRevision = resultadoRevision;
		this.observacion = observacion;
		this.estadoResultado = estadoResultado;
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	
	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	public String getTipoPersonal() {
		return tipoPersonal;
	}
	
	public void setTipoPersonal(String tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	
	public String getFlagPersona() {
		return flagPersona;
	}
	
	public void setFlagPersona(String flagPersona) {
		this.flagPersona = flagPersona;
	}
	
	public String getResultadoRevision() {
		return resultadoRevision;
	}
	
	public void setResultadoRevision(String resultadoRevision) {
		this.resultadoRevision = resultadoRevision;
	}
	
	public String getEstadoResultado() {
		return estadoResultado;
	}
	
	public void setEstadoResultado(String estadoResultado) {
		this.estadoResultado = estadoResultado;
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
        hash += (idResultadoRevision != null ? idResultadoRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoRevision)) {
            return false;
        }
        PghResultadoRevision other = (PghResultadoRevision) object;
        if ((this.idResultadoRevision == null && other.idResultadoRevision != null) || (this.idResultadoRevision != null && !this.idResultadoRevision.equals(other.idResultadoRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoRevision[ idResultadoRevision=" + idResultadoRevision + " ]";
    }
	
}
