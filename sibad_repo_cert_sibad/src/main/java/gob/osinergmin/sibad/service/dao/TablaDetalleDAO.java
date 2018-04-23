/**
 * 
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.service.exception.BaseException;


/**
 * @author DSR
 *
 */
public interface TablaDetalleDAO {

	TablaDetalleDTO obtenerSedeDSRNorteSur(Long idUbigeo) throws BaseException ;

}
