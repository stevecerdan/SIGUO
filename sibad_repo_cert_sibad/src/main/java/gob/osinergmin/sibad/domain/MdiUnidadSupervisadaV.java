package gob.osinergmin.sibad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_UNIDAD_SUPERVISADA")
@NamedQueries({
    @NamedQuery(name = "MdiUnidadSupervisadaV.findAll", query = "SELECT us FROM MdiUnidadSupervisadaV us WHERE us.idUnidadSupervisada = :idUnidadSupervisada"),
})

public class MdiUnidadSupervisadaV {

    @Id
    @Column(name = "ID_UNIDAD_SUPERVISADA")
    private Long idUnidadSupervisada;
    
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;   
    
    @Column(name = "DIRECCION")
    private String direccion;  
    
    @Column(name = "ID_EMPRESA_SUPERVISADA")
    private Long idEmpresaSupervisada;
    
    @Column(name = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;   
    
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    
	public MdiUnidadSupervisadaV() {
		
	}

	public MdiUnidadSupervisadaV(Long idUnidadSupervisada, String nombreUnidad, String direccion,
			Long idEmpresaSupervisada, String numeroIdentificacion, String razonSocial) {
		
		this.idUnidadSupervisada = idUnidadSupervisada;
		this.nombreUnidad = nombreUnidad;
		this.direccion = direccion;
		this.idEmpresaSupervisada = idEmpresaSupervisada;
		this.numeroIdentificacion = numeroIdentificacion;
		this.razonSocial = razonSocial;
	}

	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getIdEmpresaSupervisada() {
		return idEmpresaSupervisada;
	}

	public void setIdEmpresaSupervisada(Long idEmpresaSupervisada) {
		this.idEmpresaSupervisada = idEmpresaSupervisada;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}   
    
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadSupervisada != null ? idUnidadSupervisada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MdiUnidadSupervisadaV)) {
            return false;
        }
        MdiUnidadSupervisadaV other = (MdiUnidadSupervisadaV) object;
        if ((this.idUnidadSupervisada == null && other.idUnidadSupervisada != null) || (this.idUnidadSupervisada != null && !this.idUnidadSupervisada.equals(other.idUnidadSupervisada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinerg.sibad.domain.MdiUnidadSupervisadaV[ idUnidadSupervisada=" + idUnidadSupervisada + " ]";
    }
    
}
