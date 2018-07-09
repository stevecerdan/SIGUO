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

/*
 * @author jpiro
 */
@Entity
@Table(name = "VIEW_SOLICITUD_PRUEBA_REPRUEBA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudGeneral", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.idSolicitudPruebaReprueba = :idSolicitudPruebaReprueba"),
	//BUSCARPOR FECHA PROXIMA PRUEBA
	@NamedQuery(name = "PghSolicitudPruebaRepruebaV.findByFechaProximaPrueba", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.fechaProxPrueba = :fechaProxPrueba"),
	//LISTAR SOLICITUDES PRUEBA HERMETICIDAD
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudFilter", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.idUnidSupervTanque = :idUnidSupervTanque and" +
																															" upper(e.nroSolicitudUnidadSupervisa) like :nroSolicitudUnidadSupervisa and" + 
    																														" upper(e.empresaAcreditada) like :empresaAcreditada and" +
																															" upper(e.estado) like :estado"),
    //LISTAR SOLO SOLICITUDES CON RESULTADO
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySoloResultado", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.idUnidSupervTanque = :idUnidSupervTanque and" +
																															" upper(e.resultadoPrueba) like :resultadoPrueba"),
    //LISTAR REPRUEBAS GNV
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudFilter2", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.idUnidSupervModulo = :idUnidSupervModulo and" +
																															" upper(e.nroSolicitudUnidadSupervisa) like :nroSolicitudUnidadSupervisa and" + 
																															" upper(e.empresaAcreditada) like :empresaAcreditada and" +
																															" upper(e.estado) like :estado"),
    //LISTAR SOLICITUDES PENDIENTES
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudFilterPEND", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.idTipoPrueba = :idTipoPrueba and" +
																												    		" upper(e.nroSolicitudUnidadSupervisa) like :nroSolicitudUnidadSupervisa and" + 
																															" upper(e.empresaAcreditada) like :empresaAcreditada and" +
																															" (upper(e.estado) like :estado or" + 
																															" upper(e.estado) like 'R' or" +
																															" upper(e.estado) like 'C' or" +
																															" upper(e.estado) like 'E')"),
    //LISTAR SOLICITUDES ATENDIDAS
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudFilterATEND", query = "SELECT e FROM PghSolicitudPruebaRepruebaV e WHERE e.idTipoPrueba = :idTipoPrueba and" +
																												    		" upper(e.nroSolicitudUnidadSupervisa) like :nroSolicitudUnidadSupervisa and" + 
																															" upper(e.empresaAcreditada) like :empresaAcreditada and" +
																															" (upper(e.estado) like :estado or upper(e.estado) like 'I')"),
    //BUSCAR ULTIMO NUMERO DE SOLICITUD X TIPO PRUEBA
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findByUltimoSOL", query = "SELECT a FROM PghSolicitudPruebaRepruebaV a WHERE a.idSolicitudPruebaReprueba = (SELECT max(a.idSolicitudPruebaReprueba)"+
																															" FROM PghSolicitudPruebaRepruebaV a WHERE (a.idUnidSupervTanque = :idUnidSupervTanque or"+
																															" a.idUnidSupervModulo = :idUnidSupervModulo) and"+
    																														" a.idTipoPrueba = :idTipoPrueba)"),
    //BUSCAR COMPARTIMIENTOS REGISTRADOS X EMPRESA
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudFilterCompXEmp", query = "SELECT a FROM PghSolicitudPruebaRepruebaV a WHERE a.idEmpresaAcreditada = :idEmpresaAcreditada and"+
																																			 " a.idTipoPrueba = :idTipoPrueba"),
    //BUSCAR ULTIMO RESULTADO X TIPO PRUEBA CON NUMERO CERTIFICADO
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findByUltimoRESNC", query = "SELECT a FROM PghSolicitudPruebaRepruebaV a WHERE a.idResultadoPruebaReprueba = (SELECT max(a.idResultadoPruebaReprueba)"+
																															" FROM PghSolicitudPruebaRepruebaV a WHERE a.resultadoPrueba = :resultadoPrueba and"+
    																														" a.idTipoPrueba = :idTipoPrueba and a.numeroCertificado <> '0')"),
    //BUSCAR ULTIMO RESULTADO X TIPO PRUEBA CON NUMERO INFORME
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findByUltimoRESNI", query = "SELECT a FROM PghSolicitudPruebaRepruebaV a WHERE a.idResultadoPruebaReprueba = (SELECT max(a.idResultadoPruebaReprueba)"+
																															" FROM PghSolicitudPruebaRepruebaV a WHERE a.idTipoPrueba = :idTipoPrueba and"+
    																														" a.numeroInforme <> '0')"),
    //BUSCAR SOLICITUDES CON PRUEBAS CONCLUIDAS Y NO TENGAN INFORME DE RIESGO
    @NamedQuery(name = "PghSolicitudPruebaRepruebaV.findBySolicitudFilterNoInfo", query = "SELECT a FROM PghSolicitudPruebaRepruebaV a WHERE a.estado = 'I' and a.flagInformeIndiceRiesgo = :flagInformeIndiceRiesgo")

})

