package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "VIEW_PROGRAMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCompartimientoV.findByIdUnidadSupervisada", query = "SELECT t FROM PghCompartimientoV t WHERE t.idProgramacion = (SELECT max(t.idProgramacion) FROM PghCompartimientoV t WHERE t.idUnidadSupervisada = :idUnidadSupervisada)"),//SELECT t FROM PghCompartimientoV t WHERE t.idUnidadSupervisada = :idUnidadSupervisada and rownum = 1
    @NamedQuery(name = "PghCompartimientoV.findByFilterUnidadAlmacenamiento", query = "SELECT t FROM PghCompartimientoV t WHERE t.unidadAlmacenamiento = :unidadAlmacenamiento"),
    @NamedQuery(name = "PghCompartimientoV.findByFechaProxPrueba", query = "SELECT t FROM PghCompartimientoV t WHERE t.fechaProxPrueba = :fechaProxPrueba"),
    @NamedQuery(name = "PghCompartimientoV.findAllIdUnidadSupervisada", query = "SELECT t FROM PghCompartimientoV t WHERE t.idUnidadSupervisada = :idUnidadSupervisada "),
    @NamedQuery(name = "PghCompartimientoV.findProgramacionesVencidas", query = "SELECT t FROM PghCompartimientoV t WHERE t.idUnidadSupervisada = :idUnidadSupervisada and t.fechaProgramacion  < :fechaActual and (t.estado = 'P' or t.estado = 'R')"),
    @NamedQuery(name = "PghCompartimientoV.findByFilter", query = "SELECT t FROM PghCompartimientoV t WHERE upper(t.tipoRevision) like :tipoRevision and" + 
																											" upper(t.numeroProgramacion) like :numeroProgramacion and" +
																											" upper(t.estado) like:estado"),
    @NamedQuery(name = "PghCompartimientoV.findNroProgramacionXCompartimiento", query = "SELECT t FROM PghCompartimientoV t WHERE t.idProgramacion = (SELECT max(t.idProgramacion) FROM PghCompartimientoV WHERE t.tipoRevision = :tipoRevision and t.idUnidadSupervisada = :idUnidadSupervisada)")
})

