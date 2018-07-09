/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghDocumentoAdjunto;
import gob.osinergmin.sibad.domain.PghSedeAcreditacion;
import gob.osinergmin.sibad.domain.PghSedePersonalAutorizado;
import gob.osinergmin.sibad.domain.PghSedePersonalAutorizadoV;
import gob.osinergmin.sibad.domain.builder.DocumentoAdjuntoBuilder;
import gob.osinergmin.sibad.domain.builder.SedeAcreditacionBuilder;
import gob.osinergmin.sibad.domain.builder.SedePersonalAutorizadoBuilder;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedePersonalAutorizadoFilter;
import gob.osinergmin.sibad.service.dao.SedePersonalAutorizadoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.DocumentoAdjuntoException;
import gob.osinergmin.sibad.service.exception.SedePersonalAutorizadoException;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
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
@Repository("SedePersonalAutorizadoDAO")
@Transactional
public class SedePersonalAutorizadoDAOImpl implements SedePersonalAutorizadoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(SedePersonalAutorizadoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<SedePersonalAutorizadoDTO> find(SedePersonalAutorizadoFilter filtro) throws SedePersonalAutorizadoException {
        List<SedePersonalAutorizadoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = SedePersonalAutorizadoBuilder.toListSedePersonalAutorizadoDto(query.getResultList());

        return listado;
    }
    
    @Override
	public SedePersonalAutorizadoDTO update(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO, UsuarioDTO usuarioDTO)throws SedePersonalAutorizadoException {
		
	LOG.info("Iniciando actualizacion de SedePersonalAutorizado");
		
	SedePersonalAutorizadoDTO retorno = null;
		
		try {
			
			PghSedePersonalAutorizado PghSedePersonalAutorizado = crud.find(sedePersonalAutorizadoDTO.getIdSedePersonalAutorizado(), PghSedePersonalAutorizado.class);
			
			PghSedePersonalAutorizado.setIdSedePersonalAutorizado(sedePersonalAutorizadoDTO.getIdSedePersonalAutorizado());
			PghSedePersonalAutorizado.setIdCargo(sedePersonalAutorizadoDTO.getIdCargo());
			PghSedePersonalAutorizado.setIdEspecialidad(sedePersonalAutorizadoDTO.getIdEspecialidad());
			PghSedePersonalAutorizado.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+PghSedePersonalAutorizado.getIdSedePersonalAutorizado()+" - " +PghSedePersonalAutorizado.getIdCargo()+" - " +PghSedePersonalAutorizado.getIdEspecialidad());
			
			crud.update(PghSedePersonalAutorizado);
			
			retorno = SedePersonalAutorizadoBuilder.toSedePersonalADTO(PghSedePersonalAutorizado);
			 
			LOG.info("(Edicion exitosa) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
    
    private Query getFindQuery(SedePersonalAutorizadoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdSedePersonalAutorizado()!=null){
            	query = crud.getEm().createNamedQuery("PghSedePersonalAutorizadoV.findBySede");
            }else{
            	query = crud.getEm().createNamedQuery("PghSedePersonalAutorizadoV.findByFilter");
            }
            
            if(filtro.getIdSedePersonalAutorizado()==null){
            	
            	if(filtro.getIdAlcanceAcreditacion()!=null && filtro.getIdAlcanceAcreditacion()!=null){
                    query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
                }else{
                    query.setParameter("idAlcanceAcreditacion","%");
                }
            	
            	if(filtro.getFlagPersonalAutorizado()!=null && filtro.getFlagPersonalAutorizado()!=null){
                    query.setParameter("flagPersonalAutorizado",filtro.getFlagPersonalAutorizado());
                }else{
                    query.setParameter("flagPersonalAutorizado","%");
                }
            	
            	if(filtro.getNumeroDocumento()!=null && filtro.getNumeroDocumento()!=null){
                    query.setParameter("numeroDocumento",filtro.getNumeroDocumento());
                }else{
                    query.setParameter("numeroDocumento","%");
                }
            	/*if(filtro.getFlagPersonalAutorizado()!=null && !filtro.getFlagPersonalAutorizado().equals("")){
                    
                }else{
                    
                }*/
                
            }else{
                query.setParameter("idSedePersonalAutorizado",filtro.getIdSedePersonalAutorizado());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public SedePersonalAutorizadoDTO create(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO, UsuarioDTO usuarioDTO)throws SedePersonalAutorizadoException {
		
		LOG.info("Iniciando registro de Sede Personal Autorizado");
		
		SedePersonalAutorizadoDTO retorno = null;
		
		try {
			
			PghSedePersonalAutorizado pghSedePersonalAutorizado = new PghSedePersonalAutorizado();
			
			pghSedePersonalAutorizado.setIdSedePersonalAutorizado(sedePersonalAutorizadoDTO.getIdSedePersonalAutorizado());
			pghSedePersonalAutorizado.setFlagSedePersonalAutorizado(sedePersonalAutorizadoDTO.getFlagSedePersonalAutorizado());
			pghSedePersonalAutorizado.setIdSedeAcreditacion(sedePersonalAutorizadoDTO.getIdSedeAcreditacion());
			pghSedePersonalAutorizado.setIdPersonaNatural(sedePersonalAutorizadoDTO.getIdPersonaNatural());
			pghSedePersonalAutorizado.setIdCargo(sedePersonalAutorizadoDTO.getIdCargo());
			pghSedePersonalAutorizado.setIdEspecialidad(sedePersonalAutorizadoDTO.getIdEspecialidad());
			pghSedePersonalAutorizado.setDatosAuditoria(usuarioDTO);
			
            LOG.info(" Datos:"+pghSedePersonalAutorizado.getIdSedePersonalAutorizado()+" - " +pghSedePersonalAutorizado.getFlagSedePersonalAutorizado()+" - " +pghSedePersonalAutorizado.getIdSedeAcreditacion()+" - " +pghSedePersonalAutorizado.getIdPersonaNatural()+" - " +pghSedePersonalAutorizado.getIdCargo()+" - " +pghSedePersonalAutorizado.getIdEspecialidad());
			
			crud.create(pghSedePersonalAutorizado);
			
			retorno = SedePersonalAutorizadoBuilder.toSedePersonalAutoDto(pghSedePersonalAutorizado);
			 
			LOG.info("(IdSPJ) retorno: "+retorno.getIdSedePersonalAutorizado());
			
		
		}catch(Exception ex){
            
			LOG.error("",ex);
        }
		
		
		return retorno;
	}
    
	@Override
	public SedePersonalAutorizadoDTO eliminarSedePersonal(SedePersonalAutorizadoDTO personalAutorizadoDTO) throws SedePersonalAutorizadoException {
		LOG.info("eliminarSedePersonal DAO IMPL- ID = "+ personalAutorizadoDTO.getIdSedePersonalAutorizado());
		SedePersonalAutorizadoDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ personalAutorizadoDTO.getIdSedePersonalAutorizado());
			//Map<String, Object> valida= validaEliminarPersonalAutorizado(personalAutorizadoDTO.getIdSedePersonalAutorizado());
			PghSedePersonalAutorizado registroDTO = crud.find(personalAutorizadoDTO.getIdSedePersonalAutorizado(), PghSedePersonalAutorizado.class);
			LOG.info("llena registroDTO= "+ registroDTO.getIdSedePersonalAutorizado());
			crud.delete(registroDTO);
			retorno = SedePersonalAutorizadoBuilder.toSedePersonalAutoDto(registroDTO);
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}
	
	public Map<String, Object> validaEliminarPersonalAutorizado(Long id){
        LOG.info("procesando validaEliminarPersonalAutorizado");
        LOG.info("ID personal autorizado: " + id);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que la etapa no tenga un hijo-Tramite
            if(rpta.equals("1")){
                hql="select t from PghSedePersonalAutorizado t where t.idSedePersonalAutorizado =:idSedePersonalAutorizado ";
                query = crud.getEm().createQuery(hql);
                //query.setParameter("estado", gob.osinergmin.sibad.util.Constantes.CONSTANTE_ESTADO_ACTIVO);
                query.setParameter("idSedePersonalAutorizado", id);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede EliminarPersonalAutorizado";
                }
            }
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarPersonalAutorizado ",ex);
        }
        return retorno;
    }
}
