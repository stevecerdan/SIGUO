package gob.osinergmin.sibad.domain;


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
@Table(name = "VIEW_RESULTADO_PERSONA_NATURAL")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghResultadoPersonaNaturalV.findById", query = "SELECT s FROM PghResultadoPersonaNaturalV s WHERE s.idResultadoPersonaNatural=:idResultadoPersonaNatural "),
    @NamedQuery(name = "PghResultadoPersonaNaturalV.findByFilter", query = "SELECT s FROM PghResultadoPersonaNaturalV s WHERE s.idResultadoRevision =:idResultadoRevision"), 
	//@NamedQuery(name = "PghResultadoPersonaNaturalV.findByDocumento", query = "SELECT s FROM PghResultadoPersonaNaturalV s WHERE upper(s.numeroDocumento) like :numeroDocumento")
    })// and" + //" upper(s.numeroDocumento) like :numeroDocumento"	

public class PghResultadoPersonaNaturalV{
	//private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_REVISION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_PERSONA_NATURAL")
	private Long idResultadoPersonaNatural;
	
	@Column(name = "ID_RESULTADO_REVISION")
	private Long idResultadoRevision;
	
	@Column(name = "ID_PERSONA_NATURAL")
	private Long idPersonaNatural;
	
	@Column(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
	private Long idTipoDocumento;
	
	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;
	
	@Column(name = "NUMERO_DOC_IDENTIDAD")
	private String numeroDocumento;
	
	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NOMBRE_COMPLETO")
	private String nombreCompleto;
	
	@Column(name = "CIP")
	private String cip;
	
	public PghResultadoPersonaNaturalV() {
		// TODO Auto-generated constructor stub
	}
	
	public PghResultadoPersonaNaturalV(Long idResultadoPersonaNatural, Long idResultadoRevision, Long idPersonaNatural, Long idTipoDocumento, String tipoDocumento, String numeroDocumento, String apellidoPaterno, String apellidoMaterno ,String nombreCompleto, String nombre, String cip) {
		this.idResultadoPersonaNatural = idResultadoPersonaNatural;
		this.idResultadoRevision = idResultadoRevision;
		this.idPersonaNatural = idPersonaNatural;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombre;
		this.nombreCompleto = nombreCompleto;
		this.tipoDocumento = tipoDocumento;
		this.cip = cip;
	}
	
	public Long getIdResultadoPersonaNatural() {
		return idResultadoPersonaNatural;
	}
	
	public void setIdResultadoPersonaNatural(Long idResultadoPersonaNatural) {
		this.idResultadoPersonaNatural = idResultadoPersonaNatural;
	}
	
	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}
	
	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCip() {
		return cip;
	}
	
	public void setCip(String cip) {
		this.cip = cip;
	}	
}
