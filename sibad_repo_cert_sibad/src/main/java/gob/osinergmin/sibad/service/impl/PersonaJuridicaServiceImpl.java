/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.service.PersonaJuridicaService;
import gob.osinergmin.sibad.service.dao.PersonaJuridicaDAO;
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
@Service("personajuridicaService")
public class PersonaJuridicaServiceImpl implements PersonaJuridicaService{
    private static final Logger LOG = LoggerFactory.getLogger(PersonaJuridicaServiceImpl.class);
    
    @Inject
    PersonaJuridicaDAO personajuridicaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<PersonaJuridicaDTO> listarPersonaJuridica (PersonaJuridicaFilter filtro){
        List<PersonaJuridicaDTO> retorno=null;
        try{
            retorno = personajuridicaDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarPersonaJuridica",ex);
        }
        return retorno;
    }
    
   /* @Override
    @Transactional
    public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO){
        LOG.info("editarAutoayuda");
        AutoayudaDTO registro=null;
        try{
            registro=autoayudaDAO.update(autoayudaDTO,usuarioDTO);
            LOG.info("(Actualizar Base Legal ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("error editarAutoayuda",ex);
        }
        return registro;
    }*/
}