public class PghSolicitudPruebaRepruebaV{
	
	/*private String estado2;
	private String estado3;
	private String estado4;*/
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
    private Long idSolicitudPruebaReprueba;
    @Size(max = 10)
    
    @Column(name = "NRO_SOLICITUD_UNIDAD_SUPERVISA")
    private String nroSolicitudUnidadSupervisa;
    @Size(max = 32)
    
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
    @Size(max = 10)
    
    @Column(name = "TIPO_PRUEBA")
    private String tipoPrueba;
    @Size(max = 200)
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcreditada;
    @Size(max = 10)
    
    @Column(name = "EMPRESA_ACREDITADA")
    private String empresaAcreditada;
    @Size(max = 256)
    
    @Column(name = "ID_UNID_SUPERV_TANQUE")
    private Long idUnidSupervTanque;
    @Size(max = 10)
    
    @Column(name = "ID_UNID_SUPERV_MODULO")
    private Long idUnidSupervModulo;
    @Size(max = 10)
    
    @Column(name = "ID_COMPARTIMIENTO")
    private Long idCompartimiento;
    @Size(max = 10)
    
    @Column(name = "NUMERO_COMPARTIMIENTO")
    private Long numeroCompartimiento;
    @Size(max = 38)
    
    @Column(name = "ID_ALMACENAMIENTO")
    private Long idAlmacenamiento;
    @Size(max = 10)
    
    @Column(name = "NUMERO_TANQUE")
    private String numeroTanque;
    @Size(max = 50)
    
