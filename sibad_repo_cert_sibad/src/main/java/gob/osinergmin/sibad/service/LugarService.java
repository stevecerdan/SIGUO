/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.LugarDTO;

import java.util.List;

public interface LugarService {

    public List<LugarDTO> obtenerDepartamentos();
    public List<LugarDTO> obtenerProvincias(String idDepartamento);
    public List<LugarDTO> obtenerDistritos(String idProvincia);
    public LugarDTO obtenerLugar(Long idLugar);
}
