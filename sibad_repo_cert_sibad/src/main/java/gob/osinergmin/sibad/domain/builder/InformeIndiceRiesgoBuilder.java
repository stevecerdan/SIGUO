package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghInformeIndiceRiesgo;
import gob.osinergmin.sibad.domain.dto.InformeIndiceRiesgoDTO;

public class InformeIndiceRiesgoBuilder {

	
	public static List<InformeIndiceRiesgoDTO> toListInformeIndiceRiesgoDto(List<PghInformeIndiceRiesgo> lista) {
		InformeIndiceRiesgoDTO registroDTO;
	        List<InformeIndiceRiesgoDTO> retorno = new ArrayList<InformeIndiceRiesgoDTO>();
	        if (lista != null) {
	            for (PghInformeIndiceRiesgo maestro : lista) {
	                registroDTO = toPghInformeIndiceRiesgo(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static InformeIndiceRiesgoDTO toPghInformeIndiceRiesgo(PghInformeIndiceRiesgo registro) {
			
		InformeIndiceRiesgoDTO registroDTO = new InformeIndiceRiesgoDTO();
   
		registroDTO.setIdInformeIndiceRiesgo(registro.getIdInformeIndiceRiesgo());
		registroDTO.setNumeroInformeIndiceRiesgo(registro.getNumeroInformeIndiceRiesgo());
		registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
		registroDTO.setFechaInformeIniceRiesgo(registro.getFechaInformeIniceRiesgo());
		registroDTO.setFlagPersona(registro.getFlagPersona());
		registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
	
		return registroDTO;

	}
}
