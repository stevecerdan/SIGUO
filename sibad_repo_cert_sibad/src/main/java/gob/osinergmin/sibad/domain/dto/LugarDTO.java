/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;


public class LugarDTO implements Serializable{
    
    private Long idLugar;
    private String nombre;
    private String tipo;
    private String lugarSup;

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
