package gob.osinergmin.sibad.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_PRODUCTO_X_COMPARTIMIENTO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghProductoxCompartimiento.findById", query = "SELECT s FROM PghProductoxCompartimientoV s WHERE s.idCompartimiento=:idCompartimiento "),
    @NamedQuery(name = "PghProductoxCompartimientoV.findByFilter", query = "SELECT s FROM PghProductoxCompartimientoV s WHERE s.idResultadoRevision =:idResultadoRevision")	
})
public class PghProductoxCompartimientoV {
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_COMPARTIMIENTO")
	private Long idCompartimiento;
	
	@Column(name = "ID_RESULTADO_REVISION")
	private Long idResultadoRevision;
	
	@Column(name = "ID_PROGRAMACION")
	private Long idProgramacion;
	
	@Column(name = "ID_ALMACENAMIENTO")
	private Long idAlmacenamiento;
	
	@Column(name = "ID_UNID_MEDI_COMPARTIMIENTO")
	private Long idUnidMediCompartimiento;
	
	@Column(name = "CAPACIDAD")
	private Long capacidad;
	
	@Column(name = "NUMERO")
	private Long numero;
	
	public PghProductoxCompartimientoV() {
		// TODO Auto-generated constructor stub
	}
	
	public PghProductoxCompartimientoV(Long idCompartimiento, Long idResultadoRevision, Long idProgramacion, 
									   Long idAlmacenamiento, Long idUnidMediCompartimiento, Long capacidad, 
									   Long numero) {
		this.idCompartimiento = idCompartimiento;
		this.idResultadoRevision = idResultadoRevision;
		this.idProgramacion = idProgramacion;
		this.idAlmacenamiento = idAlmacenamiento;
		this.idUnidMediCompartimiento = idUnidMediCompartimiento;
		this.capacidad = capacidad;
		this.numero = numero;		
	}
	
	public Long getIdResultadoRevision() {
		return idResultadoRevision;
	}
	public void setIdResultadoRevision(Long idResultadoRevision) {
		this.idResultadoRevision = idResultadoRevision;
	}
	
	public Long getIdCompartimiento() {
		return idCompartimiento;
	}
	
	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}
	
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}
	
	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	public Long getIdUnidMediCompartimiento() {
		return idUnidMediCompartimiento;
	}
	public void setIdUnidMediCompartimiento(Long idUnidMediCompartimiento) {
		this.idUnidMediCompartimiento = idUnidMediCompartimiento;
	}
	
	public Long getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
}
