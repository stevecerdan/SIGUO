/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghAlcanceAcreditacion;
import gob.osinergmin.sibad.domain.PghEquipoCertificado;
import gob.osinergmin.sibad.domain.PghEquipoComponente;
import gob.osinergmin.sibad.domain.PghSedePersonalAutorizado;
import gob.osinergmin.sibad.domain.builder.EquipoCertificadoBuilder;
import gob.osinergmin.sibad.domain.builder.EquipoComponenteBuilder;
import gob.osinergmin.sibad.domain.builder.SedePersonalAutorizadoBuilder;
import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.EquipoCertificadoDAO;
import gob.osinergmin.sibad.service.exception.EquipoCertificadoException;
import gob.osinergmin.sibad.service.exception.EquipoComponenteException;
import gob.osinergmin.sibad.service.exception.SedePersonalAutorizadoException;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
//@Service("empacredDAO")
@Repository("EquipoCertificadoDAO")
@Transactional
public class EquipoCertificadoDAOImpl implements EquipoCertificadoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(EquipoCertificadoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<EquipoCertificadoDTO> find(EquipoCertificadoFilter filtro) throws EquipoCertificadoException {
        List<EquipoCertificadoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = EquipoCertificadoBuilder.toListEquipoCertificadoDto(query.getResultList());

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
    
    private Query getFindQuery(EquipoCertificadoFilter filtro) {
        Query query=null;
        try{
        	
        	if(filtro.getIdEquipoCertificado()!=null){
            	query = crud.getEm().createNamedQuery("PghEquipoCertificadoV.findByEquipo");  
        	}else {
        		if(filtro.getIdAlcanceAcreditacion()!=null){
        			query = crud.getEm().createNamedQuery("PghEquipoCertificadoV.findByFilterA");
        		}else {
        			query = crud.getEm().createNamedQuery("PghEquipoCertificadoV.findByFechaPC");
        		}
            }
            
            if(filtro.getIdEquipoCertificado()==null){
            	
                if(filtro.getIdAlcanceAcreditacion()==null){
                    
                    if(filtro.getFechaProximaCalibracion()!=null){
                        query.setParameter("fechaProximaCalibracion",filtro.getFechaProximaCalibracion());
                    }else{
                        query.setParameter("fechaProximaCalibracion","");
                    }
                    
                }else{
                	query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
                }
                
            }else{
                query.setParameter("idEquipoCertificado",filtro.getIdEquipoCertificado());
            }
            
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public EquipoCertificadoDTO create(EquipoCertificadoDTO equipocertificadoDTO, UsuarioDTO usuarioDTO) {
		 LOG.info("Iniciando registro de Empresa Acreditada");
			
		 EquipoCertificadoDTO retorno=null;
		 
		 try {
			 PghEquipoCertificado pghEquipoCertificado = new PghEquipoCertificado();
			 
			 pghEquipoCertificado.setIdEquipoCertificado(equipocertificadoDTO.getIdEquipoCertificado());
			 pghEquipoCertificado.setIdAlcanceAcreditacion(equipocertificadoDTO.getIdAlcanceAcreditacion());
			 pghEquipoCertificado.setIdTipoEquipo(equipocertificadoDTO.getIdTipoEquipo());
			 pghEquipoCertificado.setSerie(equipocertificadoDTO.getSerie());
			 pghEquipoCertificado.setModelo(equipocertificadoDTO.getModelo());
			 pghEquipoCertificado.setMarca(equipocertificadoDTO.getMarca());
			 pghEquipoCertificado.setFechaCalibracion(equipocertificadoDTO.getFechaCalibracion());
			 pghEquipoCertificado.setFechaProxCalibracion(equipocertificadoDTO.getFechaProximaCalibracion());
			 pghEquipoCertificado.setDatoAdicional(equipocertificadoDTO.getOtroDato());
			 pghEquipoCertificado.setDescripcion(equipocertificadoDTO.getDescripcionEquipo());
			 pghEquipoCertificado.setEstado(equipocertificadoDTO.getEstado());
			 pghEquipoCertificado.setIdTipoMotivo(equipocertificadoDTO.getIdTipoMotivo());
			 pghEquipoCertificado.setObservacion(equipocertificadoDTO.getObservacion());
			 pghEquipoCertificado.setDatosAuditoria(usuarioDTO);
			 
			 LOG.info(" Datos:"+pghEquipoCertificado.getEstado()+" - " +pghEquipoCertificado.getIdEquipoCertificado() +" - " +
					 pghEquipoCertificado.getIdTipoEquipo() +" - " + pghEquipoCertificado.getMarca() +" - " + pghEquipoCertificado.getIdTipoMotivo() +" - " + pghEquipoCertificado.getObservacion());
			 
			 if(equipocertificadoDTO.getIdEquipoCertificado() != null){
	                crud.update(pghEquipoCertificado);
	                LOG.info("Actualizacion: " +pghEquipoCertificado.getEstado()+" - " +pghEquipoCertificado.getIdEquipoCertificado() +" - " +
	   					 pghEquipoCertificado.getIdTipoEquipo() +" - " + pghEquipoCertificado.getMarca() +" - " + pghEquipoCertificado.getIdTipoMotivo() +" - " + pghEquipoCertificado.getObservacion());
	            }else{
	                crud.create(pghEquipoCertificado);
	                LOG.info("Creacion: " +pghEquipoCertificado.getEstado()+" - " +pghEquipoCertificado.getIdEquipoCertificado() +" - " +
	   					 pghEquipoCertificado.getIdTipoEquipo() +" - " + pghEquipoCertificado.getMarca() +" - " + pghEquipoCertificado.getIdTipoMotivo() +" - " + pghEquipoCertificado.getObservacion());
	            }
			 
			 
			retorno = EquipoCertificadoBuilder.toEquipoCertificadoDto(pghEquipoCertificado); 
			LOG.info("(Operacion exitosa) retorno: "+retorno.toString());
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}
	
	//--------------------------------------------
	
	@Override
	public EquipoCertificadoDTO updateEstado(EquipoCertificadoDTO equipocertificadoDTO, UsuarioDTO usuarioDTO) {
		 LOG.info("Iniciando cambio de estado de Equipo Certificado");
			
		 EquipoCertificadoDTO retorno=null;
		 
		 try {
			 //PghEquipoCertificado pghEquipoCertificado = new PghEquipoCertificado();
			 PghEquipoCertificado pghEquipoCertificado = crud.find(equipocertificadoDTO.getIdEquipoCertificado(), PghEquipoCertificado.class);
			 
			 pghEquipoCertificado.setIdEquipoCertificado(equipocertificadoDTO.getIdEquipoCertificado());
			 pghEquipoCertificado.setEstado(equipocertificadoDTO.getEstado());
			 pghEquipoCertificado.setIdTipoMotivo(equipocertificadoDTO.getIdTipoMotivo());
			 pghEquipoCertificado.setObservacion(equipocertificadoDTO.getObservacion());
			 pghEquipoCertificado.setDatosAuditoria(usuarioDTO);
			 
			 
			 LOG.info(" Datos:"+pghEquipoCertificado.getEstado()+" - " +pghEquipoCertificado.getIdEquipoCertificado() +" - " +
					 pghEquipoCertificado.getIdTipoMotivo() +" - " + pghEquipoCertificado.getObservacion());
			 
			 if(equipocertificadoDTO.getIdEquipoCertificado() != null){
	                crud.update(pghEquipoCertificado);
	                
	                LOG.info("Actualizacion: " +pghEquipoCertificado.getEstado()+" - " +pghEquipoCertificado.getIdEquipoCertificado() +" - " +
	   					 pghEquipoCertificado.getIdTipoMotivo() +" - " + pghEquipoCertificado.getObservacion());
	            }
			 
			 
			retorno = EquipoCertificadoBuilder.toEquipoCertificadoDtto(pghEquipoCertificado); 
			LOG.info("(Operacion exitosa) retorno: "+retorno.toString());
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}
	
	//-------------------------------------------------

	@Override
	public EquipoCertificadoDTO eliminar(EquipoCertificadoDTO equipoCertificadoDTO) throws EquipoCertificadoException {
		LOG.info("eliminar EquipoCertificado DAO Impl" +  equipoCertificadoDTO.getIdEquipoCertificado());
		EquipoCertificadoDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ equipoCertificadoDTO.getIdEquipoCertificado());
			PghEquipoCertificado registro = crud.find(equipoCertificadoDTO.getIdEquipoCertificado(), PghEquipoCertificado.class);
			LOG.info("encuentra registro = "+ registro.getIdEquipoCertificado());
			crud.delete(registro);
			retorno = EquipoCertificadoBuilder.toEquipoCertificadoDto(registro);
		} catch (Exception e) {
			LOG.info("no se pudo eliminar = " + e.getMessage());
		}
		return retorno;
	}
}
