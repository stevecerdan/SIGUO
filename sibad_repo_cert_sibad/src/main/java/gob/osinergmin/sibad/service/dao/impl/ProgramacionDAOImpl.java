package gob.osinergmin.sibad.service.dao.impl;



import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghProgramacion;
import gob.osinergmin.sibad.domain.PghSedePersonalAutorizado;
import gob.osinergmin.sibad.domain.builder.ProgramacionBuilder;
import gob.osinergmin.sibad.domain.builder.SedePersonalAutorizadoBuilder;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionVDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ProgramacionFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ProgramacionDAO;
import gob.osinergmin.sibad.service.exception.ProgramacionException;

@Repository("ProgramacionDAO")
@Transactional
public class ProgramacionDAOImpl implements ProgramacionDAO {
	private static final Logger LOG = LoggerFactory.getLogger(TrazAlcanceAcredDAOImpl.class);
   
	@Inject
    private CrudDAO crud;

	@Override
	public ProgramacionDTO create(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) throws ProgramacionException {
		
	 LOG.info("Iniciando registro...");
			
	       ProgramacionDTO retorno = null;
			
			try {
				
				PghProgramacion pghProgramacion = new PghProgramacion();
				
				pghProgramacion.setIdProgramacion(programacionDTO.getIdProgramacion());
				pghProgramacion.setIdCompartimiento(programacionDTO.getIdCompartimiento());
				pghProgramacion.setNumeroProgramacion(programacionDTO.getNumeroProgramacion());
				pghProgramacion.setTipoProgramacion(programacionDTO.getTipoProgramacion());
				pghProgramacion.setTipoRevision(programacionDTO.getTipoRevision());
				pghProgramacion.setFechaProgramacion(programacionDTO.getFechaProgramacion());
				pghProgramacion.setEstado(programacionDTO.getEstado());
				pghProgramacion.setDatosAuditoria(usuarioDTO);

				LOG.info(" Datos:"+pghProgramacion.getIdProgramacion()+" - " +pghProgramacion.getIdCompartimiento()+" - " +pghProgramacion.getNumeroProgramacion()+" - " +pghProgramacion.getTipoProgramacion()+" - " +pghProgramacion.getTipoRevision()+" - " +pghProgramacion.getFechaProgramacion()+" - " +pghProgramacion.getEstado());
				LOG.info(" Auditoria:"+pghProgramacion.getUsuarioCreacion()+" - " +pghProgramacion.getFechaCreacion()+" - " +pghProgramacion.getTerminalCreacion());
				crud.create(pghProgramacion);
				
				retorno = ProgramacionBuilder.toProgramacionDto(pghProgramacion);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
				
				
			}catch(Exception ex){
	            LOG.error("",ex);
	        }
			
			return retorno;
	}

