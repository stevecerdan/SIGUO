package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghProgramacion;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;

public class ProgramacionBuilder {
	
	public static ProgramacionDTO toProgramacionDto(PghProgramacion registro) {
	       
		ProgramacionDTO registroDTO = new ProgramacionDTO();
        
        registroDTO.setIdProgramacion(registro.getIdProgramacion());
        registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
        registroDTO.setNumeroProgramacion(registro.getNumeroProgramacion());
        registroDTO.setTipoProgramacion(registro.getTipoProgramacion());
        registroDTO.setTipoRevision(registro.getTipoRevision());
        registroDTO.setFechaProgramacion(registro.getFechaProgramacion());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }

}
