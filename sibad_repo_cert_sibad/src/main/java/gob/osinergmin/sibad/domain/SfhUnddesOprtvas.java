/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Clase Domain mapea la tabla SFH_UNDDES_OPRTVAS
 * 
 * @author DSR
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "SFH_UNDDES_OPRTVAS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "SfhUnddesOprtvas.findAll", query = "SELECT s FROM SfhUnddesOprtvas s") ,
	@NamedQuery(name = "SfhUnddesOprtvas.findById", query = "SELECT s FROM SfhUnddesOprtvas s WHERE s.id = :id") ,
	@NamedQuery(name = "SfhUnddesOprtvas.findByUndadMddaGnv", query = "SELECT s FROM SfhUnddesOprtvas s WHERE s.undadMddaGnv = :undadMddaGnv") ,
	@NamedQuery(name = "SfhUnddesOprtvas.findByUndadOperativaByOsinerg", query = "SELECT s.id FROM SfhUnddesOprtvas s WHERE s.codigoOsinerg = :codigoOsinerg") })
public class SfhUnddesOprtvas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "UNIOPE_TIPO")
    private String uniopeTipo;
    @Column(name = "NMRO_EXPDNTE")
    private String nmroExpdnte;
    @Column(name = "CODIGO_OSINERG")
    private String codigoOsinerg;
    @Column(name = "FCHA_EXPDNTE")
    @Temporal(TemporalType.DATE)
    private Date fchaExpdnte;
    @Basic(optional = false)
    @Column(name = "NMBRE_UNDAD")
    private String nmbreUndad;
    @Basic(optional = false)
    @Column(name = "TPO_ZNA")
    private String tpoZna;
    @Column(name = "NMBRE_ZNA")
    private String nmbreZna;
    @Basic(optional = false)
    @Column(name = "TPO_VIA")
    private String tpoVia;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "RUC")
    private String ruc;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AREA_TTAL_M2")
    private BigDecimal areaTtalM2;
    @Column(name = "AREA_ESTBLCMNTO_M2")
    private BigDecimal areaEstblcmntoM2;
    @Column(name = "RPRSNTNTE_LGAL_NMBRE")
    private String rprsntnteLgalNmbre;
    @Column(name = "RPRSNTNTE_LGAL_DRCCION")
    private String rprsntnteLgalDrccion;
    @Column(name = "NMRO_PLZA_SGRO")
    private String nmroPlzaSgro;
    @Column(name = "NMRO_TRBJDRES")
    private Integer nmroTrbjdres;
    @Column(name = "DMCLIO_LGAL")
    private String dmclioLgal;
    @Column(name = "RSPNSBLE_TCNICO_NMBRE")
    private String rspnsbleTcnicoNmbre;
    @Column(name = "RSPNSBLE_TCNICO_TLFNO")
    private String rspnsbleTcnicoTlfno;
    @Column(name = "RSPNSBLE_TCNCO_DNI")
    private String rspnsbleTcncoDni;
    @Column(name = "RSPNSBLE_TCNCO_DRCCION")
    private String rspnsbleTcncoDrccion;
    @Column(name = "CMNCCION_PRVIA")
    private String cmnccionPrvia;
    @Basic(optional = false)
    @Column(name = "USRIO_CRDOR")
    private String usrioCrdor;
    @Basic(optional = false)
    @Column(name = "FCHA_CRCION")
    @Temporal(TemporalType.DATE)
    private Date fchaCrcion;
    @Column(name = "USRIO_MDFCDOR")
    private String usrioMdfcdor;
    @Column(name = "FCHA_MDFCCION")
    @Temporal(TemporalType.DATE)
    private Date fchaMdfccion;
    @Basic(optional = false)
    @Column(name = "UBIGEO_ID")
    private long ubigeoId;
    @Column(name = "EMPBAN_ID")
    private Long empbanId;
    @Column(name = "RUUNOP_ID")
    private Integer ruunopId;
    @Column(name = "UBIGEO_ID2")
    private Long ubigeoId2;
    @Column(name = "RPRSNTNTE_TPO_DCMNTO")
    private String rprsntnteTpoDcmnto;
    @Column(name = "RPRSNTNTE_LGAL_DCMNTO")
    private String rprsntnteLgalDcmnto;
    @Column(name = "TPO_ZNA_LGAL")
    private String tpoZnaLgal;
    @Column(name = "TPO_VIA_LGAL")
    private String tpoViaLgal;
    @Column(name = "NMBRE_ZNA_LGAL")
    private String nmbreZnaLgal;
    @Column(name = "CMPNNTES_ID_CMPNNTES")
    private Long cmpnntesIdCmpnntes;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "PLACA_TRACTO")
    private String placaTracto;
    @Column(name = "DRCCION_RFRNCIA")
    private String drccionRfrncia;
    @Column(name = "ANTCNES_VRIAS")
    private String antcnesVrias;
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "CORREN_IDCORRENTISTA")
    private Integer correnIdcorrentista;
    @Basic(optional = false)
    @Column(name = "UBIGEO_IDLUGAR")
    private long ubigeoIdlugar;
    @Column(name = "CPCDAD_TTAL")
    private BigDecimal cpcdadTtal;
    @Column(name = "UNDAD_MDDA_CPCDAD")
    private String undadMddaCpcdad;
    @Column(name = "CNTDOR_MTRLGCO")
    private Short cntdorMtrlgco;
    @Column(name = "CNTDOR_CLDAD")
    private Short cntdorCldad;
    @Column(name = "TPO_ULTMA_VISITA")
    private String tpoUltmaVisita;
    @Column(name = "FCHA_MTRLGCO")
    @Temporal(TemporalType.DATE)
    private Date fchaMtrlgco;
    @Column(name = "FCHA_CLDAD")
    @Temporal(TemporalType.DATE)
    private Date fchaCldad;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "OBSRVCNES")
    private String obsrvcnes;
    @Column(name = "AREA_LBRE")
    private BigDecimal areaLbre;
    @Column(name = "RUTA_FOTO")
    private String rutaFoto;
    @Column(name = "UTM1")
    private String utm1;
    @Column(name = "UTM2")
    private String utm2;
    @Column(name = "UTM3")
    private String utm3;
    @Column(name = "UTM4")
    private String utm4;
    @Column(name = "PLACA_TRACTO_1")
    private String placaTracto1;
    @Column(name = "PLACA_TRACTO_2")
    private String placaTracto2;
    @Column(name = "PLACA_TRACTO_3")
    private String placaTracto3;
    @Column(name = "PLACA_TRACTO_4")
    private String placaTracto4;
    @Column(name = "PLACA_TRACTO_5")
    private String placaTracto5;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "CPCDAD_TTAL_GLP")
    private BigDecimal cpcdadTtalGlp;
    @Column(name = "CPCDAD_TTAL_GNV")
    private BigDecimal cpcdadTtalGnv;
    @Column(name = "CIIU")
    private String ciiu;
    @Column(name = "CPCDAD_TTAL_GLP_BALON")
    private Long cpcdadTtalGlpBalon;
    @Column(name = "UNDAD_MDDA_GLP")
    private String undadMddaGlp;
    @Column(name = "UNDAD_MDDA_GLP_BALON")
    private String undadMddaGlpBalon;
    @Column(name = "UNDAD_MDDA_GNV")
    private String undadMddaGnv;
    @Transient
    private String codigoDgh;
    @Transient
    private String estadoDgh;
    @Transient
    private String ubigeoCompleto;
    
    
   /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
  	@JoinColumn(name="UBIGEO_ID")
  	private SsrUbigeoZonaSupervision ubigeoZona;*/
    
    public SfhUnddesOprtvas () {
    }
    
    /**
	 * @param nmbreUndad
	 */
	public SfhUnddesOprtvas(long id) {
		super();
		this.id=id;
	}
    
    /**
	 * @param nmbreUndad
	 */
	public SfhUnddesOprtvas(long id,String ruc, String codigoOsinerg) {
		super();
		this.id=id;
		this.ruc = ruc;
		this.codigoOsinerg = codigoOsinerg;
	}
    
    
    /**
	 * @param nmbreUndad
	 */
	public SfhUnddesOprtvas(String nmbreUndad) {
		super();
		this.nmbreUndad = nmbreUndad;
		
	}
	/**
	 * Nuevo: Se agregó  codigoOsinerg y cpcdadTtal en la tabla de  la pantalla tacking by @jasparrin
	 * @param nmbreUndad
	 * @param codigoOsinerg
	 * @param cpcdadTtal
	 */
	public SfhUnddesOprtvas(String nmbreUndad,String codigoOsinerg) {
		super();
		this.nmbreUndad = nmbreUndad;
		this.codigoOsinerg = codigoOsinerg;
		
		
	}
	/**
	 * nuevo: se agregó para la pantalla detalle tracking by @jasparrin
	 * @param nmbreUndad
	 * @param direccion
	 * @param codigoOsinerg
	 */
	public SfhUnddesOprtvas(String nmbreUndad,String direccion,String codigoOsinerg) {
		super();
		this.nmbreUndad = nmbreUndad;
		this.direccion = direccion;
		this.codigoOsinerg = codigoOsinerg;
		
		
	}
	
	public SfhUnddesOprtvas(String nmbreUndad,long ubigeoId) {
		super();
		this.nmbreUndad = nmbreUndad;
		this.ubigeoId=ubigeoId;
	}
	/**
	 * @param nmbreUndad
	 * Documento Generado DSR
	 */
	public SfhUnddesOprtvas(String nmbreUndad, Integer ubigeoId, String nombre, Long idZona) {
		super();
		this.nmbreUndad=nmbreUndad;
		//this.ubigeoZona=new SsrUbigeoZonaSupervision(ubigeoId, idZona, nombre);
	}

	

    public SfhUnddesOprtvas (long id,String placa,String rutaFoto,String nmbreUndad, long ubigeoId,String codigoOsinerg) {
    	this.id=id;
    	this.placa=placa;
    	this.rutaFoto=rutaFoto;
    	this.nmbreUndad=nmbreUndad;
    	this.codigoOsinerg=codigoOsinerg;
    	this.ubigeoId=ubigeoId;
    	//this.ubigeoZona=new SsrUbigeoZonaSupervision(nombre);
    }
    
    public SfhUnddesOprtvas (long id,String codigoOsinerg, String  nmbreUndad,String ruc) {
    	this.id=id;
    	this.codigoOsinerg= codigoOsinerg;
    	this.nmbreUndad=nmbreUndad;
    	this.ruc=ruc;
    	//this.ubigeoZona=new SsrUbigeoZonaSupervision(nombre);
    }
    
    public SfhUnddesOprtvas (long id,String codigoOsinerg, String  nmbreUndad,String ruc,long ubigeoId) {
    	this.id=id;
    	this.codigoOsinerg= codigoOsinerg;
    	this.nmbreUndad=nmbreUndad;
    	this.ruc=ruc;
    	this.ubigeoId=ubigeoId;
    	//this.ubigeoZona=new SsrUbigeoZonaSupervision(nombre);
    }
   
    public long getId () {
	return id;
    }

    public void setId ( long id ) {
	this.id = id;
    }

    public String getCodigoDgh () {
	return codigoDgh;
    }

    public void setCodigoDgh ( String codigoDgh ) {
	this.codigoDgh = codigoDgh;
    }

    public String getUniopeTipo () {
	return uniopeTipo;
    }

    public void setUniopeTipo ( String uniopeTipo ) {
	this.uniopeTipo = uniopeTipo;
    }

    public String getNmroExpdnte () {
	return nmroExpdnte;
    }

    public void setNmroExpdnte ( String nmroExpdnte ) {
	this.nmroExpdnte = nmroExpdnte;
    }

    public String getCodigoOsinerg () {
	return codigoOsinerg;
    }

    public void setCodigoOsinerg ( String codigoOsinerg ) {
	this.codigoOsinerg = codigoOsinerg;
    }

    public Date getFchaExpdnte () {
	return fchaExpdnte;
    }

    public void setFchaExpdnte ( Date fchaExpdnte ) {
	this.fchaExpdnte = fchaExpdnte;
    }

    public String getNmbreUndad () {
	return nmbreUndad;
    }

    public void setNmbreUndad ( String nmbreUndad ) {
	this.nmbreUndad = nmbreUndad;
    }

    public String getTpoZna () {
	return tpoZna;
    }

    public void setTpoZna ( String tpoZna ) {
	this.tpoZna = tpoZna;
    }

    public String getNmbreZna () {
	return nmbreZna;
    }

    public void setNmbreZna ( String nmbreZna ) {
	this.nmbreZna = nmbreZna;
    }

    public String getTpoVia () {
	return tpoVia;
    }

    public void setTpoVia ( String tpoVia ) {
	this.tpoVia = tpoVia;
    }

    public String getDireccion () {
	return direccion;
    }

    public void setDireccion ( String direccion ) {
	this.direccion = direccion;
    }

    public String getRuc () {
	return ruc;
    }

    public void setRuc ( String ruc ) {
	this.ruc = ruc;
    }

    public String getDni () {
	return dni;
    }

    public void setDni ( String dni ) {
	this.dni = dni;
    }

    public String getFax () {
	return fax;
    }

    public void setFax ( String fax ) {
	this.fax = fax;
    }

    public String getTelefono () {
	return telefono;
    }

    public void setTelefono ( String telefono ) {
	this.telefono = telefono;
    }

    public String getEmail () {
	return email;
    }

    public void setEmail ( String email ) {
	this.email = email;
    }

    public BigDecimal getAreaTtalM2 () {
	return areaTtalM2;
    }

    public void setAreaTtalM2 ( BigDecimal areaTtalM2 ) {
	this.areaTtalM2 = areaTtalM2;
    }

    public BigDecimal getAreaEstblcmntoM2 () {
	return areaEstblcmntoM2;
    }

    public void setAreaEstblcmntoM2 ( BigDecimal areaEstblcmntoM2 ) {
	this.areaEstblcmntoM2 = areaEstblcmntoM2;
    }

    public String getRprsntnteLgalNmbre () {
	return rprsntnteLgalNmbre;
    }

    public void setRprsntnteLgalNmbre ( String rprsntnteLgalNmbre ) {
	this.rprsntnteLgalNmbre = rprsntnteLgalNmbre;
    }

    public String getRprsntnteLgalDrccion () {
	return rprsntnteLgalDrccion;
    }

    public void setRprsntnteLgalDrccion ( String rprsntnteLgalDrccion ) {
	this.rprsntnteLgalDrccion = rprsntnteLgalDrccion;
    }

    public String getNmroPlzaSgro () {
	return nmroPlzaSgro;
    }

    public void setNmroPlzaSgro ( String nmroPlzaSgro ) {
	this.nmroPlzaSgro = nmroPlzaSgro;
    }

    public Integer getNmroTrbjdres () {
	return nmroTrbjdres;
    }

    public void setNmroTrbjdres ( Integer nmroTrbjdres ) {
	this.nmroTrbjdres = nmroTrbjdres;
    }

    public String getDmclioLgal () {
	return dmclioLgal;
    }

    public void setDmclioLgal ( String dmclioLgal ) {
	this.dmclioLgal = dmclioLgal;
    }

    public String getRspnsbleTcnicoNmbre () {
	return rspnsbleTcnicoNmbre;
    }

    public void setRspnsbleTcnicoNmbre ( String rspnsbleTcnicoNmbre ) {
	this.rspnsbleTcnicoNmbre = rspnsbleTcnicoNmbre;
    }

    public String getRspnsbleTcnicoTlfno () {
	return rspnsbleTcnicoTlfno;
    }

    public void setRspnsbleTcnicoTlfno ( String rspnsbleTcnicoTlfno ) {
	this.rspnsbleTcnicoTlfno = rspnsbleTcnicoTlfno;
    }

    public String getRspnsbleTcncoDni () {
	return rspnsbleTcncoDni;
    }

    public void setRspnsbleTcncoDni ( String rspnsbleTcncoDni ) {
	this.rspnsbleTcncoDni = rspnsbleTcncoDni;
    }

    public String getRspnsbleTcncoDrccion () {
	return rspnsbleTcncoDrccion;
    }

    public void setRspnsbleTcncoDrccion ( String rspnsbleTcncoDrccion ) {
	this.rspnsbleTcncoDrccion = rspnsbleTcncoDrccion;
    }

    public String getCmnccionPrvia () {
	return cmnccionPrvia;
    }

    public void setCmnccionPrvia ( String cmnccionPrvia ) {
	this.cmnccionPrvia = cmnccionPrvia;
    }

    public String getUsrioCrdor () {
	return usrioCrdor;
    }

    public void setUsrioCrdor ( String usrioCrdor ) {
	this.usrioCrdor = usrioCrdor;
    }

    public Date getFchaCrcion () {
	return fchaCrcion;
    }

    public void setFchaCrcion ( Date fchaCrcion ) {
	this.fchaCrcion = fchaCrcion;
    }

    public String getUsrioMdfcdor () {
	return usrioMdfcdor;
    }

    public void setUsrioMdfcdor ( String usrioMdfcdor ) {
	this.usrioMdfcdor = usrioMdfcdor;
    }

    public Date getFchaMdfccion () {
	return fchaMdfccion;
    }

    public void setFchaMdfccion ( Date fchaMdfccion ) {
	this.fchaMdfccion = fchaMdfccion;
    }
    

  
