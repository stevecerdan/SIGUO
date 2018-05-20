/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.builder.UbigeoDPDBuilder;
import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;
import gob.osinergmin.sibad.filter.UbigeoDPDFilter;
import gob.osinergmin.sibad.service.dao.UbigeodpdDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.UbigeoDPDException;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("ubigeodpdDAO")
public class UbigeodpdDAOImpl implements UbigeodpdDAO {
    private static final Logger LOG = LoggerFactory.getLogger(UbigeodpdDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<UbigeodpdDTO> find(UbigeoDPDFilter filtro) throws UbigeoDPDException {
        List<UbigeodpdDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = UbigeoDPDBuilder.toListUbigeoDPDDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(UbigeoDPDFilter filtro) {
        Query query=null;
        try{
            
            //------
        	
            if(filtro.getIdDepartamento()==null){
                query = crud.getEm().createNamedQuery("MdiUbigeoDPD.findByFilterDPTO");
            }
            
            if(filtro.getIdProvincia()==null){
                query = crud.getEm().createNamedQuery("MdiUbigeoDPD.findByFilterPROV");
            }
            
            if(filtro.getIdDistrito()==null){
                query = crud.getEm().createNamedQuery("MdiUbigeoDPD.findByFilterDIST");
            }
            
            //--------
            
            if(filtro.getIdDepartamento()==null){
            	
                if(filtro.getIdProvincia()!=null){
                    query.setParameter("idProvincia","%"+filtro.getIdProvincia()+"%");
                }else{
                    query.setParameter("idProvincia","%");
                }
                if(filtro.getIdDistrito()!=null){
                    query.setParameter("idDistrito","%"+filtro.getIdDistrito()+"%");
                }else{
                    query.setParameter("idDistrito","%");
                }
            }
            
            if(filtro.getIdProvincia()==null){
            	
            	if(filtro.getIdDepartamento()!=null){
                    query.setParameter("idDepartamento","%"+filtro.getIdDepartamento()+"%");
                }else{
                    query.setParameter("idDepartamento","%");
                }
            	
            	if(filtro.getIdDistrito()!=null){
                    query.setParameter("idDistrito","%"+filtro.getIdDistrito()+"%");
                }else{
                    query.setParameter("idDistrito","%");
                }
            }
            
            if(filtro.getIdDistrito()==null) {
            	
	            if(filtro.getIdDepartamento()!=null){
	                query.setParameter("idDepartamento","%"+filtro.getIdDepartamento()+"%");
	            }else{
	                query.setParameter("idDepartamento","%");
	            }
	        	
	        	if(filtro.getIdProvincia()!=null){
	                query.setParameter("idProvincia","%"+filtro.getIdProvincia()+"%");
	            }else{
	                query.setParameter("idProvincia","%");
	            }
	        	
            }
            
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
