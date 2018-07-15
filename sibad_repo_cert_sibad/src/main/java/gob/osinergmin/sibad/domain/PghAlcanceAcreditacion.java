/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_ALCANCE_ACREDITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghAlcanceAcreditacion.findByIdAlcanceAcreditacion", query = "SELECT a FROM PghAlcanceAcreditacion a WHERE a.idAlcanceAcreditacion=:idAlcanceAcreditacion "),
  //Buscar si la empresa tiene alcances vigentes
    @NamedQuery(name = "PghAlcanceAcreditacion.findByAlcanceVigente", query = "SELECT a FROM PghAlcanceAcreditacion a WHERE a.idEmpresaAcreditada = :idEmpresaAcreditada and a.idAlcanceAcreditacion <> :idAlcanceAcreditacion and" +
																														" (upper(a.estado) = :estado or" +
																														" upper(a.estadoAccion) = 'S')"),
  //Traer ID Primer Alcance
    @NamedQuery(name = "PghAlcanceAcreditacion.findByPrimerAlcance", query = "SELECT a FROM PghAlcanceAcreditacion a WHERE a.idAlcanceAcreditacion = (SELECT min(a.idAlcanceAcreditacion) FROM PghAlcanceAcreditacion a WHERE a.idEmpresaAcreditada = :idEmpresaAcreditada)"),
  //Buscar Fechas de Vencimiento Iguales o Menores a la Actual
    @NamedQuery(name = "PghAlcanceAcreditacion.findByFechaV", query ="SELECT a FROM PghAlcanceAcreditacion a WHERE TO_DATE(a.fechaVencimiento,'DD/MM/YY') <= :fechaVencimiento and (upper(a.estado) = 'A' or upper(a.estadoAccion) = 'S')"),
  //Buscar Fechas de Vencimiento Iguales
    @NamedQuery(name = "PghAlcanceAcreditacion.findByFechIguales", query ="SELECT a FROM PghAlcanceAcreditacion a WHERE TO_DATE(a.fechaVencimiento,'DD/MM/YY') = :fechaVencimiento and (upper(a.estado) = 'A' or upper(a.estadoAccion) = :estadoAccion)")
})
public class PghAlcanceAcreditacion extends Auditoria{
    
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_ALCANCE_ACREDITACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_ALCANCE_ACREDITACION")
	private Long idAlcanceAcreditacion;
	  
    
	@Basic(optional = false)
	@Column(name = "ID_EMPRESA_ACREDITADA")
	private Long idEmpresaAcreditada;
	
	@Basic(optional = false)
	@Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;

	@Basic(optional = false)
	@Column(name = "ID_ORGANISMO_ACREDITADOR")
    private Long idOrganismoAcreditador;
	
	@Basic(optional = false)
    @Column(name = "RESOLUCION_CEDULA")
    private String resolucionCedula;
    
    @Column(name = "ID_PRIMER_ALCANCE_ACREDITACION")
    private Long idPrimerAlcanceAcreditacion;
    
    @Basic(optional = false)
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private Long idDocumentoAdjunto;
    
    @Column(name = "ID_DOCUMENTO_ALCANCE_ACREDITA")
    private Long idDocumentoAlcanceAcreditada;
    
    @Column(name = "ID_TIPO_ORGANISMO")
    private Long idTipoOrganismo;
    
    @Column(name = "NORMA_EVALUADA")
    private String normaEvualada;

    @Column(name = "FECHA_ULTIMA_ACTUALIZACION")
    private Date fechaUltimaActualizacion;
    
    @Basic(optional = false)
    @Column(name = "FECHA_ACREDITACION")
    private Date fechaAcreditacion;
    
