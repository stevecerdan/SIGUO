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
@Table(name = "VIEW_EMPRESA_ACREDITADA")
@XmlRootElement
@NamedQueries({
   // @NamedQuery(name = "PghEmpresaAcreditadaV.findByAlcance", query = "SELECT e FROM PghEmpresaAcreditadaV e"),
	@NamedQuery(name = "PghEmpresaAcreditadaV.findByAlcance", query = "SELECT e FROM PghEmpresaAcreditadaV e WHERE e.idAlcanceAcreditacion = :idAlcanceAcreditacion"),
    @NamedQuery(name = "PghEmpresaAcreditadaV.findByFilter", query = "SELECT e FROM PghEmpresaAcreditadaV e WHERE e.idOrganismoAcreditador = :idOrganismoAcreditador and" +
    																											" upper(e.ruc) like :ruc and" + 
    																											" upper(e.razonSocial) like :razonSocial and" +
    																											" upper(e.direccion) like :direccion and" + 
    																											" upper(e.departamento) like :departamento and" + 
    																											" upper(e.provincia) like :provincia and" + 
    																											" upper(e.distrito) like :distrito and" +
    																											" (upper(e.estadoAlcance) like :estadoAlcance or" +
																												" upper(e.estadoAccion) like :estadoAccion or" +
																												" upper(e.estadoAccion) like :estadoEmpresa)"),
	@NamedQuery(name = "PghEmpresaAcreditadaV.findByListarProcesos", query = "SELECT e FROM PghEmpresaAcreditadaV e WHERE e.idOrganismoAcreditador = :idOrganismoAcreditador and" +
																												" upper(e.ruc) like :ruc and" + 
																												" e.idTipoPrueba = :idTipoPrueba"),
    //Traer Fecha Ultima Actualizacion
    @NamedQuery(name = "PghEmpresaAcreditadaV.findByFechaUA", query = "SELECT e FROM PghEmpresaAcreditadaV e WHERE e.idAlcanceAcreditacion = (SELECT max(e.idAlcanceAcreditacion) FROM PghEmpresaAcreditadaV e WHERE e.idEmpresaAcreditada = :idEmpresaAcreditada and e.idOrganismoAcreditador = :idOrganismoAcreditador and e.idTipoPrueba = :idTipoPrueba)"),
    //Buscar Empresas con Alcance Vigente x Tipo de Prueba
    @NamedQuery(name = "PghEmpresaAcreditadaV.findByAlcanceXPrueba", query = "SELECT e FROM PghEmpresaAcreditadaV e WHERE e.idTipoPrueba = :idTipoPrueba and (e.estadoAlcance = 'A' or e.estadoAccion = 'S')"),
    //Traer Datos de la Empresa Acreditada
    @NamedQuery(name = "PghEmpresaAcreditadaV.findByDatosEmpresa", query = "SELECT e FROM PghEmpresaAcreditadaV e WHERE e.idEmpresaAcreditada = :idEmpresaAcreditada")
    

})

