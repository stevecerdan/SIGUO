/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.DestinatarioCorreoDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import gob.osinergmin.sibad.service.DestinatarioCorreoService;
import gob.osinergmin.sibad.service.dao.DestinatarioCorreoDAO;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jpiro
 */
@Service("destinatariocorreoService")
public class DestinatarioCorreoServiceImpl implements DestinatarioCorreoService{
    private static final Logger LOG = LoggerFactory.getLogger(DestinatarioCorreoServiceImpl.class);
    
    @Inject
    DestinatarioCorreoDAO destinatariocorreoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<DestinatarioCorreoDTO> listarDestinatarioCorreo (DestinatarioCorreoFilter filtro){
        List<DestinatarioCorreoDTO> retorno=null;
        try{
            retorno = destinatariocorreoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarDestinatarioCorreo",ex);
        }
        return retorno;
    }
}
