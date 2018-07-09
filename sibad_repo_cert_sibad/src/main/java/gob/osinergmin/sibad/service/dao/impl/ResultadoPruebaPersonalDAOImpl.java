package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import gob.osinergmin.sibad.domain.PghResultadoPruebaPersonal;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaPersonalBuilder;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaPersonalVBuilder;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaPersonalFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaPersonalDAO;

@Repository("ResultadoPruebaPersonalDAO")
@Transactional
public class ResultadoPruebaPersonalDAOImpl implements ResultadoPruebaPersonalDAO{
	 private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaPersonalDAOImpl.class);

	@Inject
	private CrudDAO crud;
	
	@Override
	public ResultadoPruebaPersonalDTO create(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando registro de  Resultado Prueba Personal");
		ResultadoPruebaPersonalDTO retorno=null;
		
		try{
			
			PghResultadoPruebaPersonal  pghResultadoPruebaPersonal=  new 	PghResultadoPruebaPersonal();
			
			pghResultadoPruebaPersonal.setIdResultadoPruebaPersonal(resultadoPruebaPersonalDTO.getIdResultadoPruebaPersonal());
			pghResultadoPruebaPersonal.setIdResultadoPruebaReprueba(resultadoPruebaPersonalDTO.getIdResultadoPruebaReprueba());
			pghResultadoPruebaPersonal.setIdSedePersonalAutorizado(resultadoPruebaPersonalDTO.getIdSedePersonalAutorizado());
			pghResultadoPruebaPersonal.setDatosAuditoria(usuarioDTO);
			
			crud. create(pghResultadoPruebaPersonal);
			
			retorno = ResultadoPruebaPersonalBuilder.toPghResultadoPruebaPersonal(pghResultadoPruebaPersonal);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
		
		}catch(Exception ex){
			
            LOG.error("",ex);
        
		}
		
		return retorno;
	}

	@Override
	public ResultadoPruebaPersonalDTO update(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando registro de  Resultado Prueba Personal");
		ResultadoPruebaPersonalDTO retorno=null;
		
		try{
		    
			PghResultadoPruebaPersonal  pghResultadoPruebaPersonal=  new PghResultadoPruebaPersonal();

			pghResultadoPruebaPersonal = crud.find(resultadoPruebaPersonalDTO.getIdResultadoPruebaPersonal(), PghResultadoPruebaPersonal.class);
    	
	    	pghResultadoPruebaPersonal.setIdResultadoPruebaPersonal(resultadoPruebaPersonalDTO.getIdResultadoPruebaPersonal());
	    	pghResultadoPruebaPersonal.setIdResultadoPruebaReprueba(resultadoPruebaPersonalDTO.getIdResultadoPruebaReprueba());
	    	pghResultadoPruebaPersonal.setIdSedePersonalAutorizado(resultadoPruebaPersonalDTO.getIdSedePersonalAutorizado());
	    	pghResultadoPruebaPersonal.setDatosAuditoria(usuarioDTO);
	    	
	    	crud.update(pghResultadoPruebaPersonal);
	    	
			retorno = ResultadoPruebaPersonalBuilder.toPghResultadoPruebaPersonal(pghResultadoPruebaPersonal);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
	
	}catch(Exception ex){
		
        LOG.error("",ex);
    
	}
	
	return retorno;
	}

	@Override
	public List<ResultadoPruebaPersonalDTO> find(ResultadoPruebaPersonalFilter filtro) {
		
		List<ResultadoPruebaPersonalDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = ResultadoPruebaPersonalBuilder.toListResultadoPruebaPersonalDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(ResultadoPruebaPersonalFilter filtro) {
        
		Query query=null;
        
        try{
            if(filtro.getIdResultadoPruebaReprueba() !=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getIdResultadoPruebaReprueba());
            	query = crud.getEm().createNamedQuery("PghResultadoPruebaPersonal.findByIdResultadoPruebaReprueba");
            }

            if(filtro.getIdResultadoPruebaReprueba()!=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getIdResultadoPruebaReprueba());
                query.setParameter("idResultadoPruebaReprueba",filtro.getIdResultadoPruebaReprueba() );                	                    
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
	
	@Override
	public List<ResultadoPruebaPersonalDTO> find2(ResultadoPruebaPersonalFilter filtro) {
		
		List<ResultadoPruebaPersonalDTO> listado;
        
        Query query = getFindQuery2(filtro);
        listado = ResultadoPruebaPersonalVBuilder.toListResultadoPruebaPersonalVDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery2(ResultadoPruebaPersonalFilter filtro) {
        
		Query query=null;
        
        try{
            if(filtro.getIdResultadoPruebaReprueba() !=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getIdResultadoPruebaReprueba());
            	query = crud.getEm().createNamedQuery("PghResultadoPruebaPersonalV.findByIdResultadoPRP");
            }

            if(filtro.getIdResultadoPruebaReprueba()!=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getIdResultadoPruebaReprueba());
                query.setParameter("idResultadoPruebaReprueba",filtro.getIdResultadoPruebaReprueba() );                	                    
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
	
	@Override
	public ResultadoPruebaPersonalDTO delete(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO,UsuarioDTO usuarioDTO) {
		
		ResultadoPruebaPersonalDTO retorno = null;
		
		try {
			
			PghResultadoPruebaPersonal registroDTO = crud.find(resultadoPruebaPersonalDTO.getIdResultadoPruebaPersonal(), PghResultadoPruebaPersonal.class);
			
			
			crud.delete(registroDTO);

			retorno = ResultadoPruebaPersonalBuilder.toPghResultadoPruebaPersonal(registroDTO);
		
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}
	
}
