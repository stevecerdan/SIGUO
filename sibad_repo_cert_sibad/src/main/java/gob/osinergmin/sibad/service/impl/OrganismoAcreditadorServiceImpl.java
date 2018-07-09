/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.OrganismoAcreditadorDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.OrganismoAcreditadorFilter;
import gob.osinergmin.sibad.service.OrganismoAcreditadorService;
import gob.osinergmin.sibad.service.dao.OrganismoAcreditadorDAO;
import gob.osinergmin.sibad.service.exception.OrganismoAcreditadorException;

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
@Service("organismoacreditadorService")
public class OrganismoAcreditadorServiceImpl implements OrganismoAcreditadorService{
    private static final Logger LOG = LoggerFactory.getLogger(OrganismoAcreditadorServiceImpl.class);
    
    @Inject
    OrganismoAcreditadorDAO organismoacreditadorDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<OrganismoAcreditadorDTO> listarOrganismoAcreditador(OrganismoAcreditadorFilter filtro){
        List<OrganismoAcreditadorDTO> retorno=null;
        try{
            retorno = organismoacreditadorDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listar Organismo Acreditador",ex);
        }
        return retorno;
    }
    
}
