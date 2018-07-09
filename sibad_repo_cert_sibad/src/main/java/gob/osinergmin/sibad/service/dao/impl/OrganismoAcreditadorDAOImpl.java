/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghOrganismoAcreditador;
import gob.osinergmin.sibad.domain.builder.OrganismoAcreditadorBuilder;
import gob.osinergmin.sibad.domain.dto.OrganismoAcreditadorDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.OrganismoAcreditadorFilter;
import gob.osinergmin.sibad.service.dao.OrganismoAcreditadorDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.OrganismoAcreditadorException;

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
@Repository("OrganismoAcreditadorDAO")
@Transactional
public class OrganismoAcreditadorDAOImpl implements OrganismoAcreditadorDAO {
    private static final Logger LOG = LoggerFactory.getLogger(OrganismoAcreditadorDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<OrganismoAcreditadorDTO> find(OrganismoAcreditadorFilter filtro) throws OrganismoAcreditadorException {
        List<OrganismoAcreditadorDTO> listado;
        
        Query query = getFindQuery(filtro);
        
        LOG.info(query.toString());
        
        listado = OrganismoAcreditadorBuilder.toListOrganismoAcreditadorDto(query.getResultList());

        return listado;
    }
    
    //UITLIZADO CON FIND
    private Query getFindQuery(OrganismoAcreditadorFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdOrganismoAcreditador()!=null){
            	
            	query = crud.getEm().createNamedQuery("PghOrganismoAcreditador.findByOrganismoGeneral");
            	
            }
            
           if(filtro.getIdOrganismoAcreditador()!=null){
        	   
        		query.setParameter("idOrganismoAcreditador",filtro.getIdOrganismoAcreditador());
        		
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }
    
}
