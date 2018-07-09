package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghInformeSolicitudPrueba;
import gob.osinergmin.sibad.domain.PghInformeSolicitudPruebaV;
import gob.osinergmin.sibad.domain.dto.InformeSolicitudPruebaDTO;

public class InformeSolicitudPruebaBuilder {
	
	public static List<InformeSolicitudPruebaDTO> toListInformeSolicitudPruebaDto(List<PghInformeSolicitudPruebaV> lista) {
		InformeSolicitudPruebaDTO registroDTO;
	        List<InformeSolicitudPruebaDTO> retorno = new ArrayList<InformeSolicitudPruebaDTO>();
	        if (lista != null) {
	            for (PghInformeSolicitudPruebaV maestro : lista) {
	                registroDTO = toPghInformeSolicitudPruebaV(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static InformeSolicitudPruebaDTO toPghInformeSolicitudPruebaV(PghInformeSolicitudPruebaV registro){
		
		InformeSolicitudPruebaDTO registroDTO = new InformeSolicitudPruebaDTO();		

		registroDTO.setIdInformeSolicitudPrueba(registro.getIdInformeSolicitudPrueba());
		registroDTO.setFechaSolicitud(registro.getFechaSolicitud());
		registroDTO.setNroSolcitudUnidadSupervisada(registro.getNroSolcitudUnidadSupervisada());
		registroDTO.setNumeroCompartimiento(registro.getNumeroCompartimiento());
		registroDTO.setNumeroTanque(registro.getNumeroTanque());
		registroDTO.setFechaProximaPrueba(registro.getFechaProxPrueba());
		
		return registroDTO;

	}
	
	public static InformeSolicitudPruebaDTO toPghInformeSolicitudPrueba(PghInformeSolicitudPrueba registro) {
		
		InformeSolicitudPruebaDTO registroDTO = new InformeSolicitudPruebaDTO();		

		registroDTO.setIdInformeSolicitudPrueba(registro.getIdInformeSolicitudPrueba());
		registroDTO.setIdInformeIndiceRiesgo(registro.getIdInformeIndiceRiesgo());
		registroDTO.setIdSolicitudPruebaReprueba(registro.getIdSolicitudPruebaReprueba());
		registroDTO.setFechaProximaPrueba(registro.getFechaProximaPrueba());
		
		return registroDTO;

	}

}
