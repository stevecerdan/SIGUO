package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.SolicitudXInformeRiesgoBuilder;
import gob.osinergmin.sibad.domain.dto.SolicitudXInformeRiesgoDTO;
import gob.osinergmin.sibad.filter.SolicitudXInformeRiesgoFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.SolicitudXInformeRiesgoDAO;

@Repository("SolicitudXInformeRiesgoDAO")
@Transactional
public class SolicitudXInformeRiesgoDAOImpl implements SolicitudXInformeRiesgoDAO{
	 private static final Logger LOG = LoggerFactory.getLogger(SolicitudXInformeRiesgoDAOImpl.class);

	@Inject
	private CrudDAO crud;
	
	@Override
	public List<SolicitudXInformeRiesgoDTO> find(SolicitudXInformeRiesgoFilter filtro) {
		
		List<SolicitudXInformeRiesgoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = SolicitudXInformeRiesgoBuilder.toListSolicitudXInformeRiesgoDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(SolicitudXInformeRiesgoFilter filtro) {
        
		Query query=null;
        
        try{
            if(filtro.getNroInformeIndiceRiesgo() !=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getNroInformeIndiceRiesgo());
            	query = crud.getEm().createNamedQuery("PghSolicitudXInformeRiesgoV.findByInfoRiesgo");
            }

            if(filtro.getNroInformeIndiceRiesgo()!=null ){
                query.setParameter("nroInformeIndiceRiesgo","%"+filtro.getNroInformeIndiceRiesgo().toUpperCase()+"%" );
            }else{
                query.setParameter("nroInformeIndiceRiesgo","%");
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
	
}
