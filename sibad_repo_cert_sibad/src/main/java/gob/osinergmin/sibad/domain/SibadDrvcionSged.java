package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the SIBAD_DRVCION_SGED database table.
 * 
 */
@Entity
@Table(name="SIBAD_DRVCION_SGED")
public class SibadDrvcionSged implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private long estdo;

	@Column(name="ID_DPNDNCIA")
	private long idDpndncia;

	@Column(name="ID_UBIGEO")
	private String idUbigeo;

	@Column(name="USRIO_DSTNO")
	private long usrioDstno;

	public SibadDrvcionSged() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEstdo() {
		return this.estdo;
	}

	public void setEstdo(long estdo) {
		this.estdo = estdo;
	}

	public long getIdDpndncia() {
		return this.idDpndncia;
	}

	public void setIdDpndncia(long idDpndncia) {
		this.idDpndncia = idDpndncia;
	}

	public String getIdUbigeo() {
		return this.idUbigeo;
	}

	public void setIdUbigeo(String idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public long getUsrioDstno() {
		return this.usrioDstno;
	}

	public void setUsrioDstno(long usrioDstno) {
		this.usrioDstno = usrioDstno;
	}

}