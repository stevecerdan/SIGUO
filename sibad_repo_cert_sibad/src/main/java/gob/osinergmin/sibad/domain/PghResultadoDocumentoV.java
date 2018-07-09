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
@Table(name = "VIEW_RESULTADO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoDocumentoV.findById", query = "SELECT a FROM PghResultadoDocumentoV a WHERE a.idResultadoDocumento like :idResultadoDocumento"),
    @NamedQuery(name = "PghResultadoDocumentoV.findByFilter", query = "SELECT s FROM PghResultadoDocumentoV s WHERE s.idResultadoRevision =:idResultadoRevision")
})
public class PghResultadoDocumentoV {
	//private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_DOCUMENTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_DOCUMENTO")
	private Long idResultadoDocumento;
	 
	@Column(name = "ID_RESULTADO_REVISION")
	private Long idResultadoRevision;
	 
	@Column(name = "ID_DOCUMENTO_ADJUNTO")
	private Long idDocumentoAdjunto;
	
	@Column(name = "NOMBRE_DOCUMENTO")
	private String nombreDocumento;
	
	@Column(name = "ARCHIVO_ADJUNTO")
	private byte[] archivoAdjunto;
	
	public PghResultadoDocumentoV() {
		
	}

	public PghResultadoDocumentoV(Long idResultadoDocumento) {
		
		this.idResultadoDocumento = idResultadoDocumento;
	}

	public PghResultadoDocumentoV(Long idDocumentoAdjunto, Long idResultadoRevision, Long idResultadoDocumento, String nombreDocumento) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.idResultadoRevision = idResultadoRevision;
		this.idResultadoDocumento = idResultadoDocumento;
		this.nombreDocumento = nombreDocumento;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	public Long getIdResultadoDocumento() {
		return idResultadoDocumento;
	}
	public void setIdResultadoDocumento(Long idResultadoDocumento) {
		this.idResultadoDocumento = idResultadoDocumento;
	}
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
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
	
}
