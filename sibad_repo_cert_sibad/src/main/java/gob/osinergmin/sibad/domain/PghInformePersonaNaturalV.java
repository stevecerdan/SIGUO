package gob.osinergmin.sibad.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_INFORME_PERSONA_NATURAL")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghInformePersonaNaturalV.findById", query = "SELECT s FROM PghInformePersonaNaturalV s WHERE s.idInformeIndiceRiesgo =:idInformeIndiceRiesgo "), 
    })

public class PghInformePersonaNaturalV {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_INFORME_PERSONA_NATURAL")
	private Long idInformePersonaNatural;
	
	@Column(name = "ID_INFORME_INDICE_RIESGO")
	private Long idInformeIndiceRiesgo;
	
	@Column(name = "ID_PERSONA_NATURAL")
	private Long idPersonaNatural;
	
	@Column(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
	private Long idTipoDocumentoIdentidad;
	
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

	public PghInformePersonaNaturalV() {
		
	}

	public Long getIdInformePersonaNatural() {
		return idInformePersonaNatural;
	}

	public void setIdInformePersonaNatural(Long idInformePersonaNatural) {
		this.idInformePersonaNatural = idInformePersonaNatural;
	}

	public Long getIdInformeIndiceRiesgo() {
		return idInformeIndiceRiesgo;
	}

	public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
		this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
	}

	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public Long getIdTipoDocumentoIdentidad() {
		return idTipoDocumentoIdentidad;
	}

	public void setIdTipoDocumentoIdentidad(Long idTipoDocumentoIdentidad) {
		this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}
		
}
