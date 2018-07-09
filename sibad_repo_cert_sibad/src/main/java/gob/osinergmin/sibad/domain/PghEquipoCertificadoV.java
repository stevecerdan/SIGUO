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

/*
 * @author jpiro
 */

@Entity
@Table(name = "VIEW_EQUIPO_CERTIFICADO")
@XmlRootElement
@NamedQueries({
	
    @NamedQuery(name = "PghEquipoCertificadoV.findByEquipo", query = "SELECT eq FROM PghEquipoCertificadoV eq WHERE eq.idEquipoCertificado = :idEquipoCertificado"),
    @NamedQuery(name = "PghEquipoCertificadoV.findByFilterA", query = "SELECT eq FROM PghEquipoCertificadoV eq WHERE eq.idAlcanceAcreditacion = :idAlcanceAcreditacion"),
    @NamedQuery(name = "PghEquipoCertificadoV.findByFechaPC", query ="SELECT eq FROM PghEquipoCertificadoV eq WHERE TO_DATE(eq.fechaProximaCalibracion,'DD/MM/YY') <= :fechaProximaCalibracion"),
    @NamedQuery(name = "PghEquipoCertificadoV.findBycbxResultadoEquipo", query = "SELECT eq FROM PghEquipoCertificadoV eq WHERE eq.idEmpresaAcreditada = :idEmpresaAcreditada and"+
																														    " eq.idTipoEquipo = :idTipoEquipo and" +
																															" eq.idTipoPrueba = '1467' and" +
																															" eq.estado = 'A' and" +
																															" (upper(eq.estadoAlcance) = 'A' or" + 
																															" upper(eq.estadoAlcance) = 'S')")
   
})

public class PghEquipoCertificadoV extends Auditoria{
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EQUIPO_CERTIFICADO")
    private Long idEquipoCertificado;
    
    @Column(name = "ID_ALCANCE_ACREDITACION")
    private Long idAlcanceAcreditacion;
    
    @Column(name = "ID_EMPRESA_ACREDITADA")
    private Long idEmpresaAcreditada;
    
    @Column(name = "ID_TIPO_PRUEBA")
    private Long idTipoPrueba;
        
    @Column(name = "ESTADO_ALCANCE")
    private String estadoAlcance;
    
    @Column(name = "ID_TIPO_EQUIPO")
    private Long idTipoEquipo;
    
    @Column(name = "TIPO_EQUIPO")
    private String tipoEquipo;
    @Size(max = 200)
    
    @Column(name = "DESCRIPCION")
    private String descripcionEquipo;
    @Size(max = 128)
    
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 36)
    
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 36)
    
    @Column(name = "SERIE")
    private String serie;
    @Size(max = 128)
    
    @Column(name = "OTRO_DATO_ADICIONAL")
    private String otroDato;
    @Size(max = 128)
    
    @Column(name = "FECHA_CALIBRACION")
    private Date fechaCalibracion;
    
    @Column(name = "FECHA_PROXIMA_CALIBRACION")
    private Date fechaProximaCalibracion;
    
    @Column(name = "ESTADO_EQUIPO")
    private String estado;
    @Size(max = 1)
    
    @Column(name = "ID_TIPO_MOTIVO")
	 private Long idTipoMotivo;
	 
    @Column(name = "OBSERVACION")
	 private String observacion;
    
    
    public PghEquipoCertificadoV() {
    }

    public PghEquipoCertificadoV(Long idEquipoCertificado) {
        this.idEquipoCertificado = idEquipoCertificado;
    }
    
    public PghEquipoCertificadoV(Long idEquipoCertificado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idEquipoCertificado = idEquipoCertificado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

	public Long getIdEquipoCertificado() {
		return idEquipoCertificado;
	}

	public void setIdEquipoCertificado(Long idEquipoCertificado) {
		this.idEquipoCertificado = idEquipoCertificado;
	}
	
	public Long getIdAlcanceAcreditacion() {
		return idAlcanceAcreditacion;
	}

	public void setIdAlcanceAcreditacion(Long idAlcanceAcreditacion) {
		this.idAlcanceAcreditacion = idAlcanceAcreditacion;
	}
	
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}

	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}

	public String getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public String getDescripcionEquipo() {
		return descripcionEquipo;
	}

	public void setDescripcionEquipo(String descripcionEquipo) {
		this.descripcionEquipo = descripcionEquipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getOtroDato() {
		return otroDato;
	}

	public void setOtroDato(String otroDato) {
		this.otroDato = otroDato;
	}

	public Date getFechaCalibracion() {
		return fechaCalibracion;
	}

	public void setFechaCalibracion(Date fechaCalibracion) {
		this.fechaCalibracion = fechaCalibracion;
	}

	public Date getFechaProximaCalibracion() {
		return fechaProximaCalibracion;
	}

	public void setFechaProximaCalibracion(Date fechaProximaCalibracion) {
		this.fechaProximaCalibracion = fechaProximaCalibracion;
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
	
	//-------------

	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public Long getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(Long idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
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
        if (!(object instanceof PghEquipoCertificadoV)) {
            return false;
        }
        PghEquipoCertificadoV other = (PghEquipoCertificadoV) object;
        if ((this.idEquipoCertificado == null && other.idEquipoCertificado != null) || (this.idEquipoCertificado != null && !this.idEquipoCertificado.equals(other.idEquipoCertificado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEquipoCertificadoV[ idEquipoCertificado=" + idEquipoCertificado + " ]";
    }
    
}
