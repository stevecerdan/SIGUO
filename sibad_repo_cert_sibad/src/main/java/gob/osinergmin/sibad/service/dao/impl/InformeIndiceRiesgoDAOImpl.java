package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghInformeIndiceRiesgo;
import gob.osinergmin.sibad.domain.builder.InformeIndiceRiesgoBuilder;
import gob.osinergmin.sibad.domain.builder.InformePersonaNaturalBuilder;
import gob.osinergmin.sibad.domain.dto.InformeIndiceRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.InformeIndiceRiesgoFilter;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.InformeIndiceRiesgoDAO;

@Repository("InformeIndiceRiesgoDAO")
@Transactional
public class InformeIndiceRiesgoDAOImpl implements InformeIndiceRiesgoDAO {
	 private static final Logger LOG = LoggerFactory.getLogger(InformeIndiceRiesgoDAOImpl.class);

	@Inject
	private CrudDAO crud;
	
	@Override
	public InformeIndiceRiesgoDTO create(InformeIndiceRiesgoDTO informeIndiceRiesgoDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando registro de  Resultado Revision");
		
		InformeIndiceRiesgoDTO retorno=null;
			
			try{
				
				PghInformeIndiceRiesgo  pghInformeIndiceRiesgo=  new PghInformeIndiceRiesgo();
				
				pghInformeIndiceRiesgo.setIdInformeIndiceRiesgo(informeIndiceRiesgoDTO.getIdInformeIndiceRiesgo());
				pghInformeIndiceRiesgo.setNumeroInformeIndiceRiesgo(informeIndiceRiesgoDTO.getNumeroInformeIndiceRiesgo());
				pghInformeIndiceRiesgo.setIdPersonaJuridica(informeIndiceRiesgoDTO.getIdPersonaJuridica());
				pghInformeIndiceRiesgo.setFechaInformeIniceRiesgo(informeIndiceRiesgoDTO.getFechaInformeIniceRiesgo());
				pghInformeIndiceRiesgo.setFlagPersona(informeIndiceRiesgoDTO.getFlagPersona());
				pghInformeIndiceRiesgo.setIdDocumentoAdjunto(informeIndiceRiesgoDTO.getIdDocumentoAdjunto());
				pghInformeIndiceRiesgo.setDatosAuditoria(usuarioDTO);

				crud. create(pghInformeIndiceRiesgo);
				
				retorno = InformeIndiceRiesgoBuilder.toPghInformeIndiceRiesgo(pghInformeIndiceRiesgo);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			}catch(Exception ex){
	            LOG.error("",ex);
	        }

	     return retorno;

	}

	@Override
	public List<InformeIndiceRiesgoDTO> find(InformeIndiceRiesgoFilter filtro) {
		
		List<InformeIndiceRiesgoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = InformeIndiceRiesgoBuilder.toListInformeIndiceRiesgoDto(query.getResultList());

		return listado;
	}
	
	private Query getFindQuery(InformeIndiceRiesgoFilter filtro) {
        
		Query query=null;
	     
	     try{
	    	 
	    	  if(filtro.getIdInformeIndiceRiesgo() !=null ){
	            	LOG.info("1 and.."+filtro.getIdInformeIndiceRiesgo());
	            	query = crud.getEm().createNamedQuery("PghInformeIndiceRiesgo.findByIdInformeIndiceRiesgo");
	                
	          }
	    	  
	    	  if(filtro.getIdInformeIndiceRiesgo()!=null ){
	            	LOG.info("2 and.."+filtro.getIdInformeIndiceRiesgo());
	                	query.setParameter("idInformeIndiceRiesgo",filtro.getIdInformeIndiceRiesgo() );
	                	                    
	              }
	    	  
		 }catch(Exception e){
	            
			 LOG.error("Error getFindQuery: "+e.getMessage());
	     }
	     
	     return query;
		}
}
