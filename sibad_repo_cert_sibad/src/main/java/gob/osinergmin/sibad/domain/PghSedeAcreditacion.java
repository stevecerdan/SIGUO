package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PGH_SEDE_ACREDITACION")
@XmlRootElement

public class PghSedeAcreditacion extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEDE_ACREDITACION")
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_SEDE_ACREDITACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idSedeAcreditacion;
     
    @Column(name = "ID_ALCANCE_ACREDITACION")
    private Long idAlcanceAcreditacion;
  
    
    @Column(name = "ID_DEPARTAMENTO")
	private String idDepartamento; 

	@Column(name = "ID_PROVINCIA")
	private String idProvincia; 

	@Column(name = "ID_DISTRITO")
	private String idDistrito; 
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    
    @Column(name = "ESTADO")
    private String estado;
    

    public PghSedeAcreditacion() {
    }

    public PghSedeAcreditacion(Long idSedeAcreditacion) {
        this.idSedeAcreditacion = idSedeAcreditacion;
    }
    
    public PghSedeAcreditacion(Long idSedeAcreditacion, String direccion,String estado) {
        this.idSedeAcreditacion = idSedeAcreditacion;
        this.direccion= direccion;
        this.estado=estado;        
    }
    
    public PghSedeAcreditacion(Long idSedeAcreditacion, String direccion) {
        this.idSedeAcreditacion = idSedeAcreditacion;
        this.direccion= direccion;
    }
    
    public PghSedeAcreditacion(Long idSedeAcreditacion, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idSedeAcreditacion = idSedeAcreditacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	public Long getIdSedeAcreditacion() {
		return idSedeAcreditacion;
	}

	public void setIdSedeAcreditacion(Long idSedeAcreditacion) {
		this.idSedeAcreditacion = idSedeAcreditacion;
	}

	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedeAcreditacion != null ? idSedeAcreditacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghSedeAcreditacion)) {
            return false;
        }
        PghSedeAcreditacion other = (PghSedeAcreditacion) object;
        if ((this.idSedeAcreditacion == null && other.idSedeAcreditacion != null) || (this.idSedeAcreditacion != null && !this.idSedeAcreditacion.equals(other.idSedeAcreditacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSedeAcreditacion[ idSedeAcreditacion=" + idSedeAcreditacion + " ]";
    }
    
}
