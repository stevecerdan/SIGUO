package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the SIBAD_DPNDNCIAS database table.
 * 
 */
@Entity
@Table(name="SIBAD_DPNDNCIAS")
public class SibadDpndncia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	@Column(name="ESTDO")
	private String estdo;
	
	@Column(name="NMBRE")
	private String nmbre;

	public SibadDpndncia() {
	}
	
	public SibadDpndncia(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstdo() {
		return this.estdo;
	}

	public void setEstdo(String estdo) {
		this.estdo = estdo;
	}

	public String getNmbre() {
		return this.nmbre;
	}

	public void setNmbre(String nmbre) {
		this.nmbre = nmbre;
	}

//	public List<SibadSlctudEstdoCnta> getSibadSlctudEstdoCntas() {
//		return this.sibadSlctudEstdoCntas;
//	}
//
//	public void setSibadSlctudEstdoCntas(List<SibadSlctudEstdoCnta> sibadSlctudEstdoCntas) {
//		this.sibadSlctudEstdoCntas = sibadSlctudEstdoCntas;
//	}
//
//	
//	public SibadSlctudEstdoCnta addSibadSlctudEstdoCntas(SibadSlctudEstdoCnta sibadSlctudEstdoCntas) {
//		getSibadSlctudEstdoCntas().add(sibadSlctudEstdoCntas);
//		sibadSlctudEstdoCntas.setSibadDpndncia(this);
//
//		return sibadSlctudEstdoCntas;
//	}
//
//	public SibadSlctudEstdoCnta removeSibadSlctudEstdoCntas(SibadSlctudEstdoCnta sibadSlctudEstdoCntas) {
//		getSibadSlctudEstdoCntas().remove(sibadSlctudEstdoCntas);
//		sibadSlctudEstdoCntas.setSibadDpndncia(null);
//
//		return sibadSlctudEstdoCntas;
//	}
}