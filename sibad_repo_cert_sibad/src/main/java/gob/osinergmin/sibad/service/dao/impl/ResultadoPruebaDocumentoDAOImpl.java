package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghProgramacion;
import gob.osinergmin.sibad.domain.PghResultadoPruebaDocumento;
import gob.osinergmin.sibad.domain.PghResultadoPruebaReprueba;
import gob.osinergmin.sibad.domain.builder.ProgramacionBuilder;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaDocumentoBuilder;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaRepruebaBuilder;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaDocumentoDAO;

@Repository("ResultadoPruebaDocumentoDAO")
@Transactional
public class ResultadoPruebaDocumentoDAOImpl implements ResultadoPruebaDocumentoDAO{
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaDocumentoDAOImpl.class);

	@Inject
	private CrudDAO crud;

	@Override
	public ResultadoPruebaDocumentoDTO create(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando registro de  Resultado Prueba Documento");
		ResultadoPruebaDocumentoDTO retorno=null;
		
		try{
			
			PghResultadoPruebaDocumento  pghResultadoPruebaDocumento=  new 	PghResultadoPruebaDocumento();
			
			pghResultadoPruebaDocumento.setIdResultadoPruebaDocumento(resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());
			pghResultadoPruebaDocumento.setIdDocumentoAdjunto(resultadoPruebaDocumentoDTO.getIdDocumentoAdjunto());
			pghResultadoPruebaDocumento.setIdResutadoPruebaReprueba(resultadoPruebaDocumentoDTO.getIdResutadoPruebaReprueba());
			pghResultadoPruebaDocumento.setDatosAuditoria(usuarioDTO);
			
			crud. create(pghResultadoPruebaDocumento);
			
			retorno = ResultadoPruebaDocumentoBuilder.toPghResultadoPruebaDocumento(pghResultadoPruebaDocumento);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
		
		}catch(Exception ex){
			
            LOG.error("",ex);
        
		}
		
		return retorno;
	}
	
	@Override
	public ResultadoPruebaDocumentoDTO update(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando registro de  Resultado Prueba Documento");
		ResultadoPruebaDocumentoDTO retorno=null;
		
		try{
		    
			PghResultadoPruebaDocumento  pghResultadoPruebaDocumento=  new PghResultadoPruebaDocumento();

			pghResultadoPruebaDocumento = crud.find(resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento(), PghResultadoPruebaDocumento.class);
    	
			pghResultadoPruebaDocumento.setIdResultadoPruebaDocumento(resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());
			pghResultadoPruebaDocumento.setIdResutadoPruebaReprueba(resultadoPruebaDocumentoDTO.getIdResutadoPruebaReprueba());
			pghResultadoPruebaDocumento.setIdDocumentoAdjunto(resultadoPruebaDocumentoDTO.getIdDocumentoAdjunto());
			pghResultadoPruebaDocumento.setDatosAuditoria(usuarioDTO);
	    	
	    	crud.update(pghResultadoPruebaDocumento);
	    	
	    	retorno = ResultadoPruebaDocumentoBuilder.toPghResultadoPruebaDocumento(pghResultadoPruebaDocumento);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
	
		}catch(Exception ex){
			
	        LOG.error("",ex);
	    
		}
		
		return retorno;
		
	}

	@Override
	public List<ResultadoPruebaDocumentoVDTO> find(ResultadoPruebaDocumentoFilter filtro) {
		
		 List<ResultadoPruebaDocumentoVDTO> listado;
	        
	        Query query = getFindQuery(filtro);
	        listado = ResultadoPruebaDocumentoBuilder.toListResultadoPruebaDocumentoDto(query.getResultList());

	        return listado;
	}
	
	private Query getFindQuery(ResultadoPruebaDocumentoFilter filtro) {
        Query query=null;
        
        try{
            if(filtro.getDescripcionDocumento() !=null ){
            	
            	query = crud.getEm().createNamedQuery("PghResultadoPruebaDocumentoV.findByFilter");
                
            }else {
            	query = crud.getEm().createNamedQuery("PghResultadoPruebaDocumentoV.findByIdResultadoPruebaReprueba");
            }

            if(filtro.getDescripcionDocumento()==null ){
            	
                query.setParameter("idResultadoPruebaReprueba",filtro.getIdResultadoPruebaReprueba() );
                	                    
              }else {
            	  query.setParameter("descripcionDocumento",filtro.getDescripcionDocumento() );
            	  query.setParameter("idResultadoPruebaReprueba",filtro.getIdResultadoPruebaReprueba() );
              }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

	@Override
	public ResultadoPruebaDocumentoDTO delete(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("eliminarResultadoPruebaDocumento DAO IMPL- ID = "+ resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());
		ResultadoPruebaDocumentoDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());
			
			PghResultadoPruebaDocumento registroDTO = crud.find(resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento(), PghResultadoPruebaDocumento.class);
			
			LOG.info("llena registroDTO= "+ resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());
			
			crud.delete(registroDTO);

			retorno = ResultadoPruebaDocumentoBuilder.toPghResultadoPruebaDocumento(registroDTO);
		
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}
	
}
