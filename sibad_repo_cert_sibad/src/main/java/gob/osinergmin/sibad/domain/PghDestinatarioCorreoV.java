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
@Table(name = "VIEW_DESTINATARIO_CORREO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghDestinatarioCorreoV.findByAllDatos", query = "SELECT c FROM PghDestinatarioCorreoV c WHERE c.idDestinatarioCorreo = :idDestinatarioCorreo"),
    @NamedQuery(name = "PghDestinatarioCorreoV.findByFilterDatos", query = "SELECT c FROM PghDestinatarioCorreoV c WHERE c.idCorreo = :idCorreo and c.idPersonal = :idPersonal")
                                                                                                                                             
})

public class PghDestinatarioCorreoV{
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_DESTINATARIO_CORREO")
	private Long idDestinatarioCorreo;
	
	@Column(name = "ID_CORREO")
	private Long idCorreo;
	
	@Column(name = "ASUNTO")
    private String asunto;
    @Size(max = 150)
    
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 4000)
    
    @Column(name = "ID_PERSONAL")
	private Long idPersonal;
    
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Size(max = 100)
    
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 100)
    
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 100)
    
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Size(max = 302)
    
    @Column(name = "ID_REGION")
	private Long idRegion;
    
    @Column(name = "NOMBRE_REGION")
    private String nombreRegion;
    @Size(max = 50)

	public PghDestinatarioCorreoV() {
		
	}
	
	public PghDestinatarioCorreoV(Long idDestinatarioCorreo) {
		
		this.idDestinatarioCorreo = idDestinatarioCorreo;
	}
	
	//S&G

	public Long getIdDestinatarioCorreo() {
		return idDestinatarioCorreo;
	}

	public void setIdDestinatarioCorreo(Long idDestinatarioCorreo) {
		this.idDestinatarioCorreo = idDestinatarioCorreo;
	}
	
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

	public Long getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Long idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Long idRegion) {
		this.idRegion = idRegion;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDestinatarioCorreo != null ? idDestinatarioCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDestinatarioCorreoV)) {
            return false;
        }
        PghDestinatarioCorreoV other = (PghDestinatarioCorreoV) object;
        if ((this.idDestinatarioCorreo == null && other.idDestinatarioCorreo != null) || (this.idDestinatarioCorreo != null && !this.idDestinatarioCorreo.equals(other.idDestinatarioCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghDestinatarioCorreoV[ idDestinatarioCorreo=" + idDestinatarioCorreo + " ]";
    }
	
}
