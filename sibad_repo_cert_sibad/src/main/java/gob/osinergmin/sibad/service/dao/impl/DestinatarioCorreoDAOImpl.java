/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.builder.DestinatarioCorreoBuilder;
import gob.osinergmin.sibad.domain.dto.DestinatarioCorreoDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import gob.osinergmin.sibad.service.dao.DestinatarioCorreoDAO;
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
@Service("destinatariocorreoDAO")
public class DestinatarioCorreoDAOImpl implements DestinatarioCorreoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(DestinatarioCorreoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<DestinatarioCorreoDTO> find(DestinatarioCorreoFilter filtro) {
        List<DestinatarioCorreoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = DestinatarioCorreoBuilder.toListDestinatarioCorreoDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(DestinatarioCorreoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdDestinatarioCorreo()!=null){
                query = crud.getEm().createNamedQuery("PghDestinatarioCorreoV.findByAllDatos");
            }else{
                query = crud.getEm().createNamedQuery("PghDestinatarioCorreoV.findByFilterDatos");
            }
            
            if(filtro.getIdDestinatarioCorreo()==null){
            	query.setParameter("idCorreo",filtro.getIdCorreo());
            	query.setParameter("idPersonal",filtro.getIdPersonal());
            }else{
                query.setParameter("idDestinatarioCorreo",filtro.getIdDestinatarioCorreo());
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
