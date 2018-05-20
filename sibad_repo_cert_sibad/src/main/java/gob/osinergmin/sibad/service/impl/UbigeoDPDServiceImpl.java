/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;
import gob.osinergmin.sibad.filter.UbigeoDPDFilter;
import gob.osinergmin.sibad.service.UbigeoDPDService;
import gob.osinergmin.sibad.service.dao.UbigeodpdDAO;

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
@Service("ubigeodpdService")
public class UbigeoDPDServiceImpl implements UbigeoDPDService{
    private static final Logger LOG = LoggerFactory.getLogger(UbigeoDPDServiceImpl.class);
    
    @Inject
    UbigeodpdDAO ubigeodpdDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<UbigeodpdDTO> listarUbigeoDPD (UbigeoDPDFilter filtro){
        List<UbigeodpdDTO> retorno=null;
        try{
            retorno = ubigeodpdDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarUbigeoDPD",ex);
        }
        return retorno;
    }
    
}
