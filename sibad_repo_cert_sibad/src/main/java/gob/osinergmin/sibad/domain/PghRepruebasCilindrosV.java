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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_REPRUEBAS_CILINDROS_GNV")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghRepruebasCilindrosV.findByALL", query = "SELECT e FROM PghRepruebasCilindrosV e"),
	@NamedQuery(name = "PghRepruebasCilindrosV.findByID", query = "SELECT e FROM PghRepruebasCilindrosV e WHERE e.idUnidSuperv = :idUnidSuperv"),
	@NamedQuery(name = "PghRepruebasCilindrosV.findByIdModulo", query = "SELECT e FROM PghRepruebasCilindrosV e WHERE e.idModulo = :idModulo")
})
public class PghRepruebasCilindrosV {
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDP")
	private Long idP;
	
    @Column(name = "ID_UNIDAD_SUPERVISADA")
	private Long idUnidSuperv;
	
	/*@Column(name = "CODIGO_OSINERGMIN")
    private String codigoOsinerg;
	
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;*/
    
    @Column(name = "NUMERO_MODULO")
    private String nroModulo;
    
    @Column(name = "ID_MODULO") 
    private Long idModulo;
    
    @Column(name = "ID_CILINDRO_GNV")
    private String idCilindro;

    @Column(name = "NUMERO_SERIE")
    private String numeroSerie;
    
    @Column(name = "NUMERO_CILINDRO")
    private String nroCilindro; 
    
    @Column(name = "FECHA_PROXIMA_REPRUEBA")
    private Date fechaProximaRep; 
    
    public PghRepruebasCilindrosV() {
    }
    
    public PghRepruebasCilindrosV(Long idUnidSuperv) {
        this.idUnidSuperv = idUnidSuperv;
    }
    
    public Long getIdUnidSuperv() {
		return idUnidSuperv;
	}
    public void setIdUnidSuperv(Long idUnidSuperv) {
		this.idUnidSuperv = idUnidSuperv;
	}
    /*
    public String getCodigoOsinerg() {
		return codigoOsinerg;
	}
    public void setCodigoOsinerg(String codigoOsinerg) {
		this.codigoOsinerg = codigoOsinerg;
	}
    */
    public Date getFechaProximaRep() {
		return fechaProximaRep;
	}
    public void setFechaProximaRep(Date fechaProximaRep) {
		this.fechaProximaRep = fechaProximaRep;
	}
    /*public String getNombreUnidad() {
		return nombreUnidad;
	}
    public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}*/
    public String getNroCilindro() {
		return nroCilindro;
	}
    public void setNroCilindro(String nroCilindro) {
		this.nroCilindro = nroCilindro;
	}
    public String getNroModulo() {
		return nroModulo;
	}
    public void setNroModulo(String nroModulo) {
		this.nroModulo = nroModulo;
	}
    public Long getIdModulo() {
		return idModulo;
	}
    public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
    public String getIdCilindro() {
		return idCilindro;
	}
    public void setIdCilindro(String idCilindro) {
		this.idCilindro = idCilindro;
	}
    public String getNumeroSerie() {
		return numeroSerie;
	}
    public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidSuperv != null ? idUnidSuperv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghRepruebasCilindrosV)) {
            return false;
        }
        PghRepruebasCilindrosV other = (PghRepruebasCilindrosV) object;
        if ((this.idUnidSuperv == null && other.idUnidSuperv != null) || (this.idUnidSuperv != null && !this.idUnidSuperv.equals(other.idUnidSuperv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghRepruebasCilindrosV[ idUnidSuperv=" + idUnidSuperv + " ]";
    }
    
}
