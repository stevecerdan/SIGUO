/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghTipoEquipoV;
import gob.osinergmin.sibad.domain.builder.TipoEquipoBuilder;
import gob.osinergmin.sibad.domain.dto.TipoEquipoDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.TipoEquipoFilter;
import gob.osinergmin.sibad.service.dao.TipoEquipoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
//import gob.osinergmin.sibad.service.dao.RequisitoDAO;
import gob.osinergmin.sibad.service.exception.TipoEquipoException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
 * @author jpiro
 */

@Service("tipoequipoDAO")
public class TipoEquipoDAOImpl implements TipoEquipoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(TipoEquipoDAOImpl.class);
    
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<TipoEquipoDTO> find(TipoEquipoFilter filtro) throws TipoEquipoException {
        List<TipoEquipoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = TipoEquipoBuilder.toListTipoEquipoDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(TipoEquipoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdEmpresaAcreditada()!=null){
                query = crud.getEm().createNamedQuery("PghTipoEquipoV.findByTipos");
            }
            
            if(filtro.getIdEmpresaAcreditada()!=null){
                query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
