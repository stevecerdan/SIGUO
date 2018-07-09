package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghInformePersonaNatural;
import gob.osinergmin.sibad.domain.builder.InformePersonaNaturalBuilder;
import gob.osinergmin.sibad.domain.builder.ResultadoRevisionBuilder;
import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;
import gob.osinergmin.sibad.filter.ResultadoRevisionFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.InformePersonaNaturalDAO;
import gob.osinergmin.sibad.service.dao.impl.InformeIndiceRiesgoDAOImpl;

@Repository("InformePersonaNaturalDAO")
@Transactional
public class InformePersonaNaturalDAOImpl implements InformePersonaNaturalDAO {
	 private static final Logger LOG = LoggerFactory.getLogger(InformePersonaNaturalDAOImpl.class);

		@Inject
		private CrudDAO crud;

		@Override
		public InformePersonaNaturalDTO create(InformePersonaNaturalDTO informePersonaNaturalDTO) {
			
			LOG.info("Iniciando registro de  Resultado Revision");
			
			InformePersonaNaturalDTO retorno=null;
				
				try{
					
					PghInformePersonaNatural  pghInformePersonaNatural=  new PghInformePersonaNatural();
					
					pghInformePersonaNatural.setIdInformePersonaNatural(informePersonaNaturalDTO.getIdInformePersonaNatural());
					pghInformePersonaNatural.setIdInformeIndiceRiesgo(informePersonaNaturalDTO.getIdInformeIndiceRiesgo());
					pghInformePersonaNatural.setIdPersonaNatural(informePersonaNaturalDTO.getIdPersonaNatural());
					
					crud. create(pghInformePersonaNatural);
					
					retorno = InformePersonaNaturalBuilder.toPghInformePersonaNatural(pghInformePersonaNatural);
					 
					LOG.info("(Registro exitoso) retorno: "+retorno.toString());
					
				}catch(Exception ex){
		            LOG.error("",ex);
		        }

		     return retorno;
		}

		@Override
		public List<InformePersonaNaturalDTO> find(InformePersonaNaturalFilter filtro) {
			
			List<InformePersonaNaturalDTO> listado;
	        
	        Query query = getFindQuery(filtro);
	        listado = InformePersonaNaturalBuilder.toListInformePersonaNaturalDto(query.getResultList());

	        return listado;
		}
		
		private Query getFindQuery(InformePersonaNaturalFilter filtro) {
	        
		Query query=null;
	     
	     try{
	    	 
	    	  if(filtro.getIdInformeIndiceRiesgo() !=null ){
	            	LOG.info("1 and.."+filtro.getIdInformeIndiceRiesgo());
	            	query = crud.getEm().createNamedQuery("PghInformePersonaNaturalV.findById");
	                
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
