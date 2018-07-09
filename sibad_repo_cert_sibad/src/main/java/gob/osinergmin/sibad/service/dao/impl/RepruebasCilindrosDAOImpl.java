package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghSolicitudPruebaReprueba;
import gob.osinergmin.sibad.domain.builder.RepruebasCilindrosBuilder;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosModuloDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.RepruebasCilindrosFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.RepruebasCilindrosDAO;

@Repository("RepruebasCilindrosDAO")
@Transactional
public class RepruebasCilindrosDAOImpl implements RepruebasCilindrosDAO{
	private static final Logger LOG = LoggerFactory.getLogger(RepruebasCilindrosDAOImpl.class);
	 @Inject
	 private CrudDAO crud;
	 
	@Override
	public List<RepruebasCilindrosDTO> find(RepruebasCilindrosFilter filtro) {
		List<RepruebasCilindrosDTO> listado;
	       
	       Query query = getFindQuery(filtro);
	       listado = RepruebasCilindrosBuilder.toListRepruebasDto(query.getResultList());

	       return listado;
	}
	
	private Query getFindQuery(RepruebasCilindrosFilter filtro) {
        Query query=null;
        try{

        		
            if(filtro.getIdSolicitudPruebaRp()!=null){
            	query = crud.getEm().createNamedQuery("PghRepruebasCilindrosGNVV.findByID");
            }else if(filtro.getIdEmpresaAcred() != null){
            	query = crud.getEm().createNamedQuery("PghRepruebasCilindrosGNVV.findByUltimoSOL");            	
            }else {
            	query = crud.getEm().createNamedQuery("PghRepruebasCilindrosGNVV.findByFilter");		
            }
            
           if(filtro.getIdSolicitudPruebaRp()==null && filtro.getIdEmpresaAcred() == null){
        		   
	            if(filtro.getNumeroReprueba()!=null && !filtro.getNumeroReprueba().equals("")){
	                query.setParameter("numeroReprueba","%"+filtro.getNumeroReprueba()+"%");
	            }else{
	                query.setParameter("numeroReprueba","%");
	            }
	            if(filtro.getNombreEmpresaAcred()!=null && !filtro.getNombreEmpresaAcred().equals("")){
	                query.setParameter("nombreEmpresaAcred","%"+filtro.getNombreEmpresaAcred().toUpperCase()+"%");
	            }else{
	                query.setParameter("nombreEmpresaAcred","%");
	            }
	            if(filtro.getIdUnidSuperv() !=null && !filtro.getIdUnidSuperv().equals("")){
	                query.setParameter("idUnidSuperv", filtro.getIdUnidSuperv() );
	            }
	            
	            if(filtro.getEstado()!=null && !filtro.getEstado().equals("")){
	                query.setParameter("estado","%"+filtro.getEstado()+"%");
	            }else{
	                query.setParameter("estado","%");
	            }
	            
            }else if(filtro.getIdEmpresaAcred() == null){
                query.setParameter("idSolicitudPruebaRp",filtro.getIdSolicitudPruebaRp());
            }else {
            	query.setParameter("idEmpresaAcred",filtro.getIdEmpresaAcred());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public List<RepruebasCilindrosModuloDTO> findCodigoOsinerg (RepruebasCilindrosFilter filtro) {
		List<RepruebasCilindrosModuloDTO> listado;
		 LOG.info("findCodigoOsinerg: "+ filtro.getIdUnidSuperv());
	       Query query = getFindQueryCilindro(filtro);
	       listado = RepruebasCilindrosBuilder.toListRepruebasCilindrosModuloDto(query.getResultList());

	       return listado;
	}
	
	private Query getFindQueryCilindro(RepruebasCilindrosFilter filtro) {
        Query query=null;
        LOG.info("getFindQueryCilindro: "+ filtro.getIdUnidSuperv());
        try{
        	
        	if ( filtro.getIdUnidSuperv() != null){
        		query = crud.getEm().createNamedQuery("PghRepruebasCilindrosV.findByID");
        	}
        	
        	if ( filtro.getIdModulo() != null){
        		query = crud.getEm().createNamedQuery("PghRepruebasCilindrosV.findByIdModulo");
        	}
        	
        	if ( filtro.getIdUnidSuperv() != null){
        		query.setParameter("idUnidSuperv",filtro.getIdUnidSuperv());
        	}
        	
        	if ( filtro.getIdModulo() != null){
        		query.setParameter("idModulo",filtro.getIdModulo());
        	}
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQueryCilindro: "+e.getMessage());
            
        }
        return query;
    }

}
