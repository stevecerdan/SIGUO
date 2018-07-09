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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * @author jpiro
 */
@Entity
@Table(name = "PGH_SOLICITUD_PRUEBA_REPRUEBA")
@XmlRootElement

public class PghSolicitudPruebaReprueba extends Auditoria{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
	@NotNull
	@Column(name = "ID_SOLICITUD_PRUEBA_REPRUEBA")
	@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_SOLICITUD_PRUEBA_REPBA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private Long idSolicitudPruebaReprueba;
    
    @Column(name = "NRO_SOLICITUD_UNIDAD_SUPERVISA")
    private String nroSolicitudUnidadSupervisa;
    
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcreditada;
    
    @Column(name = "ID_PERSONA_JURIDICA")
    private Long idPersonaJuridica;
    
    @Column(name = "FECHA_SOLICITUD")
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="MM-dd-yyyy HH:mm")
    private Date fechaSolicitud;
    
    @Column(name = "ID_COMPARTIMIENTO")
    private Long idCompartimiento;
    
    @Column(name = "ID_CILINDRO_GNV")
    private Long idCilindroGNV;
    
    @Column(name = "ID_TANQUE_GLP")
    private Long idTanqueGLP;
    
    @Column(name = "FLAG_INSPECCION")
    private String flagInspeccion;
        
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "FLAG_INFORME_INDICE_RIESGO")
    private String flagInformeIndiceRiesgo;
    
    public PghSolicitudPruebaReprueba() {
    }
    
    public PghSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
        this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
    }
    
    public PghSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba, String nroSolicitudUnidadSupervisa, Long idTipoPrueba, Long idEmpresaAcreditada, Long idPersonaJuridica, Date fechaSolicitud, Long idCompartimiento, Long idCilindroGNV, Long idTanqueGLP, String flagInspeccion, String estado, String flagInformeIndiceRiesgo) {
        this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
        this.nroSolicitudUnidadSupervisa = nroSolicitudUnidadSupervisa;
        this.idTipoPrueba = idTipoPrueba;
        this.idEmpresaAcreditada = idEmpresaAcreditada;
        this.idPersonaJuridica = idPersonaJuridica;
        this.fechaSolicitud = fechaSolicitud;
        this.idCompartimiento = idCompartimiento;
        this.idCilindroGNV = idCilindroGNV;
        this.idTanqueGLP = idTanqueGLP;
        this.flagInspeccion = flagInspeccion;
        this.estado = estado;
        this.flagInformeIndiceRiesgo = flagInformeIndiceRiesgo;
    }
    
    public PghSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
    	this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	public Long getIdSolicitudPruebaReprueba() {
		return idSolicitudPruebaReprueba;
	}

	public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
		this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
	}

	public String getNroSolicitudUnidadSupervisa() {
		return nroSolicitudUnidadSupervisa;
	}

	public void setNroSolicitudUnidadSupervisa(String nroSolicitudUnidadSupervisa) {
		this.nroSolicitudUnidadSupervisa = nroSolicitudUnidadSupervisa;
	}

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}

	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}

	public Long getIdCilindroGNV() {
		return idCilindroGNV;
	}

	public void setIdCilindroGNV(Long idCilindroGNV) {
		this.idCilindroGNV = idCilindroGNV;
	}

	public Long getIdTanqueGLP() {
		return idTanqueGLP;
	}

	public void setIdTanqueGLP(Long idTanqueGLP) {
		this.idTanqueGLP = idTanqueGLP;
	}

	public String getFlagInspeccion() {
		return flagInspeccion;
	}

	public void setFlagInspeccion(String flagInspeccion) {
		this.flagInspeccion = flagInspeccion;
	}
	
	public String getFlagInformeIndiceRiesgo() {
		return flagInformeIndiceRiesgo;
	}

	public void setFlagInformeIndiceRiesgo(String flagInformeIndiceRiesgo) {
		this.flagInformeIndiceRiesgo = flagInformeIndiceRiesgo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudPruebaReprueba != null ? idSolicitudPruebaReprueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghSolicitudPruebaReprueba)) {
            return false;
        }
        PghSolicitudPruebaReprueba other = (PghSolicitudPruebaReprueba) object;
        if ((this.idSolicitudPruebaReprueba == null && other.idSolicitudPruebaReprueba != null) || (this.idSolicitudPruebaReprueba != null && !this.idSolicitudPruebaReprueba.equals(other.idSolicitudPruebaReprueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghSolicitudPruebaReprueba[ idSolicitudPruebaReprueba=" + idSolicitudPruebaReprueba + " ]";
    }
}
