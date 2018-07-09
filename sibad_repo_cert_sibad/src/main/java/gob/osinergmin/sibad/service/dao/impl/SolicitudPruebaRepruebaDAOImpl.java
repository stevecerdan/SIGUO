/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghSolicitudPruebaReprueba;
import gob.osinergmin.sibad.domain.builder.SolicitudPruebaRepruebaBuilder;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.dao.SolicitudPruebaRepruebaDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.SolicitudPruebaRepruebaException;

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
@Repository("SolicitudPruebaRepruebaDAO")
@Transactional
public class SolicitudPruebaRepruebaDAOImpl implements SolicitudPruebaRepruebaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(SolicitudPruebaRepruebaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<SolicitudPruebaRepruebaDTO> find(SolicitudPruebaRepruebaFilter filtro) throws SolicitudPruebaRepruebaException {
        List<SolicitudPruebaRepruebaDTO> listado;
        
        Query query = getFindQuery(filtro);
        
        LOG.info(query.toString());
        
        listado = SolicitudPruebaRepruebaBuilder.toListSolicitudPruebaRepruebaDto(query.getResultList());

        return listado;
    }
    
  //UITLIZADO CON FIND
    private Query getFindQuery(SolicitudPruebaRepruebaFilter filtro) {
        Query query=null;
        try{
        	if(filtro.getFlagInformeIndiceRiesgo()!=null && !filtro.getFlagInformeIndiceRiesgo().equals("")){
        		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySolicitudFilterNoInfo");
        	} else {
        		if(filtro.getNumeroTanque()!=null && !filtro.getNumeroTanque().equals("")){
            		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findByUltimoRESNI");
            	} else {
            		if(filtro.getNumeroCompartimiento()!=null){
                		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findByUltimoRESNC");
                	} else {
                		if(filtro.getIdEmpresaAcreditada()!=null){
                    		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySolicitudFilterCompXEmp");
                    	} else {
            	        	if(filtro.getTipoPrueba()!=null){
            	        		if(filtro.getEstado().equals("P")){
            	            		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySolicitudFilterPEND");	
            	            	} else {
            	            		if(filtro.getEstado().equals("F")){
            	                		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySolicitudFilterATEND");	
            	                	}
            	            	}
            	        	} else {
            		            if(filtro.getIdTipoPrueba()!=null){
            		            	query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findByUltimoSOL");
            		            }else{
            		            	if(filtro.getResultadoPrueba()!=null && !filtro.getResultadoPrueba().equals("")){
            		            		LOG.info("BUSCARA POR RESULTADO DE PRUEBA "+filtro.getResultadoPrueba());
            		            		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySoloResultado");	
            		            	} else {
            		            		if(filtro.getFechaProxPrueba()!=null){
                		            		LOG.info("BUSCARA POR FECHA PROX. PRUEBA --> "+filtro.getFechaProxPrueba());
            		                		query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findByFechaProximaPrueba");
                		            	} else {
                		            		if(filtro.getIdUnidSupervTanque() != null){
                		            			query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySolicitudFilter");        		
                		                	}else{
    											query = crud.getEm().createNamedQuery("PghSolicitudPruebaRepruebaV.findBySolicitudFilter2");	
    										}	
                		            	}	
            		            	}
            		            }
            	            }
                    	}
                	}
            	}
        	}
        	
        	if(filtro.getFlagInformeIndiceRiesgo()==null || filtro.getFlagInformeIndiceRiesgo().equals("")){
        		
        		if(filtro.getNumeroTanque()==null || filtro.getNumeroTanque().equals("")){
            		
            		if(filtro.getNumeroCompartimiento()==null){
                		
                		if(filtro.getIdEmpresaAcreditada()==null){
                    		
            	        	if(filtro.getTipoPrueba()==null){
            	        		
            		           if(filtro.getIdTipoPrueba()==null){
            		        	   
            		        	   if(filtro.getResultadoPrueba()==null || filtro.getResultadoPrueba().equals("")){
            		        		   
            		        		   if(filtro.getFechaProxPrueba()==null || filtro.getFechaProxPrueba().equals("")){
                		        		   
            		        			   if(filtro.getIdUnidSupervTanque()==null){
                    		        		   
                    		        		   if(filtro.getIdUnidSupervModulo()!=null){
                    				                query.setParameter("idUnidSupervModulo",filtro.getIdUnidSupervModulo());
                    				            }else{
                    				                query.setParameter("idUnidSupervModulo","");
                    				            }
                    			        		   
                    				            if(filtro.getNroSolicitudUnidadSupervisa()!=null && !filtro.getNroSolicitudUnidadSupervisa().equals("")){
                    				                query.setParameter("nroSolicitudUnidadSupervisa","%"+filtro.getNroSolicitudUnidadSupervisa().toUpperCase()+"%");
                    				            }else{
                    				                query.setParameter("nroSolicitudUnidadSupervisa","%");
                    				            }
                    				            if(filtro.getEmpresaAcreditada()!=null && !filtro.getEmpresaAcreditada().equals("")){
                    				                query.setParameter("empresaAcreditada","%"+filtro.getEmpresaAcreditada().toUpperCase()+"%");
                    				            }else{
                    				                query.setParameter("empresaAcreditada","%");
                    				            }
                    				            if(filtro.getEstado()!=null && !filtro.getEstado().equals("")){
                    				            	
                    				                query.setParameter("estado",filtro.getEstado());
                    				            }else{
                    				                query.setParameter("estado","%");
                    				            }
                    		        	   } else { 
                    			        	   if(filtro.getIdUnidSupervTanque()!=null){
                    				                query.setParameter("idUnidSupervTanque",filtro.getIdUnidSupervTanque());
                    				            }else{
                    				                query.setParameter("idUnidSupervTanque","");
                    				            }
                    			        		   
                    				            if(filtro.getNroSolicitudUnidadSupervisa()!=null && !filtro.getNroSolicitudUnidadSupervisa().equals("")){
                    				                query.setParameter("nroSolicitudUnidadSupervisa","%"+filtro.getNroSolicitudUnidadSupervisa().toUpperCase()+"%");
                    				            }else{
                    				                query.setParameter("nroSolicitudUnidadSupervisa","%");
                    				            }
                    				            if(filtro.getEmpresaAcreditada()!=null && !filtro.getEmpresaAcreditada().equals("")){
                    				                query.setParameter("empresaAcreditada","%"+filtro.getEmpresaAcreditada().toUpperCase()+"%");
                    				            }else{
                    				                query.setParameter("empresaAcreditada","%");
                    				            }
                    				            if(filtro.getEstado()!=null && !filtro.getEstado().equals("")){
                    				            	
                    				                query.setParameter("estado",filtro.getEstado());
                    				            }else{
                    				                query.setParameter("estado","%");
                    				            }
                    		        	   	}
                		        	   } else { 
                		        		   query.setParameter("fechaProxPrueba",filtro.getFechaProxPrueba());
                		        	   	}
            		        	   } else {
            		        		   
            		        		   query.setParameter("resultadoPrueba",filtro.getResultadoPrueba());
            		        		   query.setParameter("idUnidSupervTanque",filtro.getIdUnidSupervTanque());
            		        	   	}
            		            }else{
            		                query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
            		            	query.setParameter("idUnidSupervTanque",filtro.getIdUnidSupervTanque());
            		            	query.setParameter("idUnidSupervModulo",filtro.getIdUnidSupervModulo());
            		            }
            	        }else{
            	        	
            	        	query.setParameter("estado",filtro.getEstado());
            	            query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
            	            
            	            if(filtro.getNroSolicitudUnidadSupervisa()!=null && !filtro.getNroSolicitudUnidadSupervisa().equals("")){
            	                query.setParameter("nroSolicitudUnidadSupervisa","%"+filtro.getNroSolicitudUnidadSupervisa().toUpperCase()+"%");
            	            }else{
            	                query.setParameter("nroSolicitudUnidadSupervisa","%");
            	            }
            	            if(filtro.getEmpresaAcreditada()!=null && !filtro.getEmpresaAcreditada().equals("")){
            	                query.setParameter("empresaAcreditada","%"+filtro.getEmpresaAcreditada().toUpperCase()+"%");
            	            }else{
            	                query.setParameter("empresaAcreditada","%");
            	            }
            	        }
            	        	
                    }else{
                    	query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
                        query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
                    }
        	        	
                }else{
                	query.setParameter("resultadoPrueba",filtro.getResultadoPrueba());
                    query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
                }
    	        	
            }else{
            	//query.setParameter("resultadoPrueba",filtro.getResultadoPrueba());
                query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
            }
	        	
        }else{
        	query.setParameter("flagInformeIndiceRiesgo",filtro.getFlagInformeIndiceRiesgo());
        }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }  
    
    @Override
	public SolicitudPruebaRepruebaDTO create(SolicitudPruebaRepruebaDTO solicitudPruebaRepruebaDTO, UsuarioDTO usuarioDTO) throws SolicitudPruebaRepruebaException {
		
        LOG.info("Iniciando registro de Solicitud Prueba Reprueba");
		SolicitudPruebaRepruebaDTO retorno=null;
		PghSolicitudPruebaReprueba  pghSolicitudPruebaReprueba=  new PghSolicitudPruebaReprueba();
		
		try{
			
			if ( solicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba()  == null ) {
				
				pghSolicitudPruebaReprueba.setIdSolicitudPruebaReprueba(solicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba());
				pghSolicitudPruebaReprueba.setNroSolicitudUnidadSupervisa(solicitudPruebaRepruebaDTO.getNroSolicitudUnidadSupervisa());
				pghSolicitudPruebaReprueba.setIdTipoPrueba(solicitudPruebaRepruebaDTO.getIdTipoPrueba());
				pghSolicitudPruebaReprueba.setIdEmpresaAcreditada(solicitudPruebaRepruebaDTO.getIdEmpresaAcreditada());
				pghSolicitudPruebaReprueba.setIdPersonaJuridica(solicitudPruebaRepruebaDTO.getIdPersonaJuridica());
				pghSolicitudPruebaReprueba.setFechaSolicitud(solicitudPruebaRepruebaDTO.getFechaSolicitud());
				pghSolicitudPruebaReprueba.setIdCompartimiento(solicitudPruebaRepruebaDTO.getIdCompartimiento());
				pghSolicitudPruebaReprueba.setIdCilindroGNV(solicitudPruebaRepruebaDTO.getIdCilindroGNV());
				pghSolicitudPruebaReprueba.setIdTanqueGLP(solicitudPruebaRepruebaDTO.getIdTanqueGLP());
				pghSolicitudPruebaReprueba.setFlagInspeccion(solicitudPruebaRepruebaDTO.getFlagInspeccion());
				pghSolicitudPruebaReprueba.setIdCompartimiento(solicitudPruebaRepruebaDTO.getIdCompartimiento());
				pghSolicitudPruebaReprueba.setEstado(solicitudPruebaRepruebaDTO.getEstado());
				pghSolicitudPruebaReprueba.setFlagInformeIndiceRiesgo(solicitudPruebaRepruebaDTO.getFlagInformeIndiceRiesgo());
				pghSolicitudPruebaReprueba.setDatosAuditoria(usuarioDTO);
				
			    LOG.info(" Datos:"+pghSolicitudPruebaReprueba.getIdSolicitudPruebaReprueba()+" - " +pghSolicitudPruebaReprueba.getNroSolicitudUnidadSupervisa()+" - " +
			    				   pghSolicitudPruebaReprueba.getIdTipoPrueba()+" - " +pghSolicitudPruebaReprueba.getIdEmpresaAcreditada()+" - " +
			    		           pghSolicitudPruebaReprueba.getFechaSolicitud()+" - " +pghSolicitudPruebaReprueba.getIdCompartimiento()+" - " +
			    				   pghSolicitudPruebaReprueba.getEstado());
	    	
				crud. create(pghSolicitudPruebaReprueba);
				
			}else {
				
				LOG.error("UPDATE");
				pghSolicitudPruebaReprueba =  crud.find(solicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba(), PghSolicitudPruebaReprueba.class);
				pghSolicitudPruebaReprueba.setEstado(solicitudPruebaRepruebaDTO.getEstado());
				
				if ( solicitudPruebaRepruebaDTO.getEstado().equals("R") ) {
				pghSolicitudPruebaReprueba.setFechaSolicitud(solicitudPruebaRepruebaDTO.getFechaSolicitud());
				}
				
				crud.update(pghSolicitudPruebaReprueba);
				
			}
			
			retorno = SolicitudPruebaRepruebaBuilder.toSolicitudPruebaRepruebaDTO(pghSolicitudPruebaReprueba);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.getIdSolicitudPruebaReprueba());
		
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
    
    @Override
	public SolicitudPruebaRepruebaDTO update(SolicitudPruebaRepruebaDTO SolicitudPruebaRepruebaDTO,UsuarioDTO usuarioDTO) throws SolicitudPruebaRepruebaException {
		
		LOG.info("Iniciando Actualizacion de Solicitud Prueba Reprueba");
		
		SolicitudPruebaRepruebaDTO retorno=null;
		PghSolicitudPruebaReprueba  pghSolicitudPruebaReprueba=  new PghSolicitudPruebaReprueba();
		
		try{
		
			LOG.error("UPDATE");
			
			pghSolicitudPruebaReprueba =  crud.find(SolicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba(), PghSolicitudPruebaReprueba.class);
			
			pghSolicitudPruebaReprueba.setEstado(SolicitudPruebaRepruebaDTO.getEstado());
			pghSolicitudPruebaReprueba.setFlagInformeIndiceRiesgo(SolicitudPruebaRepruebaDTO.getFlagInformeIndiceRiesgo());
			pghSolicitudPruebaReprueba.setDatosAuditoria(usuarioDTO);

			crud.update(pghSolicitudPruebaReprueba);
		    	
			retorno = SolicitudPruebaRepruebaBuilder.toSolicitudPruebaRepruebaDTO(pghSolicitudPruebaReprueba);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.getIdSolicitudPruebaReprueba());
	
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	
	}
    
}
