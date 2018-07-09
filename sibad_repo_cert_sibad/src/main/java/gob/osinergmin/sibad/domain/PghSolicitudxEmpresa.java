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
@Table(name = "VIEW_LISTA_SOLICITUDES")
@XmlRootElement
@NamedQueries({ 
	@NamedQuery(name = "PghSolicitudxEmpresa.findByIdEmpresa", query = "SELECT e FROM PghSolicitudxEmpresa e WHERE e.idEmpresaAcreditada = :idEmpresaAcreditada")
})
public class PghSolicitudxEmpresa {
	@Id
    @Basic(optional = false)
	@NotNull
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	
	@Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
	private Long idSolicitudPruebaReprueba;

    @Column(name = "NRO_SOLICITUD_UNIDAD_SUPERVISA")
	private String nroSolicitudUnidadSupervisa;
    
    @Column(name = "ID_TIPO_PRUEBA")
	private Long idTipoPrueba;
    
    @Column(name = "TIPO_PRUEBA")
	private String tipoPrueba;
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
	private Long idEmpresaAcreditada;
    
    @Column(name = "EMPRESA")
	private String empresaAcreditada;
    
    @Column(name = "ID_UNID_SUPERV_TANQUE")
	private Long idUnidSupervTanque;
    
    @Column(name = "ID_UNID_SUPERV_MODULO")
	private Long idUnidSupervModulo;
    
    @Column(name = "ID_COMPARTIMIENTO")
	private Long idCompartimiento;
    
    @Column(name = "ID_CILINDRO_GNV")
	private Long idCilindroGNV;
    
    @Column(name = "UNID_ALMACENAMIENTO_1")
	private String unidAlmacenamiento1;
    
    @Column(name = "UNID_ALMACENAMIENTO_2")
	private String unidAlmacenamiento2;
    
    @Column(name = "NUMERO_COMPARTIMIENTO")
	private Long numeroCompartimiento;
    
    @Column(name = "ID_ALMACENAMIENTO")
	private Long idAlmacenamiento;
    
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnid;
    
//    @Column(name = "NOMBRE_UNIDAD_MODULO")
//    private String nombreUnidModulo;
    
    @Column(name = "NUMERO_TANQUE")
	private String numeroTanque;
    
    @Column(name = "DIRECCION")
	private String direccion;
    
    @Column(name = "UBIGEO")
	private String ubigeo;
    
    @Column(name = "ID_MODULO")
	private Long idModulo;
    
    @Column(name = "NUMERO_MODULO")
	private Long modulo;
    
    @Column(name = "NUMERO_CILINDRO")
	private Long cilindro;
    
    @Column(name = "ESTADO")
	private String estado;
    
    @Column(name = "FECHA_SOLICITUD")
	private Date fechaSolicitud;
    
    @Column(name = "RESULTADO_PRUEBA")
	private String resultadoPrueba;

    @Column(name = "FECHA_CREACION")	
	private Date fechaCreacion;
    
    @Column(name = "FECHA_INICIO")	
	private Date fechaInicio;
		
    public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}
    public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public String getUnidAlmacenamiento1() {
		return unidAlmacenamiento1;
	}
	public void setUnidAlmacenamiento1(String unidAlmacenamiento1) {
		this.unidAlmacenamiento1 = unidAlmacenamiento1;
	}
	public String getUnidAlmacenamiento2() {
		return unidAlmacenamiento2;
	}
	public void setUnidAlmacenamiento2(String unidAlmacenamiento2) {
		this.unidAlmacenamiento2 = unidAlmacenamiento2;
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
	public String getNombreUnid() {
		return nombreUnid;
	}
	public void setNombreUnid(String nombreUniD) {
		this.nombreUnid = nombreUniD;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public Long getIdCilindroGNV() {
		return idCilindroGNV;
	}
	public void setIdCilindroGNV(Long idCilindroGNV) {
		this.idCilindroGNV = idCilindroGNV;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
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
}
