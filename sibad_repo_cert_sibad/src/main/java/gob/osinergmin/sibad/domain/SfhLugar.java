/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DSR
 */
@Entity
@Table(name = "LUGARES")
public class SfhLugar implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "IDLUGAR")
    private Long idLugar;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "LUGAR_SUP")
    private String lugarSup;
    
    
    
//    public SfhLugar(Long idLugar) {
////		super();
//		this.idLugar = idLugar;
//	}

	public Long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLugarSup() {
        return lugarSup;
    }

    public void setLugarSup(String lugarSup) {
        this.lugarSup = lugarSup;
    }
}
