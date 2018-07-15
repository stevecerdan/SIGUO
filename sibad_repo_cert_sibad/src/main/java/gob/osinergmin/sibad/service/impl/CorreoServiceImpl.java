/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.CorreoDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import gob.osinergmin.sibad.service.CorreoService;
import gob.osinergmin.sibad.service.dao.CorreoDAO;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jpiro
 */
@Service("correoService")
public class CorreoServiceImpl implements CorreoService{
    private static final Logger LOG = LoggerFactory.getLogger(CorreoServiceImpl.class);
    
    @Inject
    CorreoDAO correoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<CorreoDTO> listarCorreo (DestinatarioCorreoFilter filtro){
        List<CorreoDTO> retorno=null;
        try{
            retorno = correoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarCorreo",ex);
        }
        return retorno;
    }
}
