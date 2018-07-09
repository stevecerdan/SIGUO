/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghEmpresaAcreditada;
import gob.osinergmin.sibad.domain.PghEmpresaAcreditadaV;
import gob.osinergmin.sibad.domain.PghSedeAcreditacion;
import gob.osinergmin.sibad.domain.builder.EmpresaAcreditadaBuilder;
import gob.osinergmin.sibad.domain.builder.SedeAcreditacionBuilder;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
//@Service("empacredDAO")
@Repository("EmpresaAcreditadaDAO")
@Transactional
public class EmpresaAcreditadaDAOImpl implements EmpresaAcreditadaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(EmpresaAcreditadaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<EmpresaAcreditadaDTO> find(EmpresaAcreditadaFilter filtro) throws EmpresaAcreditadaException {
        List<EmpresaAcreditadaDTO> listado;
        
        Query query = getFindQuery(filtro);
        
        LOG.info(query.toString());
        
        listado = EmpresaAcreditadaBuilder.toListEmpresaAcreditadaDto(query.getResultList());

        return listado;
    }
    
    @Override
    public List<EmpresaAcreditadaDTO> find2 (EmpresaAcreditadaFilter filtro2) throws EmpresaAcreditadaException {
        List<EmpresaAcreditadaDTO> listado2;
        
        Query query2 = getFindQuery2(filtro2);
        listado2 = EmpresaAcreditadaBuilder.toListEmpresaAcreditDto(query2.getResultList());

        return listado2;
    }
    
    //UITLIZADO CON FIND
    private Query getFindQuery(EmpresaAcreditadaFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdAlcanceAcreditacion()!=null){
            	query = crud.getEm().createNamedQuery("PghEmpresaAcreditadaV.findByAlcance");
            }else{
            	if(filtro.getEmail()!=null){
            		query = crud.getEm().createNamedQuery("PghEmpresaAcreditadaV.findByListarProcesos");
            	}else {
            		if(filtro.getIdEmpresaAcreditada()!=null){
            			if(filtro.getIdOrganismoAcreditador()!=null){
            				query = crud.getEm().createNamedQuery("PghEmpresaAcreditadaV.findByFechaUA");
                		}else {
                			query = crud.getEm().createNamedQuery("PghEmpresaAcreditadaV.findByDatosEmpresa");
                		}
                	}else {
    	            	if(filtro.getIdTipoPrueba()!=null){
    	            		query = crud.getEm().createNamedQuery("PghEmpresaAcreditadaV.findByAlcanceXPrueba");	
    	            	}else{
    	            		query = crud.getEm().createNamedQuery("PghEmpresaAcreditadaV.findByFilter");
    	            	}
    	            }
	            }
            }
            
           if(filtro.getIdAlcanceAcreditacion()==null){
        	   
        	   if(filtro.getEmail()==null){  
        		   
        		   if(filtro.getIdEmpresaAcreditada()==null){  
            		   
    	        	   if(filtro.getIdTipoPrueba()==null){
    	        		   
    	        		   	if(filtro.getIdOrganismoAcreditador()!=null){
    		                	
    		                    query.setParameter("idOrganismoAcreditador",filtro.getIdOrganismoAcreditador());
    		                }else{
    		                    query.setParameter("idOrganismoAcreditador","");
    		                }  
    		                if(filtro.getRuc()!=null && !filtro.getRuc().equals("")){
    		                    query.setParameter("ruc",filtro.getRuc().toUpperCase());
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
    		                if(filtro.getEstadoAlcance()!=null && !filtro.getEstadoAlcance().equals("")){
    		                	
    		                    query.setParameter("estadoAlcance",filtro.getEstadoAlcance());
    		                }else{
    		                    query.setParameter("estadoAlcance","%");
    		                }
    		                if(filtro.getEstadoAccion()!=null && !filtro.getEstadoAccion().equals("")){
    		                	
    		                    query.setParameter("estadoAccion",filtro.getEstadoAccion());
    		                }else{
    		                    query.setParameter("estadoAccion","%");
    		                }
    		                if(filtro.getEstadoEmpresa()!=null && !filtro.getEstadoEmpresa().equals("")){
    		                	
    		                    query.setParameter("estadoEmpresa",filtro.getEstadoEmpresa());
    		                }else{
    		                    query.setParameter("estadoEmpresa","%");
    		                }
    		                
    	                }else{
    	                	query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());  
    	                }
    	           }else{
    	        	   if(filtro.getIdOrganismoAcreditador()!=null){
	    	               query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
	                       query.setParameter("idOrganismoAcreditador",filtro.getIdOrganismoAcreditador());
	                       query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
                       }else {
                    	   query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
                       }
    	           }
	           }else{
	               query.setParameter("ruc",filtro.getRuc());
                   query.setParameter("idOrganismoAcreditador",filtro.getIdOrganismoAcreditador());
                   query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
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
    
  //UITLIZADO CON FIND2
    private Query getFindQuery2(EmpresaAcreditadaFilter filtro2) {
        Query query2=null;
        try{
            if(filtro2.getIdEmpresaAcreditada()!=null){
            	query2 = crud.getEm().createNamedQuery("PghEmpresaAcreditada.findByEA");
            }else{
            	query2 = crud.getEm().createNamedQuery("PghEmpresaAcreditada.findByFilterPJ");
            }
            
           if(filtro2.getIdEmpresaAcreditada()==null){
                if(filtro2.getIdPersonaJuridica()!=null){
                    query2.setParameter("idPersonaJuridica",filtro2.getIdPersonaJuridica());
                }else{
                    query2.setParameter("idPersonaJuridica","%");
                }
            }else{
                query2.setParameter("idEmpresaAcreditada",filtro2.getIdEmpresaAcreditada());
            }
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery2: "+e.getMessage());
            
        }
        return query2;
    }
    
    @Override
	public EmpresaAcreditadaDTO create(EmpresaAcreditadaDTO empresaAcreditadaDTO, UsuarioDTO usuarioDTO)throws EmpresaAcreditadaException {
		
        LOG.info("Iniciando registro de Empresa Acreditada");
		EmpresaAcreditadaDTO retorno=null;
		
		try{
			
			PghEmpresaAcreditada  pghEmpresaAcreditada=  new PghEmpresaAcreditada();
			
			pghEmpresaAcreditada.setIdEmpresaAcreditada(empresaAcreditadaDTO.getIdEmpresaAcreditada());
			pghEmpresaAcreditada.setIdPersonaJuridica(empresaAcreditadaDTO.getIdPersonaJuridica());
			pghEmpresaAcreditada.setEstado(empresaAcreditadaDTO.getEstado());
			pghEmpresaAcreditada.setRegistro(empresaAcreditadaDTO.getRegistro());
			pghEmpresaAcreditada.setDatosAuditoria(usuarioDTO);
			
		    LOG.info(" Datos:"+pghEmpresaAcreditada.getEstado()+" - " +pghEmpresaAcreditada.getIdPersonaJuridica()+" - " +pghEmpresaAcreditada.getRegistro());

		    if(empresaAcreditadaDTO.getIdEmpresaAcreditada()!= null) {
		    	
		    	pghEmpresaAcreditada = crud.find(empresaAcreditadaDTO.getIdEmpresaAcreditada(), PghEmpresaAcreditada.class);
		    	pghEmpresaAcreditada.setIdEmpresaAcreditada(empresaAcreditadaDTO.getIdEmpresaAcreditada());
		    	pghEmpresaAcreditada.setEstado(empresaAcreditadaDTO.getEstado());
				pghEmpresaAcreditada.setDatosAuditoria(usuarioDTO);
		    	
				LOG.info(" Datos de Update:"+pghEmpresaAcreditada.getIdEmpresaAcreditada()+ " - " +pghEmpresaAcreditada.getEstado());
		    	
				crud.update(pghEmpresaAcreditada);
		    } else  {	    	

				crud. create(pghEmpresaAcreditada);
		    	
		    }
		    
			retorno = EmpresaAcreditadaBuilder.toEmpresaAcreditadaDTO(pghEmpresaAcreditada);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
		
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
    
    @Override
   	public EmpresaAcreditadaDTO update(EmpresaAcreditadaDTO empresaAcreditadaDTO, UsuarioDTO usuarioDTO)throws EmpresaAcreditadaException {
   		
        LOG.info("Iniciando actualizacion de Empresa Acreditada");
   		EmpresaAcreditadaDTO retorno=null;
   		
   		try {
			
			PghEmpresaAcreditada PghEmpresaAcreditada = crud.find(empresaAcreditadaDTO.getIdEmpresaAcreditada(), PghEmpresaAcreditada.class);
			
			PghEmpresaAcreditada.setIdEmpresaAcreditada(empresaAcreditadaDTO.getIdEmpresaAcreditada());
			PghEmpresaAcreditada.setRegistro(empresaAcreditadaDTO.getRegistro());
			PghEmpresaAcreditada.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+PghEmpresaAcreditada.getIdEmpresaAcreditada()+" - " +PghEmpresaAcreditada.getRegistro());
			
			crud.update(PghEmpresaAcreditada);
			
			retorno = EmpresaAcreditadaBuilder.toEmpresaAcreditadaRegDTO(PghEmpresaAcreditada);
			 
			LOG.info("(Edicion exitosa) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
   		
    }
}
