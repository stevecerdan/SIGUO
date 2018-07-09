/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_DOCUMENTO_ADJUNTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghDocumentoAdjunto.findByIdDoc", query = "SELECT d FROM PghDocumentoAdjunto d WHERE d.idDocumentoAdjunto=:idDocumentoAdjunto ")
})

public class PghDocumentoAdjunto extends Auditoria{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_DOCUMENTO_ADJUNTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private Long idDocumentoAdjunto;
    
	@Column(name = "DESCRIPCION_DOCUMENTO")
    private String descripcionDocumento;
	
	@Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;
    
    @Column(name = "ARCHIVO_ADJUNTO")
    private byte[] archivoAdjunto;
    
    @Column(name = "ESTADO")
    private String estadoDocumento;
    
    public PghDocumentoAdjunto() {
    }

    public PghDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
    
    public PghDocumentoAdjunto(Long idDocumentoAdjunto, String nombreDocumento, byte[] archivoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.nombreDocumento = nombreDocumento;
		this.archivoAdjunto = archivoAdjunto;
	}
    
    public PghDocumentoAdjunto(Long idDocumentoAdjunto, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
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

	public String getEstadoDocumento() {
		return estadoDocumento;
	}

	public void setEstadoDocumento(String estadoDocumento) {
		this.estadoDocumento = estadoDocumento;
	}
	
	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoAdjunto != null ? idDocumentoAdjunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDocumentoAdjunto)) {
            return false;
        }
        PghDocumentoAdjunto other = (PghDocumentoAdjunto) object;
        if ((this.idDocumentoAdjunto == null && other.idDocumentoAdjunto != null) || (this.idDocumentoAdjunto != null && !this.idDocumentoAdjunto.equals(other.idDocumentoAdjunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghDocumentoAdjunto[ idDocumentoAdjunto=" + idDocumentoAdjunto + " ]";
    }
    
}
