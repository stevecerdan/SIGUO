package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MDI_UNIDAD_SUPERVISADA")
@NamedQueries({
    @NamedQuery(name = "MdiUnidadSupervisada.findAll", query = "SELECT t FROM MdiUnidadSupervisada t"),
    @NamedQuery(name = "MdiUnidadSupervisada.findByCodigoOsinergmin", query = "SELECT t FROM MdiUnidadSupervisada t WHERE t.codigoOsinergmin = :codigoOsinergmin AND t.estado = '1' "),
    @NamedQuery(name = "MdiUnidadSupervisada.findByRuc", query = "SELECT t FROM MdiUnidadSupervisada t WHERE t.ruc = :ruc AND t.estado = '1' ")
})
public class MdiUnidadSupervisada implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_UNIDAD_SUPERVISADA")
    private Long idUnidadSupervisada;
    
    @Column(name = "CODIGO_OSINERGMIN")
    private String codigoOsinergmin;
    
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;    
    
    @Column(name = "RUC")
    private String ruc;
    
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne
    private MdiActividad idActividad;

    @Column(name = "ESTADO")
    private String estado;
    
    public MdiUnidadSupervisada() {
    }

    public MdiUnidadSupervisada(Long idUnidadSupervisada) {
        this.idUnidadSupervisada = idUnidadSupervisada;
    }
    
    public UnidadSupervisadaDTO getUnidadSupervisadaDTO() {
    	UnidadSupervisadaDTO unidadSupervisadaDTO = new UnidadSupervisadaDTO();
    	unidadSupervisadaDTO.setIdUnidadSupervisada(idUnidadSupervisada);
    	unidadSupervisadaDTO.setCodigoOsinergminUnidadSupervisada(codigoOsinergmin);
    	unidadSupervisadaDTO.setNombreUnidadSupervisada(nombreUnidad);
    	unidadSupervisadaDTO.setRucUnidadSupervisada(ruc);
    	if(idActividad != null){
    		unidadSupervisadaDTO.setIdTipoAgente(idActividad.getIdActividad());
    		unidadSupervisadaDTO.setCodigoTipoAgente(idActividad.getCodigo());
    		unidadSupervisadaDTO.setNombreTipoAgente(idActividad.getNombre());
    		unidadSupervisadaDTO.setIdActividad(idActividad.getIdActividadPadre());
    	}else{
    		unidadSupervisadaDTO.setIdTipoAgente(null);
    		unidadSupervisadaDTO.setCodigoTipoAgente("");
    		unidadSupervisadaDTO.setNombreTipoAgente("");
    		unidadSupervisadaDTO.setIdActividad(null);
    	}
    	unidadSupervisadaDTO.setEstadoUnidadSupervisada(String.valueOf(estado));
    	return unidadSupervisadaDTO;
    }

	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public String getCodigoOsinergmin() {
		return codigoOsinergmin;
	}

	public void setCodigoOsinergmin(String codigoOsinergmin) {
		this.codigoOsinergmin = codigoOsinergmin;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public MdiActividad getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(MdiActividad idActividad) {
		this.idActividad = idActividad;
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
        hash += (idUnidadSupervisada != null ? idUnidadSupervisada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MdiUnidadSupervisada)) {
            return false;
        }
        MdiUnidadSupervisada other = (MdiUnidadSupervisada) object;
        if ((this.idUnidadSupervisada == null && other.idUnidadSupervisada != null) || (this.idUnidadSupervisada != null && !this.idUnidadSupervisada.equals(other.idUnidadSupervisada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinerg.sibad.domain.MdiUnidadSupervisada[ idUnidadSupervisada=" + idUnidadSupervisada + " ]";
    }
    
}
