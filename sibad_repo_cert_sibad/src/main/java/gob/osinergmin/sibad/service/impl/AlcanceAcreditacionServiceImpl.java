/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.dao.AlcanceAcreditacionDAO;
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
@Service("alcanceacreditacionService")
public class AlcanceAcreditacionServiceImpl implements AlcanceAcreditacionService{
    private static final Logger LOG = LoggerFactory.getLogger(AlcanceAcreditacionServiceImpl.class);
    
    @Inject
    AlcanceAcreditacionDAO alcanceacreditacionDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<AlcanceAcreditacionDTO> listarAlcanceAcreditacion (AlcanceAcreditacionFilter filtro){
        List<AlcanceAcreditacionDTO> retorno=null;
        try{
            retorno = alcanceacreditacionDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarAlcanceAcreditacion",ex);
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
