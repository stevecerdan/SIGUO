package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghResultadoPruebaPersonal;
import gob.osinergmin.sibad.domain.PghResultadoPruebaReprueba;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaPersonalBuilder;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaRepruebaBuilder;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaRepruebaDAO;

@Repository("ResultadoPruebaRepruebaDAO")
@Transactional
public class ResultadoPruebaRepruebaDAOImpl implements ResultadoPruebaRepruebaDAO{
	 private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaRepruebaDAOImpl.class);

	@Inject
	private CrudDAO crud;
	 
	@Override
	public ResultadoPruebaRepruebaDTO create(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando registro de  Resultado Prueba Reprueba");

			
		 ResultadoPruebaRepruebaDTO retorno=null;
			
			try{
				
				PghResultadoPruebaReprueba  pghResultadoPruebaReprueba =  new 	PghResultadoPruebaReprueba();
			
				pghResultadoPruebaReprueba.setIdResultadoPruebaReprueba(resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba());
				pghResultadoPruebaReprueba.setIdSolicitudPruebaReprueba(resultadoPruebaRepruebaDTO.getIdSolicitudPruebaReprueba());
				pghResultadoPruebaReprueba.setFechaInicio(resultadoPruebaRepruebaDTO.getFechaInicio());
				pghResultadoPruebaReprueba.setHoraInicio(resultadoPruebaRepruebaDTO.getHoraInicio());
				pghResultadoPruebaReprueba.setFechaFin(resultadoPruebaRepruebaDTO.getFechaFin());
				pghResultadoPruebaReprueba.setHoraFin(resultadoPruebaRepruebaDTO.getHoraFin());
				pghResultadoPruebaReprueba.setFlagResultadoCompartimiento(resultadoPruebaRepruebaDTO.getFlagResultadoCompartimiento());
				pghResultadoPruebaReprueba.setFlagResutadoTuberia(resultadoPruebaRepruebaDTO.getFlagResutadoTuberia());
				pghResultadoPruebaReprueba.setFlagResultadoFinal(resultadoPruebaRepruebaDTO.getFlagResultadoFinal());
				pghResultadoPruebaReprueba.setResultadoPrueba(resultadoPruebaRepruebaDTO.getResultadoPrueba());
				pghResultadoPruebaReprueba.setObservacion(resultadoPruebaRepruebaDTO.getObservacion());
				pghResultadoPruebaReprueba.setNumeroCertificado(resultadoPruebaRepruebaDTO.getNumeroCertificado());
				pghResultadoPruebaReprueba.setFechaEmisionCertificado(resultadoPruebaRepruebaDTO.getFechaEmisionCertificado());
				pghResultadoPruebaReprueba.setNumeroInforme(resultadoPruebaRepruebaDTO.getNumeroInforme());
				pghResultadoPruebaReprueba.setFechaProximaPrueba(resultadoPruebaRepruebaDTO.getFechaProximaPrueba());
				pghResultadoPruebaReprueba.setFechaInforme(resultadoPruebaRepruebaDTO.getFechaInforme());
				pghResultadoPruebaReprueba.setDatosAuditoria(usuarioDTO);
				
				LOG.info(" Datos:"+pghResultadoPruebaReprueba.getIdResultadoPruebaReprueba()+" - " +pghResultadoPruebaReprueba.getIdSolicitudPruebaReprueba()
				+" - "+pghResultadoPruebaReprueba.getFechaInicio()+" - "+pghResultadoPruebaReprueba.getHoraInicio()+" - "+pghResultadoPruebaReprueba.getHoraInicio()
				+" - "+pghResultadoPruebaReprueba.getHoraFin()+" - "+pghResultadoPruebaReprueba.getFlagResultadoCompartimiento()+" - "+pghResultadoPruebaReprueba.getFlagResutadoTuberia()
				+" - "+pghResultadoPruebaReprueba.getFlagResultadoFinal()+" - "+pghResultadoPruebaReprueba.getResultadoPrueba()+" - "+pghResultadoPruebaReprueba.getObservacion()
				+" - "+pghResultadoPruebaReprueba.getNumeroCertificado()+" - "+pghResultadoPruebaReprueba.getFechaEmisionCertificado()
				+" - "+pghResultadoPruebaReprueba.getNumeroInforme()+" - "+pghResultadoPruebaReprueba.getFechaProximaPrueba());

				crud. create(pghResultadoPruebaReprueba);
				
				retorno = ResultadoPruebaRepruebaBuilder.toPghResultadoPruebaReprueba(pghResultadoPruebaReprueba);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
				
			
			}catch(Exception ex){
				
	            LOG.error("",ex);
	        
			}
			
			return retorno;
	}

	@Override
	public ResultadoPruebaRepruebaDTO update(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO,UsuarioDTO usuarioDTO) {

		LOG.info("Iniciando registro de  Resultado Prueba Personal");
		ResultadoPruebaRepruebaDTO retorno=null;
		
		try{
		    
			PghResultadoPruebaReprueba  pghResultadoPruebaReprueba=  new PghResultadoPruebaReprueba();

			pghResultadoPruebaReprueba = crud.find(resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba(), PghResultadoPruebaReprueba.class);
    	
			pghResultadoPruebaReprueba.setIdResultadoPruebaReprueba(resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba());
			pghResultadoPruebaReprueba.setIdSolicitudPruebaReprueba(resultadoPruebaRepruebaDTO.getIdSolicitudPruebaReprueba());
			pghResultadoPruebaReprueba.setFechaInicio(resultadoPruebaRepruebaDTO.getFechaInicio());
			pghResultadoPruebaReprueba.setHoraInicio(resultadoPruebaRepruebaDTO.getHoraInicio());
			pghResultadoPruebaReprueba.setFechaFin(resultadoPruebaRepruebaDTO.getFechaFin());
			pghResultadoPruebaReprueba.setHoraFin(resultadoPruebaRepruebaDTO.getHoraFin());
			pghResultadoPruebaReprueba.setFlagResultadoCompartimiento(resultadoPruebaRepruebaDTO.getFlagResultadoCompartimiento());
			pghResultadoPruebaReprueba.setFlagResutadoTuberia(resultadoPruebaRepruebaDTO.getFlagResutadoTuberia());
			pghResultadoPruebaReprueba.setFlagResultadoFinal(resultadoPruebaRepruebaDTO.getFlagResultadoFinal());
			pghResultadoPruebaReprueba.setResultadoPrueba(resultadoPruebaRepruebaDTO.getResultadoPrueba());
			pghResultadoPruebaReprueba.setObservacion(resultadoPruebaRepruebaDTO.getObservacion());
			pghResultadoPruebaReprueba.setNumeroCertificado(resultadoPruebaRepruebaDTO.getNumeroCertificado());
			pghResultadoPruebaReprueba.setFechaEmisionCertificado(resultadoPruebaRepruebaDTO.getFechaEmisionCertificado());
			pghResultadoPruebaReprueba.setNumeroInforme(resultadoPruebaRepruebaDTO.getNumeroInforme());
			pghResultadoPruebaReprueba.setFechaInforme(resultadoPruebaRepruebaDTO.getFechaInforme());
			pghResultadoPruebaReprueba.setFechaProximaPrueba(resultadoPruebaRepruebaDTO.getFechaProximaPrueba());
			pghResultadoPruebaReprueba.setDatosAuditoria(usuarioDTO);
	    	
	    	crud.update(pghResultadoPruebaReprueba);
	    	
	    	retorno = ResultadoPruebaRepruebaBuilder.toPghResultadoPruebaReprueba(pghResultadoPruebaReprueba);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
	
		}catch(Exception ex){
			
	        LOG.error("",ex);
	    
		}
		
		return retorno;
     
	}

	
	@Override
	public List<ResultadoPruebaRepruebaDTO> find(ResultadoPruebaRepruebaFilter filtro) {
		
        List<ResultadoPruebaRepruebaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = ResultadoPruebaRepruebaBuilder.toListResultadoPruebaRepruebaDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(ResultadoPruebaRepruebaFilter filtro) {
        Query query=null;
        
        try{
            if(filtro.getIdResultadoPruebaReprueba() !=null ){
            	
            	LOG.info("IdResultadoPruebaReprueba: "+filtro.getIdResultadoPruebaReprueba());
            	query = crud.getEm().createNamedQuery("PghResultadoPruebaReprueba.findByIdPruebaReprueba");                
            }

            if(filtro.getIdResultadoPruebaReprueba()!=null ){
            	
            	LOG.info("IdResultadoPruebaReprueba: "+filtro.getIdResultadoPruebaReprueba());
                query.setParameter("idResultadoPruebaReprueba",filtro.getIdResultadoPruebaReprueba() );               	                    
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
	
	@Override
	public ResultadoPruebaRepruebaDTO updateFechaProxPrueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO,UsuarioDTO usuarioDTO) {

		LOG.info("Iniciando registro de  Resultado Prueba Personal");
		ResultadoPruebaRepruebaDTO retorno=null;
		
		try{
		    
			PghResultadoPruebaReprueba  pghResultadoPruebaReprueba=  new PghResultadoPruebaReprueba();

			pghResultadoPruebaReprueba = crud.find(resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba(), PghResultadoPruebaReprueba.class);
    	
			pghResultadoPruebaReprueba.setIdResultadoPruebaReprueba(resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba());
			pghResultadoPruebaReprueba.setFechaProximaPrueba(resultadoPruebaRepruebaDTO.getFechaProximaPrueba());
			pghResultadoPruebaReprueba.setDatosAuditoria(usuarioDTO);
	    	
	    	crud.update(pghResultadoPruebaReprueba);
	    	
	    	retorno = ResultadoPruebaRepruebaBuilder.toPghResultadoPruebaRepruebaEdit(pghResultadoPruebaReprueba);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
	
		}catch(Exception ex){
			
	        LOG.error("",ex);
	    
		}
		
		return retorno;
     
	}

}
