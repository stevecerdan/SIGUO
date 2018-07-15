package gob.osinergmin.sibad.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PGH_CORREO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCorreo.findByAllDatos", query = "SELECT c FROM PghCorreo c WHERE c.idCorreo = :idCorreo")
                                                                                                                                             
})

public class PghCorreo{
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_CORREO")
	private Long idCorreo;
	
	@Column(name = "CODIGO_FUNCIONALIDAD")
    private String codigoFuncionalidad;
    @Size(max = 10)
	
	@Column(name = "ASUNTO")
    private String asunto;
    @Size(max = 150)
    
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 4000)
    
	public PghCorreo() {
		
	}
	
	public PghCorreo(Long idCorreo) {
		
		this.idCorreo = idCorreo;
	}
	
	//S&G

	public Long getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(Long idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigoFuncionalidad() {
		return codigoFuncionalidad;
	}

	public void setCodigoFuncionalidad(String codigoFuncionalidad) {
		this.codigoFuncionalidad = codigoFuncionalidad;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCorreo)) {
            return false;
        }
        PghCorreo other = (PghCorreo) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghCorreo[ idCorreo=" + idCorreo + " ]";
    }
	
}
