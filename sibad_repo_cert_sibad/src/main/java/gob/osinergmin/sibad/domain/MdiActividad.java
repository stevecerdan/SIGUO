package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MDI_ACTIVIDAD")
@NamedQueries({
    @NamedQuery(name = "MdiActividad.findAll", query = "SELECT t FROM MdiActividad t"),
    @NamedQuery(name = "MdiActividad.findByIdActividad", query = "SELECT t FROM MdiActividad t WHERE t.idActividad = :idActividad"),
    @NamedQuery(name = "MdiActividad.findByIdActividadPadre", query = "SELECT t FROM MdiActividad t WHERE t.idActividadPadre = :idActividadPadre")
})
public class MdiActividad implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_ACTIVIDAD")
    private Long idActividad;
    
    @Column(name = "ID_ACTIVIDAD_PADRE")
    private Long idActividadPadre;
    
    @Column(name = "CODIGO")
    private String codigo;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "ESTADO")
    private String estado;
    
    public MdiActividad() {
    }

    public MdiActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public Long getIdActividadPadre() {
		return idActividadPadre;
	}

	public void setIdActividadPadre(Long idActividadPadre) {
		this.idActividadPadre = idActividadPadre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MdiActividad)) {
            return false;
        }
        MdiActividad other = (MdiActividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinerg.sibad.domain.MdiActividad[ idActividad=" + idActividad + " ]";
    }
    
}
