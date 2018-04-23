/**
 * 
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.SibadNotaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.exception.BaseException;

/**
 * @author DSR
 *
 */
public interface SolicitudEstadoCuentaDAO {

	SolicitudEstadoCuentaDTO guardar(SolicitudEstadoCuentaDTO formatoUno, UsuarioDTO usuario) throws BaseException;
	
	public SolicitudEstadoCuentaDTO consultarReporte(Long idSolicitud);

	public SolicitudEstadoCuentaDTO obtenerEstadoCuenta(SolicitudEstadoCuentaDTO solicitud);
	
	public SibadNotaDTO obtenerNota(Long id);
	
	public Long obtenerNroSolicitud();
	
	public Long obtenerNotaId();

}
