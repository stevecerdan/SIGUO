/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "MDI_PERSONA_JURIDICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiPersonaJuridica.findByIdPersonaJ", query = "SELECT p FROM MdiPersonaJuridica p WHERE p.idPersonaJuridica=:idPersonaJuridica "),
    @NamedQuery(name = "MdiPersonaJuridica.findByFilter", query = "SELECT p FROM MdiPersonaJuridica p WHERE upper(p.ruc) like :ruc")

})
public class MdiPersonaJuridica extends Auditoria{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA_JURIDICA")
    private Long idPersonaJuridica;
    @Size(max = 10)
    
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 13)
    
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 256)
    
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 512)
    
    @Column(name = "ID_DEPARTAMENTO")
    private String departamento;
    @Size(max = 2)
    
    @Column(name = "ID_PROVINCIA")
    private String provincia;
    @Size(max = 2)
    
    @Column(name = "ID_DISTRITO")
    private String distrito;
    @Size(max = 2)
    
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 16)
    
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 64)
    
    @Column(name = "WEB")
    private String web;
    @Size(max = 256)
    
    public MdiPersonaJuridica() {
    }

    public MdiPersonaJuridica(Long idPersonaJuridica) {
        this.idPersonaJuridica = idPersonaJuridica;
    }

    /*public MdiPersonaJuridica(Long idPersonaJuridica, String ruc, String razonSocial, String direccion, String telefono, String email, String web) {
        this.idPersonaJuridica = idPersonaJuridica;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.web = web;     
    }*/
    
    public MdiPersonaJuridica(Long idPersonaJuridica, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
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

	/*public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }*/

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonaJuridica != null ? idPersonaJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiPersonaJuridica)) {
            return false;
        }
        MdiPersonaJuridica other = (MdiPersonaJuridica) object;
        if ((this.idPersonaJuridica == null && other.idPersonaJuridica != null) || (this.idPersonaJuridica != null && !this.idPersonaJuridica.equals(other.idPersonaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.MdiPersonaJuridica[ idPersonaJuridica=" + idPersonaJuridica + " ]";
    }
    
}
