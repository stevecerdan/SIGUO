package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.SibadTablaDetalle;
import gob.osinergmin.sibad.domain.builder.BandejaBuilder;
import gob.osinergmin.sibad.domain.builder.TablaDetalleBuilder;
import gob.osinergmin.sibad.domain.dto.BandejaDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.service.dao.BandejaDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.util.FechaUtil;
import gob.osinergmin.sibad.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("BandejaDAO")
public class BandejaDAOImpl implements BandejaDAO{
    private static final Logger LOG = LoggerFactory.getLogger(BandejaDAOImpl.class);
    @Inject
    private CrudDAO crudDAO;
    
    @Override
    public List<BandejaDTO> listaSolicitud(BandejaDTO bandejaDTO){    		
	List<BandejaDTO> listaSolicitudesDTO = new ArrayList<BandejaDTO>();
	try {
	    StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT p, uop FROM SibadSlctudEstdoCnta p, SfhUnddesOprtvas uop WHERE p.uniopeId = uop.id ");
		
		if (bandejaDTO.getNumeroSolicitud() != null && bandejaDTO.getNumeroSolicitud().intValue() != 0){
		    jpql.append(" AND p.nmroSlctud = :pnmroSlctud ");
		}
		if (!StringUtil.isEmpty(bandejaDTO.getFechaInicio())){
		    jpql.append(" AND p.fchaIncio >= :pfchaIncio ");
		}
		if (!StringUtil.isEmpty(bandejaDTO.getFechaFin())){
		    jpql.append(" AND p.fchaFin <= :pfchaFin ");
		}
		if (bandejaDTO.getEstadoSolicitud() != null  ){
		    jpql.append(" AND p.estdo = :pestdo ");
		}
		if (bandejaDTO.getIdUnidadOperativa() != null && bandejaDTO.getIdUnidadOperativa().intValue() != 0 ){
		    jpql.append(" AND p.uniopeId = :pidUniope ");
		}
		jpql.append(" ORDER BY p.nmroSlctud DESC");
		
		LOG.info("Query: "+jpql.toString());
		Query query = crudDAO.getEm().createQuery(jpql.toString());
		if (bandejaDTO.getNumeroSolicitud() != null && bandejaDTO.getNumeroSolicitud().intValue() != 0){
			query.setParameter("pnmroSlctud", bandejaDTO.getNumeroSolicitud());
		}
		if (!StringUtil.isEmpty(bandejaDTO.getFechaInicio())){
			query.setParameter("pfchaIncio", FechaUtil.stringToDate(bandejaDTO.getFechaInicio(), FechaUtil.FORMATO_FECHA_CORTA));
		}
		if (!StringUtil.isEmpty(bandejaDTO.getFechaFin())){
			query.setParameter("pfchaFin", FechaUtil.stringToDate(bandejaDTO.getFechaFin(), FechaUtil.FORMATO_FECHA_CORTA));
		}
		if (bandejaDTO.getEstadoSolicitud() != null  ){
			query.setParameter("pestdo", bandejaDTO.getEstadoSolicitud());
		}
		if (bandejaDTO.getIdUnidadOperativa() != null && bandejaDTO.getIdUnidadOperativa().intValue() != 0 ){
			query.setParameter("pidUniope", bandejaDTO.getIdUnidadOperativa());		    
		}
		
		List<Object[]> listaSolicitudes=query.getResultList();
		if(listaSolicitudes!=null){
			listaSolicitudesDTO=BandejaBuilder.obtenerListaRegistroSolicitudes(listaSolicitudes);
		    LOG.info("lstSolicitudes = " + listaSolicitudesDTO.size());
		}
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	
	return listaSolicitudesDTO;
    }
    
    public List<TablaDetalleDTO> listaEstados(String tipoEstados){
    	LOG.info("procesando BandejaDAO/listaEstados--> Parametro: "+tipoEstados);
        List<TablaDetalleDTO> listaTablaDetalleDTO = new ArrayList<TablaDetalleDTO>();
        try {
        	         	
            String sql = " select td from SibadTablaGeneral tg inner join tg.sibadTablaDetalles td" +
            		     " where tg.codigo =  '"+ tipoEstados + "' " +
            		     " order by td.codigo ";            		     
            Query query = this.crudDAO.getEm().createQuery(sql);
            List<SibadTablaDetalle> listaSibadTablaDetalle = query.getResultList();
            LOG.info("procesando BandejaDAO/listaEstados-> obtiene listaSibadTablaDetalle: "+listaSibadTablaDetalle.size());
            listaTablaDetalleDTO = TablaDetalleBuilder.obtenerListaTablaDetalleDTO(listaSibadTablaDetalle);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - BandejaDAO/listaEstados ==>" + e.getMessage());
        }
        return listaTablaDetalleDTO;    	    	
    }

}