/*
	public SsrUbigeoZonaSupervision getUbigeoZona() {
		return ubigeoZona;
	}

	public void setUbigeoZona(SsrUbigeoZonaSupervision ubigeoZona) {
		this.ubigeoZona = ubigeoZona;
	}*/

	public Long getEmpbanId () {
	return empbanId;
    }

    public void setEmpbanId ( Long empbanId ) {
	this.empbanId = empbanId;
    }

    public Integer getRuunopId () {
	return ruunopId;
    }

    public void setRuunopId ( Integer ruunopId ) {
	this.ruunopId = ruunopId;
    }

    public Long getUbigeoId2 () {
	return ubigeoId2;
    }

    public void setUbigeoId2 ( Long ubigeoId2 ) {
	this.ubigeoId2 = ubigeoId2;
    }

    public String getRprsntnteTpoDcmnto () {
	return rprsntnteTpoDcmnto;
    }

    public void setRprsntnteTpoDcmnto ( String rprsntnteTpoDcmnto ) {
	this.rprsntnteTpoDcmnto = rprsntnteTpoDcmnto;
    }

    public String getRprsntnteLgalDcmnto () {
	return rprsntnteLgalDcmnto;
    }

    public void setRprsntnteLgalDcmnto ( String rprsntnteLgalDcmnto ) {
	this.rprsntnteLgalDcmnto = rprsntnteLgalDcmnto;
    }

    public String getTpoZnaLgal () {
	return tpoZnaLgal;
    }

    public void setTpoZnaLgal ( String tpoZnaLgal ) {
	this.tpoZnaLgal = tpoZnaLgal;
    }

    public String getTpoViaLgal () {
	return tpoViaLgal;
    }

    public void setTpoViaLgal ( String tpoViaLgal ) {
	this.tpoViaLgal = tpoViaLgal;
    }

    public String getNmbreZnaLgal () {
	return nmbreZnaLgal;
    }

    public void setNmbreZnaLgal ( String nmbreZnaLgal ) {
	this.nmbreZnaLgal = nmbreZnaLgal;
    }

    public Long getCmpnntesIdCmpnntes () {
	return cmpnntesIdCmpnntes;
    }

    public void setCmpnntesIdCmpnntes ( Long cmpnntesIdCmpnntes ) {
	this.cmpnntesIdCmpnntes = cmpnntesIdCmpnntes;
    }

    public String getPlaca () {
	return placa;
    }

    public void setPlaca ( String placa ) {
	this.placa = placa;
    }

    public String getPlacaTracto () {
	return placaTracto;
    }

    public void setPlacaTracto ( String placaTracto ) {
	this.placaTracto = placaTracto;
    }

    public String getDrccionRfrncia () {
	return drccionRfrncia;
    }

    public void setDrccionRfrncia ( String drccionRfrncia ) {
	this.drccionRfrncia = drccionRfrncia;
    }

    public String getAntcnesVrias () {
	return antcnesVrias;
    }

    public void setAntcnesVrias ( String antcnesVrias ) {
	this.antcnesVrias = antcnesVrias;
    }

    public BigDecimal getLatitud () {
	return latitud;
    }

    public void setLatitud ( BigDecimal latitud ) {
	this.latitud = latitud;
    }

    public BigDecimal getLongitud () {
	return longitud;
    }

    public void setLongitud ( BigDecimal longitud ) {
	this.longitud = longitud;
    }

    public Integer getCorrenIdcorrentista () {
	return correnIdcorrentista;
    }

    public void setCorrenIdcorrentista ( Integer correnIdcorrentista ) {
	this.correnIdcorrentista = correnIdcorrentista;
    }

    public long getUbigeoIdlugar () {
	return ubigeoIdlugar;
    }

    public void setUbigeoIdlugar ( long ubigeoIdlugar ) {
	this.ubigeoIdlugar = ubigeoIdlugar;
    }

    public BigDecimal getCpcdadTtal () {
	return cpcdadTtal;
    }

    public void setCpcdadTtal ( BigDecimal cpcdadTtal ) {
	this.cpcdadTtal = cpcdadTtal;
    }

    public String getUndadMddaCpcdad () {
	return undadMddaCpcdad;
    }

    public void setUndadMddaCpcdad ( String undadMddaCpcdad ) {
	this.undadMddaCpcdad = undadMddaCpcdad;
    }

    public Short getCntdorMtrlgco () {
	return cntdorMtrlgco;
    }

    public void setCntdorMtrlgco ( Short cntdorMtrlgco ) {
	this.cntdorMtrlgco = cntdorMtrlgco;
    }

    public Short getCntdorCldad () {
	return cntdorCldad;
    }

    public void setCntdorCldad ( Short cntdorCldad ) {
	this.cntdorCldad = cntdorCldad;
    }

    public String getTpoUltmaVisita () {
	return tpoUltmaVisita;
    }

    public void setTpoUltmaVisita ( String tpoUltmaVisita ) {
	this.tpoUltmaVisita = tpoUltmaVisita;
    }

    public Date getFchaMtrlgco () {
	return fchaMtrlgco;
    }

    public void setFchaMtrlgco ( Date fchaMtrlgco ) {
	this.fchaMtrlgco = fchaMtrlgco;
    }

    public Date getFchaCldad () {
	return fchaCldad;
    }

    public void setFchaCldad ( Date fchaCldad ) {
	this.fchaCldad = fchaCldad;
    }

    public String getPassword () {
	return password;
    }

    public void setPassword ( String password ) {
	this.password = password;
    }

    public String getObsrvcnes () {
	return obsrvcnes;
    }

    public void setObsrvcnes ( String obsrvcnes ) {
	this.obsrvcnes = obsrvcnes;
    }

    public BigDecimal getAreaLbre () {
	return areaLbre;
    }

    public void setAreaLbre ( BigDecimal areaLbre ) {
	this.areaLbre = areaLbre;
    }

    public String getRutaFoto () {
	return rutaFoto;
    }

    public void setRutaFoto ( String rutaFoto ) {
	this.rutaFoto = rutaFoto;
    }

    public String getUtm1 () {
	return utm1;
    }

    public void setUtm1 ( String utm1 ) {
	this.utm1 = utm1;
    }

    public String getUtm2 () {
	return utm2;
    }

    public void setUtm2 ( String utm2 ) {
	this.utm2 = utm2;
    }

    public String getUtm3 () {
	return utm3;
    }

    public void setUtm3 ( String utm3 ) {
	this.utm3 = utm3;
    }

    public String getUtm4 () {
	return utm4;
    }

    public void setUtm4 ( String utm4 ) {
	this.utm4 = utm4;
    }

    public String getPlacaTracto1 () {
	return placaTracto1;
    }

    public void setPlacaTracto1 ( String placaTracto1 ) {
	this.placaTracto1 = placaTracto1;
    }

    public String getPlacaTracto2 () {
	return placaTracto2;
    }

    public void setPlacaTracto2 ( String placaTracto2 ) {
	this.placaTracto2 = placaTracto2;
    }

    public String getPlacaTracto3 () {
	return placaTracto3;
    }

    public void setPlacaTracto3 ( String placaTracto3 ) {
	this.placaTracto3 = placaTracto3;
    }

    public String getPlacaTracto4 () {
	return placaTracto4;
    }

    public void setPlacaTracto4 ( String placaTracto4 ) {
	this.placaTracto4 = placaTracto4;
    }

    public String getPlacaTracto5 () {
	return placaTracto5;
    }

    public void setPlacaTracto5 ( String placaTracto5 ) {
	this.placaTracto5 = placaTracto5;
    }

    public String getObservaciones () {
	return observaciones;
    }

    public void setObservaciones ( String observaciones ) {
	this.observaciones = observaciones;
    }

    public BigDecimal getCpcdadTtalGlp () {
	return cpcdadTtalGlp;
    }

    public void setCpcdadTtalGlp ( BigDecimal cpcdadTtalGlp ) {
	this.cpcdadTtalGlp = cpcdadTtalGlp;
    }

    public BigDecimal getCpcdadTtalGnv () {
	return cpcdadTtalGnv;
    }

    public void setCpcdadTtalGnv ( BigDecimal cpcdadTtalGnv ) {
	this.cpcdadTtalGnv = cpcdadTtalGnv;
    }

    public String getCiiu () {
	return ciiu;
    }

    public void setCiiu ( String ciiu ) {
	this.ciiu = ciiu;
    }

    public Long getCpcdadTtalGlpBalon () {
	return cpcdadTtalGlpBalon;
    }

    public void setCpcdadTtalGlpBalon ( Long cpcdadTtalGlpBalon ) {
	this.cpcdadTtalGlpBalon = cpcdadTtalGlpBalon;
    }

    public String getUndadMddaGlp () {
	return undadMddaGlp;
    }

    public void setUndadMddaGlp ( String undadMddaGlp ) {
	this.undadMddaGlp = undadMddaGlp;
    }

    public String getUndadMddaGlpBalon () {
	return undadMddaGlpBalon;
    }

    public void setUndadMddaGlpBalon ( String undadMddaGlpBalon ) {
	this.undadMddaGlpBalon = undadMddaGlpBalon;
    }

    public String getUndadMddaGnv () {
	return undadMddaGnv;
    }

    public void setUndadMddaGnv ( String undadMddaGnv ) {
	this.undadMddaGnv = undadMddaGnv;
    }

	public long getUbigeoId() {
		return ubigeoId;
	}

	public void setUbigeoId(long ubigeoId) {
		this.ubigeoId = ubigeoId;
	}

	public String getEstadoDgh() {
		return estadoDgh;
	}

	public void setEstadoDgh(String estadoDgh) {
		this.estadoDgh = estadoDgh;
	}

	public String getUbigeoCompleto() {
		return ubigeoCompleto;
	}

	public void setUbigeoCompleto(String ubigeoCompleto) {
		this.ubigeoCompleto = ubigeoCompleto;
	}
    
}
