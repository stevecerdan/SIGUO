/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.SolicitudPruebaRepruebaService;
import gob.osinergmin.sibad.service.dao.SolicitudPruebaRepruebaDAO;
import gob.osinergmin.sibad.service.exception.SolicitudPruebaRepruebaException;

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
@Service("solicitudpruebarepruebaService")
public class SolicitudPruebaRepruebaServiceImpl implements SolicitudPruebaRepruebaService{
    private static final Logger LOG = LoggerFactory.getLogger(SolicitudPruebaRepruebaServiceImpl.class);
    
    @Inject
    SolicitudPruebaRepruebaDAO solicitudpruebarepruebaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<SolicitudPruebaRepruebaDTO> listarSolicitudPruebaReprueba(SolicitudPruebaRepruebaFilter filtro){
        List<SolicitudPruebaRepruebaDTO> retorno=null;
        try{
            retorno = solicitudpruebarepruebaDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarSolicitudPruebaReprueba",ex);
        }
        return retorno;
    }
    
    
    @Override
	public SolicitudPruebaRepruebaDTO RegistrarSolicitudPruebaReprueba(SolicitudPruebaRepruebaDTO SolicitudPruebaRepruebaDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando envio de datos de Solicitud Prueba Reprueba al DAO");
		LOG.info("DATOS en service: " + SolicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba() + " - " + SolicitudPruebaRepruebaDTO.getNroSolicitudUnidadSupervisa() +
				 " - " + SolicitudPruebaRepruebaDTO.getIdTipoPrueba()+" - " + SolicitudPruebaRepruebaDTO.getIdEmpresaAcreditada()+
				 " - " + SolicitudPruebaRepruebaDTO.getFechaSolicitud()+" - " + SolicitudPruebaRepruebaDTO.getIdCompartimiento()+" - " + SolicitudPruebaRepruebaDTO.getEstado());
 		
 		SolicitudPruebaRepruebaDTO registro=null;
		
		try {
			
			registro = solicitudpruebarepruebaDAO.create(SolicitudPruebaRepruebaDTO,usuarioDTO);
			LOG.info("(Se envio con exito los datos de Solicitud Prueba Reprueba al DAO) registro: "+registro.getIdSolicitudPruebaReprueba());
			 
		} catch (SolicitudPruebaRepruebaException e) {
			
			LOG.error("error enviar datos de Solicitud Prueba Reprueba al DAO",e);
		}
	
		return registro;
	}
    
    @Override
	public SolicitudPruebaRepruebaDTO EditarSolicitudPruebaReprueba(SolicitudPruebaRepruebaDTO SolicitudPruebaRepruebaDTO, UsuarioDTO usuarioDTO) {
		
        SolicitudPruebaRepruebaDTO registro=null;
		
		try {
			
			registro = solicitudpruebarepruebaDAO.update(SolicitudPruebaRepruebaDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de Solicitud Prueba Reprueba al DAO) registro: "+registro.getIdSolicitudPruebaReprueba());
			 
		} catch (SolicitudPruebaRepruebaException e) {
			
			LOG.error("error enviar datos de Solicitud Prueba Reprueba al DAO",e);
		}
	
		return registro;
	
	}
    
}
