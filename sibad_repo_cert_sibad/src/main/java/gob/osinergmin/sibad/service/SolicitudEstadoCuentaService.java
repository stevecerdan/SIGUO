package gob.osinergmin.sibad.service;


import gob.osinergmin.sibad.domain.dto.SibadNotaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface SolicitudEstadoCuentaService {

	public SolicitudEstadoCuentaDTO guardar(SolicitudEstadoCuentaDTO solicitud,
			UsuarioDTO usuario,HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception ;	
	
	public SolicitudEstadoCuentaDTO consultarReporte(Long idSolicitud);

	public SolicitudEstadoCuentaDTO obtenerEstadoCuenta(SolicitudEstadoCuentaDTO solicitud);
	
	public SibadNotaDTO obtenerNota(Long id);

}