public class PghEmpresaAcreditadaV extends Auditoria{
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALCANCE_ACREDITACION")
    private Long idAlcanceAcreditacion;
    @Size(max = 10)
    
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 13)
    
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 256)
    
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 512)
    
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Size(max = 100)
    
    @Column(name = "PROVINCIA")
    private String provincia;
    @Size(max = 100)
    
    @Column(name = "DISTRITO")
    private String distrito;
    @Size(max = 100)
    
    @Column(name = "ID_PRIMER_ALCANCE_ACREDITACION")
    private Long idPrimerAlcanceAcreditacion;
    
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 16)
    
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 64)
    
    @Column(name = "WEB")
    private String web;
    @Size(max = 256)
    
    @Column(name = "RESOLUCION_CEDULA")
    private String resolucionCedula;
    @Size(max = 64)
    //---------------------------------------------
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private String idDocumentoAdjunto;
    
    @Column(name = "ID_DOCUMENTO_ALCANCE_ACREDITA")
    private String idDocumentoAlcanceAcredita;
    
    @Column(name = "NORMA_EVALUADA")
    private String normaEvaluada;
    
    @Column(name = "ID_ORGANISMO_ACREDITADOR")
    private Long idOrganismoAcreditador;
    //---------------------------------------------
    @Column(name = "FECHA_INICIO_VIGENCIA")
    private Date fechaIVigencia;
    
    @Column(name = "FECHA_ULTIMA_ACTUALIZACION")
    private Date fechaUActualizacion;
    
    @Column(name = "FECHA_ACREDITACION")
    private Date fechaAcreditacion;
    
    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;
    
    @Column(name = "TIPO_ORGANISMO")
    private String tipoOrganismo;
    @Size(max = 200)
    
    @Column(name = "TIPO_PRUEBA")
    private String tipoPrueba;
    @Size(max = 200)
    //----------------------------------
    @Column(name = "ID_TIPO_ORGANISMO")
    private String idTipoOrganismo;
  
    @Column(name = "ID_TIPO_PRUEBA")
    private String idTipoPrueba;
    //----------------------------------
    @Column(name = "REGISTRO")
    private String registro;
    @Size(max = 64)
    
    @Column(name = "ESTADO_EMPRESA")
    private String estadoEmpresa;
    
    @Column(name = "ESTADO_ALCANCE")
    private String estadoAlcance;
    
	@Column(name = "ESTADO_ACCION")
    private String estadoAccion;
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcreditada;
    
    
    public PghEmpresaAcreditadaV() {
    }
    /*
    public PghEmpresaAcreditadaV(Long idEmpresaAcreditada) {
        this.idEmpresaAcreditada = idEmpresaAcreditada;
    }
    
    public PghEmpresaAcreditadaV(Long idEmpresaAcreditada, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idEmpresaAcreditada = idEmpresaAcreditada;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }
    */
    public PghEmpresaAcreditadaV(Long idAlcanceAcreditacion) {
        this.idAlcanceAcreditacion = idAlcanceAcreditacion;
    }
    
    public PghEmpresaAcreditadaV(Long idAlcanceAcreditacion, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idAlcanceAcreditacion = idAlcanceAcreditacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }
    
    public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Long getIdPrimerAlcanceAcreditacion() {
		return idPrimerAlcanceAcreditacion;
	}

	public void setIdPrimerAlcanceAcreditacion(Long idPrimerAlcanceAcreditacion) {
		this.idPrimerAlcanceAcreditacion = idPrimerAlcanceAcreditacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getResolucionCedula() {
		return resolucionCedula;
	}

	public void setResolucionCedula(String resolucionCedula) {
		this.resolucionCedula = resolucionCedula;
	}

	public Date getFechaIVigencia() {
		return fechaIVigencia;
	}

	public void setFechaIVigencia(Date fechaIVigencia) {
		this.fechaIVigencia = fechaIVigencia;
	}

	public Date getFechaUActualizacion() {
		return fechaUActualizacion;
	}

	public void setFechaUActualizacion(Date fechaUActualizacion) {
		this.fechaUActualizacion = fechaUActualizacion;
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

	public String getTipoOrganismo() {
		return tipoOrganismo;
	}

	public void setTipoOrganismo(String tipoOrganismo) {
		this.tipoOrganismo = tipoOrganismo;
	}

	public String getTipoPrueba() {
		return tipoPrueba;
	}

	public void setTipoPrueba(String tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}
	
	public String getEstadoAccion() {
		return estadoAccion;
	}
	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}
	//------------------------------------------------------
	public String getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(String idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public String getIdDocumentoAlcanceAcredita() {
		return idDocumentoAlcanceAcredita;
	}

	public void setIdDocumentoAlcanceAcredita(String idDocumentoAlcanceAcredita) {
		this.idDocumentoAlcanceAcredita = idDocumentoAlcanceAcredita;
	}

	public String getNormaEvaluada() {
		return normaEvaluada;
	}

	public void setNormaEvaluada(String normaEvaluada) {
		this.normaEvaluada = normaEvaluada;
	}

	public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}

	public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}

	public String getIdTipoOrganismo() {
		return idTipoOrganismo;
	}

	public void setIdTipoOrganismo(String idTipoOrganismo) {
		this.idTipoOrganismo = idTipoOrganismo;
	}

	public String getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(String idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
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
        if (!(object instanceof PghEmpresaAcreditadaV)) {
            return false;
        }
        PghEmpresaAcreditadaV other = (PghEmpresaAcreditadaV) object;
        if ((this.idAlcanceAcreditacion == null && other.idAlcanceAcreditacion != null) || (this.idAlcanceAcreditacion != null && !this.idAlcanceAcreditacion.equals(other.idAlcanceAcreditacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEmpresaAcreditadaV[ idAlcanceAcreditacion=" + idAlcanceAcreditacion + " ]";
    }
    /*
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaAcreditada != null ? idEmpresaAcreditada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEmpresaAcreditadaV)) {
            return false;
        }
        PghEmpresaAcreditadaV other = (PghEmpresaAcreditadaV) object;
        if ((this.idEmpresaAcreditada == null && other.idEmpresaAcreditada != null) || (this.idEmpresaAcreditada != null && !this.idEmpresaAcreditada.equals(other.idEmpresaAcreditada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEmpresaAcreditadaV[ idEmpresaAcreditada=" + idEmpresaAcreditada + " ]";
    }
    */
}