    @Column(name = "NUMERO_SERIE")
    private String numeroSerie;
    
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 1)
    
    @Column(name = "FECHA_SOLICITUD")
    private Date fechaSolicitud;
    
    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;
	
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
    private Long idResultadoPruebaReprueba;
    
	@Column(name = "FECHA_INICIO")
    private Date fechaInicio;
	
	@Column(name = "RESULTADO_PRUEBA")
    private String resultadoPrueba;
    @Size(max = 1)
    
    @Column(name = "FECHA_PROXIMA_PRUEBA")
    private Date fechaProxPrueba;
	    
    @Column(name = "ID_MODULO")
    private Long idModulo;
    @Size(max = 10)
    
    @Column(name = "ID_CILINDRO_GNV")
    private Long idCilindroGNV;
    
    @Column(name = "NUMERO_MODULO")
    private Long modulo;
    
    @Column(name = "NUMERO_CILINDRO")
    private Long cilindro;
    
    @Column(name = "FECHA_EMISION_CERTIFICADO")
	private Date fechaEmisionCertificado;
    
    @Column(name = "NUMERO_CERTIFICADO")
    private String numeroCertificado;
    @Size(max = 32)
    
    @Column(name = "NUMERO_INFORME")
    private String numeroInforme;
    @Size(max = 32)
    
    @Column(name = "FLAG_INFORME_INDICE_RIESGO")
    private String flagInformeIndiceRiesgo;
    
    public PghSolicitudPruebaRepruebaV() {
    }
    
    public PghSolicitudPruebaRepruebaV(Long idSolicitudPruebaReprueba) {
        this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
    }

	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}

	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}

	public String getNroSolicitudUnidadSupervisa() {
		return nroSolicitudUnidadSupervisa;
	}

	public void setNroSolicitudUnidadSupervisa(String nroSolicitudUnidadSupervisa) {
		this.nroSolicitudUnidadSupervisa = nroSolicitudUnidadSupervisa;
	}

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public String getTipoPrueba() {
		return tipoPrueba;
	}

	public void setTipoPrueba(String tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
	}

	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public String getEmpresaAcreditada() {
		return empresaAcreditada;
	}

	public void setEmpresaAcreditada(String empresaAcreditada) {
		this.empresaAcreditada = empresaAcreditada;
	}

	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}

	public Long getNumeroCompartimiento() {
		return numeroCompartimiento;
	}

	public void setNumeroCompartimiento(Long numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}

	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	public String getNumeroTanque() {
		return numeroTanque;
	}

	public void setNumeroTanque(String numeroTanque) {
		this.numeroTanque = numeroTanque;
	}
	
	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

    
	//---------------------------
	
	public Long getIdUnidSupervTanque() {
		return idUnidSupervTanque;
	}

	public void setIdUnidSupervTanque(Long idUnidSupervTanque) {
		this.idUnidSupervTanque = idUnidSupervTanque;
	}

	public Long getIdUnidSupervModulo() {
		return idUnidSupervModulo;
	}

	public void setIdUnidSupervModulo(Long idUnidSupervModulo) {
		this.idUnidSupervModulo = idUnidSupervModulo;
	}

	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}

	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public Long getIdCilindroGNV() {
		return idCilindroGNV;
	}

	public void setIdCilindroGNV(Long idCilindroGNV) {
		this.idCilindroGNV = idCilindroGNV;
	}

	public Long getModulo() {
		return modulo;
	}

	public void setModulo(Long modulo) {
		this.modulo = modulo;
	}

	public Long getCilindro() {
		return cilindro;
	}

	public void setCilindro(Long cilindro) {
		this.cilindro = cilindro;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getResultadoPrueba() {
		return resultadoPrueba;
	}

	public void setResultadoPrueba(String resultadoPrueba) {
		this.resultadoPrueba = resultadoPrueba;
	}

	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}

	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	}

	public Date getFechaEmisionCertificado() {
		return fechaEmisionCertificado;
	}

	public void setFechaEmisionCertificado(Date fechaEmisionCertificado) {
		this.fechaEmisionCertificado = fechaEmisionCertificado;
	}
	
	public String getNumeroCertificado() {
		return numeroCertificado;
	}

	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}

	public String getNumeroInforme() {
		return numeroInforme;
	}

	public void setNumeroInforme(String numeroInforme) {
		this.numeroInforme = numeroInforme;
	}
	
	public String getFlagInformeIndiceRiesgo() {
		return flagInformeIndiceRiesgo;
	}

	public void setFlagInformeIndiceRiesgo(String flagInformeIndiceRiesgo) {
		this.flagInformeIndiceRiesgo = flagInformeIndiceRiesgo;
	}
	
	//--------------------------
	
	/*public String getEstado2() {
		return estado2;
	}

	public void setEstado2(String estado2) {
		this.estado2 = estado2;
	}

	public String getEstado3() {
		return estado3;
	}

	public void setEstado3(String estado3) {
		this.estado3 = estado3;
	}

	public String getEstado4() {
		return estado4;
	}

	public void setEstado4(String estado4) {
		this.estado4 = estado4;
	}*/

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudPruebaReprueba != null ? idSolicitudPruebaReprueba.hashCode() : 0);
        return hash;
    }
	
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghSolicitudPruebaRepruebaV)) {
            return false;
        }
        PghSolicitudPruebaRepruebaV other = (PghSolicitudPruebaRepruebaV) object;
        if ((this.idSolicitudPruebaReprueba == null && other.idSolicitudPruebaReprueba != null) || (this.idSolicitudPruebaReprueba != null && !this.idSolicitudPruebaReprueba.equals(other.idSolicitudPruebaReprueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSolicitudPruebaRepruebaV[ idSolicitudPruebaReprueba=" + idSolicitudPruebaReprueba + " ]";
    }
}
