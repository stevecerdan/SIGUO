/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MDI_UBIGEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiUbigeoDPD.findByFilterDPTO", query = "SELECT u FROM MdiUbigeoDPD u WHERE upper(u.idProvincia) like:idProvincia and upper (u.idDistrito) like:idDistrito"),
    @NamedQuery(name = "MdiUbigeoDPD.findByFilterPROV", query = "SELECT u FROM MdiUbigeoDPD u WHERE upper(u.idDepartamento) like:idDepartamento and upper(u.idProvincia) != '00' and upper (u.idDistrito) like:idDistrito"),
    @NamedQuery(name = "MdiUbigeoDPD.findByFilterDIST", query = "SELECT u FROM MdiUbigeoDPD u WHERE upper(u.idDepartamento) like:idDepartamento and upper(u.idProvincia) like:idProvincia and upper (u.idDistrito) != '00'")
    
})
public class MdiUbigeoDPD implements Serializable{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEPARTAMENTO")
    private String idDepartamento;
    @Size(max = 2)
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVINCIA")
    private String idProvincia;
    @Size(max = 2)
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DISTRITO")
    private String idDistrito;
    @Size(max = 2)
    
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    
    
    
    public MdiUbigeoDPD() {
    }

    public MdiUbigeoDPD(String idDepartamento, String idProvincia,String idDistrito, String nombre) {
        this.idDepartamento = idDepartamento;
        this.idProvincia = idProvincia;
        this.idDistrito = idDistrito;
        this.nombre = nombre;
    }
    
    public MdiUbigeoDPD(String idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }
    
    /*public MdiUbigeoDPD(Long idDepartamento, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idDepartamento = idPersonaJuridica;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }*/

	public String getNombre() {
		return nombre;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        hash += (idDistrito != null ? idDistrito.hashCode() : 0);
        return hash;
    }

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiUbigeoDPD)) {
            return false;
        }
        MdiUbigeoDPD other = (MdiUbigeoDPD) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        if ((this.idDistrito == null && other.idDistrito != null) || (this.idDistrito != null && !this.idDistrito.equals(other.idDistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.sibad.domain.MdiUbigeoDPD[ idDepartamento=" + idDepartamento + ", idProvincia=" + idProvincia + ", idDistrito=" + idDistrito + " ]";
    }
    
}
