package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghResultadoRevision;
import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;

public class ResultadoRevisionBuilder {

	public static ResultadoRevisionDTO toPghResultadoRevision(PghResultadoRevision registro) {
		
		ResultadoRevisionDTO registroDTO = new ResultadoRevisionDTO();
		
		registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
		registroDTO.setEstadoResultado(registro.getEstadoResultado());
		registroDTO.setFechaFin(registro.getFechaFin());
		registroDTO.setFechaInicio(registro.getFechaInicio());
		registroDTO.setFlagPersona(registro.getFlagPersona());
		registroDTO.setHoraFin(registro.getHoraFin());
		registroDTO.setHoraInicio(registro.getHoraInicio());
		registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
		registroDTO.setIdProgramacion(registro.getIdProgramacion());
		registroDTO.setObservacion(registro.getObservacion());
		registroDTO.setResultadoRevision(registro.getResultadoRevision());
		registroDTO.setTipoPersonal(registro.getTipoPersonal());			
		
		return registroDTO;
	}
	
	public static List<ResultadoRevisionDTO> toListResultadoRevisionDto(List<PghResultadoRevision> lista) {
		ResultadoRevisionDTO registroDTO;
	        List<ResultadoRevisionDTO> retorno = new ArrayList<ResultadoRevisionDTO>();
	        if (lista != null) {
	            for (PghResultadoRevision maestro : lista) {
	                registroDTO = toPghResultadoRevision(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	

}
