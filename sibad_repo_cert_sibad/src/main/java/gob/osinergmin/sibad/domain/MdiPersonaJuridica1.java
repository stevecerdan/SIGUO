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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MDI_PERSONA_JURIDICA")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiPersonaJuridica1.findAll", query = "SELECT t FROM MdiPersonaJuridica1 t"),
    @NamedQuery(name = "MdiPersonaJuridica1.findByFilter", query = "SELECT p FROM MdiPersonaJuridica1 p WHERE upper(p.ruc) like :ruc")
})

public class MdiPersonaJuridica1 extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	
	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "MDI_PERSONA_JURIDICA_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_PERSONA_JURIDICA")
	 private Long idPersonaJuridica;
	 
	 @Basic(optional = false)
	 @Column(name = "RUC")
	 private String ruc;
	 
	 
	 @Column(name = "ID_DEPARTAMENTO")
	 private String idDepartamento; 
	 
	 
	 @Column(name = "ID_PROVINCIA")
	 private String idProvincia; 
	 
	
	 @Column(name = "ID_DISTRITO")
	 private String idDistrito; 
	 
	 @Basic(optional = false)
	 @Column(name = "RAZON_SOCIAL")
     private String razonSocial;
    
	 @Basic(optional = false)
     @Column(name = "DIRECCION")
     private String direccion;
     
	 @Basic(optional = false)
     @Column(name = "TELEFONO")
     private String telefono;    
   
	 @Basic(optional = false)
     @Column(name = "EMAIL")
     private String email;
     
	 @Basic(optional = false)
     @Column(name = "WEB")
     private String web;

	public MdiPersonaJuridica1() {
		super();
	}

	public MdiPersonaJuridica1(Long idPersonaJuridica, String ruc, String idDepartamento, String idProvincia,
			String idDistrito, String razonSocial, String direccion, String telefono, String email, String web) {
		super();
		this.idPersonaJuridica = idPersonaJuridica;
		this.ruc = ruc;
		this.idDepartamento = idDepartamento;
		this.idProvincia = idProvincia;
		this.idDistrito = idDistrito;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.web = web;
	}

	public MdiPersonaJuridica1(Long idPersonaJuridica, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
		super();
		this.idPersonaJuridica = idPersonaJuridica;
		this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
	}

	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}

	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
    
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonaJuridica != null ? idPersonaJuridica.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiPersonaJuridica1)) {
            return false;
        }
        MdiPersonaJuridica1 other = (MdiPersonaJuridica1) object;
        if ((this.idPersonaJuridica == null && other.idPersonaJuridica != null) || (this.idPersonaJuridica != null && !this.idPersonaJuridica.equals(other.idPersonaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.MdiPersonaJuridica1[ idPersonaJuridica=" + idPersonaJuridica + " ]";
    }
     
     
     
	 

}
