package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.CamposDelDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface GenerarDocumentoSigedService {

	public String crearExpediente(CamposDelDocumentoDTO camposDTO,
			SolicitudEstadoCuentaDTO solicitud, HttpServletRequest request,
			HttpServletResponse response, HttpSession sesion)
			throws ClassNotFoundException;

	public String agregarDocumento(CamposDelDocumentoDTO camposDTO,
			HttpServletRequest request, HttpSession sesion) throws Exception;

	public File archivoParaSiged(SolicitudEstadoCuentaDTO solicitud,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession sesion);
}
