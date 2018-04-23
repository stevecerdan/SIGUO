/**
 * 
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.SibadTablaDetalle;
import gob.osinergmin.sibad.domain.builder.TablaDetalleBuilder;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.TablaDetalleDAO;
import gob.osinergmin.sibad.service.exception.BaseException;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author DSR
 *
 */

@Repository("TablaDetalleDAO")
public class TablaDetalleDAOImpl implements TablaDetalleDAO{
	
	private static final Logger LOG = LoggerFactory.getLogger(TablaDetalleDAOImpl.class);
	
	@Inject
	private CrudDAO crud;
	
	@Override
	public TablaDetalleDTO obtenerSedeDSRNorteSur(Long idUbigeo) throws BaseException  {

		LOG.info("procesando TablaDetalleDAO/obtenerSedeDSRNorteSur--> Parametro: "+idUbigeo);
		TablaDetalleDTO tablaDetalleDTO = null;
        try {
            String sql = "select l from SibadTablaDetalle l where " +
            		" l.codigo in('N','S') and l.estado = '1'  and l.nombre = "+idUbigeo;
            Query query = this.crud.getEm().createQuery(sql);
            SibadTablaDetalle tablaDetalle = (SibadTablaDetalle)query.getSingleResult();
            tablaDetalleDTO = TablaDetalleBuilder.obtenerTablaDetalleDTO(tablaDetalle);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - TablaDetalleDAO/obtenerSedeDSRNorteSur ==>" + e.getMessage());
        }
        return tablaDetalleDTO;
	}

}