    @Basic(optional = false)
    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;
    
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO_VIGENCIA")
    private Date fechaInicioVigencia;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "ESTADO_ACCION")
    private String estadoAccion;
    
    public PghAlcanceAcreditacion() {
    }

    public PghAlcanceAcreditacion(Long idAlcanceAcreditacion) {
        this.idAlcanceAcreditacion = idAlcanceAcreditacion;
    }
    
    
    public PghAlcanceAcreditacion(Long idAlcanceAcreditacion, Long idEmpresaAcreditada, Long idTipoPrueba,
			String resolucionCedula, Long idPrimerAlcanceAcreditacion, Long idDocumentoAdjunto,
			Long idDocumentoAlcanceAcreditada, Long idTipoOrganismo, String normaEvualada,
			Date fechaUltimaActualizacion, Date fechaAcreditacion, Date fechaVencimiento, String estado,
			String estadoAccion) {
		super();
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
		this.idEmpresaAcreditada = idEmpresaAcreditada;
		this.idTipoPrueba = idTipoPrueba;
		this.resolucionCedula = resolucionCedula;
		this.idPrimerAlcanceAcreditacion = idPrimerAlcanceAcreditacion;
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.idDocumentoAlcanceAcreditada = idDocumentoAlcanceAcreditada;
		this.idTipoOrganismo = idTipoOrganismo;
		this.normaEvualada = normaEvualada;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.fechaAcreditacion = fechaAcreditacion;
		this.fechaVencimiento = fechaVencimiento;
		this.estado = estado;
		this.estadoAccion = estadoAccion;
	}

	public PghAlcanceAcreditacion(Long idAlcanceAcreditacion, Long idEmpresaAcreditada, Long idTipoPrueba,
			Long idOrganismoAcreditador, String resolucionCedula, Long idPrimerAlcanceAcreditacion,
			Long idDocumentoAdjunto, Long idDocumentoAlcanceAcreditada, Long idTipoOrganismo,
			String normaEvualada, Date fechaUltimaActualizacion, Date fechaAcreditacion, Date fechaVencimiento,
			Date fechaInicioVigencia, String estado, String estadoAccion) {
		super();
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
		this.idEmpresaAcreditada = idEmpresaAcreditada;
		this.idTipoPrueba = idTipoPrueba;
		this.idOrganismoAcreditador = idOrganismoAcreditador;
		this.resolucionCedula = resolucionCedula;
		this.idPrimerAlcanceAcreditacion = idPrimerAlcanceAcreditacion;
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.idDocumentoAlcanceAcreditada = idDocumentoAlcanceAcreditada;
		this.idTipoOrganismo = idTipoOrganismo;
		this.normaEvualada = normaEvualada;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.fechaAcreditacion = fechaAcreditacion;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.estado = estado;
		this.estadoAccion = estadoAccion;
	}

	public PghAlcanceAcreditacion(Long idAlcanceAcreditacion, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idAlcanceAcreditacion = idAlcanceAcreditacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
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

	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}

	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}

	public String getResolucionCedula() {
		return resolucionCedula;
	}

	public void setResolucionCedula(String resolucionCedula) {
		this.resolucionCedula = resolucionCedula;
	}

	public Long getIdPrimerAlcanceAcreditacion() {
		return idPrimerAlcanceAcreditacion;
	}

	public void setIdPrimerAlcanceAcreditacion(Long idPrimerAlcanceAcreditacion) {
		this.idPrimerAlcanceAcreditacion = idPrimerAlcanceAcreditacion;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public Long getIdDocumentoAlcanceAcreditada() {
		return idDocumentoAlcanceAcreditada;
	}

	public void setIdDocumentoAlcanceAcreditada(Long idDocumentoAlcanceAcreditada) {
		this.idDocumentoAlcanceAcreditada = idDocumentoAlcanceAcreditada;
	}

	public Long getIdTipoOrganismo() {
		return idTipoOrganismo;
	}

	public void setIdTipoOrganismo(Long idTipoOrganismo) {
		this.idTipoOrganismo = idTipoOrganismo;
	}

	public String getNormaEvualada() {
		return normaEvualada;
	}

	public void setNormaEvualada(String normaEvualada) {
		this.normaEvualada = normaEvualada;
	}

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Date getFechaAcreditacion() {
		return fechaAcreditacion;
	}

	public void setFechaAcreditacion(Date fechaAcreditacion) {
		this.fechaAcreditacion = fechaAcreditacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoAccion() {
		return estadoAccion;
	}

	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlcanceAcreditacion != null ? idAlcanceAcreditacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghAlcanceAcreditacion)) {
            return false;
        }
        PghAlcanceAcreditacion other = (PghAlcanceAcreditacion) object;
        if ((this.idAlcanceAcreditacion == null && other.idAlcanceAcreditacion != null) || (this.idAlcanceAcreditacion != null && !this.idAlcanceAcreditacion.equals(other.idAlcanceAcreditacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghAlcanceAcreditacion[ idAlcanceAcreditacion=" + idAlcanceAcreditacion + " ]";
    }
    
    @PreUpdate
    void updatedAt() {
            this.fechaAcreditacion= new Date();
    }
    
}
