/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.SfhLugar;
import gob.osinergmin.sibad.domain.dto.LugarDTO;

import java.util.ArrayList;
import java.util.List;

public class LugarBuilder {

    public static LugarDTO obtenerLugarDTO(SfhLugar lugar) {
        LugarDTO lugarDTO = new LugarDTO();
        lugarDTO.setIdLugar(lugar.getIdLugar());
        lugarDTO.setLugarSup(lugar.getLugarSup());
        lugarDTO.setNombre(lugar.getNombre());
        lugarDTO.setTipo(lugar.getTipo());
        return lugarDTO;
    }

    public static List<LugarDTO> obtenerListaLugarDTO(List<SfhLugar> listaLugar) {
        LugarDTO lugarDTO;
        List<LugarDTO> listaLugarDTO = new ArrayList<LugarDTO>();
        if (listaLugar != null) {
            for (SfhLugar lugar : listaLugar) {
                lugarDTO = obtenerLugarDTO(lugar);
                listaLugarDTO.add(lugarDTO);
            }
        }
        return listaLugarDTO;
    }
}
