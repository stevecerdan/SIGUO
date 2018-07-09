package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gob.osinergmin.sibad.domain.PghSolicitudxEmpresa;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;

public class SolicitudxEmpresaBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(SolicitudxEmpresaBuilder.class);
	
	  public static List<SolicitudPruebaRepruebaDTO> toListSolicitudPruebaRepruebaDto(List<PghSolicitudxEmpresa> lista) {
		  SolicitudPruebaRepruebaDTO registroDTO;
	        List<SolicitudPruebaRepruebaDTO> retorno = new ArrayList<SolicitudPruebaRepruebaDTO>();
	        if (lista != null) {
	            for (PghSolicitudxEmpresa maestro : lista) {
	                registroDTO = toSolicitudPruebaRepruebaDto(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	    } 
	  
	    public static SolicitudPruebaRepruebaDTO toSolicitudPruebaRepruebaDto(PghSolicitudxEmpresa registro) {
	    	SolicitudPruebaRepruebaDTO registroDTO = new SolicitudPruebaRepruebaDTO();
	    	
	        registroDTO.setIdSolicitudPruebaReprueba(registro.getIdSolicitudPruebaReprueba());
	        registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
	        registroDTO.setNroSolicitudUnidadSupervisa(registro.getNroSolicitudUnidadSupervisa());
	        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
	        registroDTO.setDireccion(registro.getDireccion());
	        registroDTO.setTipoPrueba(registro.getTipoPrueba());
	        registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
	        registroDTO.setEmpresaAcreditada(registro.getEmpresaAcreditada());
	        registroDTO.setUnidAlmacenamiento1(registro.getUnidAlmacenamiento1());
	        registroDTO.setUnidAlmacenamiento2(registro.getUnidAlmacenamiento2());
	        registroDTO.setNombreUnid(registro.getNombreUnid());
	        registroDTO.setIdUnidSupervTanque(registro.getIdUnidSupervTanque());
	        registroDTO.setIdUnidSupervModulo(registro.getIdUnidSupervModulo());
	        registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
	        registroDTO.setFechaInicio(registro.getFechaInicio());
	        registroDTO.setResultadoPrueba(registro.getResultadoPrueba());
	        registroDTO.setNumeroCompartimiento(registro.getNumeroCompartimiento());
	        registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
	        registroDTO.setNumeroTanque(registro.getNumeroTanque());
	        registroDTO.setEstado(registro.getEstado());
	        registroDTO.setFechaSolicitud(registro.getFechaSolicitud());
	        registroDTO.setFechaCreacion(registro.getFechaCreacion());
	        registroDTO.setUbigeo(registro.getUbigeo());
	        registroDTO.setIdModulo(registro.getIdModulo());
	        registroDTO.setIdCilindroGNV(registro.getIdCilindroGNV());
	        registroDTO.setModulo(registro.getModulo());
	        registroDTO.setCilindro(registro.getCilindro());
	        
	        return registroDTO;
	    }
}
