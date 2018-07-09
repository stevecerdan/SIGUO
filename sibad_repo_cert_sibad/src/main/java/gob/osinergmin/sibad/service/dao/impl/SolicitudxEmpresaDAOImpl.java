package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.SolicitudxEmpresaBuilder;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.SolicitudxEmpresaDAO;

@Repository("SolicitudxEmpresaDAO")
@Transactional
public class SolicitudxEmpresaDAOImpl implements SolicitudxEmpresaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(SolicitudxEmpresaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<SolicitudPruebaRepruebaDTO> find(SolicitudPruebaRepruebaFilter filtro) {
        List<SolicitudPruebaRepruebaDTO> listado;
        
        Query query = getFindQuery(filtro);
        
        LOG.info(query.toString());
        
        listado = SolicitudxEmpresaBuilder.toListSolicitudPruebaRepruebaDto(query.getResultList());

        return listado;
    } 
    
    private Query getFindQuery(SolicitudPruebaRepruebaFilter filtro) {
        Query query=null;
        try{
        	if(filtro.getIdEmpresaAcreditada() != null) {
        		query = crud.getEm().createNamedQuery("PghSolicitudxEmpresa.findByIdEmpresa");
                query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
        	}
        }catch (Exception e) {
            LOG.error("Error getFindQuery: "+e.getMessage());        	
		}
		return query;
     }

}
