/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghTipoPruebaOrganismo;
import gob.osinergmin.sibad.domain.builder.TipoPruebaOrganismoBuilder;
import gob.osinergmin.sibad.domain.dto.TipoPruebaOrganismoDTO;
import gob.osinergmin.sibad.filter.TipoPruebaOrganismoFilter;
import gob.osinergmin.sibad.service.dao.TipoPruebaOrganismoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.TipoPruebaOrganismoException;
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
@Service("tipopruebaorganismoDAO")
public class TipoPruebaOrganismoDAOImpl implements TipoPruebaOrganismoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(TipoPruebaOrganismoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<TipoPruebaOrganismoDTO> find(TipoPruebaOrganismoFilter filtro) throws TipoPruebaOrganismoException {
        List<TipoPruebaOrganismoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = TipoPruebaOrganismoBuilder.toListTipoPruebaOrganismoDto(query.getResultList());

        return listado;
    }
    
    
    private Query getFindQuery(TipoPruebaOrganismoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdOrganismoAcreditador()!=null){
                query = crud.getEm().createNamedQuery("PghTipoPruebaOrganismo.findByIdTipoPrueba");
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
