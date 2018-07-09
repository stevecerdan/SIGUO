/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
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
    
    @Override
	public PersonaJuridicaDTO RegistrarPersonaJuridica(PersonaJuridicaDTO personaJuridicaDTO, UsuarioDTO usuarioDTO) {
		
    LOG.info("Iniciando envio de datos de Persona Juridica al DAO");
		
    PersonaJuridicaDTO registro=null;
		
		try {
			
			registro = personajuridicaDAO.create(personaJuridicaDTO,usuarioDTO);
			LOG.info("(Se envio con exito los datos de Persona Juridica al DAO) registro: "+registro.getIdPersonaJuridica());
			 
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Persona Juridica al DAO",e);
		}
	
		return registro;
	}
    
    @Override
	public PersonaJuridicaDTO EditarPersonaJuridica(PersonaJuridicaDTO personaJuridicaDTO, UsuarioDTO usuarioDTO) {
		
    LOG.info("Iniciando envio de datos de Persona Juridica al DAO");
		
    PersonaJuridicaDTO registro=null;
		
		try {
			
			registro = personajuridicaDAO.update(personaJuridicaDTO,usuarioDTO);
			LOG.info("(Se envio con exito los datos de Persona Juridica al DAO) registro: "+registro.toString());
			 
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Persona Juridica al DAO",e);
		}
	
		return registro;
	}
}
