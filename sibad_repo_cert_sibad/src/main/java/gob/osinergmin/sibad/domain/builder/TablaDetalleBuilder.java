/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.SibadTablaDetalle;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DSR
 */
public class TablaDetalleBuilder {

    public static TablaDetalleDTO obtenerTablaDetalleDTO(SibadTablaDetalle tablaDetalle) {
        TablaDetalleDTO tablaDetalleDTO = new TablaDetalleDTO();
        tablaDetalleDTO.setIdTablaDetalle(tablaDetalle.getId());
        tablaDetalleDTO.setCodigo(tablaDetalle.getCodigo());
        tablaDetalleDTO.setNombreCorto(tablaDetalle.getNombreCorto());
        tablaDetalleDTO.setNombreLargo(tablaDetalle.getNombre());
        return tablaDetalleDTO;
    }

    public static List<TablaDetalleDTO> obtenerListaTablaDetalleDTO(List<SibadTablaDetalle> listaTablaDetalle) {
        TablaDetalleDTO tablaDetalleDTO;
        List<TablaDetalleDTO> listaTablaDetalleDTO = new ArrayList<TablaDetalleDTO>();
        if (listaTablaDetalle != null) {
            for (SibadTablaDetalle tablaDetalle : listaTablaDetalle) {
                tablaDetalleDTO = obtenerTablaDetalleDTO(tablaDetalle);
                listaTablaDetalleDTO.add(tablaDetalleDTO);
            }
        }
        return listaTablaDetalleDTO;
    }
}
