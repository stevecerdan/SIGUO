package gob.osinergmin.sibad.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PGH_RESULTADO_PRUEBA_DOCUMENTO")
public class PghResultadoPruebaDocumento  extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_RESULTADO_PRUEBA_DOCUMENT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	@Column(name = "ID_RESULTADO_PRUEBA_DOCUMENTO")
	private Long idResultadoPruebaDocumento;
	 
	@Column(name = "ID_DOCUMENTO_ADJUNTO")
	private Long idDocumentoAdjunto;
	 
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResutadoPruebaReprueba;

	public PghResultadoPruebaDocumento() {
		
	}

	public PghResultadoPruebaDocumento(Long idResultadoPruebaDocumento) {
		
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
	}

	public PghResultadoPruebaDocumento(Long idResultadoPruebaDocumento, Long idDocumentoAdjunto,
			Long idResutadoPruebaReprueba) {
		
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
		this.idDocumentoAdjunto = idDocumentoAdjunto;
		this.idResutadoPruebaReprueba = idResutadoPruebaReprueba;
	}

	public Long getIdResultadoPruebaDocumento() {
		return idResultadoPruebaDocumento;
	}

	public void setIdResultadoPruebaDocumento(Long idResultadoPruebaDocumento) {
		this.idResultadoPruebaDocumento = idResultadoPruebaDocumento;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public Long getIdResutadoPruebaReprueba() {
		return idResutadoPruebaReprueba;
	}

	public void setIdResutadoPruebaReprueba(Long idResutadoPruebaReprueba) {
		this.idResutadoPruebaReprueba = idResutadoPruebaReprueba;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoPruebaDocumento != null ? idResultadoPruebaDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPruebaDocumento)) {
            return false;
        }
        PghResultadoPruebaDocumento other = (PghResultadoPruebaDocumento) object;
        if ((this.idResultadoPruebaDocumento == null && other.idResultadoPruebaDocumento != null) || (this.idResultadoPruebaDocumento != null && !this.idResultadoPruebaDocumento.equals(other.idResultadoPruebaDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPruebaDocumento[ idResultadoPruebaDocumento=" + idResultadoPruebaDocumento + " ]";
    }
		
}