	@Override
	public ProgramacionDTO update(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) throws ProgramacionException {
		
		ProgramacionDTO retorno = null;
		
		
		try {
			
			PghProgramacion pghProgramacion = crud.find(programacionDTO.getIdProgramacion(), PghProgramacion.class);
			
			pghProgramacion.setIdProgramacion(programacionDTO.getIdProgramacion());
			pghProgramacion.setEstado(programacionDTO.getEstado());
			pghProgramacion.setDatosAuditoria(usuarioDTO);
			
			if ( programacionDTO.getFechaProgramacion() != null ) 
				pghProgramacion.setFechaProgramacion(programacionDTO.getFechaProgramacion());
			
			LOG.info(" Datos:"+pghProgramacion.getIdProgramacion()+" - " +pghProgramacion.getIdCompartimiento()+" - " +pghProgramacion.getNumeroProgramacion()+" - " +pghProgramacion.getTipoProgramacion()+" - " +pghProgramacion.getTipoRevision()+" - " +pghProgramacion.getFechaProgramacion()+" - " +pghProgramacion.getEstado());
			
			crud.update(pghProgramacion);
			
			retorno = ProgramacionBuilder.toProgramacionDto(pghProgramacion);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}


	@Override
	public List<ProgramacionVDTO> findV(ProgramacionFilter filtro) throws ProgramacionException {
		
        List<ProgramacionVDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = ProgramacionBuilder.toListCompartimientoDto(query.getResultList());

        return listado;
	}
		
    private Query getFindQuery(ProgramacionFilter filtro) {
		
        Query query=null;
        try{
            if(filtro.getIdUnidadSupervisada()!=null && filtro.getIdUnidadSupervisada()!= 0){
            	
            	LOG.info("1..."+filtro.getIdUnidadSupervisada());
            		query = crud.getEm().createNamedQuery("PghCompartimientoV.findAllIdUnidadSupervisada");
            
            } else if (filtro.getTipoRevision()!=null && !filtro.getTipoRevision().equals("") || filtro.getNumeroProgramacion()!=null && !filtro.getNumeroProgramacion().equals("")|| filtro.getEstado()!=null && !filtro.getEstado().equals("")){
            	
            		query = crud.getEm().createNamedQuery("PghCompartimientoV.findByFilter");
            
            } else if(filtro.getUnidadAlmacenamiento()!=null && filtro.getUnidadAlmacenamiento()!= 0){
            	
            		query = crud.getEm().createNamedQuery("PghCompartimientoV.findByFilterUnidadAlmacenamiento");
            }
         
            if(filtro.getIdUnidadSupervisada()!=null && filtro.getIdUnidadSupervisada()!= 0){
            	
	            	if(filtro.getIdUnidadSupervisada()!=null && filtro.getIdUnidadSupervisada()!= 0) {
		 	            LOG.info("entro2..."+filtro.getIdUnidadSupervisada());
		 	            query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
		            } 
            	
            } else if(filtro.getTipoRevision()!=null && !filtro.getTipoRevision().equals("") || filtro.getNumeroProgramacion()!=null && !filtro.getNumeroProgramacion().equals("")|| filtro.getEstado()!=null && !filtro.getEstado().equals("")) {
            	
		           if(filtro.getTipoRevision()!=null && !filtro.getTipoRevision().equals("")){
		            	LOG.info("motivo"+filtro.getTipoRevision());
		                query.setParameter("tipoRevision","%"+filtro.getTipoRevision().toUpperCase()+"%");
		            }else{
		                query.setParameter("tipoRevision","%");
		            }
		            
		           if(filtro.getNumeroProgramacion()!=null && !filtro.getNumeroProgramacion().equals("")){
		                query.setParameter("numeroProgramacion","%"+filtro.getNumeroProgramacion().toUpperCase()+"%");
		            }else{
		                query.setParameter("numeroProgramacion","%");
		            }
		            
		            if(filtro.getEstado()!=null && !filtro.getEstado().equals("")){
		                query.setParameter("estado","%"+filtro.getEstado().toUpperCase()+"%");
		            }else{
		                query.setParameter("estado","%");
		            }
            
	            
            } else {
            	
            	if(filtro.getUnidadAlmacenamiento()!=null && filtro.getUnidadAlmacenamiento()!= 0){
	            	LOG.info("unidad Almacenamiento"+filtro.getUnidadAlmacenamiento());
	                query.setParameter("unidadAlmacenamiento",filtro.getUnidadAlmacenamiento());
	            }
            	
            }
            
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());           
        }
        return query;
    }

	@Override
	public ProgramacionDTO delete(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) throws ProgramacionException {
		
		LOG.info("eliminarProgramacion DAO IMPL- ID = "+ programacionDTO.getIdProgramacion());
		ProgramacionDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ programacionDTO.getIdProgramacion());
			PghProgramacion registroDTO = crud.find(programacionDTO.getIdProgramacion(), PghProgramacion.class);
			LOG.info("llena registroDTO= "+ programacionDTO.getIdProgramacion());
			crud.delete(registroDTO);
			retorno = ProgramacionBuilder.toProgramacionDto(registroDTO);
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}

	@Override
	public List<ProgramacionVDTO> findProgramacionesVencidas(ProgramacionFilter filtro) throws ProgramacionException {
        
		List<ProgramacionVDTO> listado;
        
        Query query = getFindQueryProgramacionesVencidas(filtro);
        listado = ProgramacionBuilder.toListCompartimientoDto(query.getResultList());

        return listado;
	}
	
    private Query getFindQueryProgramacionesVencidas(ProgramacionFilter filtro) {
		
        Query query=null;
        try{
            if(filtro.getIdUnidadSupervisada()!=null && filtro.getFechaActual()!=null){
            	
            	LOG.info("1..."+filtro.getIdUnidadSupervisada());
            		query = crud.getEm().createNamedQuery("PghCompartimientoV.findProgramacionesVencidas");
            
            } 
         
            if(filtro.getIdUnidadSupervisada()!=null && filtro.getFechaActual()!=null){

 	            LOG.info("entro2..."+filtro.getIdUnidadSupervisada());
 	            LOG.info("entro2..."+filtro.getFechaActual());
 	            query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
 	            query.setParameter("fechaActual",filtro.getFechaActual());
		             
            } 
            
            
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());           
        }
        return query;
    }

    
}
