/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VIEW_SEDE_PERSONAL_AUTORIZADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghSedePersonalAutorizadoV.findBySede", query = "SELECT pa FROM PghSedePersonalAutorizadoV pa WHERE pa.idSedePersonalAutorizado = :idSedePersonalAutorizado"),
    @NamedQuery(name = "PghSedePersonalAutorizadoV.findByFilter", query = "SELECT pa FROM PghSedePersonalAutorizadoV pa WHERE pa.idAlcanceAcreditacion = :idAlcanceAcreditacion and upper(pa.flagPersonalAutorizado) = :flagPersonalAutorizado")
   
    
})

public class PghSedePersonalAutorizadoV extends Auditoria{
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEDE_PERSONAL_AUTORIZADO")
    private Long idSedePersonalAutorizado;
    @Size(max = 10)
    
    @Column(name = "ID_ALCANCE_ACREDITACION")
    private Long idAlcanceAcreditacion;
    @Size(max = 10)
    
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 512)
    
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Size(max = 100)
    
    @Column(name = "PROVINCIA")
    private String provincia;
    @Size(max = 100)
    
    @Column(name = "DISTRITO")
    private String distrito;
    @Size(max = 100)
    
    @Column(name = "FLAG_SEDE_PERSONAL_AUTORIZADO")
    private String flagPersonalAutorizado;
    @Size(max = 1)
    
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Size(max = 200)
    
    @Column(name = "NUMERO_DOC_IDENTIDAD")
    private String numeroDocumento;
    @Size(max = 16)
    
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 64)
    
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Size(max = 32)
    
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 32)
    
    @Column(name = "ID_CARGO")
    private Long idCargo;
    
    @Column(name = "ID_ESPECIALIDAD")
    private Long idEspecialidad;
    
    @Column(name = "ESPECIALIDAD_CARGO")
    private String especialidadCargo;
    @Size(max = 200)
    
    @Column(name = "CIP")
    private Long cip;
    @Size(max = 8)
    
    
    public PghSedePersonalAutorizadoV() {
    }

    public PghSedePersonalAutorizadoV(Long idSedePersonalAutorizado) {
        this.idSedePersonalAutorizado = idSedePersonalAutorizado;
    }
    
    public PghSedePersonalAutorizadoV(Long idSedePersonalAutorizado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idSedePersonalAutorizado = idSedePersonalAutorizado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}

	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
	
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
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

	public String getFlagPersonalAutorizado() {
		return flagPersonalAutorizado;
	}

	public void setFlagPersonalAutorizado(String flagPersonalAutorizado) {
		this.flagPersonalAutorizado = flagPersonalAutorizado;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getEspecialidadCargo() {
		return especialidadCargo;
	}

	public void setEspecialidadCargo(String especialidadCargo) {
		this.especialidadCargo = especialidadCargo;
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
        hash += (idSedePersonalAutorizado != null ? idSedePersonalAutorizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghSedePersonalAutorizadoV)) {
            return false;
        }
        PghSedePersonalAutorizadoV other = (PghSedePersonalAutorizadoV) object;
        if ((this.idSedePersonalAutorizado == null && other.idSedePersonalAutorizado != null) || (this.idSedePersonalAutorizado != null && !this.idSedePersonalAutorizado.equals(other.idSedePersonalAutorizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSedePersonalAutorizadoV[ idSedePersonalAutorizado=" + idSedePersonalAutorizado + " ]";
    }
    
}
