package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.CamposDelDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.SibadNotaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDestinatarioDigedDTO;
import gob.osinergmin.sibad.service.GenerarDocumentoSigedService;
import gob.osinergmin.sibad.service.SolicitudEstadoCuentaService;
import gob.osinergmin.sibad.service.dao.BandejaDAO;
import gob.osinergmin.sibad.service.dao.GenerarDocumentoSigedDAO;
import gob.osinergmin.sibad.service.dao.SolicitudEstadoCuentaDAO;
import gob.osinergmin.sibad.service.dao.TablaDetalleDAO;
import gob.osinergmin.sibad.service.exception.SigedException;
import gob.osinergmin.sibad.util.Constantes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("rawtypes")
@Service("SolicitudEstadoCuentaService")
public class SolicitudEstadoCuentaServiceImpl implements SolicitudEstadoCuentaService{
	
	private static final Logger LOG = LoggerFactory.getLogger(SolicitudEstadoCuentaServiceImpl.class);
    @Inject
    private SolicitudEstadoCuentaDAO solicitudEstadoCuentaDAO;
    @Inject
    private BandejaDAO bandeja;
    @Inject
    private GenerarDocumentoSigedService generarDocumentoSigedService;
    @Inject
	private GenerarDocumentoSigedDAO generarDocumentoSigedDAO;
    @Inject
    private TablaDetalleDAO tablaDetalleDAO;
    
	@Override
	@Transactional(rollbackFor=SigedException.class)
	public SolicitudEstadoCuentaDTO guardar(SolicitudEstadoCuentaDTO solicitud,
			UsuarioDTO usuario,HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception {

		SolicitudEstadoCuentaDTO solicitudReporte = solicitud;
				
		//DATO DE SIGED
		CamposDelDocumentoDTO camposDTO = new CamposDelDocumentoDTO();
		UsuarioDestinatarioDigedDTO usuarioDestinario = new UsuarioDestinatarioDigedDTO();
			
		    
	    TablaDetalleDTO tablaDetalleDTO = new TablaDetalleDTO();
		if(solicitud.getDependenciaId() == Constantes.TIPO_DEPENDENCIA_DSR ){
        	if ((solicitud.getCmbDepartamento() == Constantes.TIPO_DEPARTAMENTO_LIMA) || 
        		(solicitud.getCmbDepartamento() == Constantes.TIPO_DEPARTAMENTO_CALLAO)){
        		tablaDetalleDTO = tablaDetalleDAO.obtenerSedeDSRNorteSur(solicitud.getIdDistrito());
        		camposDTO.setUbigeo(solicitud.getCmbDepartamento()+""+(tablaDetalleDTO.getCodigo()!=null?tablaDetalleDTO.getCodigo():""));    	    
        	}
        }
		
    	camposDTO.setActividadEmpresa(solicitud.getCodigoActividad());
    	camposDTO.setRuc(solicitud.getRuc());
    	camposDTO.setIdDependencia(solicitud.getDependenciaId());    	
	    		    		    	
    	usuarioDestinario = generarDocumentoSigedDAO.consultarUsuario(camposDTO);
    	camposDTO.setUsuarioIDDestinatario(Integer.parseInt(usuarioDestinario.getUsuarioPrincipal()));
    	solicitud.setNumeroSolicitud(solicitudEstadoCuentaDAO.obtenerNroSolicitud());
        String numeroExpediente = generarDocumentoSigedService.crearExpediente(camposDTO, solicitud,request, response,session);
	    
        if(numeroExpediente=="0"){
		   throw new SigedException("SIGED.EXCEPTION");
		}
        
    	//String numeroExpediente="1";//AGREGADO
	    camposDTO.setNumeroExpediente(numeroExpediente);
	    	
	    //FIN DE SIGED
	    solicitud.setNumeroExpediente(numeroExpediente);
	    solicitud.setNotaId(solicitudEstadoCuentaDAO.obtenerNotaId());
	    solicitud = solicitudEstadoCuentaDAO.guardar(solicitud, usuario);

			
	    //Invocar servicio Agregar documento Siged
	    		  		                
	    solicitudReporte.setNumeroSolicitud(solicitud.getNumeroSolicitud());
	    solicitudReporte.setNumeroExpediente(solicitud.getNumeroExpediente());
		solicitudReporte.setIdSolicitud(solicitud.getIdSolicitud());
		solicitudReporte.setNotaId(solicitud.getNotaId());
		SibadNotaDTO nota = obtenerNota(solicitud.getNotaId());
		solicitudReporte.setNotaDetalle(nota.getDetalle());
		File archivoPdf = generarDocumentoSigedService.archivoParaSiged(solicitudReporte, request, response, session);
		camposDTO.setArchivoAdjunto(archivoPdf);
		List<File> filaSiged=new ArrayList<File>();
		filaSiged.add(archivoPdf);
		camposDTO.setListaArchivosSiged(filaSiged);
		camposDTO.setUsuarioIDDestinatario(Integer.parseInt(usuarioDestinario.getUsuarioPrincipal()));
		String addDocumento=generarDocumentoSigedService.agregarDocumento(camposDTO, request,session);
		System.out.println("DOCUMENTO SIGED:::: "+addDocumento);

		return solicitud;
	}
	   
    @Override
	public SolicitudEstadoCuentaDTO consultarReporte(Long idFormato) {		
		SolicitudEstadoCuentaDTO solicitud = solicitudEstadoCuentaDAO.consultarReporte(idFormato);		
		return solicitud;
	}

    @Override
    public SolicitudEstadoCuentaDTO obtenerEstadoCuenta(SolicitudEstadoCuentaDTO formatoUno){
    	SolicitudEstadoCuentaDTO solicitud = solicitudEstadoCuentaDAO.obtenerEstadoCuenta(formatoUno);
    	return solicitud;
    }
    
    @Override
    public SibadNotaDTO obtenerNota(Long id){
    	SibadNotaDTO notaObt = solicitudEstadoCuentaDAO.obtenerNota(id);
    	return notaObt;
    }
	
}
