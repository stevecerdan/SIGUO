package gob.osinergmin.sibad.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "PGH_EQUIPO_CERTIFICADO")
@XmlRootElement
public class PghEquipoCertificado  extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_EQUIPO_CERTIFICADO_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_EQUIPO_CERTIFICADO")
	 private Long idEquipoCertificado;
	  
	 @Column(name = "ID_ALCANCE_ACREDITACION")
	 private Long idAlcanceAcreditacion; 
	 
	 @Column(name = "ID_TIPO_EQUIPO")
	 private Long idTipoEquipo; 
	
	 @Column(name = "DESCRIPCION")
	 private String descripcion; 
	
	 @Column(name = "MARCA")
	 private String marca;
	 
	 @Column(name = "MODELO")
	 private String modelo;
	 
	 @Column(name = "SERIE")
	 private String serie;
	 
	 @Column(name = "OTRO_DATO_ADICIONAL")
	 private String datoAdicional;
	 
	 @Column(name = "FECHA_CALIBRACION")
	 private Date fechaCalibracion;
	
	 @Column(name = "FECHA_PROXIMA_CALIBRACION")
	 private Date fechaProxCalibracion;
	 
	 @Basic(optional = false)
	 @Column(name = "ESTADO")
	 private String estado;
	 
	 @Column(name = "ID_TIPO_MOTIVO")
	 private Long idTipoMotivo;
	 
	 @Column(name = "OBSERVACION")
	 private String observacion;

	public PghEquipoCertificado() {
		super();
	}

	public PghEquipoCertificado(Long idEquipoCertificado,Long idAlcanceAcreditacion, Long idTipoEquipo, String descripcion, String marca, String modelo, String serie,String datoAdicional, Date fecha, Date fechaProx, String estado,Long idTipoMotivo, String observacion) {
		super();
		this.idEquipoCertificado = idEquipoCertificado;
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
		this.idTipoEquipo = idTipoEquipo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.modelo = modelo;
		this.serie = serie;
		this.datoAdicional = datoAdicional;
		this.fechaCalibracion = fecha;
		this.fechaProxCalibracion = fechaProx;
		this.estado = estado;
		this.idTipoMotivo = idTipoMotivo;
		this.observacion = observacion;
	}

	public PghEquipoCertificado(Long idEquipoCertificado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
		super();
		this.idEquipoCertificado = idEquipoCertificado;
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
	
	public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}
	
	public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}
	
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}
	
	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}
	
	public String getDatoAdicional() {
		return datoAdicional;
	}
	
	public void setDatoAdicional(String datoAdicional) {
		this.datoAdicional = datoAdicional;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Date getFechaCalibracion() {
		return fechaCalibracion;
	}
	
	public void setFechaCalibracion(Date fechaCalibracion) {
		this.fechaCalibracion = fechaCalibracion;
	}
	
	public Date getFechaProxCalibracion() {
		return fechaProxCalibracion;
	}
	
	public void setFechaProxCalibracion(Date fechaProxCalibracion) {
		this.fechaProxCalibracion = fechaProxCalibracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Long getIdTipoMotivo() {
		return idTipoMotivo;
	}
	
	public void setIdTipoMotivo(Long idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	 	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoCertificado != null ? idEquipoCertificado.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEmpresaAcreditada)) {
            return false;
        }
        PghEquipoCertificado other = (PghEquipoCertificado) object;
        if ((this.idEquipoCertificado == null && other.idEquipoCertificado != null) || (this.idEquipoCertificado != null && !this.idEquipoCertificado.equals(other.idEquipoCertificado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEquipoCertificado[ idEquipoCertificado=" + idEquipoCertificado + " ]";
    }
}
