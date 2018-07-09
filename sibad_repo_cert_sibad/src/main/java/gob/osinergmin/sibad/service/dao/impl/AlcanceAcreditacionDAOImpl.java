package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gob.osinergmin.sibad.domain.PghAlcanceAcreditacion;
import gob.osinergmin.sibad.domain.builder.AlcanceAcreditacionBuilder;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.service.dao.AlcanceAcreditacionDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.AlcanceAcreditacionException;

@Repository("AlcanceAcreditacionDAO")
@Transactional

public class AlcanceAcreditacionDAOImpl implements AlcanceAcreditacionDAO{
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
	
	private Query getFindQuery(AlcanceAcreditacionFilter filtro) {
        Query query=null;
        try{
            if(filtro.getEstado()!=null){
            	query = crud.getEm().createNamedQuery("PghAlcanceAcreditacion.findByAlcanceVigente");
            }else{
            	if(filtro.getIdAlcanceAcreditacion()!=null) {
            		query = crud.getEm().createNamedQuery("PghAlcanceAcreditacion.findByIdAlcanceAcreditacion");
            	}else {
	            	if(filtro.getIdEmpresaAcreditada()!=null){
	            		query = crud.getEm().createNamedQuery("PghAlcanceAcreditacion.findByPrimerAlcance");
	        		}else {
	        			query = crud.getEm().createNamedQuery("PghAlcanceAcreditacion.findByFechaV");
	        		}
            	}
            }
            
           if(filtro.getEstado()==null){
        	   
        	   if(filtro.getIdAlcanceAcreditacion()==null){
        		   
	        	   if(filtro.getIdEmpresaAcreditada()==null){
	        		   
	        		   	if(filtro.getFechaVencimiento()!=null){
	            		   query.setParameter("fechaVencimiento",filtro.getFechaVencimiento());
	                    }else{
	                    	query.setParameter("fechaVencimiento","");
	                    }
	        		   	
	                }else{
	                	query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
	                }
	        	   
        	   }else {
        		   
        		   query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
        	   }
        	   
            }else{
            	query.setParameter("estado",filtro.getEstado());
     		   query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
                query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }
	
	@Override
	public AlcanceAcreditacionDTO update(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO)throws AlcanceAcreditacionException {
		
	LOG.info("Iniciando actualizacion de Alcance Acreditacion");
		
	AlcanceAcreditacionDTO retorno = null;
		
		
		try {
			
			PghAlcanceAcreditacion PghAlcanceAcreditacion = crud.find(alcanceAcreditacionDTO.getIdAlcanceAcreditacion(), PghAlcanceAcreditacion.class);
			
			PghAlcanceAcreditacion.setIdAlcanceAcreditacion(alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
			PghAlcanceAcreditacion.setEstado(alcanceAcreditacionDTO.getEstado());
			PghAlcanceAcreditacion.setEstadoAccion(alcanceAcreditacionDTO.getEstadoAccion());
			PghAlcanceAcreditacion.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+PghAlcanceAcreditacion.getIdAlcanceAcreditacion()+" - " +PghAlcanceAcreditacion.getEstado()+" - " +PghAlcanceAcreditacion.getEstadoAccion());
			
			crud.update(PghAlcanceAcreditacion);
			
			retorno = AlcanceAcreditacionBuilder.toAlcanceAcreditacionDTO(PghAlcanceAcreditacion);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
	
	@Override
	public AlcanceAcreditacionDTO update2(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO)throws AlcanceAcreditacionException {
		
	LOG.info("Iniciando actualizacion de Alcance Acreditacion");
		
	AlcanceAcreditacionDTO retorno = null;
		
		try {
			
			PghAlcanceAcreditacion PghAlcanceAcreditacion = crud.find(alcanceAcreditacionDTO.getIdAlcanceAcreditacion(), PghAlcanceAcreditacion.class);
			
			PghAlcanceAcreditacion.setIdAlcanceAcreditacion(alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
			PghAlcanceAcreditacion.setEstado(alcanceAcreditacionDTO.getEstado());
			PghAlcanceAcreditacion.setEstadoAccion(alcanceAcreditacionDTO.getEstadoAccion());
			PghAlcanceAcreditacion.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+PghAlcanceAcreditacion.getIdAlcanceAcreditacion()+" - " +PghAlcanceAcreditacion.getEstado()+" - " +PghAlcanceAcreditacion.getEstadoAccion());
			
			crud.update(PghAlcanceAcreditacion);
			
			retorno = AlcanceAcreditacionBuilder.toAlcanceAcreditacionDTO(PghAlcanceAcreditacion);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}


	@Override
	public AlcanceAcreditacionDTO create(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO)throws AlcanceAcreditacionException {
		
		LOG.info("Iniciando registro de Alcance Acreditacion");
		
		AlcanceAcreditacionDTO retorno = null;
		
		try {
			
			PghAlcanceAcreditacion pghAlcanceAcreditacion = new PghAlcanceAcreditacion();
			
			pghAlcanceAcreditacion.setIdAlcanceAcreditacion(alcanceAcreditacionDTO.getIdAlcanceAcreditacion());  
			pghAlcanceAcreditacion.setIdEmpresaAcreditada(alcanceAcreditacionDTO.getIdEmpresaAcreditada());      
			pghAlcanceAcreditacion.setIdTipoPrueba(alcanceAcreditacionDTO.getIdTipoPrueba());
			pghAlcanceAcreditacion.setIdOrganismoAcreditador(alcanceAcreditacionDTO.getIdOrganismoAcreditador());
			pghAlcanceAcreditacion.setResolucionCedula(alcanceAcreditacionDTO.getResolucionCedula());
			pghAlcanceAcreditacion.setIdPrimerAlcanceAcreditacion(alcanceAcreditacionDTO.getIdPrimerAlcanceAcreditacion());
			pghAlcanceAcreditacion.setIdDocumentoAdjunto(alcanceAcreditacionDTO.getIdDocumentoAdjunto());
			pghAlcanceAcreditacion.setIdDocumentoAlcanceAcreditada(alcanceAcreditacionDTO.getIdDocumentoAlcanceAcreditada());
			pghAlcanceAcreditacion.setIdTipoOrganismo(alcanceAcreditacionDTO.getIdTipoOrganismo());
			pghAlcanceAcreditacion.setNormaEvualada(alcanceAcreditacionDTO.getNormaEvualada());
			pghAlcanceAcreditacion.setFechaAcreditacion(alcanceAcreditacionDTO.getFechaAcreditacion());
			pghAlcanceAcreditacion.setFechaUltimaActualizacion(alcanceAcreditacionDTO.getFechaUltimaActualizacion());
			pghAlcanceAcreditacion.setFechaInicioVigencia(alcanceAcreditacionDTO.getFechaInicioVigencia());
			pghAlcanceAcreditacion.setFechaVencimiento(alcanceAcreditacionDTO.getFechaVencimiento());
			pghAlcanceAcreditacion.setEstado(alcanceAcreditacionDTO.getEstado());
			pghAlcanceAcreditacion.setEstadoAccion(alcanceAcreditacionDTO.getEstadoAccion());
			pghAlcanceAcreditacion.setDatosAuditoria(usuarioDTO);
			
			 if(alcanceAcreditacionDTO.getIdAlcanceAcreditacion() != null ){
				 
				 crud.update(pghAlcanceAcreditacion);
				 
			 } else {
				 
				 crud.create(pghAlcanceAcreditacion);
				 
			 }
           
			
			retorno = AlcanceAcreditacionBuilder.toRegistrarAlcanceAcreditacion(pghAlcanceAcreditacion);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.getIdAlcanceAcreditacion());
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}

}
