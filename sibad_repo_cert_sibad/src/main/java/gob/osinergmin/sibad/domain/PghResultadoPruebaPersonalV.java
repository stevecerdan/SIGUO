package gob.osinergmin.sibad.domain;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_RESULTADO_PERS_AUTORIZADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghResultadoPruebaPersonalV.findByIdResultadoPRP", query = "SELECT r FROM PghResultadoPruebaPersonalV r WHERE r.idResultadoPruebaReprueba = :idResultadoPruebaReprueba")
                                                                                                                                             
})

public class PghResultadoPruebaPersonalV{
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_RESULTADO_PRUEBA_PERSONAL")
	private Long idResultadoPruebaPersonal;
	
	@Column(name = "ID_RESULTADO_PRUEBA_REPRUEBA")
	private Long idResultadoPruebaReprueba;
	
	@Column(name = "ID_SEDE_PERSONAL_AUTORIZADO")
	private Long idSedePersonalAutorizado;
	
	@Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Size(max = 200)
    
    @Column(name = "NUMERO_DOC_IDENTIDAD")
    private String numeroDocumento;
    @Size(max = 16)
    
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 64)
    
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Size(max = 32)
    
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 32)

	public PghResultadoPruebaPersonalV() {
		
	}
	
	public PghResultadoPruebaPersonalV(Long idResultadoPruebaPersonal) {
		
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
	}
	
	/*public PghResultadoPruebaPersonalV(Long idResultadoPruebaPersonal, Long idResultadoPruebaReprueba,
			Long idSedePersonalAutorizado) {
		
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}*/

	public Long getIdResultadoPruebaPersonal() {
		return idResultadoPruebaPersonal;
	}

	public void setIdResultadoPruebaPersonal(Long idResultadoPruebaPersonal) {
		this.idResultadoPruebaPersonal = idResultadoPruebaPersonal;
	}

	public Long getIdResultadoPruebaReprueba() {
		return idResultadoPruebaReprueba;
	}

	public void setIdResultadoPruebaReprueba(Long idResultadoPruebaReprueba) {
		this.idResultadoPruebaReprueba = idResultadoPruebaReprueba;
	}

	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}

	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
		
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoPruebaPersonal != null ? idResultadoPruebaPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghResultadoPruebaPersonalV)) {
            return false;
        }
        PghResultadoPruebaPersonalV other = (PghResultadoPruebaPersonalV) object;
        if ((this.idResultadoPruebaPersonal == null && other.idResultadoPruebaPersonal != null) || (this.idResultadoPruebaPersonal != null && !this.idResultadoPruebaPersonal.equals(other.idResultadoPruebaPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghResultadoPruebaPersonal[ idResultadoPruebaPersonal=" + idResultadoPruebaPersonal + " ]";
    }
	
}
