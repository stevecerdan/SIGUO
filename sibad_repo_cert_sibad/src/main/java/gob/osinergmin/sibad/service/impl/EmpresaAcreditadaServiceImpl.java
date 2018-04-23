/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.dao.EmpresaAcreditadaDAO;

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
@Service("empacredService")
public class EmpresaAcreditadaServiceImpl implements EmpresaAcreditadaService{
    private static final Logger LOG = LoggerFactory.getLogger(EmpresaAcreditadaServiceImpl.class);
    
    @Inject
    EmpresaAcreditadaDAO empacredDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<EmpresaAcreditadaDTO> listarEmpAcred(EmpresaAcreditadaFilter filtro){
        List<EmpresaAcreditadaDTO> retorno=null;
        try{
            retorno = empacredDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarEmpresaAcreditada",ex);
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
