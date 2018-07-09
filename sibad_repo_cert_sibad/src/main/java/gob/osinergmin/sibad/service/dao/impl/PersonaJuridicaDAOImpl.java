/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.MdiPersonaJuridica;
import gob.osinergmin.sibad.domain.MdiPersonaJuridica1;
import gob.osinergmin.sibad.domain.PghSedeAcreditacion;
import gob.osinergmin.sibad.domain.builder.PersonaJuridicaBuilder;
import gob.osinergmin.sibad.domain.builder.SedeAcreditacionBuilder;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.service.dao.PersonaJuridicaDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
//import gob.osinergmin.sibad.service.dao.RequisitoDAO;
import gob.osinergmin.sibad.service.exception.PersonaJuridicaException;
import gob.osinergmin.sibad.service.exception.SedeAcreditacionException;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
//@Service("personajuridicaDAO")
@Repository("PersonaJuridicaDAO")
@Transactional
public class PersonaJuridicaDAOImpl implements PersonaJuridicaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(PersonaJuridicaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<PersonaJuridicaDTO> find(PersonaJuridicaFilter filtro) throws PersonaJuridicaException {
        List<PersonaJuridicaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = PersonaJuridicaBuilder.toListPersonaJuridicaDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(PersonaJuridicaFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdPersonaJuridica()!=null){
                query = crud.getEm().createNamedQuery("MdiPersonaJuridica.findByIdPersonaJ");
            }else{
                query = crud.getEm().createNamedQuery("MdiPersonaJuridica.findByFilter");
            }
            
            if(filtro.getIdPersonaJuridica()==null){
                if(filtro.getRuc()!=null && !filtro.getRuc().equals("")){
                    query.setParameter("ruc",filtro.getRuc().toUpperCase());
                }else{
                    query.setParameter("ruc","%");
                }
            }else{
                query.setParameter("idPersonaJuridica",filtro.getIdPersonaJuridica());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
    
    @Override
	public PersonaJuridicaDTO create(PersonaJuridicaDTO personaJuridicaDTO, UsuarioDTO usuarioDTO)throws PersonaJuridicaException {
		
		LOG.info("Iniciando registro de Empresa Acreditada");
		
		PersonaJuridicaDTO retorno = null;
		
		try {
			
			MdiPersonaJuridica1 mdiPersonaJuridica1 = new MdiPersonaJuridica1();
			
			mdiPersonaJuridica1.setIdPersonaJuridica(personaJuridicaDTO.getIdPersonaJuridica());
			mdiPersonaJuridica1.setIdDepartamento(personaJuridicaDTO.getIdDepartamento());
			mdiPersonaJuridica1.setIdDistrito(personaJuridicaDTO.getIdDistrito());
			mdiPersonaJuridica1.setIdProvincia(personaJuridicaDTO.getIdProvincia());
			mdiPersonaJuridica1.setRuc(personaJuridicaDTO.getRuc());
			mdiPersonaJuridica1.setRazonSocial(personaJuridicaDTO.getRazonSocial());
			mdiPersonaJuridica1.setDireccion(personaJuridicaDTO.getDireccion());
			mdiPersonaJuridica1.setTelefono(personaJuridicaDTO.getTelefono());
			mdiPersonaJuridica1.setEmail(personaJuridicaDTO.getEmail());
			mdiPersonaJuridica1.setWeb(personaJuridicaDTO.getWeb());
			mdiPersonaJuridica1.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+mdiPersonaJuridica1.getIdDepartamento()+" - " +mdiPersonaJuridica1.getIdDistrito()+" - " +mdiPersonaJuridica1.getIdProvincia()+" - " +mdiPersonaJuridica1.getRuc()+" - " +mdiPersonaJuridica1.getRazonSocial()+" - " +mdiPersonaJuridica1.getDireccion()+" - " +mdiPersonaJuridica1.getTelefono()+" - " +mdiPersonaJuridica1.getEmail()+" - " +mdiPersonaJuridica1.getWeb());
			
			crud.create(mdiPersonaJuridica1);
			
			retorno = PersonaJuridicaBuilder.toPersonaJuridicaDto1(mdiPersonaJuridica1);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
    
    @Override
	public PersonaJuridicaDTO update(PersonaJuridicaDTO personaJuridicaDTO, UsuarioDTO usuarioDTO)throws PersonaJuridicaException {
		
	LOG.info("Iniciando actualizacion de Persona Juridica");
		
	PersonaJuridicaDTO retorno = null;
		
		try {
			
			MdiPersonaJuridica1 MdiPersonaJuridica1 = crud.find(personaJuridicaDTO.getIdPersonaJuridica(), MdiPersonaJuridica1.class);
			
			MdiPersonaJuridica1.setIdPersonaJuridica(personaJuridicaDTO.getIdPersonaJuridica());
			MdiPersonaJuridica1.setTelefono(personaJuridicaDTO.getTelefono());
			MdiPersonaJuridica1.setEmail(personaJuridicaDTO.getEmail());
			MdiPersonaJuridica1.setWeb(personaJuridicaDTO.getWeb());
			MdiPersonaJuridica1.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+MdiPersonaJuridica1.getIdPersonaJuridica()+" - " +MdiPersonaJuridica1.getTelefono()+" - " +MdiPersonaJuridica1.getEmail()+" - " +MdiPersonaJuridica1.getWeb());
			
			crud.update(MdiPersonaJuridica1);
			
			retorno = PersonaJuridicaBuilder.toPersonaJ1Dto(MdiPersonaJuridica1);
			 
			LOG.info("(Edicion exitosa) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
}
