/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.LugarDTO;
import gob.osinergmin.sibad.service.LugarService;
import gob.osinergmin.sibad.service.dao.LugarDAO;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("LugarService")
public class LugarServiceImpl implements LugarService {

    private static final Logger LOG = LoggerFactory.getLogger(LugarServiceImpl.class);
    @Inject
    private LugarDAO lugarDAO;

    @Override
    public List<LugarDTO> obtenerDepartamentos() {
        LOG.info("procesando LugarService/obtenerDepartamentos");
        return lugarDAO.obtenerDepartamentos();
    }

    @Override
    public List<LugarDTO> obtenerProvincias(String idDepartamento) {
        LOG.info("procesando LugarService/obtenerProvincias");
        return lugarDAO.obtenerProvincias(idDepartamento);
    }

    @Override
    public List<LugarDTO> obtenerDistritos(String idProvincia) {
        LOG.info("procesando LugarService/obtenerDistritos");
        return lugarDAO.obtenerDistritos(idProvincia);
    }
    
    @Override
    public LugarDTO obtenerLugar(Long idLugar) {
        LOG.info("procesando LugarService/obtenerLugar");
        return lugarDAO.obtenerLugar(idLugar);
    }
    
}
