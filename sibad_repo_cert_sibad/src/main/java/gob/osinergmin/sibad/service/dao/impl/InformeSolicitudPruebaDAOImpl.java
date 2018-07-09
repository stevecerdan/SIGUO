package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghInformeSolicitudPrueba;
import gob.osinergmin.sibad.domain.builder.InformePersonaNaturalBuilder;
import gob.osinergmin.sibad.domain.builder.InformeSolicitudPruebaBuilder;
import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.InformeSolicitudPruebaDTO;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;
import gob.osinergmin.sibad.filter.InformeSolicitudPruebaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.InformeSolicitudPruebaDAO;

@Repository("InformeSolicitudPruebaDAO")
@Transactional
public class InformeSolicitudPruebaDAOImpl implements InformeSolicitudPruebaDAO {
	private static final Logger LOG = LoggerFactory.getLogger(InformeSolicitudPruebaDAOImpl.class);

	@Inject
	private CrudDAO crud;

	@Override
	public InformeSolicitudPruebaDTO create(InformeSolicitudPruebaDTO informeSolicitudPruebaDTO) {
	
		LOG.info("Iniciando registro de  Resultado Revision");
		
		InformeSolicitudPruebaDTO retorno=null;
			
			try{
				
				PghInformeSolicitudPrueba  pghInformeSolicitudPrueba=  new PghInformeSolicitudPrueba();
				
				pghInformeSolicitudPrueba.setIdInformeSolicitudPrueba(informeSolicitudPruebaDTO.getIdInformeSolicitudPrueba());
				pghInformeSolicitudPrueba.setIdInformeIndiceRiesgo(informeSolicitudPruebaDTO.getIdInformeIndiceRiesgo());
				pghInformeSolicitudPrueba.setIdSolicitudPruebaReprueba(informeSolicitudPruebaDTO.getIdSolicitudPruebaReprueba());
				pghInformeSolicitudPrueba.setFechaProximaPrueba(informeSolicitudPruebaDTO.getFechaProximaPrueba());
				
				crud. create(pghInformeSolicitudPrueba);
				
				retorno = InformeSolicitudPruebaBuilder.toPghInformeSolicitudPrueba(pghInformeSolicitudPrueba);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
				
			}catch(Exception ex){
	            LOG.error("",ex);
	        }

	     return retorno;
	}

	@Override
	public List<InformeSolicitudPruebaDTO> find(InformeSolicitudPruebaFilter filtro) {
		
		List<InformeSolicitudPruebaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = InformeSolicitudPruebaBuilder.toListInformeSolicitudPruebaDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(InformeSolicitudPruebaFilter filtro) {
        
		Query query=null;
	     
	     try{
	    	 
	    	  if(filtro.getIdInformeIndiceRiesgo() !=null ){
	            	LOG.info("1 and.."+filtro.getIdInformeIndiceRiesgo());
	            	query = crud.getEm().createNamedQuery("PghInformeSolicitudPruebaV.findById");
	                
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
