/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.TipoPruebaOrganismoDTO;
import gob.osinergmin.sibad.filter.TipoPruebaOrganismoFilter;
import gob.osinergmin.sibad.service.TipoPruebaOrganismoService;
import gob.osinergmin.sibad.service.dao.TipoPruebaOrganismoDAO;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("tipopruebaorganismoService")
public class TipoPruebaOrganismoServiceImpl implements TipoPruebaOrganismoService{
    private static final Logger LOG = LoggerFactory.getLogger(TipoPruebaOrganismoServiceImpl.class);
    
    @Inject
    TipoPruebaOrganismoDAO tipopruebaorganismoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoPruebaOrganismoDTO> listarTipoPruebaOrganismo (TipoPruebaOrganismoFilter filtro){
        List<TipoPruebaOrganismoDTO> retorno=null;
        try{
            retorno = tipopruebaorganismoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarTipoPruebaOrganismo",ex);
        }
        return retorno;
    }
}
