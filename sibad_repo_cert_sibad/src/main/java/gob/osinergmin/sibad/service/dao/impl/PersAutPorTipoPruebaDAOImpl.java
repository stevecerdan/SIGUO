package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.PersAutPorTipoPruebaBuilder;
import gob.osinergmin.sibad.domain.builder.UnidadSupervisadaBuilder;
import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.PersAutPorTipoPruebaFilter;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.PersAutPorTipoPruebaDAO;
import gob.osinergmin.sibad.service.exception.PersAutPorTipoPruebaException;

@Repository("PersAutPorTipoPruebaDAO")
@Transactional
public class PersAutPorTipoPruebaDAOImpl implements PersAutPorTipoPruebaDAO{
	private static final Logger LOG = LoggerFactory.getLogger(PersAutPorTipoPruebaDAOImpl.class);
    @Inject
    private CrudDAO crud;
	
    @Override
	public List<PersAutPorTipoPruebaDTO> find(PersAutPorTipoPruebaFilter filtro) throws PersAutPorTipoPruebaException {
		
        List<PersAutPorTipoPruebaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = PersAutPorTipoPruebaBuilder.toListersAutPorTipoPruebaDto(query.getResultList());

        return listado;
	}
    
    private Query getFindQuery(PersAutPorTipoPruebaFilter filtro) {
        Query query=null;
        try{
        	if(filtro.getIdEmpresaAcreditada()!=null){
        			query = crud.getEm().createNamedQuery("PersonalAutorizadoPorTipoPruebaV.findIdEmpAcreditada");
        	} 
        	
        	if(filtro.getIdEmpresaAcreditada()!=null){

        		query.setParameter("idEmpresaAcreditada",filtro.getIdEmpresaAcreditada());
        		query.setParameter("idTipoPrueba",filtro.getIdTipoPrueba());
        		query.setParameter("flagSedePersonalAutoriazado",filtro.getFlagSedePersonalAutoriazado());
        	}
        	
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }
}
