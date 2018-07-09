package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import gob.osinergmin.sibad.domain.builder.UnidadSupervisadaBuilder;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.UnidadSupervisadaDAO;
import gob.osinergmin.sibad.service.exception.UnidadSupervisadaException;

@Repository("UnidadSupervisadaDAO")
@Transactional
public class UnidadSupervisadaDAOImpl implements UnidadSupervisadaDAO{
	private static final Logger LOG = LoggerFactory.getLogger(UnidadSupervisadaDAOImpl.class);
    @Inject
    private CrudDAO crud;
	@Override
	public List<UnidadSupervisadaDTO> find(UnidadSupervisadaFilter filtro) throws UnidadSupervisadaException {
		
        List<UnidadSupervisadaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = UnidadSupervisadaBuilder.toListUnidadSupervisadaDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(UnidadSupervisadaFilter filtro) {
        Query query=null;
        try{
        	if(filtro.getIdUnidadSupervisada()!=null){
        			query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.findAll");
        	} else {	
	            if(filtro.getCodigoOsinergmin()!=null){
	            	query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.findByCodigoOsinergmin");
	            }
        	}
        	
        	if(filtro.getIdUnidadSupervisada()==null){
	            if(filtro.getCodigoOsinergmin()!=null){
	                query.setParameter("codigoOsinergmin",filtro.getCodigoOsinergmin());
	            }else {
	            	query.setParameter("codigoOsinergmin","");
	            }
        	}else {
        		query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
        	}
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
