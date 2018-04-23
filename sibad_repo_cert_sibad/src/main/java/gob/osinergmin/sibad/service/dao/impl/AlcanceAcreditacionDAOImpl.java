/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghAlcanceAcreditacion;
import gob.osinergmin.sibad.domain.builder.AlcanceAcreditacionBuilder;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.service.dao.AlcanceAcreditacionDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
//import gob.osinergmin.sibad.service.dao.RequisitoDAO;
import gob.osinergmin.sibad.service.exception.AlcanceAcreditacionException;
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
@Service("alcanceacreditacionDAO")
public class AlcanceAcreditacionDAOImpl implements AlcanceAcreditacionDAO {
    private static final Logger LOG = LoggerFactory.getLogger(AlcanceAcreditacionDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<AlcanceAcreditacionDTO> find(AlcanceAcreditacionFilter filtro) throws AlcanceAcreditacionException {
        List<AlcanceAcreditacionDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = AlcanceAcreditacionBuilder.toListAlcanceAcreditacionDto(query.getResultList());

        return listado;
    }
    
    /*@Override
    public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException{
        AutoayudaDTO retorno = null;
        try{
            PghAutoayuda registroDAO = AutoayudaBuilder.getAutoayuda(autoayudaDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=AutoayudaBuilder.toAutoayudaDto(registroDAO);
        }catch(Exception e){
            LOG.error("Error al editar Requisito",e);
            AutoayudaException e2 = new AutoayudaException("Error al editar Requisito",e);
            throw e2;
        }
        return retorno;
    }*/
    
    private Query getFindQuery(AlcanceAcreditacionFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdAlcanceAcreditacion()!=null){
                query = crud.getEm().createNamedQuery("PghAlcanceAcreditacion.findByIdAlcanceAcreditacion");
            }else{
            	query = crud.getEm().createNamedQuery("PghAlcanceAcreditacion.findByIdAlcanceAcreditacion");
                //query = crud.getEm().createNamedQuery("MdiPersonaJuridica.findByFilter");
            }
            
            if(filtro.getIdAlcanceAcreditacion()==null){
            	query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
            }else{
                query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
