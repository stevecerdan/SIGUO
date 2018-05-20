/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.MdiMaestroColumnaTipo;
import gob.osinergmin.sibad.domain.builder.MaestroColumnaTipoBuilder;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.service.dao.MaestroColumnaTipoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
//import gob.osinergmin.sibad.service.dao.RequisitoDAO;
import gob.osinergmin.sibad.service.exception.MaestroColumnaTipoException;
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
@Service("maestrocolumnatipoDAO")
public class MaestroColumnaTipoDAOImpl implements MaestroColumnaTipoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(MaestroColumnaTipoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<MaestroColumnaTipoDTO> find(MaestroColumnaTipoFilter filtro) throws MaestroColumnaTipoException {
        List<MaestroColumnaTipoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = MaestroColumnaTipoBuilder.toListMaestroColumnaTipoDto(query.getResultList());

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
    
    private Query getFindQuery(MaestroColumnaTipoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdMaestroColumna()!=null){
                query = crud.getEm().createNamedQuery("MdiMaestroColumnaTipo.findByIdMaster");
            }else{
                query = crud.getEm().createNamedQuery("MdiMaestroColumnaTipo.findByFilter");
            }
            
            if(filtro.getIdMaestroColumna()==null){
                if(filtro.getDominio()!=null && !filtro.getDominio().equals("")){
                    query.setParameter("dominio","%"+filtro.getDominio().toUpperCase()+"%");
                }else{
                    query.setParameter("dominio","%");
                }
                if(filtro.getAplicacion()!=null && !filtro.getAplicacion().equals("")){
                    query.setParameter("aplicacion","%"+filtro.getAplicacion().toUpperCase()+"%");
                }else{
                    query.setParameter("aplicacion","%");
                }
            }else{
                query.setParameter("idMaestroColumna",filtro.getIdMaestroColumna());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
