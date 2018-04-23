package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the SIBAD_ACTIVI_DPNDNCIA database table.
 * 
 */
@Entity
@Table(name="SIBAD_ACTIVI_DPNDNCIA")
public class SibadActiviDpndncia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DPNDNCIA_ID")
	private long dpndnciaId;
	
	@Column(name="CDO_ACTVDAD")
	private String cdoActvdad;

	
	private String estdo;

	public SibadActiviDpndncia() {
	}

	public String getCdoActvdad() {
		return this.cdoActvdad;
	}

	public void setCdoActvdad(String cdoActvdad) {
		this.cdoActvdad = cdoActvdad;
	}

	public long getDpndnciaId() {
		return this.dpndnciaId;
	}

	public void setDpndnciaId(long dpndnciaId) {
		this.dpndnciaId = dpndnciaId;
	}

	public String getEstdo() {
		return this.estdo;
	}

	public void setEstdo(String estdo) {
		this.estdo = estdo;
	}

}