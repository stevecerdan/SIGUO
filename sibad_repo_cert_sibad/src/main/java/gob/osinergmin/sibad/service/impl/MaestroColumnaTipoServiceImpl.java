/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.dao.MaestroColumnaTipoDAO;

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
@Service("maestrocolumnatipoService")
public class MaestroColumnaTipoServiceImpl implements MaestroColumnaTipoService{
    private static final Logger LOG = LoggerFactory.getLogger(MaestroColumnaTipoServiceImpl.class);
    
    @Inject
    MaestroColumnaTipoDAO maestrocolumnatipoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<MaestroColumnaTipoDTO> listarMaestroColumnaTipo (MaestroColumnaTipoFilter filtro){
        List<MaestroColumnaTipoDTO> retorno=null;
        try{
            retorno = maestrocolumnatipoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarMaestroColumnaTipo",ex);
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
