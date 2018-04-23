package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.SibadSlctudEstdoCnta;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.util.FechaUtil;

import java.util.Date;

public class SolicitudEstadoCuentaBuilder {
	
    public static SibadSlctudEstdoCnta obtenerSolicitudEECC(SolicitudEstadoCuentaDTO solicitudDTO,UsuarioDTO usuario) {
    	SibadSlctudEstdoCnta solicitudEECC = null;
        if (solicitudDTO != null) {
        	solicitudEECC = new SibadSlctudEstdoCnta();
        	solicitudEECC.setCdgoOsnerg(solicitudDTO.getCodigoOsinergmin());
        	solicitudEECC.setNmroExpdnte(solicitudDTO.getNumeroExpediente());
        	solicitudEECC.setNmroSlctud(solicitudDTO.getNumeroSolicitud());
        	solicitudEECC.setRuc(solicitudDTO.getRuc());
        	solicitudEECC.setRzonScial(solicitudDTO.getRazonSocial());
        	solicitudEECC.setEstdo(solicitudDTO.getEstado());
        	solicitudEECC.setDrccion(solicitudDTO.getDireccion());
        	solicitudEECC.setTlfno(solicitudDTO.getTelefono());
        	solicitudEECC.setCrreoElctrnco(solicitudDTO.getCorreo());
        	solicitudEECC.setUbigeo(solicitudDTO.getIdDistrito());
        	solicitudEECC.setFchaIncio(FechaUtil.stringToDate(solicitudDTO.getFechaInicio(), FechaUtil.FORMATO_FECHA_CORTA));
        	solicitudEECC.setFchaFin(FechaUtil.stringToDate(solicitudDTO.getFechaFin(), FechaUtil.FORMATO_FECHA_CORTA));                	
        	solicitudEECC.setDependenciaId(solicitudDTO.getDependenciaId());
        	solicitudEECC.setUniopeId(solicitudDTO.getIdUnidadOperativa());
        	solicitudEECC.setNotaId(solicitudDTO.getNotaId());
        	solicitudEECC.setTipoPrdo(solicitudDTO.getTipoPrdo());
        	//Auditoria
        	solicitudEECC.setFchaCrcion(new Date());
        	solicitudEECC.setUsrioCrdor(usuario.getLogin());
        	
        }
        return solicitudEECC;
    }

    public static SolicitudEstadoCuentaDTO obtenerSolicitudDTO(SibadSlctudEstdoCnta solicitud, SolicitudEstadoCuentaDTO solicitudDTO) {
        
    	solicitudDTO.setIdSolicitud(solicitud.getId());
    	solicitudDTO.setNumeroSolicitud(solicitud.getNmroSlctud());
    	solicitudDTO.setCodigoOsinergmin(solicitud.getCdgoOsnerg());
    	solicitudDTO.setRazonSocial(solicitud.getRzonScial());
    	solicitudDTO.setRuc(solicitud.getRuc());
    	solicitudDTO.setDireccion(solicitud.getDrccion());
    	solicitudDTO.setTelefono(solicitud.getTlfno());
    	solicitudDTO.setCorreo(solicitud.getCrreoElctrnco());    	
    	solicitudDTO.setDependenciaId(solicitud.getDependenciaId());
    	solicitudDTO.setIdUnidadOperativa(solicitud.getUniopeId());
    	solicitudDTO.setFechaInicio(FechaUtil.DateToString(solicitud.getFchaIncio(), FechaUtil.FORMATO_FECHA_CORTA));
    	solicitudDTO.setFechaFin(FechaUtil.DateToString(solicitud.getFchaFin(), FechaUtil.FORMATO_FECHA_CORTA));
    	solicitudDTO.setEstado(solicitud.getEstdo());
    	solicitudDTO.setIdDistrito(solicitud.getUbigeo());
    	solicitudDTO.setFechaPresentacion(FechaUtil.DateToString(solicitud.getFchaCrcion(), FechaUtil.FORMATO_FECHA_LARGE));
    	solicitudDTO.setCorreoEle(solicitud.getCrreoElctrnco());
    	solicitudDTO.setNumeroExpediente(solicitud.getNmroExpdnte());
    	//agregado
    	solicitudDTO.setTipoPrdo(solicitud.getTipoPrdo());
    	solicitudDTO.setNotaId(solicitud.getNotaId());
    	
        return solicitudDTO;
    }
    
    public static SolicitudEstadoCuentaDTO obtenerSolicitudDTOInfadicional(Object[] data, SolicitudEstadoCuentaDTO solicitudDTO){
    	solicitudDTO.setDescDep(data[0].toString());
    	solicitudDTO.setDepartamento(data[1].toString());
    	solicitudDTO.setProvincia(data[2].toString());
    	solicitudDTO.setDistrito(data[3].toString());
    	
    	return solicitudDTO;
    }
}
