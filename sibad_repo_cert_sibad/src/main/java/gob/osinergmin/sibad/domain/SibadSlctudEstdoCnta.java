package gob.osinergmin.sibad.domain;

import java.io.Serializable;
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


/**
 * The persistent class for the SIBAD_SLCTUD_ESTDO_CNTA database table.
 * 
 */
@Entity
@Table(name="SIBAD_SLCTUD_ESTDO_CNTA")
@NamedQueries({
    @NamedQuery(name = "SibadSlctudEstdoCnta.findByid", query = "SELECT m FROM SibadSlctudEstdoCnta m WHERE m.id = :idFormatoUno")})

public class SibadSlctudEstdoCnta implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @SequenceGenerator(name = "ID_SLCTUD_EECC_SEQ", sequenceName = "SIBAD_SLCTUD_EECC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SLCTUD_EECC_SEQ")
    @Column(name = "ID")
	private long id;
	
		

	@Column(name="CDGO_OSNERG")
	private String cdgoOsnerg;

	@Column(name="CRREO_ELCTRNCO")
	private String crreoElctrnco;

	private String drccion;

	private Long estdo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FCHA_CRCION")
	private Date fchaCrcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FCHA_FIN")
	private Date fchaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FCHA_INCIO")
	private Date fchaIncio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FCHA_MDFCCION")
	private Date fchaMdfccion;

	@Column(name="NMRO_EXPDNTE")
	private String nmroExpdnte;

	@Column(name="NMRO_SLCTUD")
	private long nmroSlctud;

	@Column(name="RUC")
	private String ruc;

	@Column(name="RZON_SCIAL")
	private String rzonScial;

	@Column(name="TLFNO")
	private String tlfno;

	@Column(name="UBIGEO")
	private long ubigeo;

	@Column(name="UNIOPE_ID")
	private long uniopeId;

	@Column(name="USRIO_CRDOR")
	private String usrioCrdor;

	@Column(name="USRIO_MDFCDOR")
	private String usrioMdfcdor;
	
	@Column(name="DPNDNCIA_ID")
	private long dependenciaId;

	@Column(name="NOTA_ID")
	private long notaId;
	
	@Column(name="TPO_PRDO")
	private String tipoPrdo;
	
	
	public SibadSlctudEstdoCnta() {
	}
	
	public SibadSlctudEstdoCnta(Long id) {
		this.id= id;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCdgoOsnerg() {
		return this.cdgoOsnerg;
	}

	public void setCdgoOsnerg(String cdgoOsnerg) {
		this.cdgoOsnerg = cdgoOsnerg;
	}

	public String getCrreoElctrnco() {
		return this.crreoElctrnco;
	}

	public void setCrreoElctrnco(String crreoElctrnco) {
		this.crreoElctrnco = crreoElctrnco;
	}

	public String getDrccion() {
		return this.drccion;
	}

	public void setDrccion(String drccion) {
		this.drccion = drccion;
	}

	public Long getEstdo() {
		return this.estdo;
	}

	public void setEstdo(Long estdo) {
		this.estdo = estdo;
	}

	public Date getFchaCrcion() {
		return this.fchaCrcion;
	}

	public void setFchaCrcion(Date fchaCrcion) {
		this.fchaCrcion = fchaCrcion;
	}

	public Date getFchaFin() {
		return this.fchaFin;
	}

	public void setFchaFin(Date fchaFin) {
		this.fchaFin = fchaFin;
	}

	public Date getFchaIncio() {
		return this.fchaIncio;
	}

	public void setFchaIncio(Date fchaIncio) {
		this.fchaIncio = fchaIncio;
	}

	public Date getFchaMdfccion() {
		return this.fchaMdfccion;
	}

	public void setFchaMdfccion(Date fchaMdfccion) {
		this.fchaMdfccion = fchaMdfccion;
	}

	public String getNmroExpdnte() {
		return this.nmroExpdnte;
	}

	public void setNmroExpdnte(String nmroExpdnte) {
		this.nmroExpdnte = nmroExpdnte;
	}

	public long getNmroSlctud() {
		return this.nmroSlctud;
	}

	public void setNmroSlctud(long nmroSlctud) {
		this.nmroSlctud = nmroSlctud;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRzonScial() {
		return this.rzonScial;
	}

	public void setRzonScial(String rzonScial) {
		this.rzonScial = rzonScial;
	}

	public String getTlfno() {
		return this.tlfno;
	}

	public void setTlfno(String tlfno) {
		this.tlfno = tlfno;
	}

	public long getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(long ubigeo) {
		this.ubigeo = ubigeo;
	}

	public long getUniopeId() {
		return this.uniopeId;
	}

	public void setUniopeId(long uniopeId) {
		this.uniopeId = uniopeId;
	}

	public String getUsrioCrdor() {
		return this.usrioCrdor;
	}

	public void setUsrioCrdor(String usrioCrdor) {
		this.usrioCrdor = usrioCrdor;
	}

	public String getUsrioMdfcdor() {
		return this.usrioMdfcdor;
	}

	public void setUsrioMdfcdor(String usrioMdfcdor) {
		this.usrioMdfcdor = usrioMdfcdor;
	}

	public void setDependenciaId(long dependenciaId) {
		this.dependenciaId = dependenciaId;
	}

	public long getDependenciaId() {
		return dependenciaId;
	}

	public void setNotaId(long notaId) {
		this.notaId = notaId;
	}

	public long getNotaId() {
		return notaId;
	}
	
	public String getTipoPrdo() {
		return tipoPrdo;
	}

	public void setTipoPrdo(String tipoPrdo) {
		this.tipoPrdo = tipoPrdo;
	}

	
}