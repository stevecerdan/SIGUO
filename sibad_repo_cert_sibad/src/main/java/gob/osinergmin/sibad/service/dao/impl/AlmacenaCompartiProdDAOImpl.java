/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghAlmacenaCompartiProdV;
import gob.osinergmin.sibad.domain.builder.AlmacenaCompartiProdBuilder;
import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;
import gob.osinergmin.sibad.service.dao.AlmacenaCompartiProdDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.AlmacenaCompartiProdException;

import java.util.ArrayList;
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
//@Service("empacredDAO")
@Repository("AlmacenaCompartiProdDAO")
@Transactional
public class AlmacenaCompartiProdDAOImpl implements AlmacenaCompartiProdDAO {
    private static final Logger LOG = LoggerFactory.getLogger(AlmacenaCompartiProdDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<AlmacenaCompartiProdDTO> find(AlmacenaCompartiProdFilter filtro) throws AlmacenaCompartiProdException {
        List<AlmacenaCompartiProdDTO> listado;
        
        Query query = getFindQuery(filtro);
        
        LOG.info(query.toString());
        
        listado = AlmacenaCompartiProdBuilder.toListAlmacenaCompartiProdDto(query.getResultList());

        return listado;
    }
    
    //UITLIZADO CON FIND
    private Query getFindQuery(AlmacenaCompartiProdFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdCompartimiento()!=null){
            	
            	query = crud.getEm().createNamedQuery("PghAlmacenaCompartiProdV.findByACPFilter");
            	
            }else{
            	
            	if(filtro.getIdAlmacenamiento()!=null){
                	
                	query = crud.getEm().createNamedQuery("PghAlmacenaCompartiProdV.findByIdAlmacenamiento");
                	
                }else{
                	
                	query = crud.getEm().createNamedQuery("PghAlmacenaCompartiProdV.findByAlmComPro");
                	
                }
            	
            }
                    	   
           if(filtro.getIdCompartimiento()==null){
        	   
        	   if(filtro.getIdAlmacenamiento()==null){
        		   
        		   if(filtro.getIdUnidSupervTanque()!=null){
                	   
            		   query.setParameter("idUnidSupervTanque",filtro.getIdUnidSupervTanque());
            		   
                	}
        		   
        	   } else {
                  	
        		   query.setParameter("idAlmacenamiento",filtro.getIdAlmacenamiento());
               
               }
        	   
           } else {
        	   
                query.setParameter("idCompartimiento",filtro.getIdCompartimiento());
                
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }
    
}
