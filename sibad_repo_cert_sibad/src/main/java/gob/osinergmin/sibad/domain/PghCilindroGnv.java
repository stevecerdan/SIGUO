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
@Table(name = "PGH_CILINDRO_GNV")
@NamedQueries({ 
    @NamedQuery(name = "PghCilindroGnv.findByidCilindro", query = "SELECT t FROM PghCilindroGnv t WHERE t.idCilindro = :idCilindro")   

})
public class PghCilindroGnv {	
	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_CILINDRO_GNV_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_CILINDRO_GNV")
	 private Long idCilindro;
	 
	
	 @Column(name = "ID_MODULO")
	 private Long idModulo;
	 
	 @Column(name = "ID_UNIDAD_SUPERVISADA")
	 private Long idUnidadSupervisada;
	 
	 @Column(name = "NUMERO")
	 private Long numero;
	 
	 @Column(name = "NUMERO_SERIE")
	 private String numeroSerie;
	 
	 @Column(name = "ESTADO")
	 private String estado;
	 
	 public String getEstado() {
		return estado;
	}
	 public void setEstado(String estado) {
		this.estado = estado;
	}
	 public Long getIdCilindro() {
		return idCilindro;
	}
	 public void setIdCilindro(Long idCilindro) {
		this.idCilindro = idCilindro;
	}
	 public Long getIdModulo() {
		return idModulo;
	}
	 public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	 public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	 public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
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
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCilindro != null ? idCilindro.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCilindroGnv)) {
            return false;
        }
        PghCilindroGnv other = (PghCilindroGnv) object;
        if ((this.idCilindro == null && other.idCilindro != null) || (this.idCilindro != null && !this.idCilindro.equals(other.idCilindro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghCilindroGnv[ idCilindro=" + idCilindro + " ]";
    }
}
