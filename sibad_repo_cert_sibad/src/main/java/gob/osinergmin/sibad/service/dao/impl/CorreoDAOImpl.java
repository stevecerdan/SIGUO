/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.builder.CorreoBuilder;
import gob.osinergmin.sibad.domain.dto.CorreoDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import gob.osinergmin.sibad.service.dao.CorreoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
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
@Service("correoDAO")
public class CorreoDAOImpl implements CorreoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(CorreoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<CorreoDTO> find(DestinatarioCorreoFilter filtro) {
        List<CorreoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = CorreoBuilder.toListCorreoDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(DestinatarioCorreoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdCorreo()!=null){
                query = crud.getEm().createNamedQuery("PghCorreo.findByAllDatos");
            }
            
            if(filtro.getIdCorreo()!=null){
            	query.setParameter("idCorreo",filtro.getIdCorreo());
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
