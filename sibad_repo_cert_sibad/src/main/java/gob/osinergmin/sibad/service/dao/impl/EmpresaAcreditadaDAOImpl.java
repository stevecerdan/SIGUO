/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghEmpresaAcreditada;
import gob.osinergmin.sibad.domain.builder.EmpresaAcreditadaBuilder;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.service.dao.EmpresaAcreditadaDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
//import gob.osinergmin.sibad.service.dao.RequisitoDAO;
import gob.osinergmin.sibad.service.exception.EmpresaAcreditadaException;

import java.util.ArrayList;
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
@Service("empacredDAO")
public class EmpresaAcreditadaDAOImpl implements EmpresaAcreditadaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(EmpresaAcreditadaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<EmpresaAcreditadaDTO> find(EmpresaAcreditadaFilter filtro) throws EmpresaAcreditadaException {
        List<EmpresaAcreditadaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = EmpresaAcreditadaBuilder.toListEmpresaAcreditadaDto(query.getResultList());

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
    
    private Query getFindQuery(EmpresaAcreditadaFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdAlcanceAcreditacion()!=null){
            	query = crud.getEm().createNamedQuery("PghEmpresaAcreditada.findByAlcance");
            }else{
            	query = crud.getEm().createNamedQuery("PghEmpresaAcreditada.findByFilter");
            }
            
           if(filtro.getIdAlcanceAcreditacion()==null){
                if(filtro.getRuc()!=null && !filtro.getRuc().equals("")){
                    query.setParameter("ruc","%"+filtro.getRuc().toUpperCase()+"%");
                }else{
                    query.setParameter("ruc","%");
                }
                if(filtro.getRazonSocial()!=null && !filtro.getRazonSocial().equals("")){
                    query.setParameter("razonSocial","%"+filtro.getRazonSocial().toUpperCase()+"%");
                }else{
                    query.setParameter("razonSocial","%");
                }
                if(filtro.getDireccion()!=null && !filtro.getDireccion().equals("")){
                    query.setParameter("direccion","%"+filtro.getDireccion().toUpperCase()+"%");
                }else{
                    query.setParameter("direccion","%");
                }
                if(filtro.getDepartamento()!=null && !filtro.getDepartamento().equals("")){
                    query.setParameter("departamento","%"+filtro.getDepartamento().toUpperCase()+"%");
                }else{
                    query.setParameter("departamento","%");
                }
                if(filtro.getProvincia()!=null && !filtro.getProvincia().equals("")){
                    query.setParameter("provincia","%"+filtro.getProvincia().toUpperCase()+"%");
                }else{
                    query.setParameter("provincia","%");
                }
                if(filtro.getDistrito()!=null && !filtro.getDistrito().equals("")){
                    query.setParameter("distrito","%"+filtro.getDistrito().toUpperCase()+"%");
                }else{
                    query.setParameter("distrito","%");
                }
                if(filtro.getTelefono()!=null && !filtro.getTelefono().equals("")){
                    query.setParameter("telefono","%"+filtro.getTelefono().toUpperCase()+"%");
                }else{
                    query.setParameter("telefono","%");
                }
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
