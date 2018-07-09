package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_SOLICITUD_PRUEBA_REPRUEBA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghRepruebasCilindrosGNVV.findByALL", query = "SELECT e FROM PghRepruebasCilindrosGNVV e"),
	@NamedQuery(name = "PghRepruebasCilindrosGNVV.findByID", query = "SELECT e FROM PghRepruebasCilindrosGNVV e WHERE e.idSolicitudPruebaRp = :idSolicitudPruebaRp"),
    @NamedQuery(name = "PghRepruebasCilindrosGNVV.findByFilter", query = "SELECT e FROM PghRepruebasCilindrosGNVV e WHERE e.numeroReprueba like :numeroReprueba and" + 
    																														" upper(e.nombreEmpresaAcred) like :nombreEmpresaAcred and" +
																															" upper(e.estado) like :estado and" + 
																															" e.idUnidSuperv = :idUnidSuperv and idClindroGNV <> 0"),
    @NamedQuery(name = "PghRepruebasCilindrosGNVV.findByUltimoSOL", query = "SELECT a FROM PghRepruebasCilindrosGNVV a WHERE a.idSolicitudPruebaRp = (SELECT max(a.idSolicitudPruebaRp) FROM PghRepruebasCilindrosGNVV a WHERE a.idEmpresaAcred = :idEmpresaAcred) and idTipoPrueba='1526'")
})
public class PghRepruebasCilindrosGNVV {
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
    private Long idSolicitudPruebaRp;
	
	@Column(name = "ID_UNID_SUPERV_MODULO")
    private Long idUnidSuperv;
	
	@Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
	
    @Column(name = "NRO_SOLICITUD_UNIDAD_SUPERVISA")
    private String numeroReprueba;
	
    @Column(name = "EMPRESA_ACREDITADA")
    private String nombreEmpresaAcred;
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcred;
    
    @Column(name = "ID_CILINDRO_GNV")
    private String idClindroGNV;
    
    @Column(name = "NUMERO_CILINDRO")
    private String cilindro; 
    
    @Column(name = "NUMERO_MODULO")
    private String modulo; 
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;
    
    @Column(name = "FECHA_SOLICITUD")
    private Date fechaProgramada;
    
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    
    //@Column(name = "FECHA_CERTIFICADO")
//    private String fechaCertificado;
    
    //@Column(name = "RESULTADO")
//    private String resultado;
    
    public String getCilindro() {
		return cilindro;
	}
    public void setCilindro(String cilindro) {
		this.cilindro = cilindro;
	}
    public Long getIdEmpresaAcred() {
		return idEmpresaAcred;
	}
    public String getModulo() {
		return modulo;
	}
    public void setModulo(String modulo) {
		this.modulo = modulo;
	}
    public void setIdEmpresaAcred(Long idEmpresaAcred) {
		this.idEmpresaAcred = idEmpresaAcred;
	}
    public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}
    public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
    public String getEstado() {
		return estado;
	}
    public void setEstado(String estado) {
		this.estado = estado;
	}
    public String getIdClindroGNV() {
		return idClindroGNV;
	}
    public void setIdClindroGNV(String idClindroGNV) {
		this.idClindroGNV = idClindroGNV;
	}
    public Long getIdUnidSuperv() {
		return idUnidSuperv;
	}
    public void setIdUnidSuperv(Long idUnidSuperv) {
		this.idUnidSuperv = idUnidSuperv;
	}
    
//    public String getFechaCertificado() {
//		return fechaCertificado;
//	}
//    public void setFechaCertificado(String fechaCertificado) {
//		this.fechaCertificado = fechaCertificado;
//	}
    public Date getFechaCreacion() {
		return fechaCreacion;
	}
    public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
    public Date getFechaProgramada() {
		return fechaProgramada;
	}
    public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
    public Date getFechaRegistro() {
		return fechaRegistro;
	}
    public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
    public Long getIdSolicitudPruebaRp() {
		return idSolicitudPruebaRp;
	}
    public void setIdSolicitudPruebaRp(Long idSolicitudPruebaRp) {
		this.idSolicitudPruebaRp = idSolicitudPruebaRp;
	}
//    public String getModulo() {
//		return modulo;
//	}
//    public void setModulo(String modulo) {
//		this.modulo = modulo;
//	}
    public String getNombreEmpresaAcred() {
		return nombreEmpresaAcred;
	}
    public void setNombreEmpresaAcred(String nombreEmpresaAcred) {
		this.nombreEmpresaAcred = nombreEmpresaAcred;
	}
    public String getNumeroReprueba() {
		return numeroReprueba;
	}
    public void setNumeroReprueba(String numeroReprueba) {
		this.numeroReprueba = numeroReprueba;
	}
//    public String getResultado() {
//		return resultado;
//	}
//    public void setResultado(String resultado) {
//		this.resultado = resultado;
//	}    
}
