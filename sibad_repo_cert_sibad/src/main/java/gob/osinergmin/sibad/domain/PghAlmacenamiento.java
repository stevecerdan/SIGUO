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

@Entity
@Table(name = "PGH_ALMACENAMIENTO")
@NamedQueries({
    @NamedQuery(name = "PghAlmacenamiento.findByIdUnidadSupervisada", query = "SELECT t FROM PghAlmacenamiento t WHERE t.idUnidadSupervisada = :idUnidadSupervisada AND t.estado = '1' "), 
    @NamedQuery(name = "PghAlmacenamiento.findByIdAlmacenamiento", query = "SELECT t FROM PghAlmacenamiento t WHERE t.idAlmacenamiento = :idAlmacenamiento AND t.estado = '1' "),   

})

public class PghAlmacenamiento {

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_ALMACENAMIENTO_SEQ1", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_ALMACENAMIENTO")
	 private Long idAlmacenamiento;
	 
	 @Basic(optional = false)
	 @Column(name = "ESTADO")
	 private String estado;
	  
	 @Column(name = "NUMERO")
	 private Long numero; 
	 
	 @Column(name = "NUMERO_SERIE")
	 private String numeroSerie; 
	
	 @Basic(optional = false)
	 @Column(name = "ID_UNIDAD_SUPERVISADA")
	 private String idUnidadSupervisada;

	public PghAlmacenamiento() {
		
	}

	public PghAlmacenamiento(Long idAlmacenamiento) {
		
		this.idAlmacenamiento = idAlmacenamiento;
	}

	public PghAlmacenamiento(Long idAlmacenamiento, String estado, Long numero, String numeroSerie,
			String idUnidadSupervisada) {
		super();
		this.idAlmacenamiento = idAlmacenamiento;
		this.estado = estado;
		this.numero = numero;
		this.numeroSerie = numeroSerie;
		this.idUnidadSupervisada = idUnidadSupervisada;
	}

	public Long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	public String getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}

	public void setIdUnidadSupervisada(String idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
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
        hash += (idAlmacenamiento != null ? idAlmacenamiento.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghAlmacenamiento)) {
            return false;
        }
        PghAlmacenamiento other = (PghAlmacenamiento) object;
        if ((this.idAlmacenamiento == null && other.idAlmacenamiento != null) || (this.idAlmacenamiento != null && !this.idAlmacenamiento.equals(other.idAlmacenamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghAlmacenamiento[ idAlmacenamiento=" + idAlmacenamiento + " ]";
    }
	 
}
