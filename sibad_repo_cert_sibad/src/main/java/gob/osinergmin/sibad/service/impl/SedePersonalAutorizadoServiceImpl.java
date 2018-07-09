/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedePersonalAutorizadoFilter;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.SedePersonalAutorizadoService;
import gob.osinergmin.sibad.service.dao.EmpresaAcreditadaDAO;
import gob.osinergmin.sibad.service.dao.SedePersonalAutorizadoDAO;
import gob.osinergmin.sibad.service.exception.EmpresaAcreditadaException;
import gob.osinergmin.sibad.service.exception.SedePersonalAutorizadoException;

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
@Service("sedepersonalautorizadoService")
public class SedePersonalAutorizadoServiceImpl implements SedePersonalAutorizadoService{
    private static final Logger LOG = LoggerFactory.getLogger(SedePersonalAutorizadoServiceImpl.class);
    
    @Inject
    SedePersonalAutorizadoDAO sedepersonalautorizadoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<SedePersonalAutorizadoDTO> listarSedePersonalAutorizado (SedePersonalAutorizadoFilter filtro){
        List<SedePersonalAutorizadoDTO> retorno=null;
        try{
            retorno = sedepersonalautorizadoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarSedePersonalAutorizado",ex);
        }
        return retorno;
    }
    
    @Override
	public SedePersonalAutorizadoDTO EditarSedePersonalAutorizado(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando envio de datos de SedePersonalAutorizado al DAO");
			
		 SedePersonalAutorizadoDTO registro=null;
				
			try {
				
				registro = sedepersonalautorizadoDAO.update(sedePersonalAutorizadoDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos de SedePersonalAutorizado al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de  SedePersonalAutorizado al DAO",e);
			}
		
			return registro;
	}

	@Override
	public SedePersonalAutorizadoDTO RegistrarSedePersonalAutorizado(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando envio de datos de Sede Personal Autorizado al DAO");
		
		SedePersonalAutorizadoDTO registro=null;
				
			try {
				
				registro = sedepersonalautorizadoDAO.create(sedePersonalAutorizadoDTO,usuarioDTO);
				LOG.info("(Se envio con exito los datos de Sede Personal Autorizado al DAO) registro: "+registro.getIdSedePersonalAutorizado());
				 
			} catch (Exception e) {
				
				LOG.error("error al enviar los datos de Sede Personal Autorizado al DAO",e);
			}
		
			return registro;
	}
	
	@Override
	public SedePersonalAutorizadoDTO eliminarPersonal(SedePersonalAutorizadoDTO personalAutorizadoDTO)
			throws SedePersonalAutorizadoException {
		SedePersonalAutorizadoDTO eliminar = null;
		
		try {
			eliminar = sedepersonalautorizadoDAO.eliminarSedePersonal(personalAutorizadoDTO);
			//LOG.info("(eliminarSedePersonal) registro: "+eliminar.toString());
		} catch (Exception ex) {
			LOG.error("Error eliminarPersonal",ex);
            throw new SedePersonalAutorizadoException(ex.getMessage(),null);
		}
		return eliminar;
	}
    
}
