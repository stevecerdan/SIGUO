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
@Table(name = "VIEW_ALMACENA_COMPARTI_PROD")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghAlmacenaCompartiProdV.findByAlmComPro", query = "SELECT a FROM PghAlmacenaCompartiProdV a WHERE a.idUnidSupervTanque = :idUnidSupervTanque"),
	@NamedQuery(name = "PghAlmacenaCompartiProdV.findByACPFilter", query = "SELECT a FROM PghAlmacenaCompartiProdV a WHERE a.idCompartimiento = :idCompartimiento"),
	@NamedQuery(name = "PghAlmacenaCompartiProdV.findByIdAlmacenamiento", query = "SELECT a FROM PghAlmacenaCompartiProdV a WHERE a.idAlmacenamiento = :idAlmacenamiento")
})

public class PghAlmacenaCompartiProdV{
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO_X_COMPARTIMIENTO")
    private Long idProductoXCompartimiento;
    @Size(max = 10)
    
    @Column(name = "ID_UNIDAD_SUPERVISADA")
    private Long idUnidSupervTanque;
    @Size(max = 10)
    
    @Column(name = "ID_ALMACENAMIENTO")
    private Long idAlmacenamiento;
    @Size(max = 10)
    
    @Column(name = "NUMERO_TANQUE")
    private String numeroTanque;
    @Size(max = 50)
    
    @Column(name = "ID_COMPARTIMIENTO")
    private Long idCompartimiento;
    @Size(max = 10)
    
    @Column(name = "NUMERO_COMPARTIMIENTO")
    private Long numeroCompartimiento;
    @Size(max = 38)
    
    @Column(name = "CAPACIDAD")
    private Long capacidad;
    
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;
    @Size(max = 10)
    
    @Column(name = "NOMBRE_LARGO")
    private String nombreLargoProducto;
    @Size(max = 200)
    
    @Column(name = "F_PROX_PRUEB_HERMETICIDAD")
    private Date fechaProxPrueba;
    
    @Column(name = "ID_UNIDAD_MEDIDA")
    private Long idUnidadMedida;
    @Size(max = 10)
    
    @Column(name = "DESCRIPCION")
    private String descripcionMedida;
    @Size(max = 35)
    
    @Column(name = "ABREVIATURA")
    private String abreviaturaMedida;
    @Size(max = 15)
    
    @Column(name = "NUMERO")
    private String numero;
    
    public PghAlmacenaCompartiProdV() {
    }
    
    public PghAlmacenaCompartiProdV(Long idProductoXCompartimiento) {
        this.idProductoXCompartimiento = idProductoXCompartimiento;
    }
    
	public Long getIdProductoXCompartimiento() {
		return idProductoXCompartimiento;
	}

	public void setIdProductoXCompartimiento(Long idProductoXCompartimiento) {
		this.idProductoXCompartimiento = idProductoXCompartimiento;
	}
	
	public Long getIdUnidSupervTanque() {
		return idUnidSupervTanque;
	}

	public void setIdUnidSupervTanque(Long idUnidSupervTanque) {
		this.idUnidSupervTanque = idUnidSupervTanque;
	}

	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	public String getNumeroTanque() {
		return numeroTanque;
	}

	public void setNumeroTanque(String numeroTanque) {
		this.numeroTanque = numeroTanque;
	}

	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}

	public Long getNumeroCompartimiento() {
		return numeroCompartimiento;
	}

	public void setNumeroCompartimiento(Long numeroCompartimiento) {
		this.numeroCompartimiento = numeroCompartimiento;
	}

	public Long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreLargoProducto() {
		return nombreLargoProducto;
	}

	public void setNombreLargoProducto(String nombreLargoProducto) {
		this.nombreLargoProducto = nombreLargoProducto;
	}

	public Date getFechaProxPrueba() {
		return fechaProxPrueba;
	}

	public void setFechaProxPrueba(Date fechaProxPrueba) {
		this.fechaProxPrueba = fechaProxPrueba;
	}

	public Long getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getDescripcionMedida() {
		return descripcionMedida;
	}

	public void setDescripcionMedida(String descripcionMedida) {
		this.descripcionMedida = descripcionMedida;
	}

	public String getAbreviaturaMedida() {
		return abreviaturaMedida;
	}

	public void setAbreviaturaMedida(String abreviaturaMedida) {
		this.abreviaturaMedida = abreviaturaMedida;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoXCompartimiento != null ? idProductoXCompartimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghAlmacenaCompartiProdV)) {
            return false;
        }
        PghAlmacenaCompartiProdV other = (PghAlmacenaCompartiProdV) object;
        if ((this.idProductoXCompartimiento == null && other.idProductoXCompartimiento != null) || (this.idProductoXCompartimiento != null && !this.idProductoXCompartimiento.equals(other.idProductoXCompartimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghAlmacenaCompartiProdV[ idProductoXCompartimiento=" + idProductoXCompartimiento + " ]";
    }
}
