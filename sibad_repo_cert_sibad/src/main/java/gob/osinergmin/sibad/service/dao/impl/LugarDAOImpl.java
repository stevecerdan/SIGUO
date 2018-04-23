/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.SfhLugar;
import gob.osinergmin.sibad.domain.builder.LugarBuilder;
import gob.osinergmin.sibad.domain.dto.LugarDTO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.LugarDAO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("LugarDAO")
public class LugarDAOImpl implements LugarDAO {

    private static final Logger LOG = LoggerFactory.getLogger(LugarDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public List<LugarDTO> obtenerDepartamentos() {
        LOG.info("procesando LugarDAO/obtenerDepartamentos");
        List<LugarDTO> listaLugarDTO = new ArrayList<LugarDTO>();
        try {
            String sql = "select l from SfhLugar l where l.tipo = 2 order by l.nombre";
            Query query = this.crud.getEm().createQuery(sql);
            List<SfhLugar> listaLugares = query.getResultList();
            listaLugarDTO = LugarBuilder.obtenerListaLugarDTO(listaLugares);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - LugarDAO/obtenerDepartamentos ==>" + e.getMessage());
        }
        return listaLugarDTO;
    }
    
    @Override
    public List<LugarDTO> obtenerProvincias(String idDepartamento) {
        LOG.info("procesando LugarDAO/obtenerProvincias");
        List<LugarDTO> listaLugarDTO = new ArrayList<LugarDTO>();
        try {
            String sql = "select l from SfhLugar l where l.tipo = 3 and "
                    + " l.lugarSup = '"+idDepartamento
                    + "' order by l.nombre";
            Query query = this.crud.getEm().createQuery(sql);
            List<SfhLugar> listaLugares = query.getResultList();
            listaLugarDTO = LugarBuilder.obtenerListaLugarDTO(listaLugares);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - LugarDAO/obtenerProvincias ==>" + e.getMessage());
        }
        return listaLugarDTO;
    }
    
    @Override
    public List<LugarDTO> obtenerDistritos(String idProvincia) {
        LOG.info("procesando LugarDAO/obtenerDistritos");
        List<LugarDTO> listaLugarDTO = new ArrayList<LugarDTO>();
        try {
            String sql = "select l from SfhLugar l where l.tipo = 4 and "
                    + " l.lugarSup = '"+idProvincia
                    + "' order by l.nombre";
            Query query = this.crud.getEm().createQuery(sql);
            List<SfhLugar> listaLugares = query.getResultList();
            listaLugarDTO = LugarBuilder.obtenerListaLugarDTO(listaLugares);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - LugarDAO/obtenerDistritos ==>" + e.getMessage());
        }
        return listaLugarDTO;
    }
    
    @Override
    public LugarDTO obtenerLugar(Long idLugar) {
        LOG.info("procesando LugarDAO/obtenerLugar");
        LugarDTO lugarDTO = new LugarDTO();
        try {
            SfhLugar lugar = this.crud.find(idLugar, SfhLugar.class);
            lugarDTO = LugarBuilder.obtenerLugarDTO(lugar);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - LugarDAO/obtenerLugar ==>" + e.getMessage());
        }
        return lugarDTO;
    }
}
