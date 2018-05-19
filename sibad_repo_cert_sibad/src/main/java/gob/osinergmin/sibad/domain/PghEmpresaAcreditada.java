package gob.osinergmin.sibad.domain;

import java.sql.Date;

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
@Table(name = "PGH_EMPRESA_ACREDITADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghEmpresaAcreditada.findByEA", query = "SELECT e FROM PghEmpresaAcreditada e WHERE e.idEmpresaAcreditada = :idEmpresaAcreditada"),
    @NamedQuery(name = "PghEmpresaAcreditada.findByFilterPJ", query = "SELECT e FROM PghEmpresaAcreditada e WHERE e.idPersonaJuridica like :idPersonaJuridica")

})

public class PghEmpresaAcreditada  extends Auditoria{
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Basic(optional = false)
	 @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_EMPRESA_ACREDITADA_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	 @Column(name = "ID_EMPRESA_ACREDITADA")
	 private Long idEmpresaAcreditada;
	  
	 @Column(name = "ID_PERSONA_JURIDICA")
	 private Long idPersonaJuridica; 
	 
	 @Basic(optional = false)
	 @Column(name = "ESTADO")
	 private String estado;

	public PghEmpresaAcreditada() {
		super();
	}

	public PghEmpresaAcreditada(Long idEmpresaAcreditada, Long idPersonaJuridica, String estado) {
		super();
		this.idEmpresaAcreditada = idEmpresaAcreditada;
		this.idPersonaJuridica = idPersonaJuridica;
		this.estado = estado;
	}

	public PghEmpresaAcreditada(Long idEmpresaAcreditada, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
		super();
		this.idEmpresaAcreditada = idEmpresaAcreditada;
		this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
	}

	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public Long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}

	public void setIdPersonaJuridica(Long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
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
        hash += (idEmpresaAcreditada != null ? idEmpresaAcreditada.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEmpresaAcreditada)) {
            return false;
        }
        PghEmpresaAcreditada other = (PghEmpresaAcreditada) object;
        if ((this.idEmpresaAcreditada == null && other.idEmpresaAcreditada != null) || (this.idEmpresaAcreditada != null && !this.idEmpresaAcreditada.equals(other.idEmpresaAcreditada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.PghEmpresaAcreditada[ idEmpresaAcreditada=" + idEmpresaAcreditada + " ]";
    }
}
