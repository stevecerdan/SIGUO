/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.service.PersonaNaturalVService;
import gob.osinergmin.sibad.service.dao.PersonaNaturalVDAO;
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
@Service("PersonaNaturalVService")
public class PersonaNaturalVServiceImpl implements PersonaNaturalVService{
    private static final Logger LOG = LoggerFactory.getLogger(PersonaNaturalVServiceImpl.class);
    
    @Inject
    PersonaNaturalVDAO personanaturalDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<PersonaNaturalVDTO> listarPersonaNatural (PersonaNaturalVFilter filtro){
        List<PersonaNaturalVDTO> retorno=null;
        try{
            retorno = personanaturalDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarPersonaNatural",ex);
        }
        return retorno;
    }
    
    @Override
	public PersonaNaturalVDTO guardarPersonaNatural(PersonaNaturalVDTO personaNaturalDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Registro guardarPersonaNatural ServiceNegImpl");
		PersonaNaturalVDTO registro = null;
		 LOG.info(personaNaturalDTO.getApellidoMaterno()+" - "+personaNaturalDTO.getApellidoPaterno() +" - "+personaNaturalDTO.getNombre() +" - "+personaNaturalDTO.getCip());
		
		try {
			registro = personanaturalDAO.create(personaNaturalDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de PersonaNaturalVDTO al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos de PersonaNaturalVDTO al DAO",e);
		}
		
		return registro;
	}
    
    @Override
	public PersonaNaturalVDTO editarPersonaNatural(PersonaNaturalVDTO personaNaturalDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando actualizacion de datos de Persona Natural al DAO");
			
		 PersonaNaturalVDTO registro=null;
				
			try {
				
				registro = personanaturalDAO.update(personaNaturalDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos de Persona Natural al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de  Persona Natural al DAO",e);
			}
		
			return registro;
	}
    
    @Override
	public List<PersonaNaturalVDTO> listarTablaPersonaNatural(Long idPersonaNatural, String numeroDoc,
			String apellidoPaterno, String apellidoMaterno, String nombre) {
		
		List<PersonaNaturalVDTO> retorno=null;
 		 
		LOG.info(idPersonaNatural +" - "+ numeroDoc +" - "+ apellidoPaterno +" - "+apellidoMaterno +" - "+nombre);
 		
 		try {
 			retorno = personanaturalDAO.llenarTablaPersonaNatural(idPersonaNatural, numeroDoc, apellidoPaterno, apellidoMaterno, nombre);
 			LOG.info("(Se envio con exito los datos de PersonaNaturalVDTO al DAO - Sernaque) registro: "+retorno.toString());
 		} catch (Exception e) {
 			LOG.error("error enviar datos de PersonaNaturalVDTO al DAO - Sernaque",e);
 		}
 		
 		return retorno;
	}
}
