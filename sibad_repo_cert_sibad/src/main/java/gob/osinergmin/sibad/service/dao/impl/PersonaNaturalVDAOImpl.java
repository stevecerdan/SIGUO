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
                query = crud.getEm().createNamedQuery("MdiPersonaNaturalV.findByFilter");
            }
            
            if(filtro.getIdPersonaNatural()==null){
            	
                if(filtro.getNumeroDoc()!=null && !filtro.getNumeroDoc().equals("")){
                    query.setParameter("numeroDoc","%"+filtro.getNumeroDoc().toUpperCase()+"%");
                }else{
                    query.setParameter("numeroDoc","%");
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
}
