package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.CompartimientoBuilder;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.service.dao.CompartimientoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.CompartimientoException;

@Repository("CompartimientoDAO")
@Transactional
public class CompartimientoDAOImpl implements CompartimientoDAO{
	
	private static final Logger LOG = LoggerFactory.getLogger(CompartimientoDAOImpl.class);
    @Inject
    private CrudDAO crud;
	
    
    @Override
	public List<CompartimientoDTO> find(CompartimientoFilter filtro) throws CompartimientoException {
		
    	 List<CompartimientoDTO> listado;
         
         Query query = getFindQuery(filtro);
         listado = CompartimientoBuilder.toListCompartimientoDto(query.getResultList());

         return listado;
	}
    
    private Query getFindQuery(CompartimientoFilter filtro) {
        
    	Query query=null;
        try{
            if(filtro.getIdAlmacenamiento()!=null){
            	LOG.info("Id en findByIdAlmacenamiento....."+filtro.getIdAlmacenamiento());
            	query = crud.getEm().createNamedQuery("PghCompartimiento.findByIdAlmacenamiento");
            }
         
            if(filtro.getIdAlmacenamiento()==null){
                query.setParameter("idAlmacenamiento","");
            }else {
            	LOG.info("Valor Ingresado....."+filtro.getIdAlmacenamiento());
            	query.setParameter("idAlmacenamiento",filtro.getIdAlmacenamiento());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
