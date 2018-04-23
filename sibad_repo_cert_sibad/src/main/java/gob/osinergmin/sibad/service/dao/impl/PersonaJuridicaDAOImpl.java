/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.MdiPersonaJuridica;
import gob.osinergmin.sibad.domain.builder.PersonaJuridicaBuilder;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.service.dao.PersonaJuridicaDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
//import gob.osinergmin.sibad.service.dao.RequisitoDAO;
import gob.osinergmin.sibad.service.exception.PersonaJuridicaException;
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
@Service("personajuridicaDAO")
public class PersonaJuridicaDAOImpl implements PersonaJuridicaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(PersonaJuridicaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<PersonaJuridicaDTO> find(PersonaJuridicaFilter filtro) throws PersonaJuridicaException {
        List<PersonaJuridicaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = PersonaJuridicaBuilder.toListPersonaJuridicaDto(query.getResultList());

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
    
    private Query getFindQuery(PersonaJuridicaFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdPersonaJuridica()!=null){
                query = crud.getEm().createNamedQuery("MdiPersonaJuridica.findByIdPersonaJ");
            }else{
                query = crud.getEm().createNamedQuery("MdiPersonaJuridica.findByFilter");
            }
            
            if(filtro.getIdPersonaJuridica()==null){
                if(filtro.getRuc()!=null && !filtro.getRuc().equals("")){
                    query.setParameter("ruc","%"+filtro.getRuc().toUpperCase()+"%");
                }else{
                    query.setParameter("ruc","%");
                }
            }else{
                query.setParameter("idPersonaJuridica",filtro.getIdPersonaJuridica());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
