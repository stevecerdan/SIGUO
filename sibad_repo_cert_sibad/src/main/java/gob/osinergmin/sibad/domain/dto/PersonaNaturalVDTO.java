/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

/**
 *
 * @author jpiro
 */
public class PersonaNaturalVDTO {
	private Long idPersonaNatural;
	private Long idTipoDocumento;
    private String numeroDoc;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
    private Long cip;
    private String telefono;
    
	public Long getIdPersonaNatural() {
		return idPersonaNatural;
	}
	public void setIdPersonaNatural(Long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCip() {
		return cip;
	}
	public void setCip(Long cip) {
		this.cip = cip;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
}
