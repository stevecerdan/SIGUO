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
@Table(name = "PGH_ALCANCE_ACREDITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghAlcanceAcreditacion.findByIdAlcanceAcreditacion", query = "SELECT a FROM PghAlcanceAcreditacion a WHERE a.idAlcanceAcreditacion=:idAlcanceAcreditacion "),
    //@NamedQuery(name = "MdiPersonaJuridica.findByFilter", query = "SELECT p FROM MdiPersonaJuridica p WHERE upper(p.ruc) like :ruc and upper(p.razonSocial) like :razonSocial ")

})
public class PghAlcanceAcreditacion extends Auditoria{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALCANCE_ACREDITACION")
    private Long idAlcanceAcreditacion;
    @Size(max = 10)
    
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
    @Size(max = 10)
    
    @Column(name = "RESOLUCION_CEDULA")
    private String resolucionCedula;
    @Size(max = 64)
    
    @Column(name = "REGISTRO")
    private String registro;
    @Size(max = 64)
    
    @Column(name = "FECHA_ULTIMA_ACTUALIZACION")
    private Date fechaUActualizacion;
    
    @Column(name = "FECHA_ACREDITACION")
    private Date fechaAcreditacion;
    
    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;
    
    //@Column(name = "RESOLUCION_CEDULA")
    //private String resolucionCedula;
    //@Size(max = 64)
    
    //@Column(name = "FECHA_INICIO_VIGENCIA")
    //private Date fechaIVigencia;
    
    //@Column(name = "ID_TIPO_ORGANISMO")
    //private Long tipoOrganismo;
    //@Size(max = 10)
    
    //@Column(name = "REGISTRO")
    //private String Nregistro;
    //@Size(max = 64)
    
    @Column(name = "ESTADO")
    private String estado;
    
    public PghAlcanceAcreditacion() {
    }

    public PghAlcanceAcreditacion(Long idAlcanceAcreditacion) {
        this.idAlcanceAcreditacion = idAlcanceAcreditacion;
    }
    
    public PghAlcanceAcreditacion(Long idAlcanceAcreditacion, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idAlcanceAcreditacion = idAlcanceAcreditacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public String getResolucionCedula() {
		return resolucionCedula;
	}

	public void setResolucionCedula(String resolucionCedula) {
		this.resolucionCedula = resolucionCedula;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Date getFechaUActualizacion() {
		return fechaUActualizacion;
	}

	public void setFechaUActualizacion(Date fechaUActualizacion) {
		this.fechaUActualizacion = fechaUActualizacion;
	}

	public Date getFechaAcreditacion() {
		return fechaAcreditacion;
	}

	public void setFechaAcreditacion(Date fechaAcreditacion) {
		this.fechaAcreditacion = fechaAcreditacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
        hash += (idAlcanceAcreditacion != null ? idAlcanceAcreditacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghAlcanceAcreditacion)) {
            return false;
        }
        PghAlcanceAcreditacion other = (PghAlcanceAcreditacion) object;
        if ((this.idAlcanceAcreditacion == null && other.idAlcanceAcreditacion != null) || (this.idAlcanceAcreditacion != null && !this.idAlcanceAcreditacion.equals(other.idAlcanceAcreditacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghAlcanceAcreditacion[ idAlcanceAcreditacion=" + idAlcanceAcreditacion + " ]";
    }
    
}
