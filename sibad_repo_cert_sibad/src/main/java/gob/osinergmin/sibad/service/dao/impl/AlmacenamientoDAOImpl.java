package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.AlmacenamientoBuilder;
import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;
import gob.osinergmin.sibad.service.dao.AlmacenamientoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.AlmacenamientoException;

@Repository("AlmacenamientoDAO")
@Transactional
public class AlmacenamientoDAOImpl implements AlmacenamientoDAO {
	
	 private static final Logger LOG = LoggerFactory.getLogger(AlmacenamientoDAOImpl.class);
	    @Inject
	    private CrudDAO crud;
	
	@Override
	public List<AlmacenamientoDTO> find(AlmacenamientoFilter filtro) throws AlmacenamientoException {
		
    List<AlmacenamientoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = AlmacenamientoBuilder.toListAlmacenamientoDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(AlmacenamientoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdUnidadSupervisada()!=null){
            	
            	query = crud.getEm().createNamedQuery("PghAlmacenamiento.findByIdUnidadSupervisada");
            	
            }else if(filtro.getIdAlmacenamiento()!=null){
            	
            	query = crud.getEm().createNamedQuery("PghAlmacenamiento.findByIdAlmacenamiento");
            }
         
            if(filtro.getIdUnidadSupervisada()!=null){
            	
            	query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
            	
            }else if(filtro.getIdAlmacenamiento()!=null){
               
            	query.setParameter("idAlmacenamiento",filtro.getIdAlmacenamiento());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
