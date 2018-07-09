/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;
import gob.osinergmin.sibad.domain.MdiPersonaNaturalV;
import gob.osinergmin.sibad.domain.builder.PersonaNaturalVBuilder;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.service.dao.PersonaNaturalVDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.PersonaNaturalVException;

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
 * @author jpiro
 */
@Repository("PersonaNaturalVDAO")
@Transactional
public class PersonaNaturalVDAOImpl implements PersonaNaturalVDAO {
    private static final Logger LOG = LoggerFactory.getLogger(PersonaNaturalVDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<PersonaNaturalVDTO> find(PersonaNaturalVFilter filtro) throws PersonaNaturalVException {
        List<PersonaNaturalVDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = PersonaNaturalVBuilder.toListPersonaNaturalDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(PersonaNaturalVFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdPersonaNatural()!=null){
                query = crud.getEm().createNamedQuery("MdiPersonaNaturalV.findByIdPersonaN");
            }else{ 
            	if(filtro.getNumeroDoc()!=null){
                query = crud.getEm().createNamedQuery("MdiPersonaNaturalV.findByFilter");
                } else {
                query = crud.getEm().createNamedQuery("MdiPersonaNaturalV.findByBuscaCIP");
                }
            }
            
            if(filtro.getIdPersonaNatural()==null){
            	
                if(filtro.getNumeroDoc()!=null && !filtro.getNumeroDoc().equals("")){
                    query.setParameter("numeroDoc",filtro.getNumeroDoc().toUpperCase());
                }else{
                	if(filtro.getCip()!=null){
                        query.setParameter("cip",filtro.getCip());
                    }
                } 
            }else{
                query.setParameter("idPersonaNatural",filtro.getIdPersonaNatural());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
    
    @Override
	public PersonaNaturalVDTO create(PersonaNaturalVDTO personaNaturalDTO, UsuarioDTO usuarioDTO) {
    	LOG.info("LLEGA DTO: " + personaNaturalDTO.getIdPersonaNatural() + " - " +  personaNaturalDTO.getApellidoPaterno() + " - " + personaNaturalDTO.getApellidoMaterno() + " - " + personaNaturalDTO.getNombre() + " - " + personaNaturalDTO.getCip()); 
		
		MdiPersonaNaturalV mdiPersonaNatural = PersonaNaturalVBuilder.toMdiPersonaNaturalV(personaNaturalDTO);
		
		LOG.info("CAMBIA  A MDI" + mdiPersonaNatural.getIdPersonaNatural() + " - " +  mdiPersonaNatural.getApellidoPaterno() + " - " + mdiPersonaNatural.getApellidoMaterno() + " - " + mdiPersonaNatural.getNombre() + " - " + mdiPersonaNatural.getCip()); 
		
		mdiPersonaNatural.setDatosAuditoria(usuarioDTO);
		crud.create(mdiPersonaNatural);
		LOG.info("despues del create: DAOIMPL: "+ mdiPersonaNatural.getIdPersonaNatural() + " - " +  mdiPersonaNatural.getApellidoPaterno() + " - " + mdiPersonaNatural.getApellidoMaterno() + " - " + mdiPersonaNatural.getNombre() + " - " + mdiPersonaNatural.getCip());
		personaNaturalDTO.setIdPersonaNatural(mdiPersonaNatural.getIdPersonaNatural());
		return personaNaturalDTO;
	}
    
    @Override
	public PersonaNaturalVDTO update (PersonaNaturalVDTO personaNaturalDTO, UsuarioDTO usuarioDTO) throws PersonaNaturalVException {
		
	LOG.info("Iniciando actualizacion de Persona Natural");
		
	PersonaNaturalVDTO retorno = null;
		
		try {
			
			MdiPersonaNaturalV MdiPersonaNaturalV = crud.find(personaNaturalDTO.getIdPersonaNatural(), MdiPersonaNaturalV.class);
			
			MdiPersonaNaturalV.setIdPersonaNatural(personaNaturalDTO.getIdPersonaNatural());
			MdiPersonaNaturalV.setNombre(personaNaturalDTO.getNombre());
			MdiPersonaNaturalV.setApellidoPaterno(personaNaturalDTO.getApellidoPaterno());
			MdiPersonaNaturalV.setApellidoMaterno(personaNaturalDTO.getApellidoMaterno());
			MdiPersonaNaturalV.setCip(personaNaturalDTO.getCip());
			MdiPersonaNaturalV.setTelefono(personaNaturalDTO.getTelefono());
			MdiPersonaNaturalV.setDatosAuditoria(usuarioDTO);
			
			
			//LOG.info(" Datos:"+PghDocumentoAdjunto.getIdDocumentoAdjunto()+" - " +PghDocumentoAdjunto.getEstadoDocumento());
			
			crud.update(MdiPersonaNaturalV);
			
			retorno = PersonaNaturalVBuilder.toPersonaNaturalDto(MdiPersonaNaturalV);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
    
    @Override
	public List<PersonaNaturalVDTO> llenarTablaPersonaNatural(Long idPersonaNatural, String numeroDoc,String apellidoPaterno, String apellidoMaterno, String nombre) throws PersonaNaturalVException {
		
        List<PersonaNaturalVDTO> listado;
        
        listado = PersonaNaturalVBuilder.toListTablaPersonaNaturalDto(idPersonaNatural, numeroDoc, apellidoPaterno, apellidoMaterno, nombre);

        return listado;
	}
}
