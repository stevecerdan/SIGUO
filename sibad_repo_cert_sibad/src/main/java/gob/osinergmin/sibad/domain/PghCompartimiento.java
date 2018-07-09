package gob.osinergmin.sibad.domain;





import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PGH_COMPARTIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCompartimiento.findByIdAlmacenamiento", query = "SELECT t FROM PghCompartimiento t WHERE t.idAlmacenamiento = :idAlmacenamiento"),
    @NamedQuery(name = "PghCompartimiento.findByIdCompartimiento", query = "SELECT t FROM PghCompartimiento t WHERE t.idCompartimiento = :idCompartimiento"),
})
public class PghCompartimiento extends Auditoria{

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_COMPARTIMIENTO_SEQ1", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_COMPARTIMIENTO")
	 private Long idCompartimiento;
	 
	 @Basic(optional = false)
	 @Column(name = "ESTADO")
	 private String estado;
	  
	 @Column(name = "NUMERO")
	 private Long numero; 
	 
	 @Column(name = "ID_ALMACENAMIENTO")
	 private Long idAlmacenamiento; 
	
	 @Column(name = "CAPACIDAD")
	 private Long capacidad;
	 
	 @Column(name = "FECHA_PROXIMA_PRUEBA") 
	 private Date fechaProximaPrueba;
	 
	public PghCompartimiento() {
		
	}
	
	public PghCompartimiento(Long idCompartimiento) {

		this.idCompartimiento = idCompartimiento;
	}

	public PghCompartimiento(Long idCompartimiento, String estado, Long numero, Long idAlmacenamiento, Long capacidad,
			Date fechaProximaPrueba) {
		
		this.idCompartimiento = idCompartimiento;
		this.estado = estado;
		this.numero = numero;
		this.idAlmacenamiento = idAlmacenamiento;
		this.capacidad = capacidad;
		this.fechaProximaPrueba = fechaProximaPrueba;
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

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}
	 
	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	
	public Date getFechaProximaPrueba() {
		return fechaProximaPrueba;
	}

	public void setFechaProximaPrueba(Date fechaProximaPrueba) {
		this.fechaProximaPrueba = fechaProximaPrueba;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompartimiento != null ? idCompartimiento.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCompartimiento)) {
            return false;
        }
        PghCompartimiento other = (PghCompartimiento) object;
        if ((this.idCompartimiento == null && other.idCompartimiento != null) || (this.idCompartimiento != null && !this.idCompartimiento.equals(other.idCompartimiento))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghCompartimiento[ idCompartimiento=" + idCompartimiento + "]";
    }
	  
	 		
}
