/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "MDI_PERSONA_NATURAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiPersonaNaturalV.findByIdPersonaN", query = "SELECT n FROM MdiPersonaNaturalV n WHERE n.idPersonaNatural=:idPersonaNatural "),
    @NamedQuery(name = "MdiPersonaNaturalV.findByFilter", query = "SELECT n FROM MdiPersonaNaturalV n WHERE upper(n.numeroDoc) like :numeroDoc")

})
public class MdiPersonaNaturalV extends Auditoria{
	private static final long serialVersionUID = 1L;

	
	@Id
//  @NotNull
//  @Basic(optional = false)
  @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "MDI_PERSONA_NATURAL_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
  @Column(name = "ID_PERSONA_NATURAL")
  private Long idPersonaNatural;
  //@Size(max = 10)
    
    @Column(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
    private Long idTipoDocumento;
    //@Size(max = 10)
    
    @Column(name = "NUMERO_DOC_IDENTIDAD")
    private String numeroDoc;
    //@Size(max = 16)
    
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    //@Size(max = 32)
    
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    //@Size(max = 32)
    
    @Column(name = "NOMBRE")
    private String nombre;
    //@Size(max = 64)
    
    @Column(name = "CIP")
    private Long cip;
    
    
    public MdiPersonaNaturalV() {
    }

    public MdiPersonaNaturalV(Long idPersonaNatural) {
        this.idPersonaNatural = idPersonaNatural;
    }
    
    public MdiPersonaNaturalV(Long idPersonaNatural, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idPersonaNatural = idPersonaNatural;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    } 

	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
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

	public Long getCip() {
		return cip;
	}

	public void setCip(Long cip) {
		this.cip = cip;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonaNatural != null ? idPersonaNatural.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiPersonaNaturalV)) {
            return false;
        }
        MdiPersonaNaturalV other = (MdiPersonaNaturalV) object;
        if ((this.idPersonaNatural == null && other.idPersonaNatural != null) || (this.idPersonaNatural != null && !this.idPersonaNatural.equals(other.idPersonaNatural))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.MdiPersonaNaturalV[ idPersonaNatural=" + idPersonaNatural + " ]";
    }
    
}