public class PghCompartimientoV {
	  private static final long serialVersionUID = 1L;
	    
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "ID_PROGRAMACION")
	    private Long idProgramacion;
	    
	    @Column(name = "ID_COMPARTIMIENTO")
	    private Long idCompartimiento;
	    
	    @Column(name = "ID_UNIDAD_SUPERVISADA")
	    private Long idUnidadSupervisada;
	    
	    @Column(name = "ID_RESULTADO_REVISION")
		private Long IdResultadoRevision;
	    
	    @Column(name = "NUMERO")
	    private Long numero;
	    
	    @Column(name = "NUMERO_PROGRAMACION")
	    private String numeroProgramacion;
	    
	    @Column(name = "TIPO_REVISION")
	    private String tipoRevision;
	    
	    @Column(name = "UNIDAD_ALMACENAMIENTO")
	    private Long unidadAlmacenamiento;
	    
	    @Column(name = "TIPO_PROGRAMACION") 
	    private String tipoProgramacion;
	    
	    @Column(name = "ESTADO")
	    private String estado;
	    
	    @Column(name = "FECHA_PROGRAMACION", updatable = false)
		@DateTimeFormat(pattern = "MM-dd-yyyy")
		private Date fechaProgramacion;
	    
	    @Column(name = "NUMERO_SERIE") 
	    private String numeroSerie;
	    
	    @Column(name = "FECHA_INICIO", updatable = false)
	    @DateTimeFormat(pattern = "MM-dd-yyyy")
		private Date fechaInicio;
	    
	    @Column(name = "FECHA_FIN", updatable = false)
	    @DateTimeFormat(pattern = "MM-dd-yyyy")
	    private Date fechaFin;
	    
	    @Column(name = "FECHA_PROXIMA_PRUEBA", updatable = false)
	    @DateTimeFormat(pattern = "MM-dd-yyyy")
	    private Date fechaProxPrueba;
	    	    
	    @Column(name = "RESULTADO_REVISION")
		private String resultadoRevision;
	    
	    @Column(name = "FLAG_PERSONA")
		private String flagPersona;
	    
	    @Column(name = "ID_PERSONA_JURIDICA")
		private Long idPersonaJuridica;
	    
	    @Column(name = "FECHA_CREACION", updatable = false)
	    @DateTimeFormat(pattern = "MM-dd-yyyy")
		private Date fechaCreacion;

		public PghCompartimientoV() {
			
		}
		
		public PghCompartimientoV(Long idProgramacion, Long idCompartimiento, Long idUnidadSupervisada,
				Long idResultadoRevision, Long numero, String numeroProgramacion, String tipoRevision,
				Long unidadAlmacenamiento, String tipoProgramacion, String estado, Date fechaProgramacion,
				String numeroSerie, Date fechaInicio, Date fechaFin, String resultadoRevision, String flagPersona,
				Long idPersonaJuridica, Date fechaCreacion) {
			
			this.idProgramacion = idProgramacion;
			this.idCompartimiento = idCompartimiento;
			this.idUnidadSupervisada = idUnidadSupervisada;
			IdResultadoRevision = idResultadoRevision;
			this.numero = numero;
			this.numeroProgramacion = numeroProgramacion;
			this.tipoRevision = tipoRevision;
			this.unidadAlmacenamiento = unidadAlmacenamiento;
			this.tipoProgramacion = tipoProgramacion;
			this.estado = estado;
			this.fechaProgramacion = fechaProgramacion;
			this.numeroSerie = numeroSerie;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.resultadoRevision = resultadoRevision;
			this.flagPersona = flagPersona;
			this.idPersonaJuridica = idPersonaJuridica;
			this.fechaCreacion = fechaCreacion;
		}

		public Long getIdProgramacion() {
			return idProgramacion;
		}

		public void setIdProgramacion(Long idProgramacion) {
			this.idProgramacion = idProgramacion;
		}
		public Date getFechaProxPrueba() {
			return fechaProxPrueba;
		}
		public void setFechaProxPrueba(Date fechaProxPrueba) {
			this.fechaProxPrueba = fechaProxPrueba;
		}
		public Long getIdCompartimiento() {
			return idCompartimiento;
		}

		public void setIdCompartimiento(Long idCompartimiento) {
			this.idCompartimiento = idCompartimiento;
		}

		public Long getIdUnidadSupervisada() {
			return idUnidadSupervisada;
		}

		public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
			this.idUnidadSupervisada = idUnidadSupervisada;
		}

		public Long getIdResultadoRevision() {
			return IdResultadoRevision;
		}

		public void setIdResultadoRevision(Long idResultadoRevision) {
			IdResultadoRevision = idResultadoRevision;
		}

		public String getNumeroProgramacion() {
			return numeroProgramacion;
		}

		public void setNumeroProgramacion(String numeroProgramacion) {
			this.numeroProgramacion = numeroProgramacion;
		}

		public String getTipoRevision() {
			return tipoRevision;
		}

		public void setTipoRevision(String tipoRevision) {
			this.tipoRevision = tipoRevision;
		}

		public Long getUnidadAlmacenamiento() {
			return unidadAlmacenamiento;
		}

		public Long getNumero() {
			return numero;
		}

		public void setNumero(Long numero) {
			this.numero = numero;
		}

		public void setUnidadAlmacenamiento(Long unidadAlmacenamiento) {
			this.unidadAlmacenamiento = unidadAlmacenamiento;
		}

		public String getTipoProgramacion() {
			return tipoProgramacion;
		}

		public void setTipoProgramacion(String tipoProgramacion) {
			this.tipoProgramacion = tipoProgramacion;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		public Date getFechaProgramacion() {
			return fechaProgramacion;
		}

		public void setFechaProgramacion(Date fechaProgramacion) {
			this.fechaProgramacion = fechaProgramacion;
		}
		
		public String getNumeroSerie() {
			return numeroSerie;
		}

		public void setNumeroSerie(String numeroSerie) {
			this.numeroSerie = numeroSerie;
		}

		public Date getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public String getResultadoRevision() {
			return resultadoRevision;
		}

		public void setResultadoRevision(String resultadoRevision) {
			this.resultadoRevision = resultadoRevision;
		}

		public Date getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
		}

		public String getFlagPersona() {
			return flagPersona;
		}

		public void setFlagPersona(String flagPersona) {
			this.flagPersona = flagPersona;
		}

		public Long getIdPersonaJuridica() {
			return idPersonaJuridica;
		}

		public void setIdPersonaJuridica(Long idPersonaJuridica) {
			this.idPersonaJuridica = idPersonaJuridica;
		}
		
		public Date getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idProgramacion != null ? idProgramacion.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof PghCompartimientoV)) {
	            return false;
	        }
	        PghCompartimientoV other = (PghCompartimientoV) object;
	        if ((this.idProgramacion == null && other.idProgramacion != null) || (this.idProgramacion != null && !this.idProgramacion.equals(other.idProgramacion))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "gob.osinerg.sibad.domain.PghCompartimientoV[ idProgramacion=" + idProgramacion + " ]";
	    }
}
