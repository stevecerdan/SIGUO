package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.UnidadSupervisadaBuilder;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.UnidadSupervisadaVDAO;
import gob.osinergmin.sibad.service.exception.UnidadSupervisadaException;

@Repository("UnidadSupervisadaVDAO")
@Transactional
public class UnidadSupervisadaVDAOImpl implements UnidadSupervisadaVDAO{
	private static final Logger LOG = LoggerFactory.getLogger(UnidadSupervisadaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
	@Override
	public List<UnidadSupervisadaVDTO> find(UnidadSupervisadaFilter filtro) throws UnidadSupervisadaException {
		
        List<UnidadSupervisadaVDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = UnidadSupervisadaBuilder.toListUnidadSupervisadaVDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(UnidadSupervisadaFilter filtro) {
        Query query=null;
        try{
        	if(filtro.getIdUnidadSupervisada()!=null){
        			query = crud.getEm().createNamedQuery("MdiUnidadSupervisadaV.findAll");
        	} 
        	
        	if(filtro.getIdUnidadSupervisada()!=null){

        		query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
        	}
        	
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
