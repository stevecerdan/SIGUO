package gob.osinergmin.sibad.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "VIEW_ORGANISMO_ACREDITADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghOrganismoAcreditador.findByOrganismoGeneral", query = "SELECT n FROM PghOrganismoAcreditador n WHERE n.idOrganismoAcreditador = :idOrganismoAcreditador")
})

public class PghOrganismoAcreditador{
	 
	 @Id
	 @Basic(optional = false)
	 @NotNull
	 @Column(name = "ID_ORGANISMO_ACREDITADOR")
	 private Long idOrganismoAcreditador;
	 @Size(max = 10)
	 
	 @Column(name = "RUC")
     private String ruc;
     @Size(max = 13) 
	 
	 @Column(name = "NOMBRE_ORG_ACREDITADOR")
	 private String nombreOrgAcreditador;
	 @Size(max = 85)
	 
	 @Column(name = "DIRECCION")
	 private String direccion;
	 @Size(max = 200)
	 
	 @Column(name = "DEPARTAMENTO")
	 private String departamento;
	 @Size(max = 100)
	 
	 @Column(name = "PROVINCIA")
	 private String provincia;
	 @Size(max = 100)
	 
	 @Column(name = "DISTRITO")
	 private String distrito;
	 @Size(max = 100)
	 
	 @Column(name = "TELEFONO")
	 private String telefono;
	 //@Size(max = 10)
	 
	 @Column(name = "EMAIL")
	 private String email;
	 //@Size(max = 200)
	 
	 @Column(name = "WEB")
	 private String web;
	 //@Size(max = 200)
	 
	/* @Column(name = "TIPO_PRUEBA")
	 private String tipoPrueba;
	 @Size(max = 200)
	 	 
	 @Basic(optional = false)
	 @NotNull
	 @Column(name = "ID_TIPO_PRUEBA")
	 private Long idTipoPrueba;*/
	 
	 @Basic(optional = false)
	 @NotNull
	 @Column(name = "ID_PERSONA_JURIDICA")
	 private Long idPersonaJuridica;
	 
	 @Column(name = "FECHA_CREACION")
	 private Date fechaCreacion;
	 
	 @Column(name = "FECHA_ACTUALIZACION")
	 private Date fechaActualizacion;
	 
	 @Basic(optional = false)
	 @NotNull
	 @Column(name = "ESTADO")
	 private String estado;
	 
	 public PghOrganismoAcreditador() {}
	 
	 public PghOrganismoAcreditador(Long idOrganismoAcreditado, String nombreOrgAcreditador, String direccion) {
		 this.idOrganismoAcreditador = idOrganismoAcreditado;
	 }
	 
	 public Long getIdOrganismoAcreditador() {
		return idOrganismoAcreditador;
	}
	 public void setIdOrganismoAcreditador(Long idOrganismoAcreditador) {
		this.idOrganismoAcreditador = idOrganismoAcreditador;
	}
	 
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	 public String getRuc() {
		return ruc;
	}
	 
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	 public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	 
	public String getDireccion() {
		return direccion;
	}
	 
	 public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	 
	 public String getEmail() {
		return email;
	}
	 
	 public void setEmail(String email) {
		this.email = email;
	}
	 
	 public String getTelefono() {
		return telefono;
	}
	 public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	 public String getNombreOrgAcreditador() {
		return nombreOrgAcreditador;
	}
	 
	 public void setNombreOrgAcreditador(String nombreOrgAcreditador) {
		this.nombreOrgAcreditador = nombreOrgAcreditador;
	}
	 	 
	 public String getEstado() {
		return estado;
	}
	 
	 public void setEstado(String estado) {
		this.estado = estado;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idOrganismoAcreditador != null ? idOrganismoAcreditador.hashCode() : 0);
	        return hash;
	    }
	 
	 @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof PghOrganismoAcreditador)) {
	            return false;
	        }
	        PghOrganismoAcreditador other = (PghOrganismoAcreditador) object;
	        if ((this.idOrganismoAcreditador == null && other.idOrganismoAcreditador != null) || (this.idOrganismoAcreditador != null && !this.idOrganismoAcreditador.equals(other.idOrganismoAcreditador))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "gob.osinergmin.sibad.domain.PghOrganismoAcreditador[ idOrganismoAcreditador=" + idOrganismoAcreditador + " ]";
	    }
}
