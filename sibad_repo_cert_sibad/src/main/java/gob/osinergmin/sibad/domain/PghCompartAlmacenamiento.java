package gob.osinergmin.sibad.domain;

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
@Table(name = "VIEW_CMPTMTO_ALMACENAMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCompartAlmacenamiento.findBySerie", query = "SELECT t FROM PghCompartAlmacenamiento t WHERE t.numeroSerie = :numeroSerie and t.numero = :numero"),
    @NamedQuery(name = "PghCompartAlmacenamiento.findByUnidad", query = "SELECT t FROM PghCompartAlmacenamiento t WHERE t.idUnidadSupervisada = :idUnidadSupervisada")
})
public class PghCompartAlmacenamiento {
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDP")
   	private Long idp;
	
    @Column(name = "ID_ALMACENAMIENTO")
	private Long idAlmacenamiento;
	
	@Column(name = "ID_UNIDAD_SUPERVISADA")
	private Long idUnidadSupervisada;
	
	@Column(name = "NUMERO_SERIE")
	private String numeroSerie;
	
	@Column(name = "NUMERO_COMPARTIMIENTO")
	private String numero;
	
	@Column(name = "ID_COMPARTIMIENTO")
	private Long idCompartimiento;
	
	@Column(name = "CAPACIDAD")
	private Long capacidad;
	
	@Column(name = "NOMBRE_LARGO")
	private String nombreProd;
	
	@Column(name = "TANQUE")
	private String tanque;
	
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}
	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	public String getTanque() {
		return tanque;
	}
	public void setTanque(String tanque) {
		this.tanque = tanque;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}	
	public Long getIdp() {
		return idp;
	}
	public void setIdp(Long idp) {
		this.idp = idp;
	}
	public Long getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}
	public String getNombreProd() {
		return nombreProd;
	}
	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
