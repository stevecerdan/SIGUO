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
@Table(name = "VIEW_RESULT_PRUEBA_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoPruebaDocumentoV.findByIdResultadoPruebaReprueba", query = "SELECT a FROM PghResultadoPruebaDocumentoV a WHERE a.idResultadoPruebaReprueba = :idResultadoPruebaReprueba"),
    @NamedQuery(name = "PghResultadoPruebaDocumentoV.findByFilter", query = "SELECT a FROM PghResultadoPruebaDocumentoV a WHERE a.descripcionDocumento = :descripcionDocumento AND a.idResultadoPruebaReprueba = :idResultadoPruebaReprueba")
})
public class PghResultadoPruebaDocumentoV {
private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_PRUEBA_DOCUMENT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_PRUEBA_DOCUMENTO")
	private Long idResultadoPruebaDocumento;
	 
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	 
	@Column(name = "ID_DOCUMENTO_ADJUNTO")
	private Long idDocumentoAdjunto;
	
	@Column(name = "NOMBRE_DOCUMENTO")
	private String nombreDocumento;
	
	@Column(name = "DESCRIPCION_DOCUMENTO")
	private String descripcionDocumento;
	
	@Column(name = "ARCHIVO_ADJUNTO")
	private byte[] archivoAdjunto;

	public PghResultadoPruebaDocumentoV() {
		
	}

	public PghResultadoPruebaDocumentoV(Long idResultadoPruebaDocumento) {
		
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
	}

	public PghResultadoPruebaDocumentoV(Long idResultadoPruebaDocumento, Long idResultadoPruebaReprueba,Long idDocumentoAdjunto, String nombreDocumento, byte[] archivoAdjunto) {
		
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.nombreDocumento = nombreDocumento;
		this.archivoAdjunto = archivoAdjunto;
	}

	public Long getIdResultadoPruebaDocumento() {
		return idResultadoPruebaDocumento;
	}

	public void setIdResultadoPruebaDocumento(Long idResultadoPruebaDocumento) {
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
	}

	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}

	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public byte[] getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}
	
	
	

}
