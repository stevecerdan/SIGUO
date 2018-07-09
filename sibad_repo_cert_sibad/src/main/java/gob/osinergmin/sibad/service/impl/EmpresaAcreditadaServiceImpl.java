/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.dao.EmpresaAcreditadaDAO;
import gob.osinergmin.sibad.service.exception.EmpresaAcreditadaException;

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
    
    @Override
    @Transactional(readOnly = true)
    public List<EmpresaAcreditadaDTO> listarEmpAcred2(EmpresaAcreditadaFilter filtro2){
        List<EmpresaAcreditadaDTO> retorno=null;
        try{
            retorno = empacredDAO.find2(filtro2);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarEmpresaAcreditada",ex);
        }
        return retorno;
    }
    
    @Override
	public EmpresaAcreditadaDTO RegistrarEmpresaAcreditada(EmpresaAcreditadaDTO empresaAcreditadaDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando envio de datos de Empresa Acreditada al DAO");
		LOG.info("DATOS en service: " + empresaAcreditadaDTO.getIdEmpresaAcreditada() + " - " + empresaAcreditadaDTO.getEstado());
 		EmpresaAcreditadaDTO registro=null;
		
		try {
			
			registro = empacredDAO.create(empresaAcreditadaDTO,usuarioDTO);
			LOG.info("(Se envio con exito los datos de Empresa Acreditada al DAO) registro: "+registro.toString());
			 
		} catch (EmpresaAcreditadaException e) {
			
			LOG.error("error enviar datos de Empresa Acreditada al DAO",e);
		}
	
		return registro;
	}
    
    @Override
	public EmpresaAcreditadaDTO EditarEmpresaAcreditada(EmpresaAcreditadaDTO empresaAcreditadaDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando envio de datos de Empresa Acreditada al DAO");
 		EmpresaAcreditadaDTO registro=null;
		
		try {
			
			registro = empacredDAO.update(empresaAcreditadaDTO,usuarioDTO);
			LOG.info("(Se envio con exito los datos de Empresa Acreditada al DAO) registro: "+registro.toString());
			 
		} catch (EmpresaAcreditadaException e) {
			
			LOG.error("error enviar datos de Empresa Acreditada al DAO",e);
		}
	
		return registro;
	}
}
