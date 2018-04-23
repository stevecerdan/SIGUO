/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;

/**
 *
 * @author DSR
 */
public class TablaDetalleDTO implements Serializable {

    private Long idTablaDetalle;
    private String nombreCorto;
    private String nombreLargo;
    private short estado;
    private String codigo;

    public Long getIdTablaDetalle() {
        return idTablaDetalle;
    }

    public void setIdTablaDetalle(Long idTablaDetalle) {
        this.idTablaDetalle = idTablaDetalle;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
