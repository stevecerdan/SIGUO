package gob.osinergmin.sibad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_PERS_AUTOR_X_TIPO_PRUEBA")
@NamedQueries({
    @NamedQuery(name = "PersonalAutorizadoPorTipoPruebaV.findIdEmpAcreditada", query = "SELECT p FROM PersonalAutorizadoPorTipoPruebaV p WHERE p.idEmpresaAcreditada = :idEmpresaAcreditada and p.idTipoPrueba = :idTipoPrueba and p.estadoAlcance = 'A' and p.flagSedePersonalAutoriazado = :flagSedePersonalAutoriazado"),
})

public class PersonalAutorizadoPorTipoPruebaV {

	@Id
    @Column(name = "ID_SEDE_PERSONAL_AUTORIZADO ")
    private Long idSedePersonalAutorizado;
	
    @Column(name = "ID_TIPO_PRUEBA ")
    private String idTipoPrueba;   
    
    @Column(name = "ESTADO_ALCANCE ")
    private String estadoAlcance;  
    
    @Column(name = "FLAG_SEDE_PERSONAL_AUTORIZADO  ")
    private String flagSedePersonalAutoriazado;  
   
    @Column(name = "ID_EMPRESA_ACREDITADA ")
    private Long idEmpresaAcreditada;
    
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

	public PersonalAutorizadoPorTipoPruebaV() {
		
	}

	public PersonalAutorizadoPorTipoPruebaV(Long idEmpresaAcreditada, String idTipoPrueba, String estadoAlcance,
			String flagSedePersonalAutoriazado, Long idSedePersonalAutorizado, String nombreCompleto) {
	
		this.idEmpresaAcreditada = idEmpresaAcreditada;
		this.idTipoPrueba = idTipoPrueba;
		this.estadoAlcance = estadoAlcance;
		this.flagSedePersonalAutoriazado = flagSedePersonalAutoriazado;
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
		this.nombreCompleto = nombreCompleto;
	}

	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}

	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}

	public String getIdTipoPrueba() {
		return idTipoPrueba;
	}

	public void setIdTipoPrueba(String idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}

	public String getFlagSedePersonalAutoriazado() {
		return flagSedePersonalAutoriazado;
	}

	public void setFlagSedePersonalAutoriazado(String flagSedePersonalAutoriazado) {
		this.flagSedePersonalAutoriazado = flagSedePersonalAutoriazado;
	}

	public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}

	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	} 
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedePersonalAutorizado != null ? idSedePersonalAutorizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PersonalAutorizadoPorTipoPruebaV)) {
            return false;
        }
        PersonalAutorizadoPorTipoPruebaV other = (PersonalAutorizadoPorTipoPruebaV) object;
        if ((this.idSedePersonalAutorizado == null && other.idSedePersonalAutorizado != null) || (this.idSedePersonalAutorizado != null && !this.idSedePersonalAutorizado.equals(other.idSedePersonalAutorizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinerg.sibad.domain.PersonalAutorizadoPorTipoPruebaV[ idSedePersonalAutorizado=" + idSedePersonalAutorizado + " ]";
    }
    
	
    
}
