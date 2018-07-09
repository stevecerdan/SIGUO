package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghResultadoPruebaReprueba;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;


public class ResultadoPruebaRepruebaBuilder {
	
	public static List<ResultadoPruebaRepruebaDTO> toListResultadoPruebaRepruebaDto(List<PghResultadoPruebaReprueba> lista) {
		
		ResultadoPruebaRepruebaDTO registroDTO;
	        
		List<ResultadoPruebaRepruebaDTO> retorno = new ArrayList<ResultadoPruebaRepruebaDTO>();
	        if (lista != null) {
	            for (PghResultadoPruebaReprueba maestro : lista) {
	                registroDTO = toPghResultadoPruebaReprueba(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        
	   return retorno;
	} 

    public static ResultadoPruebaRepruebaDTO toPghResultadoPruebaReprueba(PghResultadoPruebaReprueba registro) {
		
	    ResultadoPruebaRepruebaDTO registroDTO = new ResultadoPruebaRepruebaDTO();
		
	    registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
	    registroDTO.setIdSolicitudPruebaReprueba(registro.getIdSolicitudPruebaReprueba());
	    registroDTO.setFechaInicio(registro.getFechaInicio());
	    registroDTO.setHoraInicio(registro.getHoraInicio());
	    registroDTO.setFechaFin(registro.getFechaFin());
	    registroDTO.setHoraFin(registro.getHoraFin());
	    registroDTO.setFlagResultadoCompartimiento(registro.getFlagResultadoCompartimiento());
	    registroDTO.setFlagResutadoTuberia(registro.getFlagResutadoTuberia());
	    registroDTO.setFlagResultadoFinal(registro.getFlagResultadoFinal());
	    registroDTO.setResultadoPrueba(registro.getResultadoPrueba());
	    registroDTO.setObservacion(registro.getObservacion());
	    registroDTO.setNumeroCertificado(registro.getNumeroCertificado());
	    registroDTO.setFechaEmisionCertificado(registro.getFechaEmisionCertificado());
	    registroDTO.setNumeroInforme(registro.getNumeroInforme());
	    registroDTO.setFechaProximaPrueba(registro.getFechaProximaPrueba());
	    registroDTO.setFechaInforme(registro.getFechaInforme());
		
		return registroDTO;
	}
    
    	public static ResultadoPruebaRepruebaDTO toPghResultadoPruebaRepruebaEdit(PghResultadoPruebaReprueba registro) {
		
	    ResultadoPruebaRepruebaDTO registroDTO = new ResultadoPruebaRepruebaDTO();
		
	    registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
	    registroDTO.setFechaProximaPrueba(registro.getFechaProximaPrueba());
		
		return registroDTO;
	}
}
