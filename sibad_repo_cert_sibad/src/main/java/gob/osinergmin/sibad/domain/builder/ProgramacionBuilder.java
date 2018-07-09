package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghCompartimientoV;
import gob.osinergmin.sibad.domain.PghProgramacion;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionVDTO;

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
	
	public static List<ProgramacionVDTO> toListCompartimientoDto(List<PghCompartimientoV> lista) {
		ProgramacionVDTO registroDTO;
	        List<ProgramacionVDTO> retorno = new ArrayList<ProgramacionVDTO>();
	        if (lista != null) {
	            for (PghCompartimientoV valor : lista) {
	                registroDTO = toProgramacionVDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static ProgramacionVDTO toProgramacionVDto(PghCompartimientoV registro) {
	    	
		   ProgramacionVDTO registroDTO = new ProgramacionVDTO();
		  
		   registroDTO.setIdUnidadSupervisada(registro.getIdUnidadSupervisada());
		   registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
		   registroDTO.setCompartimiento(registro.getNumero());
		   registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
		   registroDTO.setIdProgramacion(registro.getIdProgramacion());
		   registroDTO.setNumeroProgramacion(registro.getNumeroProgramacion());
		   registroDTO.setTipoRevision(registro.getTipoRevision());
		   registroDTO.setUnidadAlmacenamiento(registro.getUnidadAlmacenamiento());
		   registroDTO.setEstado(registro.getEstado());
		   registroDTO.setTipoProgramacion(registro.getTipoProgramacion());
		   registroDTO.setFechaProgramacion(registro.getFechaProgramacion());
		   registroDTO.setNumeroSerie(registro.getNumeroSerie());
		   registroDTO.setFechaInicio(registro.getFechaInicio());
		   registroDTO.setFechaFin(registro.getFechaFin());
		   registroDTO.setResultadoRevision(registro.getResultadoRevision());
		   registroDTO.setFlagPersona(registro.getFlagPersona());
		   registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
		   registroDTO.setFechaCreacion(registro.getFechaCreacion());
	       return registroDTO;
	}

}
