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


@Entity
@Table(name="SIBAD_NOTA")
@NamedQueries({
    @NamedQuery(name = "SibadNota.findByid", query = "SELECT m FROM SibadNota m WHERE m.id = :id")})

public class SibadNota implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "ID")
	private long id;
	
   	@Column(name="ESTDO")
	private String estdo;

	@Column(name="DTLLE")
	private String detalle;

	@Column(name="FCHA_CRCION")
	private Date fchaCrcion;

	@Column(name="USRIO_CRDOR")
	private String usrCrdor;

	
	
	
	public SibadNota() {
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getEstdo() {
		return estdo;
	}




	public void setEstdo(String estdo) {
		this.estdo = estdo;
	}




	public String getDetalle() {
		return detalle;
	}




	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}




	public Date getFchaCrcion() {
		return fchaCrcion;
	}




	public void setFchaCrcion(Date fchaCrcion) {
		this.fchaCrcion = fchaCrcion;
	}




	public String getUsrCrdor() {
		return usrCrdor;
	}




	public void setUsrCrdor(String usrCrdor) {
		this.usrCrdor = usrCrdor;
	}
	
	

	
}
